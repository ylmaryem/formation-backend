package net.javaprojet.formation.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="Categories")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noCategorie;
    @Column(name = "nom", nullable = false)
    private String designation;
    @ManyToMany(mappedBy = "categoriesList",fetch = FetchType.EAGER)
//    @JoinTable(name = "theme_categorie", joinColumns = @JoinColumn(name = "no_theme"), inverseJoinColumns = @JoinColumn(name = "no_categorie"))
    private List<Theme> themesList;
    @Override
    public String toString() {
        return "noTheme=" + noCategorie +
                ", designation='" + designation + '\'' +
                ", liste des themes=" + themesList;
    }

}
