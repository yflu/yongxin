package com.eric.util.dao;

import com.eric.util.model.QueryParams;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Eric
 * Date: 13-7-29
 * Time: 下午4:46
 * To change this template use File | Settings | File Templates.
 */
public class BaseDaoImpl<T extends Serializable> implements IBaseDao<T> {
    private Class<T> persistentClass = null;

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    public BaseDaoImpl() {
        this.persistentClass = (Class<T>) (((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    public final void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected final Session getSession()
            throws DataAccessResourceFailureException, IllegalStateException {
        return this.sessionFactory.getCurrentSession();
    }

    protected Class<T> getPersistentClass() {
        return persistentClass;
    }

    public T save(T t) {
        Assert.notNull(t);
        getSession().save(t);
        return t;
    }

    public void saveAll(Collection<T> ts) {
        Session session = getSession();

        for (T t : ts)
            session.saveOrUpdate(t);
    }

    public Object saveObj(Object t) {
        Assert.notNull(t);
        getSession().save(t);
        return t;
    }

    public void saveObjAll(Collection<Object> ts) {
        Assert.notNull(ts);
        Session session = getSession();

        for (Object t : ts)
            session.saveOrUpdate(t);
    }

    @Override
    public T saveOrUpdate(T t) {
        getSession().saveOrUpdate(t);
        return t;
    }

    public T update(T t) {
        Assert.notNull(t);
        getSession().saveOrUpdate(t);
        return t;
    }

    public Object updateObj(Object t) {
        Assert.notNull(t);
        getSession().saveOrUpdate(t);
        return t;
    }

    public void updateAll(Collection<T> ts) {
        Assert.notNull(ts);
        Session session = getSession();

        for (T t : ts)
            session.saveOrUpdate(t);
    }

    public int update(Map<String, Object> updaFiledMap, QueryParams... params) {
        Session session = getSession();
        int i = update(session, updaFiledMap, params);
        return i;
    }

    private int update(Session session, Map<String, Object> updaFiledMap,
                       QueryParams... params) {
        StringBuffer hql = new StringBuffer("update ");
        hql.append(getPersistentClass().getName()).append(" as u set ");

        if (updaFiledMap != null)
            for (String field : updaFiledMap.keySet())
                hql.append(field).append("=:").append(field).append(" ");

        if (params != null) {
            hql.append("where 1=1 ");
            getQueryHql(hql, params);
        }

        Query query = session.createQuery(hql.toString());
        if (updaFiledMap != null)
            for (String key : updaFiledMap.keySet())
                if (updaFiledMap.get(key) == null)
                    continue;
                else if (updaFiledMap.get(key) instanceof Collection<?>)
                    query.setParameterList(key,
                            (Collection<?>) updaFiledMap.get(key));
                else
                    query.setParameter(key, updaFiledMap.get(key));

        if (params != null)
            for (QueryParams param : params)
                if (param == null || param.getValue() == null)
                    continue;
                else if (param.getValue() instanceof Collection<?>)
                    query.setParameterList(param.getField(),
                            (Collection<?>) param.getValue());
                else
                    query.setParameter(param.getField(), param.getValue());

        int i = query.executeUpdate();
        return i;
    }

    public void update(Map<List<QueryParams>, Map<String, Object>> updaFiledMaps) {

        Session session = getSession();
        for (List<QueryParams> qps : updaFiledMaps.keySet())
            update(session, updaFiledMaps.get(qps),
                    qps.toArray(new QueryParams[]{}));
    }

    public void updateSingle(Map<QueryParams, Map<String, Object>> updaFiledMaps) {

        Session session = getSession();
        for (QueryParams qps : updaFiledMaps.keySet())
            update(session, updaFiledMaps.get(qps), qps);
    }

    public void delete(T t) {
        Assert.notNull(t);
        getSession().delete(t);
    }

    public void deleteObj(Object t) {
        Assert.notNull(t);
        getSession().delete(t);
    }

    public void deleteAll(List<T> ts) {
        Assert.notNull(ts);
        Session session = getSession();

        for (T t : ts)
            session.delete(t);
    }

    public int remove(QueryParams... params) {
        StringBuffer hql = new StringBuffer("delete from ")
                .append(getPersistentClass().getName());
        hql.append(" where 1=1 ");
        getQueryHql(hql, params);

        Session session = getSession();
        Query query = session.createQuery(hql.toString());
        if (params != null)
            for (QueryParams param : params)
                if (param == null || param.getValue() == null)
                    continue;
                else if (param.getValue() instanceof Collection<?>)
                    query.setParameterList(param.getField(),
                            (Collection<?>) param.getValue());
                else
                    query.setParameter(param.getField(), param.getValue());

        int res = query.executeUpdate();
        return res;
    }

    @SuppressWarnings("unchecked")
    public T get(Serializable id) {
        Assert.notNull(id);
        return (T) getSession().get(getPersistentClass(), id);
    }

    public List<T> findAll() {
        return findAll(null);
    }

    public List<T> findAll(String[][] orders) {
        return find(-1, -1, null, orders);
    }

    public List<T> find(QueryParams... params) {
        return find(-1, -1, Arrays.asList(params), null);
    }

    public List<T> find(String[][] orders, QueryParams... params) {
        return find(-1, -1, Arrays.asList(params), orders);
    }

    public List<T> find(int first, int max, QueryParams... params) {
        return find(first, max, Arrays.asList(params), null);
    }

    public List<T> find(int first, int max, String[][] orders,
                        QueryParams... params) {
        return find(first, max, Arrays.asList(params), orders);
    }

    public List<T> find(List<QueryParams> params) {
        return find(-1, -1, params, null);
    }

    public List<T> find(int first, int max, List<QueryParams> params) {
        return find(first, max, params, null);
    }

    @SuppressWarnings("unchecked")
    public List<T> find(int first, int max, List<QueryParams> params,
                        String[][] order) {
        Session session = getSession();
        Criteria criteria = session.createCriteria(getPersistentClass());

        if (params != null)
            for (QueryParams param : params) {
                if (param == null)
                    continue;
                if (param.getEq() == QueryParams.EQ)
                    criteria.add(Restrictions.eq(param.getField(),
                            param.getValue()));
                else if (param.getEq() == QueryParams.GE)
                    criteria.add(Restrictions.ge(param.getField(),
                            param.getValue()));
                else if (param.getEq() == QueryParams.LT)
                    criteria.add(Restrictions.lt(param.getField(),
                            param.getValue()));
                else if (param.getEq() == QueryParams.GT)
                    criteria.add(Restrictions.gt(param.getField(),
                            param.getValue()));
                else if (param.getEq() == QueryParams.LE)
                    criteria.add(Restrictions.le(param.getField(),
                            param.getValue()));
                else if (param.getEq() == QueryParams.LIKE)
                    criteria.add(Restrictions.like(param.getField(),
                            param.getValue()));
                else if (param.getEq() == QueryParams.LEFT_LIKE)
                    criteria.add(Restrictions.like(param.getField(),
                            param.getValue()));
                else if (param.getEq() == QueryParams.RIGHT_LIKE)
                    criteria.add(Restrictions.like(param.getField(),
                            param.getValue()));
                else if (param.getEq() == QueryParams.IN)
                    criteria.add(Restrictions.in(param.getField(),
                            (Collection<?>) param.getValue()));
                else if (param.getEq() == QueryParams.NULL)
                    criteria.add(Restrictions.isNull(param.getField()));
            }

        if (order != null) {
            for (int j = 0; j < order.length; j++) {
                criteria.addOrder(order[j][1].compareToIgnoreCase("asc") == 0 ? Order
                        .asc(order[j][0]) : Order.desc(order[j][0]));
            }
        }
        if (first > 0)
            criteria.setFirstResult(first);

        if (max > 0)
            criteria.setMaxResults(max);

        List<T> ts = criteria.list();
        return ts;
    }

    public List<?> findByHql(String hql) {
        return findByHql(hql, null);
    }

    public List<?> findByHql(String hql, Map<String, Object> params) {
        return findByHql(hql, params, -1, -1);
    }

    public List<?> findByHql(String hql, int first, int max) {
        return findByHql(hql, null, first, max);
    }

    public List<?> findByHql(String hql, Map<String, Object> params, int first,
                             int max) {

        if (hql == null || "".equals(hql))
            return null;

        Query query = getSession().createQuery(hql);

        if (params != null) {
            for (String key : params.keySet())
                if (params.get(key) instanceof Collection<?>)
                    query.setParameterList(key, (Collection<?>) params.get(key));
                else
                    query.setParameter(key, params.get(key));

        }

        if (first > 0)
            query.setFirstResult(first);

        if (max > 0)
            query.setMaxResults(max);

        return query.list();
    }

    public long count(QueryParams... params) {
        return count(Arrays.asList(params));
    }

    public long count(String hql) {
        return count(hql, new ArrayList<QueryParams>());
    }

    public long count(String hql, List<QueryParams> params) {
        getQueryHql(new StringBuffer(hql), params);

        Session session = getSession();
        Query query = session.createQuery(hql.toString());

        if (params != null) {
            for (QueryParams param : params) {
                if (param == null)
                    continue;
                if (param.getValue() instanceof Collection<?>)
                    query.setParameterList(param.getField(),
                            (Collection<?>) param.getValue());
                else
                    query.setParameter(param.getField(), param.getValue());
            }
        }

        return (Long) query.list().get(0);
    }

    public long count(String hql, Map<String, Object> params) {
        return (Long) findByHql(hql, params).get(0);
    }

    /**
     * 按HQL更新
     *
     * @param hql
     * @return
     */
    public int updateByHql(String hql) {
        Query query = getSession().createQuery(hql);
        return query.executeUpdate();
    }

    public long count(List<QueryParams> params) {

        StringBuffer hql = new StringBuffer("select count(*) from ");
        hql.append(getPersistentClass().getName()).append(" t where 1=1 ");

        getQueryHql(hql, params);

        Session session = getSession();
        Query query = session.createQuery(hql.toString());

        if (params != null) {
            for (QueryParams param : params) {
                if (param == null)
                    continue;
                if (param.getValue() instanceof Collection<?>)
                    query.setParameterList(param.getField(),
                            (Collection<?>) param.getValue());
                else
                    query.setParameter(param.getField(), param.getValue());
            }
        }

        long i = ((Long) query.list().get(0)).intValue();

        return i;
    }

    private void getQueryHql(StringBuffer hql, QueryParams... params) {
        if (params != null) {
            getQueryHql(hql, Arrays.asList(params));
        }
    }

    private void getQueryHql(StringBuffer hql, List<QueryParams> params) {

        if (params != null) {
            for (QueryParams param : params) {
                if (param == null)
                    continue;
                if (param.getEq() == QueryParams.EQ)
                    hql.append(" and ").append(param.getField()).append("=:")
                            .append(param.getField());
                else if (param.getEq() == QueryParams.GE)
                    hql.append(" and ").append(param.getField()).append(">=:")
                            .append(param.getField());
                else if (param.getEq() == QueryParams.LT)
                    hql.append(" and ").append(param.getField()).append("<:")
                            .append(param.getField());
                else if (param.getEq() == QueryParams.GT)
                    hql.append(" and ").append(param.getField()).append(">:")
                            .append(param.getField());
                else if (param.getEq() == QueryParams.LE)
                    hql.append(" and ").append(param.getField()).append("<=:")
                            .append(param.getField());
                else if (param.getEq() == QueryParams.LIKE)
                    hql.append(" and ").append(param.getField())
                            .append(" like :").append(param.getField());
                else if (param.getEq() == QueryParams.LEFT_LIKE)
                    hql.append(" and ").append(param.getField())
                            .append(" like :").append(param.getField());
                else if (param.getEq() == QueryParams.RIGHT_LIKE)
                    hql.append(" and ").append(param.getField())
                            .append(" like :").append(param.getField());
                else if (param.getEq() == QueryParams.IN)
                    hql.append(" and ").append(param.getField())
                            .append(" in(:").append(param.getField())
                            .append(")");
                else if (param.getEq() == QueryParams.NULL)
                    hql.append(" and ").append(param.getField())
                            .append(" is null ");
            }
        }
    }

    @Override
    public List<T> find(String field, Object value) {
        return find(new QueryParams(field, value));
    }

    @Override
    public T findUnique(String field, Object value) {
        return findUnique(new QueryParams(field, value));
    }

    @Override
    public T findUnique(QueryParams... params) {
        Session session = getSession();
        Criteria criteria = session.createCriteria(getPersistentClass());
        // criteria.setCacheable(true);

        if (params != null)
            for (QueryParams param : params) {
                if (param == null)
                    continue;
                if (param.getEq() == QueryParams.EQ)
                    criteria.add(Restrictions.eq(param.getField(),
                            param.getValue()));
                else if (param.getEq() == QueryParams.GE)
                    criteria.add(Restrictions.ge(param.getField(),
                            param.getValue()));
                else if (param.getEq() == QueryParams.LT)
                    criteria.add(Restrictions.lt(param.getField(),
                            param.getValue()));
                else if (param.getEq() == QueryParams.GT)
                    criteria.add(Restrictions.gt(param.getField(),
                            param.getValue()));
                else if (param.getEq() == QueryParams.LE)
                    criteria.add(Restrictions.le(param.getField(),
                            param.getValue()));
                else if (param.getEq() == QueryParams.LIKE)
                    criteria.add(Restrictions.like(param.getField(),
                            param.getValue()));
                else if (param.getEq() == QueryParams.LEFT_LIKE)
                    criteria.add(Restrictions.like(param.getField(),
                            param.getValue()));
                else if (param.getEq() == QueryParams.RIGHT_LIKE)
                    criteria.add(Restrictions.like(param.getField(),
                            param.getValue()));
                else if (param.getEq() == QueryParams.IN)
                    criteria.add(Restrictions.in(param.getField(),
                            (Collection<?>) param.getValue()));
                else if (param.getEq() == QueryParams.NULL)
                    criteria.add(Restrictions.isNull(param.getField()));
            }

        @SuppressWarnings("unchecked")
        T t = (T) criteria.uniqueResult();
        return t;
    }

    public List<?> findBySql(String sql) {
        return findBySql(sql, null);
    }

    public List<?> findBySql(String sql, Map<String, Object> params) {
        return findBySql(sql, params, -1, -1);
    }

    public List<?> findBySql(String sql, int first, int max) {
        return findBySql(sql, null, first, max);
    }

    public List<?> findBySql(String sql, Map<String, Object> params, int first,
                             int max) {

        if (sql == null || "".equals(sql))
            return null;

        Query query = getSession().createSQLQuery(sql);

        if (params != null) {
            for (String key : params.keySet())
                if (params.get(key) instanceof Collection<?>)
                    query.setParameterList(key, (Collection<?>) params.get(key));
                else
                    query.setParameter(key, params.get(key));
        }

        if (first > 0)
            query.setFirstResult(first);

        if (max > 0)
            query.setMaxResults(max);

        return query.list();
    }
}
