package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "animals")
public class Animal implements Serializable {
// ping
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ANIMAL_ID")
    private long animalId;

    @Column(name = "ANIMAL_NAME")
    private String animalName;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
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

    @Override
    public String toString() {
        return "[" +
                "Id = " + animalId +
                ", animal = " + animalName +
                ", category = " + categoryAnimal +
                ']';
    }

}
