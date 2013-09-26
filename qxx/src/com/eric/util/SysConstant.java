package com.eric.util;

import com.eric.model.Cate;
import com.eric.model.Product;
import com.eric.util.tool.ParsProperFile;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Eric
 * Date: 13-8-7
 * Time: 上午9:27
 * To change this template use File | Settings | File Templates.
 */
public class SysConstant {
    //官方邮箱
    public static final String COMPANY_EMAIL_ACCOUNT = ParsProperFile.getRyAppProp("com.eric.send.email.account");
    //官方邮箱密码
    public static final String COMPANY_EMAIL_PASSWORD = ParsProperFile.getRyAppProp("com.eric.send.email.password");
    //SMTP主机地址
    public static final String COMPANY_EMAIL_SMTP = ParsProperFile.getRyAppProp("com.eric.send.email.smtp");

    public static final String COMPANY_ACCEPT_EMAIL = ParsProperFile.getRyAppProp("com.eric.accept.email.account");
    //图片服务器路径
    public static final String IMAGE_URL = ParsProperFile.getRyAppProp("com.eric.image.url");

    //热门商品
    public static List<Product> HOT_LIST = null;
    //推荐商品
    public static List<Product> REC_LIST = null;
    //产品分类
    public static List<Cate> CATE_LIST = null;

    public static final String UPLOAD_PATH = ParsProperFile.getRyAppProp("com.raiyi.fileserver.uploadpath");

    public static final String WATER_PICTURE = UPLOAD_PATH + "watermark.png";

    public static final String WATER_CONTENT = "www.everxin.com";
}

