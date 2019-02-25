package converter;


import dto.AnimalDtoByteMedia;
import entity.Animal;

public class ConverterAnimalDtoByteMediaToAnimal {

    public Animal converterAnimalDtoByteMediaToAnimal(){

            return null;

    }

    public AnimalDtoByteMedia converterAnimalToAnimalDtoByteMedia(Animal animal){

        AnimalDtoByteMedia animalDtoByteMedia = new AnimalDtoByteMedia();
        animalDtoByteMedia.setIdAnimalDtoByteMedia(animal.getAnimalId());
        animalDtoByteMedia.setNameAnimalDtoByteMedia(animal.getAnimalName());
        animalDtoByteMedia.setAnimalCategoryDtoByteMedia(String.valueOf(animal.getCategoryAnimal()));
        animalDtoByteMedia.setImageAnimalDtoByteMedia(animal.getAnimalImage());
        animalDtoByteMedia.setAudioAnimalDtoByteMedia(animal.getAnimalAudio());



        return animalDtoByteMedia;

    }


}

