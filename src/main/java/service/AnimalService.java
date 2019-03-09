package service;

import dto.AnimalDto;
import org.springframework.ui.ModelMap;

public interface AnimalService {

    void create(AnimalDto animalDto);

    void getIdMax(ModelMap model);

    void delete(AnimalDto animalDto);

    void update(AnimalDto animalDto);

    void getAll(ModelMap model, String locale);

    void getId(AnimalDto animalDto, ModelMap model);

    AnimalDto getId(AnimalDto animalDto);
}
