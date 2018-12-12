package dto;

import org.springframework.web.multipart.MultipartFile;

public class AnimalDto {


    private long animalIdDto;
    private String animalNameDto;
    private int idCategoryDto;
    private MultipartFile animalPictureDto;
    private MultipartFile animalSoundDto;

    public AnimalDto() {
    }

    public long getAnimalIdDto() {
        return animalIdDto;
    }

    public void setAnimalIdDto(long animalIdDto) {
        this.animalIdDto = animalIdDto;
    }

    public String getAnimalNameDto() {
        return animalNameDto;
    }

    public void setAnimalNameDto(String animalNameDto) {
        this.animalNameDto = animalNameDto;
    }

    public int getIdCategoryDto() {
        return idCategoryDto;
    }

    public void setIdCategoryDto(int idCategoryDto) {
        this.idCategoryDto = idCategoryDto;
    }

    public MultipartFile getAnimalPictureDto() {
        return animalPictureDto;
    }

    public void setAnimalPictureDto(MultipartFile animalPictureDto) {
        this.animalPictureDto = animalPictureDto;
    }

    public MultipartFile getAnimalSoundDto() {
        return animalSoundDto;
    }

    public void setAnimalSoundDto(MultipartFile animalSoundDto) {
        this.animalSoundDto = animalSoundDto;
    }
}
