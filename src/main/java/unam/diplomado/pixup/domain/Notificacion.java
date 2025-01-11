package unam.diplomado.pixup.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@Entity
@Table(name = "notificacion")
public class Notificacion {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "fecha_notificacion", nullable = false)
    private Instant fechaNotificacion;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario", nullable = false)
    private unam.diplomado.pixup.domain.Usuario idUsuario;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipo_notificacion", nullable = false)
    private unam.diplomado.pixup.domain.TipoNotificacion idTipoNotificacion;

}