
package dto;

import entity.Category;
import org.springframework.web.multipart.MultipartFile;

public class AnimalDto {


    private long animalId;
    private String animalName;
    private int idCategory;
    private Category category;
    private byte[] animalPicture;
    private byte[] animalSound;


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

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public byte[] getAnimalPicture() {
        return animalPicture;
    }

    public void setAnimalPicture(byte[] animalPicture) {
        this.animalPicture = animalPicture;
    }

    public byte[] getAnimalSound() {
        return animalSound;
    }

    public void setAnimalSound(byte[] animalSound) {
        this.animalSound = animalSound;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


}