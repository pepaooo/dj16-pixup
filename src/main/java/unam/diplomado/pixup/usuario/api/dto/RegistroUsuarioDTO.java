package unam.diplomado.pixup.usuario.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistroUsuarioDTO {

    @NotNull(message = "Usuario es requerido para realizar el registro")
    @Valid
    private UsuarioRequestDTO usuario;

    @NotNull(message = "Domicilio es requerido para realizar el registro")
    @Valid
    private DomicilioDTO domicilio;


}
