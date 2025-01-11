package unam.diplomado.pixup.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Float costoTotal) {
        this.costoTotal = costoTotal;
    }

    public Instant getFecha() {
        return fecha;
    }

    public void setFecha(Instant fecha) {
        this.fecha = fecha;
    }

    public Integer getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(Integer cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    public Boolean getEstatusEnvio() {
        return estatusEnvio;
    }

    public void setEstatusEnvio(Boolean estatusEnvio) {
        this.estatusEnvio = estatusEnvio;
    }

    public Float getCostoEnvio() {
        return costoEnvio;
    }

    public void setCostoEnvio(Float costoEnvio) {
        this.costoEnvio = costoEnvio;
    }

    public unam.diplomado.pixup.domain.Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(unam.diplomado.pixup.domain.Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

}