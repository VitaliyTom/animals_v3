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
@Transactional
//@Repository("categories")  fixme разобрать!
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Category> getAllCategory() {

        String getAllCategoryHql = "FROM Category";
        Query query = sessionFactory.getCurrentSession().createQuery(getAllCategoryHql);
        List<Category> list = query.list();
        return list;
    }

    @Override
    public Category read(long categoryId) {
        return sessionFactory.getCurrentSession().get(Category.class, categoryId);
    }

    @Override
    public void saveOrUpdate(Category category) {
        sessionFactory.getCurrentSession().saveOrUpdate(category);
    }

    @Override
    public void delete(long id) {
        sessionFactory.getCurrentSession().delete(this.read(id));
    }

}
