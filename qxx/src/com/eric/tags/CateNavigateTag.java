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
public class CateNavigateTag extends TagSupport {
    private List<Cate> value;
    private String cateid;

    @Override
    public int doStartTag() throws JspException {
        try {
            JspWriter out = this.pageContext.getOut();
            StringBuffer buffer = new StringBuffer();
            List<Cate> cateList = new ArrayList<Cate>();
            cateList.addAll(value);
            if (cateList == null) {
                out.println("No UserInfo Found...");
                return SKIP_BODY;
            } else {
                List<Cate> rootCate = new ArrayList<Cate>();

                for (Cate cate : cateList) {
                    if ("01".equals(cate.getParentid())) {
                        rootCate.add(cate);
                    }
                }
                buffer.append("<li><a href=\"/product/list\" id=\"cate_\">ALL</a></li>");
                if (rootCate.size() > 0) {
                    cateList.removeAll(rootCate);
                    for (Cate cate : rootCate) {
                        List<Cate> list = new ArrayList<Cate>();
                        for (Cate temp : cateList) {
                            if (temp.getParentid().equals(cate.getId())) {
                                list.add(temp);
                            }
                        }

                        if (list.size() > 0) {
                            if (!cateid.isEmpty() && (cate.getId().startsWith(cateid) || (cateid.length() >= 6 && cate.getId().startsWith(cateid.substring(0, 4)))))
                                buffer.append("<li><a href=\"javascript:void(0);\" data-trigger=\"collapse\" data-parent=\".collapsegroup\" id=\"cate_" + cate.getId() + "\" onclick=\"findProduct('" + cate.getId() + "');\">" + cate.getName() + "</a><div class=\"collapsible\"><ul>");
                            else
                                buffer.append("<li><a href=\"javascript:void(0);\" data-trigger=\"collapse\" data-parent=\".collapsegroup\" id=\"cate_" + cate.getId() + "\" onclick=\"findProduct('" + cate.getId() + "');\">" + cate.getName() + "</a><div class=\"collapsible hide\"><ul>");

                            for (Cate model : list) {
                                buffer.append("<li><a href=\"javascript:void(0);\" id=\"cate_" + model.getId() + "\" onclick=\"findProduct('" + model.getId() + "');\">" + model.getName() + "</a></li>");

                            }
                            buffer.append("</ul></div></li>");
                        } else {
                            buffer.append("<li><a href=\"javascript:void(0);\" id=\"cate_" + cate.getId() + "\" onclick=\"findProduct('" + cate.getId() + "');\">" + cate.getName() + "</a></li>");
                        }
                    }
                }
                out.println(buffer.toString());
            }
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
        this.value = null;
    }

    public List<Cate> getValue() {
        return value;
    }

    public void setValue(List<Cate> value) {
        this.value = value;
    }

    public String getCateid() {
        return cateid;
    }

    public void setCateid(String cateid) {
        this.cateid = cateid;
    }
}
