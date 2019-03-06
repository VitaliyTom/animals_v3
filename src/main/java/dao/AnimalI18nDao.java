package dao;

import entity.Animal;
import entity.AnimalI18n;

public interface AnimalI18nDao {

    AnimalI18n getId(long animalId, String locale);
}
