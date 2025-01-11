package unam.diplomado.pixup.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "colonia")
public class Colonia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Size(max = 5)
    @NotNull
    @Column(name = "cp", nullable = false, length = 5)
    private String cp;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_municipio", nullable = false)
    private unam.diplomado.pixup.domain.Municipio idMunicipio;

}