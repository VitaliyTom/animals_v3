package converter;

import dto.AnimalDto;
import entity.Animal;
import entity.Category;
import org.apache.log4j.Logger;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import service.impl.AnimalServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Converter {

    private static final Logger LOGGER = Logger.getLogger(AnimalServiceImpl.class);

    //  animalDto to Animal
    public Animal animalDtoToAnimal(AnimalDto animalDto) {
        Category category = new Category();
        category.setCategoryid(animalDto.getCategoryId());
        category.setCategory(animalDto.getAnimalCategory());

        Animal animal = new Animal();
        animal.setAnimalId(animalDto.getIdAnimal());
        //   animal.setAnimalName(animalDto.getNameAnimal());
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
        //    animalDto.setNameAnimal(animal.getAnimalName());
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



    public List<AnimalDto> animalToAnimalDto2(List<Animal> getAll) {

        List<AnimalDto> animalI18nList = new ArrayList<>();

        for (Animal i : getAll) {
            AnimalDto animalDto =new AnimalDto();
            animalDto.setNameAnimal(i.getAnimalName().get(0).getNameAnimalI18n());
            animalDto.setIdAnimal(i.getAnimalId());
            animalI18nList.add(animalDto);
            }
        return animalI18nList;
        }
/*for (int i = 0; i < array.length; i++) {
                System.out.println(array[i]);*/

         /*   for (AnimalDto j:animalI18n){
                j.setNameAnimal(String.valueOf(i.getAnimalName()));

            }*/
        //animalI18n.set()
        //  i.setAnimalName();


        /*for (int i:array) {
           System.out.println(i);
           }*/





}