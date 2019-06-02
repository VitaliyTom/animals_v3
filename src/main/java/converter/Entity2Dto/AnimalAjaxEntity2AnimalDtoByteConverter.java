package converter.Entity2Dto;

import converter.Dto2Entity.AnimalI18nDto2AnimalI18nEntityConverter;
import dao.AnimalDao;
import dao.CategoryDao;
import dao.LocaleDao;
import dto.AnimalAjaxDto;
import dto.AnimalDtoByte;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AnimalAjaxEntity2AnimalDtoByteConverter implements Converter<AnimalAjaxDto, AnimalDtoByte> {

    @Autowired
    AnimalDao animalDao;
    @Autowired
    LocaleDao localeDao;
    @Autowired
    CategoryDao categoryDao;
    @Autowired
    AnimalI18nDto2AnimalI18nEntityConverter animalI18nDto2AnimalI18nEntityConverter;

    @Override
    public AnimalDtoByte convert(AnimalAjaxDto animalAjaxDto) {

        AnimalI18n animalI18n = animalI18nDto2AnimalI18nEntityConverter.convert(animalAjaxDto);
        Animal animal = animalDao.read(animalAjaxDto.getIdAnimals());
        Locale locale = localeDao.read(animalAjaxDto.getAnimalI18nLocaleDto());
        animalI18n.setLocaleAnimalI18n(locale);

        AnimalDtoByte animalDtoByte = new AnimalDtoByte();
        animalDtoByte.setIdAnimal(animal.getAnimalId());
        animalDtoByte.setNameAnimal(animalI18n.getNameAnimalI18n());
        animalDtoByte.setImageAnimal(animal.getAnimalImage());
        animalDtoByte.setAudioAnimal(animal.getAnimalAudio());

        Category category = categoryDao.read(animal.getCategoryAnimal().getCategoryId());
        CategoryI18n categoryI18n = new CategoryI18n();
        categoryI18n.setI18nCategoryId(category.getCategoryId());
        categoryI18n.setLocaleCategoryI18n(locale);
        animalDtoByte.setCategoryId(category.getCategoryId());
        animalDtoByte.setNameCategory(categoryI18n.getNameCategoryI18n());
        animalDtoByte.setLogoCategory(category.getLogo());

        return animalDtoByte;

    }
}
