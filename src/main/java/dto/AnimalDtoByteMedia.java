package dto;

public class AnimalDtoByteMedia {
    //ping
    private long idAnimalDtoByteMedia;

    private String nameAnimalDtoByteMedia;

    private int categoryIdDtoByteMedia;

    private String animalCategoryDtoByteMedia;

    private byte[] ImageAnimalDtoByteMedia;

    private byte[] audioAnimalDtoByteMedia;

    public AnimalDtoByteMedia() {
    }

    public long getIdAnimalDtoByteMedia() {
        return idAnimalDtoByteMedia;
    }

    public void setIdAnimalDtoByteMedia(long idAnimalDtoByteMedia) {
        this.idAnimalDtoByteMedia = idAnimalDtoByteMedia;
    }

    public String getNameAnimalDtoByteMedia() {
        return nameAnimalDtoByteMedia;
    }

    public void setNameAnimalDtoByteMedia(String nameAnimalDtoByteMedia) {
        this.nameAnimalDtoByteMedia = nameAnimalDtoByteMedia;
    }

    public int getCategoryIdDtoByteMedia() {
        return categoryIdDtoByteMedia;
    }

    public void setCategoryIdDtoByteMedia(int categoryIdDtoByteMedia) {
        this.categoryIdDtoByteMedia = categoryIdDtoByteMedia;
    }

    public String getAnimalCategoryDtoByteMedia() {
        return animalCategoryDtoByteMedia;
    }

    public void setAnimalCategoryDtoByteMedia(String animalCategoryDtoByteMedia) {
        this.animalCategoryDtoByteMedia = animalCategoryDtoByteMedia;
    }

    public byte[] getImageAnimalDtoByteMedia() {
        return ImageAnimalDtoByteMedia;
    }

    public void setImageAnimalDtoByteMedia(byte[] imageAnimalDtoByteMedia) {
        ImageAnimalDtoByteMedia = imageAnimalDtoByteMedia;
    }

    public byte[] getAudioAnimalDtoByteMedia() {
        return audioAnimalDtoByteMedia;
    }

    public void setAudioAnimalDtoByteMedia(byte[] audioAnimalDtoByteMedia) {
        this.audioAnimalDtoByteMedia = audioAnimalDtoByteMedia;
    }
}
