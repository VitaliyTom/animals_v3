package dto;

public class CategoryDto {

    private long categoryIdDto;
    private String categoryDto;

    public CategoryDto() {
    }

    public String getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(String categoryDto) {
        this.categoryDto = categoryDto;
    }

    public long getCategoryIdDto() {
        return categoryIdDto;
    }

    public void setCategoryIdDto(long categoryIdDto) {
        this.categoryIdDto = categoryIdDto;
    }
}
