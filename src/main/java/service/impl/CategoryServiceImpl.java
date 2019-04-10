package service.impl;

import dao.CategoryDao;
import entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import service.CategoryService;

import java.util.List;

@Service("CategoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDao categoryDao;

    @Override
    @Transactional
    public List<Category> getCategory() {
        return categoryDao.getAllCategory();
    }
}
//   model.addAttribute("getAllCategory", getAllCategory);