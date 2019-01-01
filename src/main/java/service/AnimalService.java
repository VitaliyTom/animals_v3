package service;

import dto.AnimalDto;
import entity.Animal;
import org.springframework.ui.ModelMap;

public interface AnimalService {


    void create( AnimalDto animalDto );
    void getIdMax(ModelMap model);
    void delete(Animal animal);
    void getAll(ModelMap model);





}
