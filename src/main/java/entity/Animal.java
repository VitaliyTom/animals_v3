package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;


@Entity
@Table(name = "animals")
public class Animal implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ANIMAL_ID")
    private long animalId;

    @Column(name = "ANIMAL_NAME")
    private String animalName;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CATEGORY")
    private Category category;
//    @JoinColumn(name = "ID_CATEGORY",  insertable=false, updatable=false)


    private long idCategory;

    @Column(name = "ANIMAL_PICTURE")
    private byte[] animalPicture;

    @Column(name = "ANIMAL_SOUND")
    private byte[] animalSound;


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

    public long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(long idCategory) {
        this.idCategory = idCategory;
    }

    public byte[] getAnimalPicture() {
        return animalPicture;
    }

    public void setAnimalPicture(byte[] animalPicture) {
        this.animalPicture = animalPicture;
    }

    public byte[] getAnimalSound() {
        return animalSound;
    }

    public void setAnimalSound(byte[] animalSound) {
        this.animalSound = animalSound;
    }

    @Override
    public String toString() {
        return "[" +
                "id = " + animalId +
                " | name = " + animalName +
                " | idCategory = " + idCategory +
                ']';
    }

}



/*@ManyToOne ( fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "ID_CATEGORY")
    private int idCategory;*/