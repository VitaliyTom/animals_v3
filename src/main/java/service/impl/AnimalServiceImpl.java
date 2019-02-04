package service.impl;

import converter.Converter;
import dao.AnimalDao;
import dto.AnimalDto;
import entity.Animal;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import service.AnimalService;

import java.util.List;
import java.util.Random;


@Service("animalService")
public class AnimalServiceImpl implements AnimalService {

    private static final Logger LOGGER = Logger.getLogger(AnimalServiceImpl.class);

    @Autowired
    AnimalDao animalDao;


    @Override
    @Transactional                    //fixme разобраться!
    public void create(AnimalDto animalDto) {

        Converter cnvrt = new Converter();
        animalDao.saveOrUpdate(cnvrt.animalDtoToAnimal(animalDto));

    }

    @Override
    @Transactional
    public void getIdMax(ModelMap model) {
        Animal animalIdMax = animalDao.getIdMax();

        Random rnd = new Random();
        int id = 0;
        int i = 1;
        boolean flag = true;

        while (flag) {
            //selection of an arbitrary id in the range of existing
            id = 1 + rnd.nextInt((int) animalIdMax.getAnimalId());
            Animal animal = animalDao.read((long) id);

            //we check there is an object under such id or not
            if (animal == null) {
                i++;

            } else {

                flag = false;
                LOGGER.info("найден существующий идишник c " + i + " попытки.");
                Converter cnvrt = new Converter();
                AnimalDto animalDto = cnvrt.animalToAnimalDto(animal);
                model.addAttribute("animalDto", animalDto);
            }
        }
    }

    @Override
    @Transactional
    public void delete(AnimalDto animalDto) {

        Animal animal = new Animal();
        animal.setAnimalId(animalDto.getIdAnimal());
        animalDao.delete(animal);
    }

    @Override                       //fixme добавить апдейт на конкретные поля
    public void update(AnimalDto animalDto) {

        Converter cnvrt = new Converter();
        animalDao.saveOrUpdate(cnvrt.animalDtoToAnimal(animalDto));
    }

    @Override
    @Transactional
    public void getAll(ModelMap model) {

        List<Animal> getAll = (animalDao.getAll());
        model.addAttribute("getAllList", getAll);
    }
}
