package com.eric.service;

import com.eric.model.Comment;
import com.eric.util.model.QueryParams;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Eric
 * Date: 13-8-7
 * Time: 上午11:31
 * To change this template use File | Settings | File Templates.
 */
public interface ICommentService {
    /**
     * 按条件评论获取用户信息
     *
     * @param params
     * @param first
     * @param max
     * @param order
     * @return
     */
    public List<Comment> getCommentList(List<QueryParams> params, int first, int max, String[][] order);

    /**
     * 根据ID获取评论信息
     *
     * @param id
     * @return
     */
    public Comment getCommentById(Long id);


    /**
     * 获取评论信息
     *
     * @param params
     * @return
     */
    public Comment getComment(QueryParams... params);

    /**
     * 保存评论信息
     *
     * @param comment
     * @return
     */
    public Comment saveOrUpdateComment(Comment comment);

    /**
     * 添加评论
     *
     * @param name
     * @param email
     * @param content
     * @param productid
     * @param parentid
     * @return
     */
    public Comment addComment(String name, String email, String content, Long productid, Long parentid);
}
