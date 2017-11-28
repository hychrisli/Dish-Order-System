package cmpe.dos.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;

public interface HibernateDao<T> {

    public T getById(Serializable id);

    public void delete(T po);

    public void deleteById(Serializable id);

    public List<T> findAll();

    public List<T> findByCriterion(final Criterion... criterion);

    public void save(T po);

    public T saveReturn(T po);

    public void create(T po);

    public void update(T po);

    public T doQueryUnique(final String hql, final Object... values);

    public T doQueryFirst(final String hql, final Object... values);

    public void executeHsql(final String hql, final Object... values);

    public List<T> doQueryList(final String hql, final boolean cacheable, final Object... values);

    public String getFromHql();

    public long doQueryCount(final String hql, final Object... values);

    public List<T> doQueryLimitList(final String hql, final boolean cacheable, final int dataNum,
	    final Object... values);

    public List<T> findByProperty(String propertyName, Object value);

    public List<String> doQueryListString(final String hql, final boolean cacheable, final Object... values);

    public List<Date> doQueryListDate(final String hql, final boolean cacheable, final Object... values);

    public List<Date> doQueryLimitListDate(final String hql, final boolean cacheable, final int dataNum,
	    final Object... values);

    public List<T> findByCombineProperties(final Map<String, Object> pairs);

    public List doQueryListUntype(final String hql, final boolean cacheable, final Object... values);

    public void batchCreate(final List<T> poList);
}