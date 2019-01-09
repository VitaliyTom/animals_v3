package service.impl;

import converter.Converter;
import dao.AnimalDao;
import dto.AnimalDto;
import entity.Animal;
import entity.Category;
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
    public void create(AnimalDto animalDto) {

        Converter cnvrt = new Converter();
        animalDao.create(cnvrt.animalDtoToAnimal(animalDto));

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

                System.out.println( i + " попытка найти существующий идишник");
                i++;

            } else {

                System.out.println("all good " + "id = " + id);
                flag = false;
                String image = new String(animal.getAnimalPicture());   //fixme работает? почему?
                String sound = new String(animal.getAnimalSound());
                System.out.println(animal.getAnimalName());





                Converter cnvrt = new Converter();
                AnimalDto animalDto = cnvrt.animalToAnimalDto(animal);

                model.addAttribute("id", animalDto.getAnimalId());
                model.addAttribute("name", animalDto.getAnimalName());
              //  model.addAttribute("category", animalDto.getIdCategory());
                model.addAttribute("category", animalDto.getCategory());
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
//Category cate = new Category();
//        List<Category> cate2 = getAnimalCategory();
//        for (Category list2 : getAll) {
//
//
//        }
        // byte[] bytes = new byte[1];
        for (Animal list2 : getAll) {


            System.out.println("id: "
                    + list2.getAnimalId()
                    + ", name: "
                    + list2.getAnimalName());
//                    + ", category: "
//                    + list2.getIdCategory());
           // list2.setAnimalSound( bytes);
           // list2.setAnimalPicture( bytes);

        }

        model.addAttribute("getAllList", getAll);

    }




}
