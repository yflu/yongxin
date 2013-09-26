package com.eric.util;

import org.springframework.web.multipart.MultipartFile;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class BufferedImageUtil {

	/**
	 * 获得缓存图像
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public BufferedImage convertBufferedImage(InputStream ins){
		BufferedImage buffer=null;
		try {
			buffer = ImageIO.read(ins);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		}
		return buffer;
	}

	public BufferedImage convertBufferedImage(MultipartFile item){
		BufferedImage buffer=null;
		try {
			buffer = ImageIO.read(item.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		}
		return buffer;
	}
		
	
	/**
	 * 图片压缩
	 * @param originalImage
	 * @param quality
	 * @return
	 */
	public BufferedImage compressImage(BufferedImage originalImage,float compressRatio){
		BufferedImage resultBuffer = null;
		ByteArrayOutputStream out = null;
		ByteArrayInputStream is = null;
		ImageWriter imgWrier;
		ImageWriteParam imgWriteParams;
		// 指定写图片的方式为 jpg
		imgWrier = ImageIO.getImageWritersByFormatName("jpg").next();
		imgWriteParams = new javax.imageio.plugins.jpeg.JPEGImageWriteParam(null);
		// 要使用压缩，必须指定压缩方式为MODE_EXPLICIT
		imgWriteParams.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
		// 这里指定压缩的程度，参数qality是取值0~1范围内，
		imgWriteParams.setCompressionQuality(compressRatio);
		imgWriteParams.setProgressiveMode(ImageWriteParam.MODE_DISABLED);
		ColorModel colorModel = ColorModel.getRGBdefault();
		// 指定压缩时使用的色彩模式
		imgWriteParams.setDestinationType(new javax.imageio.ImageTypeSpecifier(
				colorModel, colorModel.createCompatibleSampleModel(16, 16)));
		try {
			out = new ByteArrayOutputStream();
			imgWrier.reset();
			// 必须先指定 out值，才能调用write方法, ImageOutputStream可以通过任何 OutputStream构造
			imgWrier.setOutput(ImageIO.createImageOutputStream(out));
			// 调用write方法，就可以向输入流写图片
			imgWrier.write(null, new IIOImage(originalImage, null, null),imgWriteParams);
			byte[] b = out.toByteArray();
			is = new ByteArrayInputStream(b);
			resultBuffer = ImageIO.read(is);
			originalImage.flush();
			out.flush();
		} catch (Exception e) {
			return originalImage;
		} finally {
			if(out != null){
				try {
					out.close();
				} catch (IOException e) {}
				out = null;
			}
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {}
				is = null;
			}
		}
		return resultBuffer;  
	}

	/**
	 * 图像尺寸调整，将原图缩放至新的宽、高，对图片进行截取
	 * @param buffer
	 * @param width
	 * @param height
	 * @return
	 */
	public BufferedImage resizeAndCutBufferedImage(BufferedImage buffer, int width,
			int height) {
		// TODO Auto-generated method stub
		int old_w=buffer.getWidth();
		int old_h=buffer.getHeight();
		float scale_w=old_w/(float)width;
		float scale_h=old_h/(float)height;
		float scale = Math.min(scale_w, scale_h);
		int new_w = Math.round(old_w / scale);
		int new_h = Math.round(old_h / scale);
		BufferedImage tag = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		int offsets_w = 0;
		int offsets_h = 0;
		int offsete_w = old_w;
		int offsete_h = old_h;
		offsets_w = Math.round((new_w - width) * scale/2);
		offsets_h = Math.round((new_h-height) * scale/2);
		offsete_w = Math.round(old_w-((new_w - width) * scale/2));
		offsete_h = Math.round(old_h-((new_h-height) * scale/2));
		tag.getGraphics().drawImage(buffer, 0, 0, width, height, offsets_w, offsets_h, offsete_w, offsete_h, null);
		tag.getGraphics().dispose();
		buffer.flush();
		return tag;
	}
	
	/**
	 * 图像尺寸调整，将原图等比缩放至限制宽、高内
	 * @param buffer
	 * @param width
	 * @param height
	 * @return
	 */
	public BufferedImage scaleBufferedImage(BufferedImage buffer, int width,
			int height, boolean isCut) {
		// TODO Auto-generated method stub
		if(width<=0&&height<=0) return buffer;
		if(height<=0){
			return scaleBufferedImageByWidth(buffer,width);
		}else if(width<=0){
			return scaleBufferedImageByHeight(buffer,height);
		}else{
			int old_w=buffer.getWidth();
			int old_h=buffer.getHeight();
			if(old_w<=width&&old_h<=height){
				return buffer;
			}else{
				float scale_w=old_w/(float)width;
				float scale_h=old_h/(float)height;
				try {
					if(scale_w==scale_h){
						int tag = old_w>old_h?width:height;
						return zoomBufferedImage(buffer, tag);
					}else{
						if(isCut){
							return resizeAndCutBufferedImage(buffer, width, height);
						}
						return resizeBufferedImage(buffer, width, height);
					}
				} catch (Exception e) {
					return null;
				}
			}
		}
	}
	
	private BufferedImage scaleBufferedImageByHeight(BufferedImage buffer,
			int height) {
		// TODO Auto-generated method stub
		int old_w = buffer.getWidth();
		int old_h = buffer.getHeight();
		float tempdouble = old_h / (float)height;
		int new_w = Math.round(old_w / tempdouble);
		int new_h = Math.round(old_h / tempdouble);
		
		BufferedImage tag = new BufferedImage(new_w, new_h,
				BufferedImage.TYPE_INT_RGB);
		tag.getGraphics().drawImage(buffer, 0, 0, new_w, new_h, null);
		tag.getGraphics().dispose();
		buffer.flush();
		return tag;
	}

	private BufferedImage scaleBufferedImageByWidth(BufferedImage buffer,
			int width) {
		// TODO Auto-generated method stub
		int old_w = buffer.getWidth();
		int old_h = buffer.getHeight();
		float tempdouble = old_w / (float)width;
		int new_w = Math.round(old_w / tempdouble);
		int new_h = Math.round(old_h / tempdouble);
		
		BufferedImage tag = new BufferedImage(new_w, new_h,
				BufferedImage.TYPE_INT_RGB);
		tag.getGraphics().drawImage(buffer, 0, 0, new_w, new_h, null);
		tag.getGraphics().dispose();
		buffer.flush();
		return tag;
	}

	private BufferedImage resizeBufferedImage(BufferedImage buffer, int width,
			int height) {
		// TODO Auto-generated method stub
		BufferedImage tag = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		tag.getGraphics().drawImage(buffer, 0, 0, width, height, null);
		tag.getGraphics().dispose();
		buffer.flush();
		return tag;
	}

	/**
	 * BufferedImage 限制尺寸
	 * @param originalImage
	 * @param tagsize
	 * @return BufferedImage
	 * @throws Exception
	 */
	public BufferedImage zoomBufferedImage(BufferedImage originalImage, int tagsize) throws Exception {
		int old_w = originalImage.getWidth();
		int old_h = originalImage.getHeight();
		int new_w = 0;
		int new_h = 0;
		float tempdouble;
		if (old_w > old_h) {
			tempdouble = old_w / (float)tagsize;
		} else {
			tempdouble = old_h / (float)tagsize;
		}
		new_w = Math.round(old_w / tempdouble);
		new_h = Math.round(old_h / tempdouble);
		
		BufferedImage tag = new BufferedImage(new_w, new_h,
				BufferedImage.TYPE_INT_RGB);
		tag.getGraphics().drawImage(originalImage, 0, 0, new_w, new_h, null);
		tag.getGraphics().dispose();
		originalImage.flush();
		return tag;
	}
}
