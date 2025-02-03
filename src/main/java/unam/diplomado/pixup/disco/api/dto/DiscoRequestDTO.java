package unam.diplomado.pixup.disco.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DiscoRequestDTO {

    @NotBlank(message = "El campo título es requerido")
    private String titulo;

    @NotNull(message = "El campo precio es requerido")
    private Float precio;

    private Integer existencia;

    private Float descuento;

    @NotNull(message = "El campo fechaLanzamiento es requerido")
//    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}", message = "El formato de la fecha debe ser yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fechaLanzamiento;

    @NotBlank(message = "El campo imagen es requerido")
    private String imagen;

    @NotNull(message = "El campo disquera es requerido")
    private Integer disquera;

    @NotNull(message = "El campo artista es requerido")
    private Integer artista;

    @NotNull(message = "El campo generoMusical es requerido")
    private Integer generoMusical;


}
