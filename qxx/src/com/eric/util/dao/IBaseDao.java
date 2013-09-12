package com.eric.util.dao;

import com.eric.util.model.QueryParams;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <p>通用DAO接口 </p>
 * <p>Copyright: 2013</p>
 * <p>Raiyi InfoTech Co. Ltd.</p>
 * <p>author: fei.liu</p>
 */
public interface IBaseDao<T extends Serializable> {

    /**
     * 添加对象
     *
     * @param t
     * @return
     */
    public T save(T t);

    /**
     * 批量添加对象
     *
     * @param ts
     * @return
     */
    public void saveAll(Collection<T> ts);

    /**
     * 添加对象
     *
     * @param t
     * @return
     */
    public Object saveObj(Object t);

    /**
     * 批量添加对象
     *
     * @param ts
     * @return
     */
    public void saveObjAll(Collection<Object> ts);

    /**
     * 添加对象
     *
     * @param t
     * @return
     */
    public T saveOrUpdate(T t);

    /**
     * 修改对象
     *
     * @param t
     * @return
     */
    public T update(T t);

    /**
     * 修改对象
     *
     * @param t
     * @return
     */
    public Object updateObj(Object t);

    /**
     * 批量修改对象
     *
     * @param ts
     * @return
     */
    public void updateAll(Collection<T> ts);

    /**
     * 批量修改对象
     *
     * @param updaFiledMap 修改字段
     *                     params  条件
     * @return
     */
    public int update(Map<String, Object> updaFiledMap, QueryParams... params);

    /**
     * 批量修改对象
     *
     * @param updaFiledMaps 多个条件对应修改字段
     * @return
     */
    public void update(Map<List<QueryParams>, Map<String, Object>> updaFiledMaps);

    /**
     * 批量修改对象
     *
     * @param updaFiledMaps 单个条件对应修改字段
     * @return
     */
    public void updateSingle(Map<QueryParams, Map<String, Object>> updaFiledMaps);

    /**
     * 删除对象
     *
     * @param t
     * @return
     */
    public void delete(T t);

    /**
     * 删除对象
     *
     * @param t
     */
    public void deleteObj(Object t);

    /**
     * 批量删除对象
     *
     * @param ts
     * @return
     */
    public void deleteAll(List<T> ts);

    /**
     * 按条件删除对象
     *
     * @param params
     * @return
     */
    public int remove(QueryParams... params);

    /**
     * 根据ID查找对象
     *
     * @param id
     * @return
     */
    public T get(Serializable id);

    /**
     * 查询所有记录
     *
     * @return
     */
    public List<T> findAll();

    /**
     * 查询所有记录并排序
     *
     * @return
     */
    public List<T> findAll(String[][] orders);

    /**
     * 按条件进行查询
     *
     * @param field 属性,
     *              value 属性对应的值,
     * @return
     */
    public List<T> find(String field, Object value);

    /**
     * 按条件唯一进行查询
     *
     * @param field 属性,
     *              value 属性对应的值,
     * @return
     */
    public T findUnique(String field, Object value);

    /**
     * 按条件进行唯一查询
     *
     * @param params 排序
     *               params
     *               属性,
     *               属性对应的值,
     *               比较方式
     * @return
     */
    public T findUnique(QueryParams... params);

    /**
     * 按条件进行查询
     *
     * @param params 排序
     *               params
     *               属性,
     *               属性对应的值,
     *               比较方式
     * @return
     */
    public List<T> find(QueryParams... params);

    /**
     * 按条件进行查询 排序返回
     *
     * @param orders 排序
     *               params
     *               属性,
     *               属性对应的值,
     *               比较方式
     * @return
     */
    public List<T> find(String[][] orders, QueryParams... params);

    /**
     * 按条件进行分页查询
     *
     * @param first
     * @param max
     * @param params
     * @return
     */
    public List<T> find(int first, int max, QueryParams... params);

    /**
     * 按条件进行分页查询 排序返回
     *
     * @param first
     * @param max
     * @param orders
     * @param params
     * @return
     */
    public List<T> find(int first, int max, String[][] orders, QueryParams... params);

    /**
     * 按条件进行查询
     *
     * @param params
     * @return
     */
    public List<T> find(List<QueryParams> params);

    /**
     * 按条件进行分页查询
     *
     * @param first
     * @param max
     * @param params
     * @return
     */
    public List<T> find(int first, int max, List<QueryParams> params);

    /**
     * 按条件进行分页查询 并排序
     *
     * @param first
     * @param max
     * @param params
     * @param orders
     * @return
     */
    public List<T> find(int first, int max, List<QueryParams> params, String[][] orders);

    /**
     * hql查询
     *
     * @param hql
     * @return
     */
    public List<?> findByHql(String hql);

    /**
     * 带参数的hql查询
     *
     * @param hql
     * @param params
     * @return
     */
    public List<?> findByHql(String hql, Map<String, Object> params);

    /**
     * 不带参数的hql 分页查询
     *
     * @param hql
     * @param first
     * @param max
     * @return
     */
    public List<?> findByHql(String hql, int first, int max);


    /**
     * 带参数的hql查询
     *
     * @param hql
     * @param params
     * @param first
     * @param max
     * @return
     */
    public List<?> findByHql(String hql, Map<String, Object> params, int first, int max);

    /**
     * 记录数查询
     *
     * @param params
     * @return
     */
    public long count(QueryParams... params);

    /**
     * 记录数查询 纯hql查询，可以多表查询
     *
     * @param hql
     * @return
     */
    public long count(String hql);

    /**
     * 记录数查询
     *
     * @param params 属性,
     *               属性对应的值,
     *               比较方式
     * @return
     */
    public long count(List<QueryParams> params);

    /**
     * 记录数查询
     *
     * @param hql
     * @param params
     * @return
     */
    public long count(String hql, List<QueryParams> params);

    /**
     * 记录数查询
     *
     * @param hql
     * @param params
     * @return
     */
    public long count(String hql, Map<String, Object> params);

    /**
     * 按HQL更新
     *
     * @param hql
     * @return
     */
    public int updateByHql(String hql);


    /**
     * sql查询
     *
     * @param sql
     * @return
     */
    public List<?> findBySql(String sql);

    /**
     * 带参数的sql查询
     *
     * @param sql
     * @param params
     * @return
     */
    public List<?> findBySql(String sql, Map<String, Object> params);

    /**
     * 不带参数的sql分页查询
     *
     * @param sql
     * @param first
     * @param max
     * @return
     */
    public List<?> findBySql(String sql, int first, int max);


    /**
     * 带参数的sql查询
     *
     * @param sql
     * @param params
     * @param first
     * @param max
     * @return
     */
    public List<?> findBySql(String sql, Map<String, Object> params, int first, int max);
}
