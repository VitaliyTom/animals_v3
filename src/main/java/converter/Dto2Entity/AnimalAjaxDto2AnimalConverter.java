package converter.Dto2Entity;

import dao.AnimalDao;
import dto.AnimalAjaxDto;
import entity.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AnimalAjaxDto2AnimalConverter implements Converter<AnimalAjaxDto, Animal> {

    @Autowired
    AnimalDao animalDao;
    @Override
    public Animal convert(AnimalAjaxDto animalAjaxDto) {

        return animalDao.read(animalAjaxDto.getIdAnimals());

    }
}
