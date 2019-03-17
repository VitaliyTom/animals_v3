package dto;

import org.springframework.web.multipart.MultipartFile;

public class AnimalDto {

    private long idAnimal;

    private String nameAnimalRus;

    private String nameAnimalEng;

    private long categoryId;

    private String animalCategory;

    private MultipartFile ImageAnimal;

    private MultipartFile audioAnimal;

    public AnimalDto() {
    }

    public long getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(long idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNameAnimalRus() {
        return nameAnimalRus;
    }

    public void setNameAnimalRus(String nameAnimalRus) {
        this.nameAnimalRus = nameAnimalRus;
    }

    public String getNameAnimalEng() {
        return nameAnimalEng;
    }

    public void setNameAnimalEng(String nameAnimalEng) {
        this.nameAnimalEng = nameAnimalEng;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getAnimalCategory() {
        return animalCategory;
    }

    public void setAnimalCategory(String animalCategory) {
        this.animalCategory = animalCategory;
    }

    public MultipartFile getImageAnimal() {
        return ImageAnimal;
    }

    public void setImageAnimal(MultipartFile imageAnimal) {
        ImageAnimal = imageAnimal;
    }

    public MultipartFile getAudioAnimal() {
        return audioAnimal;
    }

    public void setAudioAnimal(MultipartFile audioAnimal) {
        this.audioAnimal = audioAnimal;
    }
}