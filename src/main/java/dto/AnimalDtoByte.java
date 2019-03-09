package dto;

public class AnimalDtoByte {
    private long idAnimal;

    private String nameAnimal;

    private int categoryId;

    private String animalCategory;

    private byte[] imageAnimal;

    private byte[] audioAnimal;

    public AnimalDtoByte() {
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

    public void setNameAnimal(String nameAnimal) {
        this.nameAnimal = nameAnimal;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getAnimalCategory() {
        return animalCategory;
    }

    public void setAnimalCategory(String animalCategory) {
        this.animalCategory = animalCategory;
    }

    public byte[] getImageAnimal() {
        return imageAnimal;
    }

    public void setImageAnimal(byte[] imageAnimal) {
        this.imageAnimal = imageAnimal;
    }

    public byte[] getAudioAnimal() {
        return audioAnimal;
    }

    public void setAudioAnimal(byte[] audioAnimal) {
        this.audioAnimal = audioAnimal;
    }
}
