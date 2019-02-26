package controllers;

import dto.AnimalDto;
import dto.AnimalDtoByteMedia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.AnimalService;

@Controller
public class AnimalAjaxController {
//ping
    @Autowired
    private AnimalService animalService;

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
    public AnimalDtoByteMedia getAnimalInBaseAjax(@PathVariable("PathVarId") long animalId) {

        AnimalDtoByteMedia animalDtoByteMedia = new AnimalDtoByteMedia();
        animalDtoByteMedia.setIdAnimalDtoByteMedia(animalId);
        animalDtoByteMedia = animalService.getIdAjax(animalDtoByteMedia);

        return animalDtoByteMedia;
    }

}

