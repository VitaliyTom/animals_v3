package controllers;

import dto.AnimalAjaxDto;
import dto.AnimalDtoByte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.AnimalService;

import java.util.Locale;

@Controller
public class AnimalAjaxController {

    @Autowired
    private AnimalService animalService;

    //ajax запрос животного по иди и локали
    @ResponseBody
    @RequestMapping(value = "/getAnimalInBaseAjax{PathVarId}", produces = MediaType.APPLICATION_JSON_VALUE)
     public AnimalDtoByte getAnimalInBaseAjax(@PathVariable("PathVarId") long animalIdDto, Locale loc) {
        String locale = loc.getLanguage();
        AnimalAjaxDto animalAjaxDto = new AnimalAjaxDto();
        animalAjaxDto.setAnimalI18nLocaleDto(locale);
        animalAjaxDto.setIdAnimals(animalIdDto);

        return animalService.getIdAjax(animalAjaxDto);
    }
}

