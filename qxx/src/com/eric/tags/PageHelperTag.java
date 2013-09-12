package com.eric.tags;

import com.eric.model.Cate;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Eric
 * Date: 13-7-30
 * Time: 下午1:30
 * To change this template use File | Settings | File Templates.
 */
public class PageHelperTag extends TagSupport {
    private Integer total;
    private Integer pageindex;
    private String keyword;
    private String cateid;

    @Override
    public int doStartTag() throws JspException {
        try {
            JspWriter out = this.pageContext.getOut();
            StringBuffer buffer = new StringBuffer();
            if (total > 1 && pageindex > 0 && total >= pageindex) {
                if (pageindex == 1)
                    buffer.append("<span class=\"disabled_smk_pagination\">Prev</span>");
                else
                    buffer.append("<a href=\"javascript:void(0);\" onclick=\"searchProduct('" + (pageindex - 1) + "');\">Prev</a>");

                //分页算法
                int startIndex = 0;
                int endIndex = 0;
                if (total <= 10) {
                    startIndex = 1;
                    endIndex = total;
                } else {
                    if (pageindex > 5) {
                        int flag = total - pageindex - 4;
                        if (flag >= 0) {
                            startIndex = pageindex - 5;
                            endIndex = pageindex + 4;
                        } else {
                            endIndex = pageindex + flag + 4;
                            startIndex = pageindex - (10 - 1 - flag - 4);
                        }
                    } else {
                        startIndex = 1;
                        endIndex = 10;
                    }
                }


                //int startIndex = pageindex / 10 == 0 ? pageindex / 10 * 10 + 1 : pageindex / 10 * 10;
                //int endIndex = startIndex + 10 > total ? total + 1 : startIndex + 10;
                for (int i = startIndex; i <= endIndex; i++) {
                    if (i == pageindex)
                        buffer.append("<span class=\"active_smk_link\">" + i + "</span>");
                    else
                        buffer.append("<a href=\"javascript:void(0);\" onclick=\"searchProduct('" + i + "');\">" + i + "</a>");
                }

                if (pageindex.equals(total))
                    buffer.append("<span class=\"disabled_smk_pagination\">Next</span>");
                else
                    buffer.append("<a href=\"javascript:void(0);\" onclick=\"searchProduct('" + (pageindex + 1) + "');\">Next</a>");
            }
            out.println(buffer.toString());
        } catch (Exception e) {
            throw new JspException(e.getMessage());
        }
        return SKIP_BODY;
    }


    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }


    @Override
    public void release() {
        super.release();
        this.total = null;
        this.pageindex = null;
        this.cateid = "";
        this.keyword = "";
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPageindex() {
        return pageindex;
    }

    public void setPageindex(Integer pageindex) {
        this.pageindex = pageindex;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getCateid() {
        return cateid;
    }

    public void setCateid(String cateid) {
        this.cateid = cateid;
    }
}
