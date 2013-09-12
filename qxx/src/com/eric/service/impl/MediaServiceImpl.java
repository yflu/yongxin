package com.eric.service.impl;

import com.eric.dao.IMediaDao;
import com.eric.model.Media;
import com.eric.service.IMediaService;
import com.eric.util.model.QueryParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Eric
 * Date: 13-9-6
 * Time: 上午11:31
 * To change this template use File | Settings | File Templates.
 */
@Service("mediaService")
public class MediaServiceImpl implements IMediaService {
    @Autowired
    private IMediaDao mediaDao;

    @Override
    public List<Media> getMediaList(List<QueryParams> params, int first, int max, String[][] order) {
        return mediaDao.find(first, max, params, order);
    }

    @Override
    public Media getMediaById(Long id) {
        return mediaDao.findUnique("id", id);
    }

    @Override
    public Media getMedia(QueryParams... params) {
        List<Media> list = mediaDao.find(params);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}
