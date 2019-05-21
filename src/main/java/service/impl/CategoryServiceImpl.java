package service.impl;

import converter.Converter;
import dao.CategoryDao;
import dao.CategoryI18nDao;
import dao.LocaleDao;
import dto.CategoryDto;
import entity.Category;
import entity.CategoryI18n;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CategoryService;

import java.util.List;

@Service("CategoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDao categoryDao;
    @Autowired
    CategoryI18nDao categoryI18nDao;
    @Autowired
    LocaleDao localeDao;
    @Autowired
    Converter cnvrt;

    @Override
    public List<CategoryDto> getCategory(String locale) {
        List<Category> categoryList = categoryDao.getAllCategory();
        List<CategoryI18n> categoryI18nList = categoryI18nDao.getAll(localeDao.read(locale));
        return cnvrt.categoryToCategoryDto(categoryList, categoryI18nList);
    }

}
//   model.addAttribute("getAllCategory", getAllCategory);