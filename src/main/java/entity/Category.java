package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID")
    private long categoryId;

    @OneToMany(mappedBy = "idCategory", cascade = CascadeType.ALL)
    private List<CategoryI18n> categoryName;

    @Column(name = "LOGO")
    private String LOGO;

    @OneToMany(mappedBy = "categoryAnimal")
    private List<Animal> animalCategory;


/*@OneToMany(mappedBy = "idAnimals", cascade = CascadeType.ALL)
    private List<AnimalI18n> animalName;*/

    public Category() {
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getLOGO() {
        return LOGO;
    }

    public void setLOGO(String LOGO) {
        this.LOGO = LOGO;
    }

    public List<Animal> getAnimalCategory() {
        return animalCategory;
    }

    public void setAnimalCategory(List<Animal> animalCategory) {
        this.animalCategory = animalCategory;
    }

    public List<CategoryI18n> getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(List<CategoryI18n> categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "LOGO='" + LOGO + '\'' +
                '}';
    }
}


