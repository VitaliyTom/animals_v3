package service.impl;

import dao.AnimalDao;
import entity.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import service.AnimalService;

import java.util.List;
import java.util.Random;


@Service("animalService")
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    AnimalDao animalDao;


    @Override
    //  @Transactional                    //fixme разобраться!
    public void create(Animal animal) {
        animalDao.create(animal);
    }

    @Override
    public void getIdMax(ModelMap model) {


        Animal animalIdMax = animalDao.getIdMax();

        System.out.println("max id: " + animalIdMax.getAnimalId());

        int id = 0;
        Random rnd = new Random();
        int i = 1;
        boolean flag = true;
        while (flag) {

            id = 1 + rnd.nextInt((int) animalIdMax.getAnimalId());
            System.out.println("-------id------" + id);
            Animal animal = animalDao.read((long) id);

            if (animal == null) {

                System.out.println(i + " попытка найти существующий идишник");
                i++;

            } else {

                System.out.println("all good " + "id = " + id);
                flag = false;
                String image = new String(animal.getAnimalPicture());   //fixme работает? почему?
                String sound = new String(animal.getAnimalSound());
                System.out.println(animal.getAnimalName());

                model.addAttribute("id", animal.getAnimalId());
                model.addAttribute("name", animal.getAnimalName());
                model.addAttribute("category", animal.getIdCategory());
                model.addAttribute("image", image);
                model.addAttribute("sound", sound);

            }
        }

    }

    @Override
    public void delete(Animal animal) {
        animalDao.delete(animal);
    }

    @Override
    public void getAll(ModelMap model) {

        List<Animal> getAll = (animalDao.getAll());

        // byte[] bytes = new byte[1];
        for (Animal list2 : getAll) {


            System.out.println("id: "
                    + list2.getAnimalId()
                    + ", name: "
                    + list2.getAnimalName()
                    + ", category: "
                    + list2.getIdCategory());
           // list2.setAnimalSound( bytes);
           // list2.setAnimalPicture( bytes);

        }

        model.addAttribute("getAllList", getAll);

    }




}
