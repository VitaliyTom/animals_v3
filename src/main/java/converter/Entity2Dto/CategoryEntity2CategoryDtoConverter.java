package converter.Entity2Dto;

import dto.CategoryDto;
import entity.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryEntity2CategoryDtoConverter implements Converter<List<Category>, List<CategoryDto>> {

    @Override
    public List<CategoryDto> convert(List<Category> categoryList) {

//(List<Category> categoryList, List<CategoryI18n> categoryI18nList)
        List<CategoryDto> categoryDtoList = new ArrayList<>();

        for (Category category : categoryList) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setCategoryIdDto(category.getCategoryId());

            if (category.getLogo() != null) {

                MultipartFile multipartFileImage = new MockMultipartFile(
                        "image", "filename", "image/png", category.getLogo());
                categoryDto.setLogo(multipartFileImage);
            }
            categoryDtoList.add(categoryDto);
        }
        return categoryDtoList;
    }
}
