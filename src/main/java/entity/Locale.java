package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name ="locale")
public class Locale implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOCALE_ID")
    private long localeId;

    @Column(name = "LOCALE")
    private String locale;

    @OneToMany(mappedBy = "localeAnimalI18n", cascade=CascadeType.ALL)
    private List<AnimalI18n> animalI18nLocale;

    @OneToMany(mappedBy = "localeCategoryI18n", cascade=CascadeType.ALL)
    private List<CategoryI18n> categoryI18nLocale;

    public Locale() {
    }

    public long getLocaleId() {
        return localeId;
    }

    public void setLocaleId(long localeId) {
        this.localeId = localeId;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public List<AnimalI18n> getAnimalI18nLocale() {
        return animalI18nLocale;
    }

    public void setAnimalI18nLocale(List<AnimalI18n> animalI18nLocale) {
        this.animalI18nLocale = animalI18nLocale;
    }

    public List<CategoryI18n> getCategoryI18nLocale() {
        return categoryI18nLocale;
    }

    public void setCategoryI18nLocale(List<CategoryI18n> categoryI18nLocale) {
        this.categoryI18nLocale = categoryI18nLocale;
    }
}
