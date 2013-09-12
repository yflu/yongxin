package com.eric.action;

import com.eric.model.Cate;
import com.eric.service.ICateService;
import com.eric.util.action.BaseAction;
import com.eric.util.model.QueryParams;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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
public class IndexAction extends BaseAction {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String doIndex() {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }
}
