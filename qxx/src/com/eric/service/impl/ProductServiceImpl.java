package com.eric.service.impl;

import com.eric.dao.IProductDao;
import com.eric.model.Product;
import com.eric.service.IProductService;
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
@Service("productService")
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> getProductList(List<QueryParams> params, int first, int max, String[][] order) {
        return productDao.find(first, max, params, order);
    }

    @Override
    public Product getProductById(Long id) {
        return productDao.findUnique("id", id);
    }

    @Override
    public Product getProduct(QueryParams... params) {
        List<Product> list = productDao.find(params);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public long countProduct(List<QueryParams> params) {
        return productDao.count(params);
    }
}
