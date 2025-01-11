package unam.diplomado.pixup.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "detalle_orden")
public class DetalleOrden {
    @EmbeddedId
    private DetalleOrdenId id;

    @MapsId("idOrden")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_orden", nullable = false)
    private unam.diplomado.pixup.domain.Orden idOrden;

    @MapsId("idDisco")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_disco", nullable = false)
    private unam.diplomado.pixup.domain.Disco idDisco;

    @NotNull
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @NotNull
    @Column(name = "costo", nullable = false)
    private Float costo;

    public DetalleOrdenId getId() {
        return id;
    }

    public void setId(DetalleOrdenId id) {
        this.id = id;
    }

    public unam.diplomado.pixup.domain.Orden getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(unam.diplomado.pixup.domain.Orden idOrden) {
        this.idOrden = idOrden;
    }

    public unam.diplomado.pixup.domain.Disco getIdDisco() {
        return idDisco;
    }

    public void setIdDisco(unam.diplomado.pixup.domain.Disco idDisco) {
        this.idDisco = idDisco;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

}