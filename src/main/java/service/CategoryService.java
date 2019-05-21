package service;

import dto.CategoryDto;
import entity.Category;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> getCategory(String locale);


}
