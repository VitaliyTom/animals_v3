package converter;

import dao.*;
import dto.CategoryDto;
import entity.Category;
import entity.CategoryI18n;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class Converter {

    private static final Logger LOGGER = Logger.getLogger(Converter.class);

    @Autowired
    LocaleDao localeDao;
    @Autowired
    CategoryI18nDao categoryI18nDao;

    public List<CategoryDto> categoryToCategoryDto(List<Category> categoryList, List<CategoryI18n> categoryI18nList) {
//        List<CategoryDto> categoryDtoList = new ArrayList<>();
//
//        for (Category category : categoryList) {
//            CategoryDto categoryDto = new CategoryDto();
//            categoryDto.setCategoryIdDto(category.getCategoryId());
//
//            if (category.getLogo() != null) {
//
//                MultipartFile multipartFileImage = new MockMultipartFile(
//                        "image", "filename", "image/png", category.getLogo());
//                categoryDto.setLogo(multipartFileImage);
//            }
//            for (CategoryI18n nameCategory : categoryI18nList) {
//                if (nameCategory.getIdCategory().getCategoryId() == category.getCategoryId()) {
//                    categoryDto.setNameCategoryRus(nameCategory.getNameCategoryI18n());
//
//                }
//            }
//            categoryDtoList.add(categoryDto);
//        }
//        return categoryDtoList;
        return null;
    }

   }


