package dao;

import entity.CategoryI18n;
import entity.Locale;

import java.util.List;

public interface CategoryI18nDao {

    CategoryI18n getId(CategoryI18n categoryI18n);
    List<CategoryI18n> getAll(Locale locale);

}
