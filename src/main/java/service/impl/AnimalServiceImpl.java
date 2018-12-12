package service.impl;

import dao.AnimalDao;
import entity.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.AnimalService;


@Service("animalService")
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    AnimalDao animalDao;


    @Override
  //  @Transactional                    //fixme разобраться!
    public void create(Animal animal) {
        animalDao.create(animal);
    }
}
