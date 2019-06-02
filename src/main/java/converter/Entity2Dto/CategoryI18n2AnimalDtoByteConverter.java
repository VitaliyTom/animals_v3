package converter.Entity2Dto;

import dao.AnimalDao;
import dao.CategoryDao;
import dto.AnimalDtoByte;
import entity.Animal;
import entity.Category;
import entity.CategoryI18n;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryI18n2AnimalDtoByteConverter implements Converter<List<CategoryI18n>, List<AnimalDtoByte>> {

    @Autowired
    AnimalDao animalDao;
    @Autowired
    CategoryDao categoryDao;

    @Override
    public List<AnimalDtoByte> convert(List<CategoryI18n> categoryI18n) {

        List<AnimalDtoByte> animalDtoByteList = new ArrayList<>();
        List<Animal> getAll = animalDao.getAll();
        List<Category> categoryList = categoryDao.getAllCategory() ;

        for (Category category : categoryList) {
            AnimalDtoByte animalDtoByte = new AnimalDtoByte();
            animalDtoByte.setCategoryId(category.getCategoryId());
            animalDtoByte.setLogoCategory(category.getLogo());

            for (CategoryI18n nameCategory : categoryI18n) {
                if (nameCategory.getIdCategory().getCategoryId() == category.getCategoryId()) {
                    animalDtoByte.setNameCategory(nameCategory.getNameCategoryI18n());
                }
            }

            animalDtoByteList.add(animalDtoByte);
        }
  /*      for (CategoryI18n nameCategory : categoryI18n) {
//fixme
            AnimalDtoByte animalDtoByte = new AnimalDtoByte();
            animalDtoByte.setCategoryId(nameCategory.getI18nCategoryId());
            animalDtoByte.setNameCategory(nameCategory.getNameCategoryI18n());
            animalDtoByte.setLogoCategory(animals.getCategoryAnimal().getLogo());

        }
*/
        return animalDtoByteList;
    }
}
/* if (nameCategory.getIdCategory() == animals.getCategoryAnimal()) {
                animalDtoByte.setCategoryId(nameCategory.getI18nCategoryId());
                animalDtoByte.setNameCategory(nameCategory.getNameCategoryI18n());
                animalDtoByte.setLogoCategory(animals.getCategoryAnimal().getLogo());
            }*/