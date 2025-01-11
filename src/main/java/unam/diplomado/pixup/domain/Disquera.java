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
@Table(name = "disquera")
public class Disquera {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 60)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 60)
    private String nombre;

}