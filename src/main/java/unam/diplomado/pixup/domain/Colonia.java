package unam.diplomado.pixup.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "colonia")
public class Colonia {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Size(max = 5)
    @NotNull
    @Column(name = "cp", nullable = false, length = 5)
    private String cp;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_municipio", nullable = false)
    private unam.diplomado.pixup.domain.Municipio idMunicipio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public unam.diplomado.pixup.domain.Municipio getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(unam.diplomado.pixup.domain.Municipio idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

}