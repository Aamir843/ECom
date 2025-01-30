package dev.akhtar.ProductService.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category extends Base {

    private String title;

    @OneToMany(fetch = FetchType.LAZY ,mappedBy = "category", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Product> product;
}
