package converter.Dto2Entity;

import dao.CategoryDao;
import dao.CategoryI18nDao;
import dao.LocaleDao;
import dto.CategoryDto;
import entity.Category;
import entity.CategoryI18n;
import entity.Locale;
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
    @Autowired
    CategoryDao categoryDao;

    @Override
    public Category convert(CategoryDto categoryDto) {

        Category category = categoryDto.getCategoryIdDto() != 0 ? categoryDao.read(categoryDto.getCategoryIdDto()) : new Category();
        if (categoryDto.getLogo() != null) {
            try {
                category.setLogo(categoryDto.getLogo().getBytes());
            } catch (IOException e) {
                LOGGER.error("error_field_upload_getBytes in categoryDto to category logo -img");
                e.printStackTrace();
            }
        }
        List<CategoryI18n> categoryI18nList = new ArrayList<>();
        categoryI18nList.add(createI18N(categoryDto.getNameCategoryRus(), "ru", category));
        categoryI18nList.add(createI18N(categoryDto.getNameCategoryEng(), "en", category));
        category.setCategoryName(categoryI18nList);
        return category;
    }

    private CategoryI18n createI18N(String name, String locale, Category category) {
        Locale loc = localeDao.read(locale);
        CategoryI18n categoryI18n = new CategoryI18n();
        if (category.getCategoryName() != null) {
            List<CategoryI18n> I18n = categoryI18nDao.getAll(loc);
            for (CategoryI18n categoryName : I18n)
                if (category.getCategoryId() == categoryName.getIdCategory().getCategoryId()) {
                    categoryI18n = categoryName;
                }
        }
        categoryI18n.setLocaleCategoryI18n(loc);
        categoryI18n.setNameCategoryI18n(name);
        categoryI18n.setIdCategory(category);
        return categoryI18n;
    }
}


