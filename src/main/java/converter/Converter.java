package converter;

import dto.AnimalDto;
import entity.Animal;

public class Converter {

            public Animal animalDtoToAnimal(AnimalDto animalDto){
                Animal animal = new Animal();
                animal.setAnimalId(animalDto.getAnimalId());
                animal.setAnimalName(animalDto.getAnimalName());
                animal.setIdCategory(animalDto.getIdCategory());
                animal.setAnimalPicture(animalDto.getAnimalPicture());
                animal.setAnimalSound(animalDto.getAnimalSound());

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

            public AnimalDto animalToAnimalDto(Animal animal){

                AnimalDto animalDto = new AnimalDto();

                animalDto.setAnimalId(animal.getAnimalId());
                animalDto.setAnimalName(animal.getAnimalName());
                animalDto.setIdCategory(animal.getIdCategory());
//                animalDto.setAnimalPicture(animal.getAnimalPicture());
//                animalDto.setAnimalSound(animal.getAnimalSound());


                return animalDto;


    }

}
