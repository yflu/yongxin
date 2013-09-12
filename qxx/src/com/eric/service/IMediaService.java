package com.eric.service;

import com.eric.model.Media;
import com.eric.util.model.QueryParams;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Eric
 * Date: 13-5-6
 * Time: 上午11:31
 * To change this template use File | Settings | File Templates.
 */
public interface IMediaService {
    /**
     * 按条件获取图片信息
     *
     * @param params
     * @param first
     * @param max
     * @param order
     * @return
     */
    public List<Media> getMediaList(List<QueryParams> params, int first, int max, String[][] order);

    /**
     * 根据ID获取图片信息
     *
     * @param id
     * @return
     */
    public Media getMediaById(Long id);


    /**
     * 获取图片信息
     *
     * @param params
     * @return
     */
    public Media getMedia(QueryParams... params);
}
