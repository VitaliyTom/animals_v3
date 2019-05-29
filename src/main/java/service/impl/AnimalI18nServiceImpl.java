package service.impl;

import converter.Converter;
import dao.AnimalDao;
import dao.AnimalI18nDao;
import dao.CategoryI18nDao;
import dto.AnimalDtoByte;
import dto.AnimalI18nDto;
import entity.Animal;
import entity.AnimalI18n;
import entity.CategoryI18n;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AnimalI18nService;

@Service("animalI18nService")
public class AnimalI18nServiceImpl implements AnimalI18nService {

    @Autowired
    AnimalI18nDao animalI18nDao;
    @Autowired
    CategoryI18nDao categoryI18nDao;
    @Autowired
    AnimalDao animalDao;
    @Autowired
    Converter cnvrt;

    @Override
    public AnimalDtoByte getIdAjaxI18n(AnimalI18nDto animalI18nDto) {

        Animal animal = animalDao.read(animalI18nDto.getIdAnimals());
        AnimalI18n animalI18n = animalI18nDao.getId(cnvrt.converterAnimalI18nDtoToAnimalI18n(animalI18nDto, animal));
        //CategoryI18n categoryI18n =
        return cnvrt.converterAnimalToAnimalDtoByte(animalI18n, animal);
    }
}
