package converter.Dto2Entity;

import dao.AnimalDao;
import dao.AnimalI18nDao;
import dao.CategoryDao;
import dao.LocaleDao;
import dto.AnimalDto;
import entity.Animal;
import entity.AnimalI18n;
import entity.Category;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class AnimalDto2AnimalEntityConverter implements Converter<AnimalDto, Animal> {

    private static final Logger LOGGER = Logger.getLogger(AnimalDto2AnimalEntityConverter.class);

    @Autowired
    CategoryDao categoryDao;
    @Autowired
    LocaleDao localeDao;
    @Autowired
    AnimalI18nDao animalI18nDao;
    @Autowired
    AnimalDao animalDao;

    @Override
    public Animal convert(AnimalDto animalDto) {
            Animal animal = new Animal();
        if (animalDto.getImageAnimal() != null && animalDto.getAudioAnimal() != null) {
            try {
                animal.setAnimalImage(animalDto.getImageAnimal().getBytes());
                animal.setAnimalAudio(animalDto.getAudioAnimal().getBytes());
            } catch (IOException e) {
                LOGGER.error("error_field_upload_getBytes in animalDto to animal-img and audio");
                e.printStackTrace();
            }
        }
        Category category = categoryDao.read(animalDto.getCategoryId());
        animal.setCategoryAnimal(category);
        animal.setAnimalId(animalDto.getIdAnimal());
        return animal;
    }
}
/*
   String ru = "ru";
        String en = "en";
        List<AnimalI18n> animalI18nList = new ArrayList<>();

        Animal animal = new Animal();
        if (animalDto.getImageAnimal() != null && animalDto.getAudioAnimal() != null) {
            try {
                animal.setAnimalImage(animalDto.getImageAnimal().getBytes());
                animal.setAnimalAudio(animalDto.getAudioAnimal().getBytes());
            } catch (IOException e) {
                LOGGER.error("error_field_upload_getBytes in animalDto to animal-img and audio");
                e.printStackTrace();
            }
        }
        Category category = categoryDao.read(animalDto.getCategoryId());
        animal.setCategoryAnimal(category);
        animal.setAnimalId(animalDto.getIdAnimal());

        AnimalI18n animalI18nRu = new AnimalI18n();
        animalI18nRu.setLocaleAnimalI18n(localeDao.read(ru));
        animalI18nRu.setNameAnimalI18n(animalDto.getNameAnimalRus());
        animalI18nRu.setIdAnimals(animal);
//        animalI18nList.add(animalI18nRu);
        animalI18nDao.saveOrUpdate(animalI18nRu);
//        animalDao.saveOrUpdate(animal);
        animalI18nRu.setI18nAnimalId(animalI18nDao.getId(animalI18nRu).getI18nAnimalId());
        animalI18nList.add(animalI18nRu);

        AnimalI18n animalI18nEn = new AnimalI18n();
        animalI18nEn.setLocaleAnimalI18n(localeDao.read(en));
        animalI18nEn.setNameAnimalI18n(animalDto.getNameAnimalEng());
        animalI18nEn.setIdAnimals(animal);
//        animalI18nList.add(animalI18nEn);
        animalI18nDao.saveOrUpdate(animalI18nEn);
        animalI18nEn.setI18nAnimalId(animalI18nDao.getId(animalI18nEn).getI18nAnimalId());
        animalI18nList.add(animalI18nEn);
        animal.setAnimalName(animalI18nList);
        //try catch img mp3
*/