package dao.impl;

import dao.CategoryI18nDao;
import entity.CategoryI18n;
import entity.Locale;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class CategoryI18nDaoImpl implements CategoryI18nDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public CategoryI18n getId(CategoryI18n categoryI18n) {

        String categoryI18nHql = "FROM CategoryI18n WHERE localeCategoryI18n =:locale AND idCategory =:categoryId";
        Query query = sessionFactory.getCurrentSession().createQuery(categoryI18nHql);
        query.setParameter("locale", categoryI18n.getLocaleCategoryI18n());
        query.setParameter("categoryId", categoryI18n.getIdCategory());
        return (CategoryI18n) query.uniqueResult();
    }

    @Override
    public List<CategoryI18n> getAll(Locale locale) {

        String categoryI18nGetAllHql = "FROM CategoryI18n WHERE localeCategoryI18n =:locale";
        Query query = sessionFactory.getCurrentSession().createQuery(categoryI18nGetAllHql);
        query.setParameter("locale", locale);
        List<CategoryI18n> categoryI18nList = query.list();
        return categoryI18nList;
    }
}
