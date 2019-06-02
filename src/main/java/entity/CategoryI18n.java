package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "categoryi18n")
public class CategoryI18n implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "I18N_CATEGORY_ID")
    private long i18nCategoryId;

    @ManyToOne(fetch = FetchType.LAZY, cascade={CascadeType.ALL})
    @JoinColumn(name = "ID_CATEGORY")
    private Category idCategory;

    @Column(name = "NAME_CATEGORY_I18N")
    private String nameCategoryI18n;

    @ManyToOne(fetch = FetchType.LAZY,cascade={CascadeType.ALL})
    @JoinColumn(name = "ID_LOCALE")
    private Locale localeCategoryI18n;


    public CategoryI18n() {}

    public long getI18nCategoryId() {
        return i18nCategoryId;
    }

    public void setI18nCategoryId(long i18nCategoryId) {
        this.i18nCategoryId = i18nCategoryId;
    }

    public Category getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Category idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategoryI18n() {
        return nameCategoryI18n;
    }

    public void setNameCategoryI18n(String nameCategoryI18n) {
        this.nameCategoryI18n = nameCategoryI18n;
    }

    public Locale getLocaleCategoryI18n() {
        return localeCategoryI18n;
    }

    public void setLocaleCategoryI18n(Locale localeCategoryI18n) {
        this.localeCategoryI18n = localeCategoryI18n;
    }


}
