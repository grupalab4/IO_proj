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
@Table(name = "products", schema = "liczymy_kalorie")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long idProduct;
    private String name;
    @Nullable
    private String description;
    @Nullable
    private String composition;
    private Integer calorificValuePer100G;
    @Nullable
    @ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
    private List<Recipe> recipes = new ArrayList<>();

    public Product(String name,
                   String description,
                   String composition,
                   Integer calorificValuePer100G){
        this.name = name;
        this.description = description;
        this.composition = composition;
        this.calorificValuePer100G = calorificValuePer100G;
    }
}
