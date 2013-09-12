package com.eric.action;

import com.eric.model.Comment;
import com.eric.model.Message;
import com.eric.service.ICommentService;
import com.eric.service.IMessageService;
import com.eric.util.action.BaseAction;
import com.eric.util.model.QueryParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: Eric
 * Date: 13-7-29
 * Time: 下午5:23
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/comment")
public class CommentAction extends BaseAction {
    @Autowired
    private ICommentService commentService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String saveProductComment(HttpServletRequest request) {
        try {
            String name = getString(request, "author", "");
            String email = getString(request, "email", "");
            String content = getString(request, "comment", "");
            Long productid = getLong(request, "productid", 0);
            Long parentid = getLong(request, "parentid", 0);
            if (name.isEmpty() || email.isEmpty() || content.isEmpty() || productid == 0) {
                return returnFormJson(false, "param error!");
            } else {
                Comment comment = commentService.getComment(new QueryParams("name", name), new QueryParams("email", email), new QueryParams("content", content), new QueryParams("productid", productid));
                if (comment == null) {
                    if (commentService.addComment(name, email, content, productid, parentid) == null) {
                        return returnFormJson(false, "sorry,send error!");
                    } else {
                        return returnFormJson(true, "send success!");
                    }
                } else {
                    return returnFormJson(false, "sorry,the comment is already exist!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return returnFormJson(false, "sorry,send error!");
        }
    }
}
