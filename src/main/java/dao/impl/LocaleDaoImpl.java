package dao.impl;

import dao.LocaleDao;
import entity.Locale;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;



@Component
@Transactional
public class LocaleDaoImpl implements LocaleDao {

    @Autowired
    private SessionFactory  sessionFactory;

    @Override
    public Locale read(String locale) {
        String getLocaleHql = "FROM Locale WHERE locale=:locale";
        Query query = sessionFactory.getCurrentSession().createQuery(getLocaleHql);
        query.setParameter("locale", locale);
        return (Locale) query.uniqueResult();
    }
}
