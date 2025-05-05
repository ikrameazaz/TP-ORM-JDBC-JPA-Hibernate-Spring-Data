package enset.ma.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data // Lombok génère automatiquement Getters et Setters
@AllArgsConstructor @NoArgsConstructor
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length=50)
    private String Nom;
    @Temporal(TemporalType.DATE)
    private Date DateNaissance;
    private boolean malade;
    private int score ;


}
