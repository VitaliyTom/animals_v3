package dao.impl;

import dao.CategoryDao;
import entity.Category;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
//@Repository("categories")
@Transactional
public class CategoryDaoImpl implements CategoryDao {

@Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Category> getAllCategory() {

        String getAllCategoryHql= "FROM Category";
        Query query = sessionFactory.getCurrentSession().createQuery(getAllCategoryHql);
        List<Category> list = query.list();
        return list;
            }
}
