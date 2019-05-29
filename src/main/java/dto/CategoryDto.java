package dto;

import org.springframework.web.multipart.MultipartFile;

public class CategoryDto {

    private long categoryIdDto;

    private String nameCategoryRus;

    private String nameCategoryEng;

    private MultipartFile logo;

    //    private String animalCategory;


    public CategoryDto() {
    }

    public long getCategoryIdDto() {
        return categoryIdDto;
    }

    public void setCategoryIdDto(long categoryIdDto) {
        this.categoryIdDto = categoryIdDto;
    }

    public String getNameCategoryRus() {
        return nameCategoryRus;
    }

    public void setNameCategoryRus(String nameCategoryRus) {
        this.nameCategoryRus = nameCategoryRus;
    }

    public String getNameCategoryEng() {
        return nameCategoryEng;
    }

    public void setNameCategoryEng(String nameCategoryEng) {
        this.nameCategoryEng = nameCategoryEng;
    }

    public MultipartFile getLogo() {
        return logo;
    }

    public void setLogo(MultipartFile logo) {
        this.logo = logo;
    }
}
