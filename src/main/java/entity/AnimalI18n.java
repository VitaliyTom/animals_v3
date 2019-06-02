package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "animali18n")
public class AnimalI18n implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "I18N_ANIMAL_ID")
    private long i18nAnimalId;

    @ManyToOne(fetch = FetchType.LAZY, cascade={CascadeType.ALL})
    @JoinColumn(name = "ID_ANIMALS")
    private Animal idAnimals;

    @Column(name = "NAME_ANIMAL_I18N")
    private String nameAnimalI18n;

    @ManyToOne(fetch = FetchType.LAZY,  cascade={CascadeType.ALL})
    @JoinColumn(name = "ID_LOCALE")
    private Locale localeAnimalI18n;

    public AnimalI18n() {}

    public long getI18nAnimalId() {
        return i18nAnimalId;
    }

    public void setI18nAnimalId(long i18nAnimalId) {
        this.i18nAnimalId = i18nAnimalId;
    }

    public Animal getIdAnimals() {
        return idAnimals;
    }

    public void setIdAnimals(Animal idAnimals) {
        this.idAnimals = idAnimals;
    }

    public String getNameAnimalI18n() {
        return nameAnimalI18n;
    }

    public void setNameAnimalI18n(String nameAnimalI18n) {
        this.nameAnimalI18n = nameAnimalI18n;
    }

    public Locale getLocaleAnimalI18n() {
        return localeAnimalI18n;
    }

    public void setLocaleAnimalI18n(Locale localeAnimalI18n) {
        this.localeAnimalI18n = localeAnimalI18n;
    }
}
