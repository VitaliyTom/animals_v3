package service.impl;

import converter.ConverterAnimalI18nDto;
import dao.AnimalI18nDao;
import dto.AnimalDtoByteMedia;
import dto.AnimalI18nDto;
import entity.Animal;
import entity.AnimalI18n;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.AnimalI18nService;

@Service("animalI18nService")
public class AnimalI18nServiceImpl implements AnimalI18nService {

    @Autowired
    AnimalI18nDao animalI18nDao;


    @Override
    @Transactional
    public AnimalDtoByteMedia getIdAjaxI18n(long animalId, String locale) {
       // ConverterAnimalI18nDto cnvrt = new ConverterAnimalI18nDto();
        AnimalI18n animalI18n = new AnimalI18n();
        animalI18n = animalI18nDao.getId(animalId,locale);
        System.out.println(animalI18n);
        return null;  //fixme пока стояночка.
        /*cnvrt.converterAnimalI18nDtoToAnimalI18n(animalI18nDto)*/
    }
}
