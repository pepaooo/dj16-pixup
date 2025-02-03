package unam.diplomado.pixup.disco.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "disco")
@ToString
public class Disco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private LocalDateTime fechaLanzamiento;

    @Size(max = 120)
    @NotNull
    @Column(name = "imagen", nullable = false, length = 120)
    private String imagen;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_disquera", nullable = false)
    private Disquera disquera;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_artista", nullable = false)
    private Artista artista;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_genero_musical", nullable = false)
    private GeneroMusical generoMusical;

}