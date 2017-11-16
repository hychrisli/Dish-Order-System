package cmpe.dos.dao.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cmpe.dos.dao.HibernateDao;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;

@Configuration
public abstract class HibernateDaoImpl<T> extends HibernateDaoSupport implements HibernateDao<T> {
    
    protected Class<T> poClass;
    
    public HibernateDaoImpl(Class<T> poClass) {
	this.poClass = poClass;
    }

    @Autowired
    public void initSessFactory(SessionFactory sessionFactory)
    {
        setSessionFactory(sessionFactory);
    }
   
    @Override
    public T getById(Serializable id) {
	return getHibernateTemplate().get(poClass, id);
    }

    @Override
    public void delete(T po) {
	getHibernateTemplate().delete(po);
    }

    @Override
    public void deleteById(Serializable id) {
	Object o = getById(id);
	if (o != null) {
	    getHibernateTemplate().delete(o);
	}
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAll() {
	return (List<T>) getHibernateTemplate().find("from " + poClass.getName() + " obj");
    }

    @Override
    public List<T> findByCriterion(Criterion... criterion) {

	return (List<T>) getHibernateTemplate().execute(new HibernateCallback<List<T>>() {

	    @SuppressWarnings({ "unchecked" })
	    public List<T> doInHibernate(Session session) throws HibernateException {
		Criteria criteria = session.createCriteria(poClass);
		for (Criterion c : criterion) {
		    criteria.add(c);
		}
		return criteria.list();
	    }
	});
    }

    @Override
    public void save(T po) {
	getHibernateTemplate().merge(po);
    }

    @Override
    public T saveReturn(T po) {
	return getHibernateTemplate().merge(po);
    }

    @Override
    public void create(T po) {
	getHibernateTemplate().save(po);
    }

    @Override
    public void update(T po) {
	getHibernateTemplate().update(po);
    }

    @Override
    public T doQueryUnique(String hql, Object... values) {
	return this.getHibernateTemplate().execute(new HibernateCallback<T>() {

	    @SuppressWarnings("unchecked")
	    public T doInHibernate(Session session) throws HibernateException {
		Query query = session.createQuery(hql);
		query.setCacheable(true);
		for (int i = 0; i < values.length; i++) {
		    query.setParameter(i, values[i]);
		}
		return (T) query.uniqueResult();
	    }
	});
    }

    @Override
    public T doQueryFirst(String hql, Object... values) {
	return this.getHibernateTemplate().execute(new HibernateCallback<T>() {

	    @SuppressWarnings("unchecked")
	    public T doInHibernate(Session session) throws HibernateException {
		Query query = session.createQuery(hql);
		query.setCacheable(true);
		for (int i = 0; i < values.length; i++) {
		    query.setParameter(i, values[i]);
		}
		List<T> list = query.list();
		if (list.size() > 0) {
		    return list.get(0);
		} else {
		    return null;
		}
	    }
	});
    }

    @Override
    public void executeHsql(String hql, Object... values) {
	this.getHibernateTemplate().execute(new HibernateCallback<Object>() {
	    public Object doInHibernate(Session session) throws HibernateException {
		Query query = session.createQuery(hql);
		for (int i = 0; i < values.length; i++) {
		    query.setParameter(i, values[i]);
		}
		query.executeUpdate();
		return null;
	    }
	});
    }

    @Override
    public List<T> doQueryList(String hql, boolean cacheable, Object... values) {
	return this.getHibernateTemplate().execute(new HibernateCallback<List<T>>() {

	    @SuppressWarnings("unchecked")
	    public List<T> doInHibernate(Session session) throws HibernateException {
		Query query = session.createQuery(hql);
		query.setCacheable(cacheable);
		for (int i = 0; i < values.length; i++)
		    query.setParameter(i, values[i]);

		return query.list();
	    }
	});
    }

    @Override
    public String getFromHql() {
	return "from " + poClass.getName();
    }

    @Override
    public long doQueryCount(String hql, Object... values) {
	return this.getHibernateTemplate().execute(new HibernateCallback<Long>() {
	    public Long doInHibernate(Session session) throws HibernateException {
		Query query = session.createQuery(hql);
		for (int i = 0; i < values.length; i++) {
		    query.setParameter(i, values[i]);
		}
		Long count = (Long) query.uniqueResult();
		if (count == null) {
		    return 0L;
		} else {
		    return count;
		}
	    }
	});
    }

    @Override
    public List<T> doQueryLimitList(String hql, boolean cacheable, int dataNum, Object... values) {
	return this.getHibernateTemplate().execute(new HibernateCallback<List<T>>() {

	    @SuppressWarnings("unchecked")
	    public List<T> doInHibernate(Session session) throws HibernateException {
		Query query = session.createQuery(hql);
		query.setCacheable(cacheable);
		for (int i = 0; i < values.length; i++) {
		    query.setParameter(i, values[i]);
		}
		query.setFirstResult(0);
		query.setMaxResults(dataNum);
		return query.list();
	    }
	});
    }

    @Override
    public List<T> findByProperty(String propertyName, Object value) {
	String poName = poClass.getName();
	logger.debug("finding " + poName + " instance with property: " + propertyName + ", value: " + value);
	try {
	    String hql = "from " + poName + " as model where model." + propertyName + "= ?";
	    return doQueryList(hql, true, value);
	} catch (RuntimeException re) {
	    logger.error("find by property name failed", re);
	    throw re;
	}
    }

    @Override
    public List<String> doQueryListString(final String hql, final boolean cacheable, final Object... values) {
	return this.getHibernateTemplate().execute(new HibernateCallback<List<String>>() {

	    @SuppressWarnings("unchecked")
	    public List<String> doInHibernate(Session session) throws HibernateException {
		Query query = session.createQuery(hql);
		query.setCacheable(cacheable);
		for (int i = 0; i < values.length; i++) {
		    query.setParameter(i, values[i]);
		}
		return query.list();
	    }
	});
    }

    @Override
    public List<Date> doQueryListDate(final String hql, final boolean cacheable, final Object... values) {
	return (List<Date>) this.getHibernateTemplate().execute(new HibernateCallback<List<Date>>() {

	    @SuppressWarnings("unchecked")
	    public List<Date> doInHibernate(Session session) throws HibernateException {
		Query query = session.createQuery(hql);
		query.setCacheable(cacheable);
		for (int i = 0; i < values.length; i++) {
		    query.setParameter(i, values[i]);
		}
		return query.list();
	    }
	});
    }

    public List<Date> doQueryLimitListDate(final String hql, final boolean cacheable, final int dataNum,
	    final Object... values) {
	return this.getHibernateTemplate().execute(new HibernateCallback<List<Date>>() {

	    @SuppressWarnings("unchecked")
	    public List<Date> doInHibernate(Session session) throws HibernateException {
		Query query = session.createQuery(hql);
		query.setCacheable(cacheable);
		for (int i = 0; i < values.length; i++) {
		    query.setParameter(i, values[i]);
		}
		query.setFirstResult(0);
		query.setMaxResults(dataNum);
		return query.list();
	    }
	});
    }

    @Override
    public List<T> findByCombineProperties(Map<String, Object> pairs) {
	return (List<T>) this.getHibernateTemplate().execute(new HibernateCallback<List<T>>() {

	    @SuppressWarnings("unchecked")
	    public List<T> doInHibernate(Session session) throws HibernateException {
		String poName = poClass.getName();
		String[] properties = pairs.keySet().toArray(new String[0]);
		Object[] values = pairs.values().toArray();
		StringBuffer sb = new StringBuffer(
			"from " + poName + " as model where model." + properties[0] + " = ?");
		for (int i = 1; i < properties.length; i++) {
		    sb.append(" and model." + properties[i] + " = ?");
		}
		String hql = sb.toString();
		Query query = session.createQuery(hql);
		query.setCacheable(true);
		for (int i = 0; i < values.length; i++) {
		    query.setParameter(i, values[i]);
		}
		return query.list();
	    }
	});
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List doQueryListUntype(String hql, boolean cacheable, Object... values) {
        return this.getHibernateTemplate().execute(new HibernateCallback<List>() {
            public List doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(hql);
                query.setCacheable(cacheable);
                for (int i = 0; i < values.length; i++) {
                    query.setParameter(i, values[i]);
                }
                return query.list();
            }
        });
    }

    @Override
    public void batchCreate(List<T> poList) {
	this.getHibernateTemplate().execute(new HibernateCallback<Object>() {
	    public Object doInHibernate(Session session) throws HibernateException {
		int j = 0;
		for (int i = 0; i < poList.size(); i++) {
		    session.save(poList.get(i));
		    if (i == 2)
			break;
		}
		return true;
	    }
	});

    }

}
