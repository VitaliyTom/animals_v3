package converter;

import dao.*;
import dto.AnimalDto;
import dto.AnimalDtoByte;
import dto.AnimalI18nDto;
import dto.CategoryDto;
import entity.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class Converter {

    private static final Logger LOGGER = Logger.getLogger(Converter.class);

    @Autowired
    CategoryDao categoryDao;
    @Autowired
    AnimalI18nDao animalI18nDao;
    @Autowired
    AnimalDao animalDao;
    @Autowired
    LocaleDao localeDao;
    @Autowired
    CategoryI18nDao categoryI18nDao;


    //  animalDto to Animal
    public Animal animalDtoToAnimal(AnimalDto animalDto) {
        String ru = "ru";
        String en = "en";
        List<AnimalI18n> animalI18nList = new ArrayList<>();
//        List<CategoryI18n> categoryI18nList = new ArrayList<>();
        Animal animal = new Animal();

        Category category = categoryDao.read(animalDto.getCategoryId());

//        if (animalDto.getLogo() != null) {
//            try {
//                category.setLogo(animalDto.getLogo().getBytes());
//            } catch (IOException e) {
//                LOGGER.error("error_field_upload_getBytes in animalDto to animal-logo");
//                e.printStackTrace();
//            }
//        }
        category.setCategoryId(animalDto.getCategoryId());

//        CategoryI18n categoryI18nRu = new CategoryI18n();
//        categoryI18nRu.setLocaleCategoryI18n(localeDao.read(ru));
//        categoryI18nRu.setIdCategory(category);
//        categoryI18nRu.setNameCategoryI18n(animalDto.getNameAnimalRus());
//        categoryI18nList.add(categoryI18nRu);
//
//        CategoryI18n categoryI18nEn = new CategoryI18n();
//        categoryI18nEn.setLocaleCategoryI18n(localeDao.read(en));
//        categoryI18nEn.setIdCategory(category);
//        categoryI18nEn.setNameCategoryI18n(animalDto.getNameAnimalEng());
//        categoryI18nList.add(categoryI18nEn);
//
//        category.setCategoryName(categoryI18nList);

        animal.setCategoryAnimal(category);
        animal.setAnimalId(animalDto.getIdAnimal());

        AnimalI18n animalI18nRu = new AnimalI18n();
        animalI18nRu.setLocaleAnimalI18n(localeDao.read(ru));

        animalI18nRu.setNameAnimalI18n(animalDto.getNameAnimalRus());
        animalI18nRu.setIdAnimals(animal);
        animalI18nList.add(animalI18nRu);

        AnimalI18n animalI18nEn = new AnimalI18n();

        animalI18nEn.setLocaleAnimalI18n(localeDao.read(en));
        animalI18nEn.setNameAnimalI18n(animalDto.getNameAnimalEng());
        animalI18nEn.setIdAnimals(animal);
        animalI18nList.add(animalI18nEn);

        animal.setAnimalName(animalI18nList);

        //try catch img mp3
        if (animalDto.getImageAnimal() != null && animalDto.getAudioAnimal() != null) {
            try {
                animal.setAnimalImage(animalDto.getImageAnimal().getBytes());
                animal.setAnimalAudio(animalDto.getAudioAnimal().getBytes());
            } catch (IOException e) {
                LOGGER.error("error_field_upload_getBytes in animalDto to animal-img and audio");
                e.printStackTrace();
            }
        }

        return animal;
    }

    public AnimalDto animalToAnimalDto(Animal animal) {

        return null;
    }

    public List<AnimalDtoByte> animalToAnimalDtoByte(List<Animal> getAll, List<AnimalI18n> getAllAnimalI18n, List<CategoryI18n> getAllCategoryI18n) {

        List<AnimalDtoByte> animalI18nList = new ArrayList<>();

        for (Animal animals : getAll) {
            AnimalDtoByte animalDtoByte = new AnimalDtoByte();
            animalDtoByte.setIdAnimal(animals.getAnimalId());
//            animalDtoByte.setAnimalCategory(String.valueOf(i.getCategoryAnimal()));
            animalDtoByte.setImageAnimal(animals.getAnimalImage());
            animalDtoByte.setAudioAnimal(animals.getAnimalAudio());

            for (AnimalI18n nameAnimal : getAllAnimalI18n) {
                if (nameAnimal.getIdAnimals().getAnimalId() == animals.getAnimalId()) {
                    animalDtoByte.setNameAnimal(nameAnimal.getNameAnimalI18n());
                }
            }
            for (CategoryI18n nameCategory : getAllCategoryI18n) {
                if (nameCategory.getIdCategory() == animals.getCategoryAnimal()) {
                    animalDtoByte.setCategoryId(nameCategory.getI18nCategoryId());
                    animalDtoByte.setNameCategory(nameCategory.getNameCategoryI18n());
                    animalDtoByte.setLogoCategory(animals.getCategoryAnimal().getLogo());
                }
            }

            animalI18nList.add(animalDtoByte);
        }
        return animalI18nList;
    }

    public AnimalI18n converterAnimalI18nDtoToAnimalI18n(AnimalI18nDto animalI18nDto, Animal animal) {
        AnimalI18n animalI18n = new AnimalI18n();
        animalI18n.setIdAnimals(animal);
        animalI18n.setLocaleAnimalI18n(localeDao.read(animalI18nDto.getAnimalI18nLocaleDto()));
//        animalI18n.setAnimalI18nLocale(animalI18nDto.getAnimalI18nLocaleDto());

        return animalI18n;
    }

    public AnimalDtoByte converterAnimalToAnimalDtoByte(AnimalI18n animalI18n, Animal animal) {

        AnimalDtoByte animalDtoByte = new AnimalDtoByte();
        animalDtoByte.setIdAnimal(animal.getAnimalId());
        animalDtoByte.setNameAnimal(animalI18n.getNameAnimalI18n());
        animalDtoByte.setLogoCategory(animal.getCategoryAnimal().getLogo());
        //      animalDtoByte.setAnimalCategory(String.valueOf(animal.getCategoryAnimal()));
        animalDtoByte.setImageAnimal(animal.getAnimalImage());
        animalDtoByte.setAudioAnimal(animal.getAnimalAudio());

        CategoryI18n categoryI18n = new CategoryI18n();
        categoryI18n.setIdCategory(animal.getCategoryAnimal());
        categoryI18n.setLocaleCategoryI18n(animalI18n.getLocaleAnimalI18n());
        CategoryI18n categoryI18nName = categoryI18nDao.getId(categoryI18n);

        animalDtoByte.setNameCategory(categoryI18nName.getNameCategoryI18n());

//FIXME
//        Category category = categoryDao.read(animal.getCategoryAnimal().getCategoryId());
//
//        CategoryI18n categoryI18n = new CategoryI18n();
//        categoryI18n.setIdCategory(category);
// //       categoryI18n.setIdCategory(animal.getCategoryAnimal());
//        categoryI18n.setLocaleCategoryI18n(animalI18n.getLocaleAnimalI18n());
//        animalDtoByte.setNameCategory(categoryI18nDao.getId(categoryI18n).getNameCategoryI18n());
        return animalDtoByte;

    }

    public List<CategoryDto> categoryToCategoryDto(List<Category> categoryList, List<CategoryI18n> categoryI18nList) {
        List<CategoryDto> categoryDtoList = new ArrayList<>();

        for (Category category : categoryList) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setCategoryIdDto(category.getCategoryId());

            for (CategoryI18n nameCategory : categoryI18nList) {
                if (nameCategory.getIdCategory().getCategoryId() == category.getCategoryId()) {
                    categoryDto.setNameCategoryRus(nameCategory.getNameCategoryI18n());
                }
            }
            categoryDtoList.add(categoryDto);
        }
        return categoryDtoList;
    }

    public Category categoryDtoToCategory(CategoryDto categoryDto) {
        String ru = "ru";
        String en = "en";
        List<CategoryI18n> categoryI18nList = new ArrayList<>();
        Category category = new Category();
        category.setCategoryId(categoryDto.getCategoryIdDto());

        CategoryI18n categoryI18nRu = new CategoryI18n();
        categoryI18nRu.setLocaleCategoryI18n(localeDao.read(ru));
        categoryI18nRu.setIdCategory(category);
        categoryI18nRu.setNameCategoryI18n(categoryDto.getNameCategoryRus());
        categoryI18nList.add(categoryI18nRu);

        CategoryI18n categoryI18nEn = new CategoryI18n();
        categoryI18nEn.setLocaleCategoryI18n(localeDao.read(en));
        categoryI18nEn.setIdCategory(category);
        categoryI18nEn.setNameCategoryI18n(categoryDto.getNameCategoryEng());
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


        return category;
    }

    public AnimalI18nDto convertAnimalI18nToAnimalI18nDto(AnimalI18n animalI18n) {
//        AnimalI18nDto animalI18nDto = new AnimalI18nDto();
//        animalI18nDto.set
        return null;
    }
}


