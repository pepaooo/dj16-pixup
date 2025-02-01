package unam.diplomado.pixup.colonia.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ColoniaDTO {
    private Integer id;
    private String nombre;
    private String cp;
    private String municipio;
    private String estado;
}
