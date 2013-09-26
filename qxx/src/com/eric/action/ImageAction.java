package com.eric.action;

import com.eric.util.PictureHelper;
import com.eric.util.SysConstant;
import com.eric.util.action.BaseAction;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Eric
 * Date: 13-9-26
 * Time: 下午4:17
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ImageAction extends BaseAction {
    @RequestMapping(value = "/image.do")
    public void getFile(@RequestParam("path") String path, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String result = "";
        if (path == null || path.isEmpty()) {
            result = "参数错误";
            writeToClient(response, result);
        } else {
            String filePath = SysConstant.UPLOAD_PATH + path;
            File file = new File(filePath);
            if (file.exists()) {

                PictureHelper.outputImageByPath(filePath, getInt(request, "width", 0), getInt(request, "height", 0), false, 2, null, 4, response);
            } else {
                result = "无效的文件";
                writeToClient(response, result);
            }
        }
    }

}
