package com.eric.service;

import com.eric.model.Product;
import com.eric.util.model.QueryParams;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Eric
 * Date: 13-9-6
 * Time: 上午11:31
 * To change this template use File | Settings | File Templates.
 */
public interface IProductService {
    /**
     * 按条件获取产品信息
     *
     * @param params
     * @param first
     * @param max
     * @param order
     * @return
     */
    public List<Product> getProductList(List<QueryParams> params, int first, int max, String[][] order);

    /**
     * 根据ID获取产品信息
     *
     * @param id
     * @return
     */
    public Product getProductById(Long id);


    /**
     * 获取产品信息
     *
     * @param params
     * @return
     */
    public Product getProduct(QueryParams... params);


    public long countProduct(List<QueryParams> params);
}
