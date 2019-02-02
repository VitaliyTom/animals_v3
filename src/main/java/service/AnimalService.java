package service;

import dto.AnimalDto;
import dto.CategoryDto;
import entity.Animal;
import entity.Category;
import org.springframework.ui.ModelMap;

public interface AnimalService {


    void create(AnimalDto animalDto);
    void getIdMax(ModelMap model);
    void delete(Animal animal);
    void getAll(ModelMap model);





}
