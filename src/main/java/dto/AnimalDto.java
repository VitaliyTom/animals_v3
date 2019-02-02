
package dto;

import entity.Category;
import org.springframework.web.multipart.MultipartFile;

public class AnimalDto {


    private long animalId;
    private String animalName;
    private int idCategory;
    private String categoryAnimal;
    private MultipartFile animalPicture;
    private MultipartFile animalSound;


    public AnimalDto() {
    }

    public long getAnimalId() {
        return animalId;
    }

    public void setAnimalId(long animalId) {
        this.animalId = animalId;
    }

    public String getAnimalName() {
        return animalName;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public MultipartFile getAnimalPicture() {
        return animalPicture;
    }

    public void setAnimalPicture(MultipartFile animalPicture) {
        this.animalPicture = animalPicture;
    }

    public MultipartFile getAnimalSound() {
        return animalSound;
    }

    public void setAnimalSound(MultipartFile animalSound) {
        this.animalSound = animalSound;
    }

    public String getCategoryAnimal() {
        return categoryAnimal;
    }

    public void setCategoryAnimal(String categoryAnimal) {
        this.categoryAnimal = categoryAnimal;
    }
}