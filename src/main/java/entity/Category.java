package entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    @Column(name = "logo")
    private byte[] logo;

    //    @JsonIgnore
//    @JsonBackReference
    @JsonManagedReference
    @OneToMany(mappedBy = "categoryAnimal")
    private List<Animal> animalCategory;

    public Category() {
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public List<CategoryI18n> getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(List<CategoryI18n> categoryName) {
        this.categoryName = categoryName;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public List<Animal> getAnimalCategory() {
        return animalCategory;
    }

    public void setAnimalCategory(List<Animal> animalCategory) {
        this.animalCategory = animalCategory;
    }

}


