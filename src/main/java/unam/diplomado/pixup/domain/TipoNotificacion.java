package unam.diplomado.pixup.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tipo_notificacion")
public class TipoNotificacion {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 40)
    @NotNull
    @Column(name = "descripcion", nullable = false, length = 40)
    private String descripcion;

    @Size(max = 120)
    @NotNull
    @Column(name = "ruta_plantilla", nullable = false, length = 120)
    private String rutaPlantilla;

}