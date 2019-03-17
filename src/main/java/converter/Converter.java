package converter;

import dao.CategoryDao;
import dto.AnimalDto;
import dto.AnimalDtoByte;
import dto.AnimalDtoByteMedia;
import dto.AnimalI18nDto;
import entity.Animal;
import entity.AnimalI18n;
import entity.Category;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Converter {


    private static final Logger LOGGER = Logger.getLogger(Converter.class);


    @Autowired
    CategoryDao categoryDao;

    //  animalDto to Animal
    public Animal animalDtoToAnimal(AnimalDto animalDto) {

        Animal animal = new Animal();

        Category category = categoryDao.read(animalDto.getCategoryId());
        animal.setCategoryAnimal(category);
        animal.setAnimalId(animalDto.getIdAnimal());


        try {                                                     // fixme добавить условие на налпоинтер
            animal.setAnimalImage(animalDto.getImageAnimal().getBytes());
            animal.setAnimalAudio(animalDto.getAudioAnimal().getBytes());
        } catch (IOException e) {
            LOGGER.error("error_field_upload_getBytes in animalDto to animal");
            e.printStackTrace();
        }
        return animal;
    }

    public AnimalDto animalToAnimalDto(Animal animal) {

        return null;
    }

    public List<AnimalDtoByte> animalToAnimalDtoByte(List<Animal> getAll, List<AnimalI18n> getAllAnimalI18n) {

        List<AnimalDtoByte> animalI18nList = new ArrayList<>();

        for (Animal i : getAll) {
            AnimalDtoByte animalDtoByte = new AnimalDtoByte();
            animalDtoByte.setIdAnimal(i.getAnimalId());
            animalDtoByte.setAnimalCategory(String.valueOf(i.getCategoryAnimal()));
            animalDtoByte.setImageAnimal(i.getAnimalImage());
            animalDtoByte.setAudioAnimal(i.getAnimalAudio());

            for (AnimalI18n j : getAllAnimalI18n) {
                if (j.getIdAnimals().getAnimalId() == i.getAnimalId()) {
                    animalDtoByte.setNameAnimal(j.getNameAnimalI18n());
                }
            }
            animalI18nList.add(animalDtoByte);
        }
        return animalI18nList;
    }

    public AnimalI18n converterAnimalI18nDtoToAnimalI18n(AnimalI18nDto animalI18nDto) {
        AnimalI18n animalI18n = new AnimalI18n();
        Animal animal = new Animal();
        animal.setAnimalId(animalI18nDto.getIdAnimals());
        animalI18n.setIdAnimals(animal);
        animalI18n.setAnimalI18nLocale(animalI18nDto.getAnimalI18nLocaleDto());
        return animalI18n;
    }

    public AnimalI18nDto convertAnimalI18nToAnimalI18nDto(AnimalI18n animalI18n) {
//        AnimalI18nDto animalI18nDto = new AnimalI18nDto();
//        animalI18nDto.set
        return null;
    }

    public AnimalDtoByteMedia converterAnimalToAnimalDtoByteMedia(AnimalI18n animalI18n, Animal animal) {
        Category category = new Category();

        AnimalDtoByteMedia animalDtoByteMedia = new AnimalDtoByteMedia();
        animalDtoByteMedia.setIdAnimalDtoByteMedia(animal.getAnimalId());
        animalDtoByteMedia.setNameAnimalDtoByteMedia(animalI18n.getNameAnimalI18n());
        animalDtoByteMedia.setAnimalCategoryDtoByteMedia(String.valueOf(animal.getCategoryAnimal()));
        animalDtoByteMedia.setImageAnimalDtoByteMedia(animal.getAnimalImage());
        animalDtoByteMedia.setAudioAnimalDtoByteMedia(animal.getAnimalAudio());

        return animalDtoByteMedia;

    }
}

//        AnimalI18n animalI18nRu = new AnimalI18n();
//        animalI18nRu.setAnimalI18nLocale(animalDto.getNameAnimalRus());
//        animalI18nRu.setNameAnimalI18n(animalDto.getNameAnimalRus());
//        animalI18nRu.setIdAnimals(animal);
//
//        AnimalI18n animalI18nEn = new AnimalI18n();
//        animalI18nEn.setAnimalI18nLocale(animalDto.getNameAnimalEng());
//        animalI18nEn.setNameAnimalI18n(animalDto.getNameAnimalEng());
//        animalI18nEn.setIdAnimals(animal);
//animal.setAnimalName(animalDto.getNameAnimalRus());
//      long idCategory = animalDto.getCategoryId();
//        animal.setCategoryAnimal(categoryDao.read(idCategory));

//    Animal to animalDto