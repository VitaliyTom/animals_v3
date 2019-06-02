package controllers;

import dto.AnimalAjaxDto;
import dto.AnimalDtoByte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.AnimalI18nService;
import service.AnimalService;

import java.util.Locale;
//@CrossOrigin  /*methods = RequestMethod.POST,*/ /* (origins = "*",   allowedHeaders ="*")*/
@Controller
public class AnimalAjaxController {

    @Autowired
    private AnimalService animalService;


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

