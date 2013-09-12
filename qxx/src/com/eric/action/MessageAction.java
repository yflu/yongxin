package com.eric.action;

import com.eric.model.Message;
import com.eric.service.IMessageService;
import com.eric.util.SysConstant;
import com.eric.util.action.BaseAction;
import com.eric.util.tool.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Eric
 * Date: 13-7-29
 * Time: 下午5:23
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/message")
public class MessageAction extends BaseAction {
    @Autowired
    private IMessageService messageService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String saveMessage(HttpServletRequest request) {
        try {
            String name = getString(request, "name", "");
            String email = getString(request, "email", "");
            String subject = getString(request, "subject", "");
            String content = getString(request, "content", "");
            if (name.isEmpty() || email.isEmpty() || subject.isEmpty() || content.isEmpty()) {
                return returnFormJson(false, "param error!");
            } else {
                Message message = new Message(0, name, email, subject, content);
                messageService.saveOrUpdateMessage(message);
                sendEmail(name, content, email, subject);
                return returnFormJson(true, "send success!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return returnFormJson(false, "sorry,send error!");
        }
    }


    public void sendEmail(String name, String message, String email, String subject) {
        Map<String, String> recipients = new HashMap<String, String>();
        String sendersname = "永鑫国际留言系统";
        recipients.put(SysConstant.COMPANY_ACCEPT_EMAIL, "永鑫国际官方邮箱");
        /*邮件正文类型 两种: html格式和纯文本格式*/
        int contentType = EmailUtil.CONTENT_TYPE_HTML;
        /*邮件正文*/
        String content = message +
                "<br><br>By<br><font color='red' style='font-size:14px;'>&nbsp;&nbsp;" + name + "<br>&nbsp;&nbsp;" + email +
                "</font><br><br>本邮件由系统自动发出，请勿回复。<br><br><div align=\"right\">永鑫国际<br>" + new SimpleDateFormat("yyyy年MM月dd日").format(new Date())+"</div>";
        /*邮件正文编码 默认为null 一般不用修改*/
        String contentEncoding = null;
        /*附件文件名编码 默认为null 一般不用修改*/
        String fileNameEncoding = null;

        try {
            EmailUtil sender = new EmailUtil(SysConstant.COMPANY_EMAIL_SMTP, SysConstant.COMPANY_EMAIL_ACCOUNT, SysConstant.COMPANY_EMAIL_PASSWORD,
                    SysConstant.COMPANY_EMAIL_ACCOUNT, sendersname, recipients, subject,
                    content, contentEncoding, contentType,
                    null, fileNameEncoding);
            sender.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
