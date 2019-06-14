package dao;

import entity.Category;

import java.util.List;

public interface CategoryDao {

    List<Category> getAllCategory();

    Category read(long categoryId);

    void saveOrUpdate(Category  category);

    void delete(long id);


}
