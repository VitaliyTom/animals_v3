package service.impl;

import converter.Entity2Dto.CategoryDto2CategoryConverter;
import converter.Entity2Dto.CategoryEntity2CategoryDtoConverter;
import dao.CategoryDao;
import dao.CategoryI18nDao;
import dao.LocaleDao;
import dto.CategoryDto;
import entity.Category;
import entity.CategoryI18n;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CategoryService;

import java.util.ArrayList;
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
    CategoryDto2CategoryConverter categoryDto2CategoryConverter;
    @Autowired
    CategoryEntity2CategoryDtoConverter categoryEntity2CategoryDtoConverter;

    @Override
    public void create(CategoryDto categoryDto) {

        categoryDao.saveOrUpdate(categoryDto2CategoryConverter.convert(categoryDto));

    }

    @Override
    public List<CategoryDto> getCategory(String locale) {
        List<Category> categoryList = categoryDao.getAllCategory();
        List<CategoryDto> categoryDtoList = categoryEntity2CategoryDtoConverter.convert(categoryList);
        List<CategoryI18n> categoryI18nList = categoryI18nDao.getAll(localeDao.read(locale));
        for (CategoryDto categories : categoryDtoList) {
            for (CategoryI18n nameCategory : categoryI18nList) {
                if (nameCategory.getIdCategory().getCategoryId() == categories.getCategoryIdDto()) {
                    categories.setNameCategoryRus(nameCategory.getNameCategoryI18n());
                }
            }
        }
        return categoryDtoList;
    }
}
