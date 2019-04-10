package controllers;

import dto.AnimalDtoByte;
import dto.AnimalI18nDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.AnimalI18nService;

import java.util.Locale;

@Controller
public class AnimalAjaxController {

    @Autowired
    private AnimalI18nService animalI18nService;

    @ResponseBody
    @RequestMapping(value = "/getAnimalInBaseAjax{PathVarId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AnimalDtoByte getAnimalInBaseAjax(@PathVariable("PathVarId") long animalIdDto, Locale loc) {
        String locale = loc.getLanguage();
        AnimalI18nDto animalI18nDto = new AnimalI18nDto();
        animalI18nDto.setAnimalI18nLocaleDto(locale);
        animalI18nDto.setIdAnimals(animalIdDto);

        return animalI18nService.getIdAjaxI18n(animalI18nDto);
    }
}

