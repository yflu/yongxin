package com.eric.action;

import com.eric.model.Comment;
import com.eric.model.Product;
import com.eric.service.ICommentService;
import com.eric.service.IMediaService;
import com.eric.service.IProductService;
import com.eric.util.SysConstant;
import com.eric.util.action.BaseAction;
import com.eric.util.model.QueryParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
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
@RequestMapping(value = "/product")
public class ProductAction extends BaseAction {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICommentService commentService;
    @Autowired
    private IMediaService mediaService;

    private static final Integer PAGE_SIZE = 10;
   //private Integer PAGE_SIZE = 1;

    @RequestMapping(value = "/list")
    public String getProductList(ModelMap modelMap, @RequestParam("k") String keyword, @RequestParam("c") String cStr, @RequestParam("p") String pageindex) {
        try {
            Integer pageIndex = pageindex == null || pageindex.isEmpty() ? 1 : Integer.parseInt(pageindex);
            List<QueryParams> params = new ArrayList<QueryParams>();
            if (keyword != null && !keyword.isEmpty())
                params.add(new QueryParams("name", keyword, 3));
            if (cStr != null && !cStr.isEmpty())
                params.add(new QueryParams("cateid", cStr, 3));
            params.add(new QueryParams("status", 1, 0));
            String[][] order = {{"cateid", "asc"}, {"sortno", "asc"}, {"updatetime", "desc"}, {"id", "desc"}};
            long total = productService.countProduct(params);
            List<Product> productList = null;
            long pages = 0;
            if (total > 0) {
                pages = total % PAGE_SIZE == 0 ? total / PAGE_SIZE : total / PAGE_SIZE + 1;
                if (pages >= pageIndex)
                    productList = productService.getProductList(params, (pageIndex - 1) * PAGE_SIZE, PAGE_SIZE, order);
            }
            modelMap.put("productList", productList);
            modelMap.put("pages", pages);
            modelMap.put("pageindex", pageIndex);
            modelMap.put("cateid", cStr);
            modelMap.put("keyword", keyword);
            modelMap.put("hotList", SysConstant.HOT_LIST);
            modelMap.put("recList", SysConstant.REC_LIST);
            modelMap.put("cateList", SysConstant.CATE_LIST);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "product_list";
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String getProductInfo(ModelMap modelMap, HttpServletRequest request) {
        try {
            Long productid = getLong(request, "id", 0);
            Product product = productService.getProductById(productid);
            if (product == null || product.getId() == 0) {
                return "404";
            }
            List<QueryParams> params = new ArrayList<QueryParams>();
            params.add(new QueryParams("productid", productid));
            params.add(new QueryParams("status", 1));
            String[][] order = {{"sortno", "asc"}, {"id", "asc"}};
            product.setMedias(mediaService.getMediaList(params, 0, 0, order));
            List<Comment> commentList = getComment(productid, 0, 0);
            modelMap.put("product", product);
            modelMap.put("commentList", commentList);
            modelMap.put("hotList", SysConstant.HOT_LIST);
            modelMap.put("recList", SysConstant.REC_LIST);
            modelMap.put("cateList", SysConstant.CATE_LIST);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "product_info";
    }

    /**
     * 获取评论
     *
     * @param productid
     * @param pagesize
     * @param pageindex
     * @return
     */
    public List<Comment> getComment(Long productid, int pagesize, int pageindex) {
        List<QueryParams> params = new ArrayList<QueryParams>();
        params.add(new QueryParams("productid", productid, 0));
        params.add(new QueryParams("status", 0, -1));
        String[][] order = {{"parentid", "asc"}, {"id", "asc"}};
        return commentService.getCommentList(params, (pageindex * pagesize), pagesize, order);
    }

    /**
     * 获取热门产品
     *
     * @param productService
     * @param pagesize
     * @return
     */
    public static List<Product> getHotProduct(IProductService productService, int pagesize) {
        if (SysConstant.HOT_LIST == null) {
            List<QueryParams> params = new ArrayList<QueryParams>();
            params.add(new QueryParams("hot", 1, 0));
            params.add(new QueryParams("status", 1, 0));
            String[][] order = {{"sortno", "asc"}, {"updatetime", "desc"}, {"id", "desc"}};
            SysConstant.HOT_LIST = productService.getProductList(params, 0, pagesize, order);
        }
        return SysConstant.HOT_LIST;
    }

    /**
     * 获取推荐产品
     *
     * @param productService
     * @param pagesize
     * @return
     */
    public static List<Product> getRecProduct(IProductService productService, int pagesize) {
        if (SysConstant.REC_LIST == null) {
            List<QueryParams> params = new ArrayList<QueryParams>();
            params.add(new QueryParams("recommend", 1, 0));
            params.add(new QueryParams("status", 1, 0));
            String[][] order = {{"sortno", "asc"}, {"updatetime", "desc"}, {"id", "desc"}};
            SysConstant.REC_LIST = productService.getProductList(params, 0, pagesize, order);
        }
        return SysConstant.REC_LIST;
    }
}
