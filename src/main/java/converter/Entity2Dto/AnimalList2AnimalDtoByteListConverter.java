package converter.Entity2Dto;

import dto.AnimalDtoByte;
import entity.Animal;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AnimalList2AnimalDtoByteListConverter implements Converter<Animal, AnimalDtoByte> {

    @Override
    public AnimalDtoByte convert(Animal animal) {
        AnimalDtoByte animalDtoByte = new AnimalDtoByte();
        animalDtoByte.setIdAnimal(animal.getAnimalId());
        animalDtoByte.setLogoCategory(animal.getCategoryAnimal().getLogo());
        animalDtoByte.setImageAnimal(animal.getAnimalImage());
        animalDtoByte.setAudioAnimal(animal.getAnimalAudio());
        return animalDtoByte;
    }
}
