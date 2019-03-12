package dao;

import entity.Animal;

import java.util.List;

public interface AnimalDao {
    @Deprecated
    void create(Animal animal);

    @Deprecated
    void update(Animal animal);

    void delete(long id);


    void saveOrUpdate(Animal animal);

    Animal read(long animalId);

    Animal getIdMax();

    List<Animal> getAll();
}
