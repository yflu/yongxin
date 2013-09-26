package com.eric.util;

import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Eric
 * Date: 13-9-26
 * Time: 下午4:02
 * To change this template use File | Settings | File Templates.
 */
public class PictureHelper {
    /**
     * 输出文件
     *
     * @param path
     * @param width
     * @param height
     * @param isCut
     * @param watermark
     * @param coordinate
     * @param location
     * @param response
     * @throws Exception
     */
    public static void outputImageByPath(String path, int width, int height, boolean isCut, int watermark, int[] coordinate, int location, HttpServletResponse response) throws Exception {
        //获取图片文件
        File file = retrieveByPath(path);
        BufferedImageUtil bufferedImageUtil = new BufferedImageUtil();
        //将文件转换为bufferedimage
        BufferedImage buffer = null;
        //默认图片后缀jpg
        String suffix = "jpg";
        if (file != null) {
            String filename = file.getName();
            if (filename.lastIndexOf(".") > 0 || filename.lastIndexOf(".") < filename.length() - 1) {
                suffix = filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();
            }
            buffer = bufferedImageUtil.convertBufferedImage(new FileInputStream(file));
            if (buffer == null) {
                response.setStatus(404);
            } else {
                //图像缩放
                buffer = bufferedImageUtil.scaleBufferedImage(buffer, width, height, isCut);
                if (buffer == null) {
                    response.setStatus(404);
                } else {
                    if (watermark > 0) {
                        WatermarkHelper waterHelper = new WatermarkHelper();
                        switch (watermark) {
                            case 1:
                                if (coordinate != null && coordinate.length == 2) {
                                    buffer = waterHelper.createTextMark(buffer, SysConstant.WATER_CONTENT, coordinate[0], coordinate[1]);
                                } else {
                                    buffer = waterHelper.createTextMark(buffer, SysConstant.WATER_CONTENT, location);
                                }
                                break;
                            case 2:
                                BufferedImage waterbuffer = bufferedImageUtil.convertBufferedImage(new FileInputStream(SysConstant.WATER_PICTURE));
                                int locationX = (buffer.getWidth() - waterbuffer.getWidth()) / 2;
                                int locationY = (buffer.getHeight() - waterbuffer.getHeight()) / 2 > 0 ? (buffer.getHeight() - waterbuffer.getHeight()) / 2 : 0;
                                buffer = waterHelper.createPicMark(buffer, waterbuffer, locationX, locationY);
                                // buffer = waterHelper.createPicMark(buffer, waterbuffer, 4);
                                break;
                            default:
                                break;
                        }
                        if (buffer == null) {
                            response.setStatus(404);
                        }
                    }
                }
            }
        } else {
            response.setStatus(404);
            String result = "文件路径错误";
            writeToClient(response, result);
        }
        ImageHelper.outputImage(buffer, suffix, response);
    }

    public static File retrieveByPath(String path) {
        File file = new File(path);
        if (file.exists() && file.isFile()) {
            return file;
        }
        return null;
    }

    public static void writeToClient(HttpServletResponse response, String result) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(result);
        response.getWriter().flush();
    }

}
