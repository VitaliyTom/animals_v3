package service.impl;

import converter.Converter;
import dao.AnimalDao;
import dao.AnimalI18nDao;
import dto.AnimalDto;
import dto.AnimalDtoByte;
import entity.Animal;
import entity.AnimalI18n;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import service.AnimalService;
import service.CategoryService;

import java.util.List;
import java.util.Random;


@Service("animalService")
public class AnimalServiceImpl implements AnimalService {

    private static final Logger LOGGER = Logger.getLogger(AnimalServiceImpl.class);

    @Autowired
    AnimalDao animalDao;

    @Autowired
    CategoryService categoryService;

    @Autowired
    AnimalI18nDao animalI18nDao;

//-------------------------block CRUD------------------------------------

    @Override
    @Transactional                    //fixme разобраться!
    public void create(AnimalDto animalDto) {

        Converter cnvrt = new Converter();
        animalDao.saveOrUpdate(cnvrt.animalDtoToAnimal(animalDto));

    }
    @Deprecated
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
    public void delete(long id) {
        animalDao.delete(id);
    }

    @Override                       //fixme добавить апдейт на конкретные поля
    public void update(AnimalDto animalDto) {

        Converter cnvrt = new Converter();
        animalDao.saveOrUpdate(cnvrt.animalDtoToAnimal(animalDto));
    }
//------------------------block CRUD end---------------------------------

    @Override
    @Transactional
    public void getAll(ModelMap model, String locale) {
        List<AnimalI18n> getAllAnimalI18n = animalI18nDao.getAll(locale);

        List<Animal> getAll = (animalDao.getAll());
        Converter cnvrt = new Converter();
        List<AnimalDtoByte> getAllDto = cnvrt.animalToAnimalDtoByte(getAll, getAllAnimalI18n);
        model.addAttribute("getAllList", getAllDto);
        categoryService.getCategory(model);
    }

    //fixme пересмотреть методы и лишние удалить
    @Override
    public void getId(AnimalDto animalDto, ModelMap model) {

//        Animal animal = new Animal();
//        animal.setAnimalId(animalDto.getIdAnimal());
//        Converter cnvrt = new Converter();
//        animalDto = cnvrt.animalToAnimalDto(animalDao.read(animal.getAnimalId()));
//        model.addAttribute("animalDto", animalDto);
    }

    //fixme пересмотреть методы и лишние удалить
    @Override
    public AnimalDto getId(AnimalDto animalDto) {
        Animal animal = new Animal();
        animal.setAnimalId(animalDto.getIdAnimal());
        Converter cnvrt = new Converter();
        animalDto = cnvrt.animalToAnimalDto(animalDao.read(animal.getAnimalId()));

        return animalDto;
    }
}
