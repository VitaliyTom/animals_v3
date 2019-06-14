package service;

import dto.CategoryDto;


import java.util.List;

public interface CategoryService {

    void create(CategoryDto categoryDto);

    List<CategoryDto> getCategory(String locale);

    void delete(long id);

    void update(CategoryDto categoryDto);
}
