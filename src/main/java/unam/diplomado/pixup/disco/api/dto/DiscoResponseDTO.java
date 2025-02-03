package unam.diplomado.pixup.disco.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DiscoResponseDTO {

    private Integer id;
    private String titulo;
    private String artista;
}
