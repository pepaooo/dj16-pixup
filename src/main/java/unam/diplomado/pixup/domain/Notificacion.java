package unam.diplomado.pixup.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getFechaNotificacion() {
        return fechaNotificacion;
    }

    public void setFechaNotificacion(Instant fechaNotificacion) {
        this.fechaNotificacion = fechaNotificacion;
    }

    public unam.diplomado.pixup.domain.Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(unam.diplomado.pixup.domain.Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public unam.diplomado.pixup.domain.TipoNotificacion getIdTipoNotificacion() {
        return idTipoNotificacion;
    }

    public void setIdTipoNotificacion(unam.diplomado.pixup.domain.TipoNotificacion idTipoNotificacion) {
        this.idTipoNotificacion = idTipoNotificacion;
    }

}