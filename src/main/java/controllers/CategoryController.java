package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import service.CategoryService;

import java.util.Locale;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/getCategory")
    public String getCategory (ModelMap model, Locale loc){
        String locale = loc.getLanguage();
        model.addAttribute("getAllCategory", categoryService.getCategory( locale));

       return "/getCategory";
    }
}
