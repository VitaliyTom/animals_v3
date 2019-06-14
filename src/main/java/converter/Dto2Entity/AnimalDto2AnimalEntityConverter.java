package converter.Dto2Entity;

import dao.AnimalDao;
import dao.AnimalI18nDao;
import dao.CategoryDao;
import dao.LocaleDao;
import dto.AnimalDto;
import entity.Animal;
import entity.AnimalI18n;
import entity.Category;
import entity.Locale;
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

        Animal animal = animalDto.getIdAnimal() != 0 ? animalDao.read(animalDto.getIdAnimal()) : new Animal();
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

        List<AnimalI18n> animalI18nList = new ArrayList<>();
        animalI18nList.add(createI18N(animalDto.getNameAnimalRus(), "ru", animal));
        animalI18nList.add(createI18N(animalDto.getNameAnimalEng(), "en", animal));
        animal.setAnimalName(animalI18nList);
        return animal;
    }

    private AnimalI18n createI18N(String name, String locale, Animal animal) {
        Locale loc = localeDao.read(locale);
        AnimalI18n animalI18n = new AnimalI18n();
        if (animal.getAnimalName() != null) {
            List<AnimalI18n> I18n = animalI18nDao.getAll(loc);
            for (AnimalI18n animalName : I18n)
                if (animal.getAnimalId() == animalName.getIdAnimals().getAnimalId()) {
                    animalI18n = animalName;
                }
        }
        animalI18n.setLocaleAnimalI18n(loc);
        animalI18n.setNameAnimalI18n(name);
        animalI18n.setIdAnimals(animal);
        return animalI18n;
    }
}

 /*
 private AnimalI18n createI18N(String name, String locale, Animal animal) {
Locale loc = localeDao.read(locale);
Optional<AnimalI18n> i18n = animal.getAnimalName().stream().filter(animalI18n -> animalI18n.getLocaleAnimalI18n().equals(loc)).findAny();
AnimalI18n animalI18nEn = i18n.isPresent() ? i18n.get() : new AnimalI18n();
animalI18nEn.setLocaleAnimalI18n(loc);
animalI18nEn.setNameAnimalI18n(name);
animalI18nEn.setIdAnimals(animal);
return animalI18nEn;
}
 */
