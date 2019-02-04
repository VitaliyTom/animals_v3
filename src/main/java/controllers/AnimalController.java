
package controllers;

import dto.AnimalDto;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import service.AnimalService;
import service.impl.AnimalServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

                                                    //fixme добавить скрипт sql
@RequestMapping("/")
@Controller
public class AnimalController {
                                                            //fixme добавить логеры которые убрал
    private static final Logger LOGGER = Logger.getLogger(AnimalServiceImpl.class);

    @Autowired
    private AnimalService animalService;

    @RequestMapping("/")
    public String index(HttpServletRequest request) {
        return "index";
    }

    @RequestMapping(value = "/loginAdmin")
    public String loginAdmin() {

        return "loginAdmin";
    }

    @RequestMapping("/getAll")
    public String getAllGet(ModelMap model) {

        animalService.getAll(model);
        return "getAll";
    }

//    -----------------block CRUD-----------------------------

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createAnimal(@Valid @ModelAttribute("newAnimal") AnimalDto animalDto,
                               BindingResult result) {

        if (!result.hasErrors()) {
            animalService.create(animalDto);
        }
        return "loginAdmin";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createAnimal(HttpServletRequest request, Model model) {

        AnimalDto animalDto = new AnimalDto();
        model.addAttribute("newAnimal", animalDto);
        return "create";
    }

    @RequestMapping("/read")
    public String readAnimal(ModelMap model) {

        animalService.getIdMax(model);
        return "getAnimal";
    }

    @ResponseBody                                        //fixme не работает, переделать на updateOr...
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updatePost(@RequestParam("id") int animalId,
                             @RequestParam("name") String animalName,
                             @RequestParam("category") int idCategory,
                             @RequestParam("photo") MultipartFile filePhoto,
                             @RequestParam("audio") MultipartFile fileAudio) {

        return "controllers.redirect:uploadSuccess_2";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateGet() {

        return "update";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deletePost(@Valid @ModelAttribute("newAnimal") AnimalDto animalDto, BindingResult result) {

        animalService.delete(animalDto);
        return "loginAdmin";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteGet(HttpServletRequest request, Model model) {

        AnimalDto animalDto = new AnimalDto();
        model.addAttribute("newAnimal", animalDto);
        return "delete";
    }

}



