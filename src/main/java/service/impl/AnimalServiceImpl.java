package service.impl;

import converter.Dto2Entity.AnimalAjaxDto2AnimalConverter;
import converter.Dto2Entity.AnimalDto2AnimalEntityConverter;
import converter.Entity2Dto.AnimalI18n2AnimalDtoByteConverter;
import converter.Entity2Dto.CategoryI18n2AnimalDtoByteConverter;
import dao.*;
import dto.AnimalAjaxDto;
import dto.AnimalDto;
import dto.AnimalDtoByte;
import entity.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import service.AnimalService;

import java.util.List;
import java.util.Random;


@Service("animalService")
public class AnimalServiceImpl implements AnimalService {

    private static final Logger LOGGER = Logger.getLogger(AnimalServiceImpl.class);

    @Autowired
    LocaleDao localeDao;
    @Autowired
    AnimalDao animalDao;
    @Autowired
    CategoryDao categoryDao;
    @Autowired
    AnimalI18nDao animalI18nDao;
    @Autowired
    CategoryI18nDao categoryI18nDao;
    @Autowired
    AnimalDto2AnimalEntityConverter animalDto2AnimalEntityConverter;
    @Autowired
    AnimalAjaxDto2AnimalConverter animalAjaxDto2AnimalConverter;
    @Autowired
    AnimalI18n2AnimalDtoByteConverter animalI18n2AnimalDtoByteConverter;
    @Autowired
    CategoryI18n2AnimalDtoByteConverter categoryI18n2AnimalDtoByteConverter;

    @Override
    @Transactional                                                //fixme разобраться с этой аннотацией!
    public void create(AnimalDto animalDto) {
            Animal animal = animalDto2AnimalEntityConverter.convert(animalDto);
            animalDao.saveOrUpdate(animal);
    }
    @Override
    public void update(AnimalDto animalDto) {
        Animal animal = animalDto2AnimalEntityConverter.convert(animalDto);
        animalDao.saveOrUpdate(animal);
    }

    @Override
    @Transactional
    public void delete(long id) {
        animalDao.delete(id);
    }

    @Override
    @Transactional
    public List<AnimalDtoByte> getAll(String locale) {

        List<AnimalI18n> getAllAnimalI18n = animalI18nDao.getAll(localeDao.read(locale));
        List<CategoryI18n> getAllCategoryI18n = categoryI18nDao.getAll(localeDao.read(locale));
        List<AnimalDtoByte> animalDtoByteList = animalI18n2AnimalDtoByteConverter.convert(getAllAnimalI18n);
        List<AnimalDtoByte> animalDtoByteListCategoryName = categoryI18n2AnimalDtoByteConverter.convert(getAllCategoryI18n);

        for (AnimalDtoByte animalDtoByte : animalDtoByteList) {

            for (AnimalDtoByte AnimalDtoByteCategory : animalDtoByteListCategoryName) {
                if (animalDtoByte.getCategoryId() == AnimalDtoByteCategory.getCategoryId()) {
                    animalDtoByte.setNameCategory(AnimalDtoByteCategory.getNameCategory());
                    animalDtoByte.setLogoCategory(AnimalDtoByteCategory.getLogoCategory());
                }
            }
        }
        return animalDtoByteList;
    }

    @Override
    public AnimalDtoByte getIdAjax(AnimalAjaxDto animalAjaxDto) {

        Animal animal = animalAjaxDto2AnimalConverter.convert(animalAjaxDto);
        Locale locale = localeDao.read(animalAjaxDto.getAnimalI18nLocaleDto());
        AnimalI18n animalI18n = new AnimalI18n();
        animalI18n.setIdAnimals(animal);
        animalI18n.setLocaleAnimalI18n(locale);
        animalI18n = animalI18nDao.getId(animalI18n);

        Category category = categoryDao.read(animal.getCategoryAnimal().getCategoryId());
        CategoryI18n categoryI18n = new CategoryI18n();
        categoryI18n.setIdCategory(category);
        categoryI18n.setLocaleCategoryI18n(locale);
        categoryI18n = categoryI18nDao.getId(categoryI18n);

        AnimalDtoByte animalDtoByte = new AnimalDtoByte();
        animalDtoByte.setIdAnimal(animal.getAnimalId());
        animalDtoByte.setNameAnimal(animalI18n.getNameAnimalI18n());
        animalDtoByte.setImageAnimal(animal.getAnimalImage());
        animalDtoByte.setAudioAnimal(animal.getAnimalAudio());
        animalDtoByte.setCategoryId(category.getCategoryId());
        animalDtoByte.setNameCategory(categoryI18n.getNameCategoryI18n());
        animalDtoByte.setLogoCategory(category.getLogo());

        return animalDtoByte;
    }

    @Deprecated
    @Override
    @Transactional
    public void getIdMax(ModelMap model) {
        Animal animalIdMax = animalDao.getIdMax();
        Random rnd = new Random();
        int id = 0;
        int i = 1;
        boolean flag = true;
        while (flag) {
            //selection of an arbitrary id in the range of existing
            id = 1 + rnd.nextInt((int) animalIdMax.getAnimalId());
            Animal animal = animalDao.read((long) id);
            //we check there is an object under such id or not
            if (animal == null) {
                i++;
            } else {
                flag = false;
                LOGGER.info("найден существующий идишник c " + i + " попытки.");
            }
        }
    }

}
