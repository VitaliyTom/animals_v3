package dao.impl;


import dao.AnimalI18nDao;
import entity.AnimalI18n;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class AnimalI18nDaoImpl implements AnimalI18nDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override           //fixme
    public AnimalI18n getId(AnimalI18n animalI18n) {

        String animalI18nHQL = "FROM AnimalI18n WHERE animalI18nLocale =:locale AND idAnimals =:animalId";
        Query query = sessionFactory.getCurrentSession().createQuery(animalI18nHQL);
        query.setParameter("locale", animalI18n.getAnimalI18nLocale());
        query.setParameter("animalId", animalI18n.getIdAnimals());
        return (AnimalI18n) query.uniqueResult();
    }

    @Override
    public List<AnimalI18n> getAll(String locale) {
        String animalI18nGetAllHQL = "FROM AnimalI18n WHERE animalI18nLocale =:locale";
        Query query = sessionFactory.getCurrentSession().createQuery(animalI18nGetAllHQL);
        query.setParameter("locale", locale);
        List<AnimalI18n> animalI18nList = query.list();
        return animalI18nList;
    }
}
