
package dao;

import entity.Animal;

import java.util.List;

public interface AnimalDao {
    void create(Animal animal);

    void update(Animal animal);

    void delete(Animal animal);

    void saveOrUpdate(Animal animal);

    Animal read(long animalId);

    Animal getIdMax();

    List<Animal> getAll();
}
