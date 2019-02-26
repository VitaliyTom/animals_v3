package service;

import dto.AnimalDto;
import dto.AnimalDtoByteMedia;
import org.springframework.ui.ModelMap;

public interface AnimalService {

    void create(AnimalDto animalDto);

    void getIdMax(ModelMap model);

    void delete(AnimalDto animalDto);

    void update(AnimalDto animalDto);

    void getAll(ModelMap model);

    void getId(AnimalDto animalDto, ModelMap model);

    AnimalDtoByteMedia getIdAjax(AnimalDtoByteMedia animalDtoByteMedia);

    AnimalDto getId(AnimalDto animalDto);
}
