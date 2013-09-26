package com.eric.util;

import java.awt.*;
import java.awt.image.BufferedImage;

public class WatermarkHelper {

    public BufferedImage createTextMark(BufferedImage buffer, String content, int x, int y) {
        BufferedImage img = null;
        content = content == null ? "" : content;
        if (buffer != null) {
            int w = buffer.getWidth();
            int h = buffer.getHeight();
            img = new BufferedImage(w, h,
                    BufferedImage.TYPE_INT_RGB);// 构建画板
            Graphics g = img.getGraphics();// 得到画笔
            g.drawImage(buffer, 0, 0, w, h, null);// 把源图片写入画板
            g.setColor(Color.white);
            int fontsize = 20;
            Font f = new Font("宋体", Font.PLAIN, fontsize);
            g.setFont(f);
            FontMetrics fm = g.getFontMetrics();
            if ((x + fm.stringWidth(content)) > w) x = w - fm.stringWidth(content);
            if (y > (h - fm.getMaxDescent())) y = h - fm.getMaxDescent();
            if (y < fm.getMaxAscent()) y = fm.getMaxAscent();
            g.drawString(content, x, y); // 添加文字
            g.dispose();// 生成图片
        }
        return img;
    }

    public BufferedImage createTextMark(BufferedImage buffer, String content, int type) {
        BufferedImage img = null;
        if (buffer != null) {
            int w = buffer.getWidth();
            int h = buffer.getHeight();
            img = new BufferedImage(w, h,
                    BufferedImage.TYPE_INT_RGB);// 构建画板
            Graphics g = img.getGraphics();// 得到画笔
            g.drawImage(buffer, 0, 0, w, h, null);// 把源图片写入画板
            g.setColor(new Color(0, 189, 233));
            int fontsize = 20;
            Font f = new Font("华文彩云", Font.BOLD, fontsize);
            g.setFont(f);

            FontMetrics fm = g.getFontMetrics();
            int x = 0;
            int y = 0;
            if (type < 1 || type > 4) {
                type = 4;
            }
            if (content == null) {
                content = "";
            }
            switch (type) {
                case 1:
                    x = 0;
                    y = fm.getMaxAscent();
                    break;
                case 2:
                    x = 0;
                    y = h - fm.getMaxDescent();
                    break;
                case 3:
                    x = w - fm.stringWidth(content);
                    y = fm.getMaxAscent();
                    break;
                case 4:
                    x = w - fm.stringWidth(content);
                    y = h - fm.getMaxDescent();
                    break;
                default:
                    break;
            }
            g.drawString(content, x, y); // 添加文字
            g.dispose();// 生成图片
        }
        return img;
    }

    public BufferedImage createPicMark(BufferedImage buffer, BufferedImage markPic, int x, int y) {
        BufferedImage img = null;
        if (buffer != null && markPic != null) {
            int width = buffer.getWidth();
            int height = buffer.getHeight();
            img = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);// 构建画板
            int markWidth = markPic.getWidth();
            int markHeight = markPic.getHeight();
            if (width < markWidth || height < markHeight) return buffer;
            Graphics g = img.createGraphics();
            g.drawImage(buffer, 0, 0, width, height, null);
            if (x > width - markWidth) x = width - markWidth;
            if (y > height - markHeight) y = height - markHeight;
            g.drawImage(markPic, x,
                    y, markWidth, markHeight, null);
            //水印文件结束
            g.dispose();
        } else if (buffer != null && markPic == null) return buffer;
        return img;
    }

    public BufferedImage createPicMark(BufferedImage buffer, BufferedImage markPic, int type) {
        BufferedImage img = null;
        if (buffer != null && markPic != null) {
            int width = buffer.getWidth();
            int height = buffer.getHeight();
            img = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);// 构建画板
            int markWidth = markPic.getWidth();
            int markHeight = markPic.getHeight();
            if (width < markWidth || height < markHeight) return buffer;
            Graphics g = img.createGraphics();
            g.drawImage(buffer, 0, 0, width, height, null);

            int x = 0;
            int y = 0;
            if (type < 1 || type > 4) {
                type = 4;
            }
            switch (type) {
                case 1:
                    x = 0;
                    y = 0;
                    break;
                case 2:
                    x = 0;
                    y = height - markHeight;
                    break;
                case 3:
                    x = width - markWidth;
                    y = 0;
                    break;
                case 4:
                    x = width - markWidth;
                    y = height - markHeight;
                    break;
                default:
                    break;
            }
            if (x > width - markWidth) x = width - markWidth;
            if (y > height - markHeight) y = height - markHeight;
            g.drawImage(markPic, x,
                    y, markWidth, markHeight, null);
            //水印文件结束
            g.dispose();
        } else if (buffer != null && markPic == null) return buffer;
        return img;
    }
}
