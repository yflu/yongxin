package com.eric.service.impl;

import com.eric.dao.IMessageDao;
import com.eric.model.Message;
import com.eric.service.IMessageService;
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
@Service("messageService")
public class MessageServiceImpl implements IMessageService {
    @Autowired
    private IMessageDao messageDao;

    @Override
    public List<Message> getMessageList(List<QueryParams> params, int first, int max, String[][] order) {
        return messageDao.find(first, max, params, order);
    }

    @Override
    public Message getMessageById(Long id) {
        return messageDao.findUnique("id", id);
    }

    @Override
    public Message getMessage(QueryParams... params) {
        List<Message> list = messageDao.find(params);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public Message saveOrUpdateMessage(Message message) {
        return messageDao.saveOrUpdate(message);
    }
}
