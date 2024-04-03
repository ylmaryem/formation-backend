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
@Table(name ="Themes")
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noTheme;
    @Column(name = "nom", nullable = false)
    private String nom;
    @ManyToMany(mappedBy = "themesList",fetch = FetchType.EAGER)
//    @JoinTable(name = "cours_theme", joinColumns = @JoinColumn(name = "no_cours"), inverseJoinColumns = @JoinColumn(name = "no_theme"))
    private List<Cours> coursList;
    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "theme_categorie", joinColumns = @JoinColumn(name = "no_theme"), inverseJoinColumns = @JoinColumn(name = "no_categorie"))
    private List<Categories> categoriesList;
    @Override
    public String toString() {
        return "noTheme=" + noTheme +
                ", nom='" + nom + '\'' +
                ", liste des cours=" + coursList+
                ", liste des categories=" + categoriesList;
    }

}
