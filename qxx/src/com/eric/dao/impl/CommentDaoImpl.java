package com.eric.dao.impl;

import com.eric.dao.ICommentDao;
import com.eric.model.Comment;
import com.eric.util.dao.BaseDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Eric
 * Date: 13-8-6
 * Time: 上午11:32
 * To change this template use File | Settings | File Templates.
 */
@Repository("commentDao")
public class CommentDaoImpl extends BaseDaoImpl<Comment> implements ICommentDao {

}
