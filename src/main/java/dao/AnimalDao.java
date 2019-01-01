package dao;

import entity.Animal;

import java.util.ArrayList;
import java.util.List;

public interface AnimalDao {
    void create(Animal animal);
    void update(Animal animal);
    void delete(Animal animal);
    Animal read(long animalId);
    List<Animal> readIdMax();
    Animal getAnimal(String animalName);
    List<Animal> getAll ();
}
