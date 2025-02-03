package unam.diplomado.pixup.disco.api.dto;

import jakarta.inject.Singleton;
import unam.diplomado.pixup.disco.domain.Artista;
import unam.diplomado.pixup.disco.domain.Disco;
import unam.diplomado.pixup.disco.domain.Disquera;
import unam.diplomado.pixup.disco.domain.GeneroMusical;

import java.time.LocalDateTime;

@Singleton
public class DiscoMapper {

    public Disco toDisco (DiscoRequestDTO discoRequestDTO){
        return Disco.builder()
                .titulo(discoRequestDTO.getTitulo())
                .precio(discoRequestDTO.getPrecio())
                .existencia(discoRequestDTO.getExistencia())
                .descuento(discoRequestDTO.getDescuento())
                .fechaLanzamiento(discoRequestDTO.getFechaLanzamiento())
                .imagen(discoRequestDTO.getImagen())
                .disquera(Disquera.builder().id(discoRequestDTO.getDisquera())   .build())
                .artista(Artista.builder().id(discoRequestDTO.getArtista()).build())
                .generoMusical(GeneroMusical.builder().id(discoRequestDTO.getGeneroMusical()).build())
                .build();
    }

    public DiscoResponseDTO toResponseDTO(Disco disco){
        return DiscoResponseDTO.builder()
                .id(disco.getId())
                .titulo(disco.getTitulo())
                .artista(disco.getArtista().getNombre())
                .build();
    }

}
