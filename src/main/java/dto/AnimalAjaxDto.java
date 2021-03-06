package dto;

public class AnimalAjaxDto {

    private long i18nAnimalIdDto;
    private String animalI18nLocaleDto;
    private long idAnimals;
    private String nameAnimalI18n;
    private String nameCategory;

    public AnimalAjaxDto() {
    }

    public long getI18nAnimalIdDto() {
        return i18nAnimalIdDto;
    }

    public void setI18nAnimalIdDto(long i18nAnimalIdDto) {
        this.i18nAnimalIdDto = i18nAnimalIdDto;
    }

    public String getAnimalI18nLocaleDto() {
        return animalI18nLocaleDto;
    }

    public void setAnimalI18nLocaleDto(String animalI18nLocaleDto) {
        this.animalI18nLocaleDto = animalI18nLocaleDto;
    }

    public long getIdAnimals() {
        return idAnimals;
    }

    public void setIdAnimals(long idAnimals) {
        this.idAnimals = idAnimals;
    }

    public String getNameAnimalI18n() {
        return nameAnimalI18n;
    }

    public void setNameAnimalI18n(String nameAnimalI18n) {
        this.nameAnimalI18n = nameAnimalI18n;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
