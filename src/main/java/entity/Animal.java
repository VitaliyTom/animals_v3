package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "animals")
public class Animal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ANIMAL_ID")
    private long animalId;

    @OneToMany(mappedBy = "idAnimals", cascade = CascadeType.ALL)
    private List<AnimalI18n> animalName;

    @ManyToOne
    @JoinColumn(name = "ID_CATEGORY")
    private Category categoryAnimal;

    @Column(name = "ANIMAL_PICTURE")
    private byte[] animalImage;

    @Column(name = "ANIMAL_SOUND")
    private byte[] animalAudio;


    public Animal() {
    }

    public long getAnimalId() {
        return animalId;
    }

    public void setAnimalId(long animalId) {
        this.animalId = animalId;
    }

    public List<AnimalI18n> getAnimalName() {
        return animalName;
    }

    public void setAnimalName(List<AnimalI18n> animalName) {
        this.animalName = animalName;
    }

    public Category getCategoryAnimal() {
        return categoryAnimal;
    }

    public void setCategoryAnimal(Category categoryAnimal) {
        this.categoryAnimal = categoryAnimal;
    }

    public byte[] getAnimalImage() {
        return animalImage;
    }

    public void setAnimalImage(byte[] animalImage) {
        this.animalImage = animalImage;
    }

    public byte[] getAnimalAudio() {
        return animalAudio;
    }

    public void setAnimalAudio(byte[] animalAudio) {
        this.animalAudio = animalAudio;
    }

}
