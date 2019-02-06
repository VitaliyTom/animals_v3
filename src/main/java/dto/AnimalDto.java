package dto;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AnimalDto {

    private long idAnimal;
//    @Size(min=3, max=15)
//    @NotNull
    private String nameAnimal;

    private int categoryId;

    private String animalCategory;
//    @NotNull
    private MultipartFile ImageAnimal;
//    @NotNull
    private MultipartFile audioAnimal;

    public AnimalDto() {
    }

    public long getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(long idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNameAnimal() {
        return nameAnimal;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setNameAnimal(String nameAnimal) {
        this.nameAnimal = nameAnimal;
    }

    public MultipartFile getImageAnimal() {
        return ImageAnimal;
    }

    public void setImageAnimal(MultipartFile imageAnimal) {
        this.ImageAnimal = imageAnimal;
    }

    public MultipartFile getAudioAnimal() {
        return audioAnimal;
    }

    public void setAudioAnimal(MultipartFile audioAnimal) {
        this.audioAnimal = audioAnimal;
    }

    public String getAnimalCategory() {
        return animalCategory;
    }

    public void setAnimalCategory(String animalCategory) {
        this.animalCategory = animalCategory;
    }
}