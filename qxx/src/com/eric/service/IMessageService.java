package com.eric.service;

import com.eric.model.Message;
import com.eric.util.model.QueryParams;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Eric
 * Date: 13-8-6
 * Time: 上午11:31
 * To change this template use File | Settings | File Templates.
 */
public interface IMessageService {
    /**
     * 按条件留言获取用户信息
     *
     * @param params
     * @param first
     * @param max
     * @param order
     * @return
     */
    public List<Message> getMessageList(List<QueryParams> params, int first, int max, String[][] order);

    /**
     * 根据ID获取留言信息
     *
     * @param id
     * @return
     */
    public Message getMessageById(Long id);


    /**
     * 获取留言信息
     *
     * @param params
     * @return
     */
    public Message getMessage(QueryParams... params);

    /**
     * 保存留言信息
     *
     * @param Message
     * @return
     */
    public Message saveOrUpdateMessage(Message Message);
}
