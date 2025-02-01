package unam.diplomado.pixup.colonia.api.dto;

import jakarta.inject.Singleton;
import unam.diplomado.pixup.colonia.domain.Colonia;

@Singleton
public class ColoniaMapper {

    public ColoniaDTO toDTO(Colonia colonia) {
        return ColoniaDTO.builder()
                .id(colonia.getId())
                .nombre(colonia.getNombre())
                .cp(colonia.getCp())
                .municipio(colonia.getMunicipio().getNombre())
                .estado(colonia.getMunicipio().getIdEstado().getNombre())
                .build();
    }

}
