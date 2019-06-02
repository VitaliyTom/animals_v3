package converter.Entity2Dto;

import dao.AnimalDao;
import dto.AnimalDtoByte;
import entity.Animal;
import entity.AnimalI18n;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AnimalI18n2AnimalDtoByteConverter implements Converter<List<AnimalI18n>, List<AnimalDtoByte>> {

    @Autowired
    AnimalDao animalDao;
    @Override
    public List<AnimalDtoByte> convert(List<AnimalI18n> animalI18n) {

        List<AnimalDtoByte> animalDtoByteList = new ArrayList<>();
        List<Animal> getAll = animalDao.getAll();

        for (Animal animals : getAll) {
            AnimalDtoByte animalDtoByte = new AnimalDtoByte();
            animalDtoByte.setIdAnimal(animals.getAnimalId());
            animalDtoByte.setImageAnimal(animals.getAnimalImage());
            animalDtoByte.setAudioAnimal(animals.getAnimalAudio());
            animalDtoByte.setCategoryId(animals.getCategoryAnimal().getCategoryId());
            for (AnimalI18n nameAnimal : animalI18n) {
                if (nameAnimal.getIdAnimals().getAnimalId() == animals.getAnimalId()) {
                    animalDtoByte.setNameAnimal(nameAnimal.getNameAnimalI18n());
                }
            }
            animalDtoByteList.add(animalDtoByte);
        }
        return animalDtoByteList;
    }
}
