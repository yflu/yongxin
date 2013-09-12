package com.eric.service.impl;

import com.eric.dao.ICateDao;
import com.eric.model.Cate;
import com.eric.service.ICateService;
import com.eric.util.model.QueryParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Eric
 * Date: 13-5-6
 * Time: 上午11:31
 * To change this template use File | Settings | File Templates.
 */
@Service("cateService")
public class CateServiceImpl implements ICateService {
    @Autowired
    private ICateDao cateDao;

    @Override
    public List<Cate> getCateList(List<QueryParams> params, int first, int max, String[][] order) {
        return cateDao.find(first, max, params, order);
    }

    @Override
    public Cate getCateById(Long id) {
        return cateDao.findUnique("id", id);
    }

    @Override
    public Cate getCate(QueryParams... params) {
        List<Cate> list = cateDao.find(params);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public Cate saveOrUpdateCate(Cate cate) {
        return cateDao.saveOrUpdate(cate);
    }
}
