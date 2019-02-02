package converter;

import dto.AnimalDto;
import entity.Animal;
import entity.Category;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class Converter {

    public Animal animalDtoToAnimal(AnimalDto animalDto){  //  animalDto To Animal
        Category category = new Category();
        category.setCategoryid(animalDto.getIdCategory());
        category.setCategory(animalDto.getCategoryAnimal());

        Animal animal = new Animal();
        animal.setAnimalId(animalDto.getAnimalId());
        animal.setAnimalName(animalDto.getAnimalName());
        animal.setCategoryAnimal(category);
        try {
            animal.setAnimalPicture(animalDto.getAnimalPicture().getBytes());
            animal.setAnimalSound(animalDto.getAnimalSound().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    /*    try {
            if (animalDto.getAnimalPicture().getBytes().length>0 && animalDto.getAnimalSound().getBytes().length>0 ) {


                animal.setAnimalPicture(animalDto.getAnimalPicture().getBytes());
                animal.setAnimalSound(animalDto.getAnimalSound().getBytes());
            }
        } catch (Exception ex) {
            System.out.println("error_field_upload");
     //       LOGGER.error("error_field_upload_Base64");
        }*/

        /*try {
            if (!animalDto.getAnimalPicture().isEmpty() && !animalDto.getAnimalSound().isEmpty() ) {
                animal.setAnimalPicture(Base64.getEncoder().encode(animalDto.getAnimalPicture().getBytes()));
                animal.setAnimalSound(Base64.getEncoder().encode(animalDto.getAnimalSound().getBytes()));
            }
        } catch (Exception ex) {
            System.out.println("error_field_upload");
        }
*/


//        animal.setAnimalPicture(animalDto.getAnimalPicture());
//        animal.setAnimalSound(animalDto.getAnimalSound());

        /*Category category = new Category();
        category.setCategoryid(categoryDto.getCategoryIdDto());
        category.setCategory(categoryDto.getCategoryDto());


        Animal animal = new Animal();
        animal.setAnimalId(animalDto.getAnimalId());
        animal.setAnimalName(animalDto.getAnimalName());
        animal.setCategoryAnimal(category);
        animal.setAnimalPicture(animalDto.getAnimalPicture());
        animal.setAnimalSound(animalDto.getAnimalSound());*/

                /*try {
                    if (!animalDto.getAnimalPicture().isEmpty() && !animalDto.getAnimalSound().isEmpty() ) {
                        animal.setAnimalPicture(Base64.getEncoder().encode(animalDto.getAnimalPicture().getBytes()));
                        animal.setAnimalSound(Base64.getEncoder().encode(animalDto.getAnimalSound().getBytes()));
                    }
                } catch (Exception ex) {
                    System.out.println("error_field_upload");
                }*/

        return animal;
    }

    public AnimalDto animalToAnimalDto(Animal animal){          // animal To AnimalDto

        AnimalDto animalDto = new AnimalDto();
        Category category =new Category();
        
        animalDto.setAnimalId(animal.getAnimalId());
        animalDto.setAnimalName(animal.getAnimalName());
        animalDto.setCategoryAnimal(category.getCategory());
       // animalDto.setIdCategory(category.getCategoryid());

        if (animal.getAnimalPicture() != null && animal.getAnimalSound() != null) {
            MultipartFile multipartFileImage = new MockMultipartFile("image", "filename", "image/png", animal.getAnimalPicture());
            animalDto.setAnimalPicture(multipartFileImage);
            MultipartFile multipartFileAudio = new MockMultipartFile("sound", "filename", "audio/mp3", animal.getAnimalSound());
            animalDto.setAnimalSound(multipartFileAudio);
        }
        /*


//        MultipartFile multipartFile = new MockMultipartFile(animal.getAnimalPicture().getInputStream()) {
//        };
//        animalDto.setAnimalPicture(animal.getAnimalPicture());

     /*   try {
            
              //  animalDto.setAnimalPicture(Base64.getEncoder().encode(animal.getAnimalPicture().getBytes()));
             //   animalDto.setAnimalSound(Base64.getEncoder().encode(animal.getAnimalSound().getBytes()));
            
        } catch (Exception ex) {
            System.out.println("error_field_upload");
        }*/
        
      //          animalDto.setAnimalPicture(animal.getAnimalPicture());
       //         animalDto.setAnimalSound(animal.getAnimalSound());


        return animalDto;


    }

}