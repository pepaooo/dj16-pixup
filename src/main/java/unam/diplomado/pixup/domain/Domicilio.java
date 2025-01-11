package unam.diplomado.pixup.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "domicilio")
public class Domicilio {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 60)
    @NotNull
    @Column(name = "calle", nullable = false, length = 60)
    private String calle;

    @Size(max = 30)
    @NotNull
    @Column(name = "num_exterior", nullable = false, length = 30)
    private String numExterior;

    @Size(max = 30)
    @Column(name = "num_interior", length = 30)
    private String numInterior;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario", nullable = false)
    private unam.diplomado.pixup.domain.Usuario idUsuario;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_colonia", nullable = false)
    private Colonia idColonia;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipo_domicilio", nullable = false)
    private unam.diplomado.pixup.domain.TipoDomicilio idTipoDomicilio;

}