package controllers;

import dto.AnimalDto;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.AnimalService;
import service.CategoryService;
import service.impl.AnimalServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Locale;

//fixme добавить скрипт/дамп sql

@Controller
public class AnimalController {

    //fixme добавить логеры которые убрал
    private static final Logger LOGGER = Logger.getLogger(AnimalServiceImpl.class);

    @Autowired
    private AnimalService animalService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/loginAdmin")
    public String loginAdmin() {
        return "loginAdmin";
    }

    @RequestMapping("/getAll")
    public String getAllGet(ModelMap model, Locale loc) {
        String locale = loc.getLanguage();
        model.addAttribute("getAllList", animalService.getAll(locale));
        model.addAttribute("getAllCategory", categoryService.getCategory());
        return "getAll";
    }

    // выбор животного по ид
    @RequestMapping("/getId")
    public String getId(ModelMap model, Locale loc) {
        String locale = loc.getLanguage();
        model.addAttribute("getAllList", animalService.getAll(locale));
        return "getAnimal";
    }


//    -----------------block CRUD-----------------------------

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createAnimal(@Valid @ModelAttribute("newAnimal") AnimalDto animalDto,
                               BindingResult result) {

        if (!result.hasErrors()) {
            animalService.create(animalDto);
            System.out.println(animalDto.getNameAnimalRus());
        }
        return "loginAdmin";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createAnimal(Model model) {

        AnimalDto animalDto = new AnimalDto();
        model.addAttribute("newAnimal", animalDto);
        return "create";
    }

    @RequestMapping("/read")
    public String readAnimal(ModelMap model) {

        animalService.getIdMax(model);
        return "getAnimal";
    }

    //fixme не работает, переделать на saveOrUpdate
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updatePost(@Valid @ModelAttribute("newAnimal") AnimalDto animalDto,
                             BindingResult result) {

        if (!result.hasErrors()) {
            animalService.update(animalDto);
        }
        return "loginAdmin";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateGet(HttpServletRequest request, Model model) {

        AnimalDto animalDto = new AnimalDto();
        model.addAttribute("newAnimal", animalDto);
        return "update";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deletePost(@RequestParam("id") long id) {

        animalService.delete(id);
        return "loginAdmin";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteGet(HttpServletRequest request, Model model) {


        return "delete";
    }

}