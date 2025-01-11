package unam.diplomado.pixup.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Integer getExistencia() {
        return existencia;
    }

    public void setExistencia(Integer existencia) {
        this.existencia = existencia;
    }

    public Float getDescuento() {
        return descuento;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public unam.diplomado.pixup.domain.Disquera getIdDisquera() {
        return idDisquera;
    }

    public void setIdDisquera(unam.diplomado.pixup.domain.Disquera idDisquera) {
        this.idDisquera = idDisquera;
    }

    public Artista getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(Artista idArtista) {
        this.idArtista = idArtista;
    }

    public unam.diplomado.pixup.domain.GeneroMusical getIdGeneroMusical() {
        return idGeneroMusical;
    }

    public void setIdGeneroMusical(unam.diplomado.pixup.domain.GeneroMusical idGeneroMusical) {
        this.idGeneroMusical = idGeneroMusical;
    }

}