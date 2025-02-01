package unam.diplomado.pixup.usuario.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DomicilioDTO {
    @NotBlank(message = "El campo calle es requerido")
    private String calle;

    @NotBlank(message = "El campo numExterior es requerido")
    private String numExterior;

    private String numInterior;

    @NotNull(message = "El campo colonia es requerido")
    private Integer colonia;

    @NotNull(message = "El campo tipoDomicilio es requerido")
    private Integer tipoDomicilio;
}
