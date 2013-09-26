package com.eric.util;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class ImageHelper {

	/**
	 * 图片输出
	 * @param buffer
	 * @param suffix 
	 * @param response
	 */
	public static void outputImage(BufferedImage buffer, String suffix, HttpServletResponse response) throws Exception{
		if (buffer!=null){
			response.setHeader("Pragma", "Public");
			response.setHeader("Cache-Control", "Public");
			if("jpg".equalsIgnoreCase(suffix)||"jpeg".equalsIgnoreCase(suffix)){
				response.setContentType("image/"+"jpeg");
			}else{
				response.setContentType("image/"+suffix);
			}
			setExpires(10, response);
			ServletOutputStream opstream = response.getOutputStream();
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			if("jpg".equalsIgnoreCase(suffix)||"jpeg".equalsIgnoreCase(suffix)){
				JPEGImageEncoder e = JPEGCodec.createJPEGEncoder(out);
				e.encode(buffer);
			}
			ImageIO.write(buffer, suffix, out);
			byte[] by = out.toByteArray();
			out.close();
			setContentLength(response,by.length);
			buffer.flush();//释放资源
			opstream.write(by); 
			opstream.close();//释放资源
		}else{
			
		}
	}
	
	public static void outputFile(File file, HttpServletResponse response) throws Exception{
		if(file!=null){
			response.setHeader("Pragma", "Public");
			response.setHeader("Cache-Control", "Public");
			setExpires(10, response);
			
			response.setContentType("application/octet-stream");
			ServletOutputStream opstream = response.getOutputStream();
			FileInputStream fis = new FileInputStream(file);
			byte[] b = new byte[2048];
			int i=-1;
			while((i=fis.read(b))!=-1){
				opstream.write(b);
			}
			fis.close();
			opstream.close();
		}else{
			
		}
	}
	
	private static void setContentLength(HttpServletResponse response,int imageSize){
		if(imageSize>0){
			response.setContentLength(imageSize);
		}
	}
	
	/**
	 * 设置过期时间 time==-1 默认 单位分钟
	 * 
	 * @2011-11-24下午04:47:58
	 * @param time
	 */
	public static long setExpires(long time, HttpServletResponse response) throws Exception{
		long currentTime = System.currentTimeMillis();
		time = (time == -1 ? 10 : time) * 60 * 1000;
		long ct = currentTime + time;
		response.setDateHeader("Expires", ct);
		return ct;
	}
}
