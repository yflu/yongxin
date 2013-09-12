package com.eric.action;

import com.eric.model.Cate;
import com.eric.model.Message;
import com.eric.service.ICateService;
import com.eric.util.action.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Eric
 * Date: 13-7-29
 * Time: 下午5:23
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping
public class VerifyCodeAction extends BaseAction {
    @Autowired
    private ICateService cateService;

    @RequestMapping(value = "/checkcode", method = RequestMethod.POST)
    @ResponseBody
    public String checkVerifyCode(HttpServletRequest request) {
        try {
            String verify = getString(request, "verify", "");
            if (verify.isEmpty()) {
                return returnFormJson(false, "param error!");
            } else {
                String kaptchaExpected = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
                request.getSession().removeAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
                if (!kaptchaExpected.equals(verify)) {
                    return returnFormJson(false, "verify code success!");
                } else {
                    return returnFormJson(true, "verify success!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return returnFormJson(false, "sorry,service error!");
        }
    }
}
