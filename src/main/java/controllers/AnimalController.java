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

import javax.validation.Valid;
import java.util.Locale;

//todo добавить  документацию!!!
//todo добавить  tests.
//todo добавить  валидацию.

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

    //fixme добавить регистрацию
    //станица админка
    @RequestMapping(value = "/loginAdmin")
    public String loginAdmin() {
        return "loginAdmin";
    }

    //получение всех животных и категории
    @RequestMapping("/getAll")
    public String getAll(ModelMap model, Locale loc) {
        String locale = loc.getLanguage();
        model.addAttribute("getAllList", animalService.getAll(locale));
        model.addAttribute("getAllCategory", categoryService.getCategory(locale));
        return "getAll";
    }

    // выбор всех животных для отображения в списке
    @RequestMapping("/getId")
    public String getId(ModelMap model, Locale loc) {
        String locale = loc.getLanguage();
        model.addAttribute("getAllList", animalService.getAll(locale));
        return "getAnimal";
    }


//    -----------------block CRUD-----------------------------

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createAnimal(Model model) {
        AnimalDto animalDto = new AnimalDto();
        model.addAttribute("newAnimal", animalDto);
        return "create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createAnimal(@Valid @ModelAttribute("newAnimal") AnimalDto animalDto,
                               BindingResult result) {
        if (!result.hasErrors()) {
            animalService.create(animalDto);
        }
        return "loginAdmin";
    }

    @RequestMapping("/read")
    public String readAnimal(ModelMap model) {

        animalService.getIdMax(model);
        return "getAnimal";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("newAnimal") AnimalDto animalDto,
                         BindingResult result) {

        if (!result.hasErrors()) {
            animalService.update(animalDto);
        }
        return "loginAdmin";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update(Model model) {

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
    public String deleteGet() {
        return "delete";
    }

 //    -----------------end block CRUD-----------------------------
}