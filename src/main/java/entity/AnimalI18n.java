package entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "animali18n")
public class AnimalI18n  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "I18N_ANIMAL_ID")
    private long i18nAnimalId;

    @Column(name = "ANIMAL_I18N_LOCALE")
    private String animalI18nLocale;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="ID_ANIMALS" )
    private Animal idAnimals;

    @Column(name = "NAME_ANIMAL_I18N")
    private String nameAnimalI18n;

    public AnimalI18n() {
    }

    public long getI18nAnimalId() {
        return i18nAnimalId;
    }

    public void setI18nAnimalId(long i18nAnimalId) {
        this.i18nAnimalId = i18nAnimalId;
    }

    public String getAnimalI18nLocale() {
        return animalI18nLocale;
    }

    public void setAnimalI18nLocale(String animalI18nLocale) {
        this.animalI18nLocale = animalI18nLocale;
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

    @Override
    public String toString() {
        return "AnimalI18n{" +
                "i18nAnimalId=" + i18nAnimalId +
                ", animalI18nLocale='" + animalI18nLocale + '\'' +
                ", idAnimals=" + idAnimals +
                ", nameAnimalI18n='" + nameAnimalI18n + '\'' +
                '}';
    }
}
