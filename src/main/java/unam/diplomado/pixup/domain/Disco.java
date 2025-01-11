package unam.diplomado.pixup.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "disco")
public class Disco {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    @NotNull
    @Column(name = "precio", nullable = false)
    private Float precio;

    @NotNull
    @Column(name = "existencia", nullable = false)
    private Integer existencia;

    @NotNull
    @Column(name = "descuento", nullable = false)
    private Float descuento;

    @NotNull
    @Column(name = "fecha_lanzamiento", nullable = false)
    private LocalDate fechaLanzamiento;

    @Size(max = 120)
    @NotNull
    @Column(name = "imagen", nullable = false, length = 120)
    private String imagen;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_disquera", nullable = false)
    private unam.diplomado.pixup.domain.Disquera idDisquera;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_artista", nullable = false)
    private Artista idArtista;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_genero_musical", nullable = false)
    private unam.diplomado.pixup.domain.GeneroMusical idGeneroMusical;

}