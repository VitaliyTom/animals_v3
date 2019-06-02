package converter.Dto2Entity;

import dao.AnimalDao;
import dao.AnimalI18nDao;
import dao.LocaleDao;
import dto.AnimalAjaxDto;
import entity.AnimalI18n;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AnimalI18nDto2AnimalI18nEntityConverter implements Converter <AnimalAjaxDto, AnimalI18n> {

    @Autowired
    AnimalI18nDao animalI18nDao;
    @Autowired
    AnimalDao animalDao;
    @Autowired
    LocaleDao localeDao;

    @Override
    public AnimalI18n convert(AnimalAjaxDto animalAjaxDto) {
        AnimalI18n animalI18n = new AnimalI18n();
        animalI18n.setIdAnimals(animalDao.read(animalAjaxDto.getIdAnimals())) ;
        animalI18n.setLocaleAnimalI18n(localeDao.read(animalAjaxDto.getAnimalI18nLocaleDto()));

        return   animalI18nDao.getId(animalI18n) ;
    }
}
