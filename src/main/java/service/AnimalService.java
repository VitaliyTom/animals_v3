package service;

import entity.Animal;
import org.springframework.ui.ModelMap;

public interface AnimalService {


    void create( Animal animal );
    void getIdMax(ModelMap model);
    void delete(Animal animal);
    void getAll(ModelMap model);





}
