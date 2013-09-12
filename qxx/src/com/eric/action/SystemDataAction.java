package com.eric.action;

import com.eric.init.SystemInitListener;
import com.eric.service.ICateService;
import com.eric.service.IProductService;
import com.eric.util.SysConstant;

/**
 * Created with IntelliJ IDEA.
 * User: Eric
 * Date: 13-9-3
 * Time: 下午1:19
 * To change this template use File | Settings | File Templates.
 */
public class SystemDataAction {

    public void init() {
        IProductService productService = SystemInitListener.getBean("productService");
        ICateService cateService= SystemInitListener.getBean("cateService");
        SysConstant.HOT_LIST = ProductAction.getHotProduct(productService, 10);
        SysConstant.REC_LIST = ProductAction.getRecProduct(productService, 10);
        SysConstant.CATE_LIST=CateAction.getCates(cateService);
    }
}
