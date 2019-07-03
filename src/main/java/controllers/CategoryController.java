package controllers;

import dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.CategoryService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Locale;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService  categoryService;


    @RequestMapping(value = "/createCategory", method = RequestMethod.GET)
    public String createCategory(Model model) {
        CategoryDto categoryDto = new CategoryDto();
        model.addAttribute("newCategory", categoryDto);
        return "createCategory";
    }

    @RequestMapping(value = "/createCategory", method = RequestMethod.POST)
    public String createCategory(@Valid @ModelAttribute("newCategory") CategoryDto categoryDto,
                                 BindingResult result) {

        if (!result.hasErrors()) {
            categoryService.create(categoryDto);

        }
        return "loginAdmin";
    }

    @RequestMapping(value = "/updateCategory", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("newCategory") CategoryDto categoryDto,
                         BindingResult result) {

        if (!result.hasErrors()) {
            categoryService.update(categoryDto);
        }
        return "loginAdmin";
    }

    @RequestMapping(value = "/updateCategory", method = RequestMethod.GET)
    public String update(Model model) {

        CategoryDto categoryDto = new CategoryDto();
        model.addAttribute("newCategory", categoryDto);
        return "updateCategory";
    }

    @RequestMapping("/getCategory")
    public String getCategory(ModelMap model, Locale loc) {
        String locale = loc.getLanguage();
        model.addAttribute("getAllCategory", categoryService.getCategory(locale));

        return "/getCategory";
    }

    @RequestMapping(value = "/deleteCategory", method = RequestMethod.POST)
    public String deletePost(@RequestParam("id") long id) {
        categoryService.delete(id);
        return "loginAdmin";
    }

    @RequestMapping(value = "/deleteCategory", method = RequestMethod.GET)
    public String deleteGet(HttpServletRequest request, Model model) {
                return "deleteCategory";
    }
}
