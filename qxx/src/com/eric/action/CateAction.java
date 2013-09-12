package com.eric.action;

import com.eric.model.Cate;
import com.eric.service.ICateService;
import com.eric.util.SysConstant;
import com.eric.util.action.BaseAction;
import com.eric.util.model.QueryParams;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping(value = "/cate")
public class CateAction extends BaseAction {

    public static List<Cate> getCates(ICateService service) {
        try {
            if (SysConstant.CATE_LIST == null) {
                List<QueryParams> params = new ArrayList<QueryParams>();
                params.add(new QueryParams("status", 1, 0));
                String[][] order = {{"parentid", "asc"}, {"deep", "asc"}, {"sortno", "asc"}};
                SysConstant.CATE_LIST = service.getCateList(params, 0, 0, order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SysConstant.CATE_LIST;
    }
}
