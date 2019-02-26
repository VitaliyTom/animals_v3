package converter;

import dto.AnimalDto;
import entity.Animal;
import entity.Category;
import org.apache.log4j.Logger;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import service.impl.AnimalServiceImpl;

import java.io.IOException;


public class Converter {

    private static final Logger LOGGER = Logger.getLogger(AnimalServiceImpl.class);

    //  animalDto to Animal
    public Animal animalDtoToAnimal(AnimalDto animalDto) {
        Category category = new Category();
        category.setCategoryid(animalDto.getCategoryId());
        category.setCategory(animalDto.getAnimalCategory());

        Animal animal = new Animal();
        animal.setAnimalId(animalDto.getIdAnimal());
        animal.setAnimalName(animalDto.getNameAnimal());
        animal.setCategoryAnimal(category);

        try {                                                     // fixme добавить условие на налпоинтер
            animal.setAnimalImage(animalDto.getImageAnimal().getBytes());
            animal.setAnimalAudio(animalDto.getAudioAnimal().getBytes());
        } catch (IOException e) {
            LOGGER.error("error_field_upload_getBytes in animalDto to animal");
            e.printStackTrace();
        }
        return animal;
    }

    //    Animal to animalDto
    public AnimalDto animalToAnimalDto(Animal animal) {

        AnimalDto animalDto = new AnimalDto();
        animalDto.setIdAnimal(animal.getAnimalId());
        animalDto.setNameAnimal(animal.getAnimalName());
        animalDto.setAnimalCategory(String.valueOf(animal.getCategoryAnimal()));

        if (animal.getAnimalImage() != null && animal.getAnimalAudio() != null) {

            MultipartFile multipartFileImage = new MockMultipartFile(
                    "image", "filename", "image/png", animal.getAnimalImage());
            animalDto.setImageAnimal(multipartFileImage);

            MultipartFile multipartFileAudio = new MockMultipartFile(
                    "sound", "filename", "audio/mp3", animal.getAnimalAudio());
            animalDto.setAudioAnimal(multipartFileAudio);
        }
        return animalDto;
    }

}