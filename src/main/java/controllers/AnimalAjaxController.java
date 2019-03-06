package controllers;

import dto.AnimalDto;
import dto.AnimalDtoByteMedia;
import dto.AnimalI18nDto;
import entity.AnimalI18n;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.AnimalI18nService;
import service.AnimalService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.Locale;

@Controller
public class AnimalAjaxController {

    @Autowired
    private AnimalService animalService;

    @Autowired
    private AnimalI18nService animalI18nService;

    @Deprecated
    @ResponseBody
    @RequestMapping(value = "/getAllAjax{PathVarId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AnimalDto getAllAjax(@PathVariable("PathVarId") long animalId) {

        AnimalDto animalDto = new AnimalDto();
        animalDto.setIdAnimal(animalId);
        animalDto = animalService.getId(animalDto);

        return animalDto;
    }

    @ResponseBody
    @RequestMapping(value = "/getAnimalInBaseAjax{PathVarId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AnimalDtoByteMedia getAnimalInBaseAjax(Locale loc,
                                                  @PathVariable("PathVarId") long animalId) {

        String locale = loc.getLanguage();
        System.out.println(locale);

        AnimalI18nDto animalI18nDto = new AnimalI18nDto();
        animalI18nDto.setAnimalI18nLocaleDto(locale);
        animalI18nDto.setIdAnimals(animalId);
        AnimalDtoByteMedia animalDtoByteMedia = new AnimalDtoByteMedia();
        animalDtoByteMedia = animalI18nService.getIdAjaxI18n(animalId,locale);

        /*AnimalDtoByteMedia animalDtoByteMedia = new AnimalDtoByteMedia();
        animalDtoByteMedia.setIdAnimalDtoByteMedia(animalId);
        animalDtoByteMedia.setLocale(locale);
        animalDtoByteMedia = animalService.getIdAjax(animalDtoByteMedia);*/

        return animalDtoByteMedia;
    }

}

