package unam.diplomado.pixup.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@Entity
@Table(name = "orden")
public class Orden {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "costo_total", nullable = false)
    private Float costoTotal;

    @NotNull
    @Column(name = "fecha", nullable = false)
    private Instant fecha;

    @NotNull
    @Column(name = "cantidad_total", nullable = false)
    private Integer cantidadTotal;

    @NotNull
    @Column(name = "estatus_envio", nullable = false)
    private Boolean estatusEnvio = false;

    @NotNull
    @Column(name = "costo_envio", nullable = false)
    private Float costoEnvio;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario", nullable = false)
    private unam.diplomado.pixup.domain.Usuario idUsuario;

}