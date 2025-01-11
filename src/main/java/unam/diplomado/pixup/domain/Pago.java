package unam.diplomado.pixup.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@Entity
@Table(name = "pago")
public class Pago {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 4)
    @NotNull
    @Column(name = "numero_tarjeta", nullable = false, length = 4)
    private String numeroTarjeta;

    @NotNull
    @Column(name = "monto", nullable = false)
    private Float monto;

    @NotNull
    @Column(name = "fecha", nullable = false)
    private Instant fecha;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_orden", nullable = false)
    private Orden idOrden;

}