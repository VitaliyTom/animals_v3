package dto;

public class AnimalDtoByte {
    private long idAnimal;

    private String nameAnimal;

    private long categoryId;

    private String nameCategory;

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

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
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
