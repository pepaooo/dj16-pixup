package unam.diplomado.pixup.usuario.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioRequestDTO {
    @NotBlank(message = "El campo nombre es requerido")
    private String nombre;

    @NotBlank(message = "El campo primerApellido es requerido")
    private String primerApellido;

    private String segundoApellido;

    @NotBlank(message = "El campo password es requerido")
    private String password;

    @NotBlank(message = "El campo email es requerido")
    @Pattern(
            regexp = "^(?:[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\u0001-\\u0008\\u000B\\u000C\\u000E-\\u001F\\u0021\\u0023-\\u005B\\u005D-\\u007F]|\\\\[\\u0001-\\u0009\\u000B\\u000C\\u000E-\\u007F])*\")@(?:(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z]{2,}|\\[(?:(?:25[0-5]|2[0-4]\\d|[01]?\\d?\\d)\\.){3}(?:25[0-5]|2[0-4]\\d|[01]?\\d?\\d)\\])$",
            message = "El correo electrónico no cumple los estándares internacionales"
    )
    private String email;

    private String rfc;
}
