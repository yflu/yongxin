package com.eric.action;

import com.eric.model.Cate;
import com.eric.model.Product;
import com.eric.service.ICateService;
import com.eric.service.IProductService;
import com.eric.util.action.BaseAction;
import com.eric.util.model.QueryParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    @Autowired
    private IProductService productService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String doIndex(ModelMap modelMap) {
        try {
            //获取热门产品
            List<QueryParams> params = new ArrayList<QueryParams>();
            params.add(new QueryParams("hot", 1));
            params.add(new QueryParams("status", 1));
            String[][] hot_order = {{"updatetime", "desc"}, {"id", "desc"}};
            List<Product> hots = productService.getProductList(params, 0, 6, hot_order);
            //获取推荐产品
            params = new ArrayList<QueryParams>();
            params.add(new QueryParams("recommend", 1));
            params.add(new QueryParams("status", 1));
            String[][] rec_order = {{"updatetime", "desc"}, {"id", "desc"}};
            List<Product> recs = productService.getProductList(params, 0, 6, rec_order);

            modelMap.put("hots", hots);
            modelMap.put("recs", recs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }
}
