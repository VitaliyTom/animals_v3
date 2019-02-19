package controllers;

import dto.AnimalDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.AnimalService;

@Controller
public class AnimalAjaxController {

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


}

