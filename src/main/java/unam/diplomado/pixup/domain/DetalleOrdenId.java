package unam.diplomado.pixup.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@Embeddable
public class DetalleOrdenId implements java.io.Serializable {
    private static final long serialVersionUID = -4122216244147099482L;
    @NotNull
    @Column(name = "id_orden", nullable = false)
    private Integer idOrden;

    @NotNull
    @Column(name = "id_disco", nullable = false)
    private Integer idDisco;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetalleOrdenId entity = (DetalleOrdenId) o;
        return Objects.equals(this.idDisco, entity.idDisco) &&
                Objects.equals(this.idOrden, entity.idOrden);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDisco, idOrden);
    }

}