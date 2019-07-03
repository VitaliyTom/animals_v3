package dao;

import entity.AnimalI18n;
import entity.Locale;

import java.util.List;

public interface AnimalI18nDao {

    AnimalI18n getId(AnimalI18n animalI18n);

    List<AnimalI18n> getAll(Locale locale);

    void saveOrUpdate(AnimalI18n animalI18n);

}
