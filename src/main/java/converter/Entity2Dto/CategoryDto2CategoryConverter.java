package converter.Entity2Dto;

import dao.CategoryDao;
import dao.CategoryI18nDao;
import dao.LocaleDao;
import dto.CategoryDto;
import entity.Category;
import entity.CategoryI18n;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryDto2CategoryConverter implements Converter<CategoryDto, Category> {

    private static final Logger LOGGER = Logger.getLogger(CategoryDto2CategoryConverter.class);

    @Autowired
    LocaleDao localeDao;
    @Autowired
    CategoryI18nDao categoryI18nDao;
//    @Autowired
//    CategoryDao categoryDao;

    @Override
    public Category convert(CategoryDto categoryDto) {

        String ru = "ru";
        String en = "en";
        List<CategoryI18n> categoryI18nList = new ArrayList<>();

        Category category = new Category();
//        Category category = categoryDao.read(categoryDto.getCategoryIdDto());
        category.setCategoryId(categoryDto.getCategoryIdDto());

        CategoryI18n categoryI18nRu = new CategoryI18n();
        categoryI18nRu.setLocaleCategoryI18n(localeDao.read(ru));
        categoryI18nRu.setIdCategory(category);
        CategoryI18n categoryI18nRu2 = categoryI18nDao.getId(categoryI18nRu);
        categoryI18nRu.setNameCategoryI18n(categoryDto.getNameCategoryRus());
        categoryI18nList.add(categoryI18nRu2);

        CategoryI18n categoryI18nEn = new CategoryI18n();
        categoryI18nEn.setLocaleCategoryI18n(localeDao.read(en));
        categoryI18nEn.setIdCategory(category);
        CategoryI18n categoryI18nEn2 = categoryI18nDao.getId(categoryI18nEn);
        categoryI18nEn.setNameCategoryI18n(categoryDto.getNameCategoryEng());
        categoryI18nList.add(categoryI18nEn2);

        category.setCategoryName(categoryI18nList);

        if (categoryDto.getLogo() != null) {
            try {
                category.setLogo(categoryDto.getLogo().getBytes());
            } catch (IOException e) {
                LOGGER.error("error_field_upload_getBytes in categoryDto to category-logo");
                e.printStackTrace();
            }
        }
        return category;
    }
}
/*   String ru = "ru";
        String en = "en";
        List<CategoryI18n> categoryI18nList = new ArrayList<>();
        Category category = new Category();
        category.setCategoryId(categoryDto.getCategoryIdDto());

        CategoryI18n categoryI18nRu = new CategoryI18n();
        categoryI18nRu.setLocaleCategoryI18n(localeDao.read(ru));
        categoryI18nRu.setIdCategory(category);
        categoryI18nRu = categoryI18nDao.getId(categoryI18nRu);
//        categoryI18nRu.setNameCategoryI18n(categoryDto.getNameCategoryRus());
        categoryI18nList.add(categoryI18nRu);

        CategoryI18n categoryI18nEn = new CategoryI18n();
        categoryI18nEn.setLocaleCategoryI18n(localeDao.read(en));
        categoryI18nEn.setIdCategory(category);
        categoryI18nEn=categoryI18nDao.getId(categoryI18nEn);
//        categoryI18nEn.setNameCategoryI18n(categoryDto.getNameCategoryEng());
        categoryI18nList.add(categoryI18nEn);

        category.setCategoryName(categoryI18nList);

        if (categoryDto.getLogo() != null) {
            try {
                category.setLogo(categoryDto.getLogo().getBytes());
            } catch (IOException e) {
                LOGGER.error("error_field_upload_getBytes in categoryDto to category-logo");
                e.printStackTrace();
            }
        }
        return category;*/

