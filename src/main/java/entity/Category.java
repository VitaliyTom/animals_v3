package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "categories")
public class Category implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID")
    private long categoryid;


    @Column(name = "CATEGORY")
    private String category;

    @OneToMany(mappedBy = "categoryAnimal")
    private List<Animal> animalCategory;


    public Category() {
    }

    public long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(long categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Animal> getAnimalCategory() {
        return animalCategory;
    }

    public void setAnimalCategory(List<Animal> animalCategory) {
        this.animalCategory = animalCategory;
    }

        @Override
    public String toString() {
        return category;
    }
}
