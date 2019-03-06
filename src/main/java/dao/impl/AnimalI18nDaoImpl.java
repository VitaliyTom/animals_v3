package dao.impl;

import dao.AnimalI18nDao;
import entity.AnimalI18n;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class AnimalI18nDaoImpl implements AnimalI18nDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override           //fixme  падла не работает :(
    public AnimalI18n getId(long animalId, String locale) {

        String animalI18nHQL = "FROM AnimalI18n WHERE  locale = animalI18nLocale AND animalId = idAnimals";
        Query query = sessionFactory.getCurrentSession().createQuery(animalI18nHQL);
        query.uniqueResult();
        return (AnimalI18n) query.uniqueResult();

    }
}
