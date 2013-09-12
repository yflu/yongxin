package com.eric.service.impl;

import com.eric.dao.ICommentDao;
import com.eric.model.Comment;
import com.eric.service.ICommentService;
import com.eric.util.model.QueryParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Eric
 * Date: 13-5-6
 * Time: 上午11:31
 * To change this template use File | Settings | File Templates.
 */
@Service("commentService")
public class CommentServiceImpl implements ICommentService {
    @Autowired
    private ICommentDao commentDao;

    @Override
    public List<Comment> getCommentList(List<QueryParams> params, int first, int max, String[][] order) {
        return commentDao.find(first, max, params, order);
    }

    @Override
    public Comment getCommentById(Long id) {
        return commentDao.findUnique("id", id);
    }

    @Override
    public Comment getComment(QueryParams... params) {
        List<Comment> list = commentDao.find(params);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public Comment saveOrUpdateComment(Comment comment) {
        return commentDao.saveOrUpdate(comment);
    }

    @Override
    public Comment addComment(String name, String email, String content, Long productid, Long parentid) {
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setEmail(email);
        comment.setName(name);
        comment.setParentid(parentid);
        comment.setProductid(productid);
        comment.setLeaf(1);
        comment.setStatus(0);
        if (parentid > 0) {
            Comment parentComment = commentDao.findUnique("parentid", parentid);
            if (parentComment == null && parentComment.getId() > 0) {
                return null;
            } else {
                comment.setDeep(parentComment.getDeep() + 1);
            }
        } else {
            comment.setDeep(1);
        }

        return commentDao.save(comment);
    }
}
