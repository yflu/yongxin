package com.eric.action;

import com.eric.service.ICateService;
import com.eric.service.IProductService;
import com.eric.util.SysConstant;
import com.eric.util.action.BaseAction;
import com.eric.util.model.QueryParams;
import org.springframework.beans.factory.annotation.Autowired;
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
public class HelpAction extends BaseAction {
    @Autowired
    private ICateService cateService;
    @Autowired
    private IProductService productService;

    @RequestMapping(value = "/help", method = RequestMethod.GET)
    @ResponseBody
    public String doHelp() {
        try {
            List<QueryParams> params = new ArrayList<QueryParams>();
            params.add(new QueryParams("hot", 1, 0));
            params.add(new QueryParams("status", 1, 0));
            String[][] hot_order = {{"sortno", "asc"}, {"updatetime", "desc"}, {"id", "desc"}};
            SysConstant.HOT_LIST = productService.getProductList(params, 0, 10, hot_order);

            params = new ArrayList<QueryParams>();
            params.add(new QueryParams("recommend", 1, 0));
            params.add(new QueryParams("status", 1, 0));
            String[][] rec_order = {{"sortno", "asc"}, {"updatetime", "desc"}, {"id", "desc"}};
            SysConstant.REC_LIST = productService.getProductList(params, 0, 10, rec_order);

            params = new ArrayList<QueryParams>();
            params.add(new QueryParams("status", 1, 0));
            String[][] cate_order = {{"parentid", "asc"}, {"deep", "asc"}, {"sortno", "asc"}};
            SysConstant.CATE_LIST = cateService.getCateList(params, 0, 0, cate_order);
            return returnFormJson(true, "success!");
        } catch (Exception e) {
            e.printStackTrace();
            return returnFormJson(false, "sorry,service error!");
        }
    }
}
