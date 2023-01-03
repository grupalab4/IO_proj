package pl.io_proj.model;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "recipes", schema = "liczymy_kalorie")
public class Recipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recipe")
    private Long idRecipe;
    @Nullable
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "recipe_products", schema = "liczymy_kalorie", joinColumns = {
            @JoinColumn(name = "id_product",
                    updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "id_recipe",
                            updatable = false)})
    private List<Product> products = new ArrayList<>();
    @Nullable
    private Integer calorificValuePer100G;
    private String name;
    @Nullable
    private String description;

    public Recipe(String name,
                  Integer calorificValuePer100G,
                  String description){
        this.name = name;
        this.calorificValuePer100G = calorificValuePer100G;
        this.description = description;
    }
}
