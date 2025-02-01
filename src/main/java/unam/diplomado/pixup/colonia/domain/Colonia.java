package unam.diplomado.pixup.colonia.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "colonia")
public class Colonia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotBlank(message = "El nombre de la colonia no puede estar vacio")
    private String nombre;

    @Pattern(regexp = "^(\\d{5}$)", message = "El código postal debe tener 5 dígitos")
    private String cp;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_municipio", nullable = false)
    @NotNull(message = "La colonia debe estar asociada a un municipio")
    private Municipio municipio;

}