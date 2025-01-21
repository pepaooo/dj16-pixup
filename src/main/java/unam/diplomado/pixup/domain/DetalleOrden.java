package unam.diplomado.pixup.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import unam.diplomado.pixup.disco.domain.Disco;

@Data
@NoArgsConstructor
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
    private Disco idDisco;

    @NotNull
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @NotNull
    @Column(name = "costo", nullable = false)
    private Float costo;

}