package com.eric.service;

import com.eric.model.Cate;
import com.eric.util.model.QueryParams;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Eric
 * Date: 13-5-6
 * Time: 上午11:31
 * To change this template use File | Settings | File Templates.
 */
public interface ICateService {
    /**
     * 按条件分类获取用户信息
     *
     * @param params
     * @param first
     * @param max
     * @param order
     * @return
     */
    public List<Cate> getCateList(List<QueryParams> params, int first, int max, String[][] order);

    /**
     * 根据ID获取分类信息
     *
     * @param id
     * @return
     */
    public Cate getCateById(Long id);


    /**
     * 获取分类信息
     *
     * @param params
     * @return
     */
    public Cate getCate(QueryParams... params);

    /**
     * 保存分类信息
     *
     * @param cate
     * @return
     */
    public Cate saveOrUpdateCate(Cate cate);
}
