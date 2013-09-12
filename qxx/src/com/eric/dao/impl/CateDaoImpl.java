package com.eric.dao.impl;

import com.eric.dao.ICateDao;
import com.eric.model.Cate;
import com.eric.util.dao.BaseDaoImpl;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: Eric
 * Date: 13-8-6
 * Time: 上午11:32
 * To change this template use File | Settings | File Templates.
 */
@Repository("cateDao")
public class CateDaoImpl extends BaseDaoImpl<Cate> implements ICateDao {

}
