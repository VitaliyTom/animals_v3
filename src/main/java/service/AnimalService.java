package service;

import dto.AnimalAjaxDto;
import dto.AnimalDto;
import dto.AnimalDtoByte;
import org.springframework.ui.ModelMap;

import java.util.List;

public interface AnimalService {

    void create(AnimalDto animalDto);

    void getIdMax(ModelMap model);

    void delete(long id);

    void update(AnimalDto animalDto);

    List<AnimalDtoByte> getAll(String locale);

    AnimalDtoByte getIdAjax(AnimalAjaxDto animalAjaxDto);
}
