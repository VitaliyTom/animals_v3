package dao.impl;

import dao.CategoryDao;
import entity.Category;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
//@Repository("categories")  fixme разобрать!
@Transactional
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Category> getAllCategory() {

        String getAllCategoryHql = "FROM Category";
        Query query = sessionFactory.getCurrentSession().createQuery(getAllCategoryHql);
        List<Category> list = query.list();
        return list;
    }

    @Override
    public Category read(long categoryId) {
        String categoryHQL = "FROM Category WHERE categoryId =:idCategory";
        Query query = sessionFactory.getCurrentSession().createQuery(categoryHQL);
        query.setParameter("idCategory", categoryId);

        //Category category = sessionFactory.getCurrentSession().get(Category.class, categoryId);

        return (Category) query.uniqueResult();

    }


}
