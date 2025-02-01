package unam.diplomado.pixup.usuario.api.dto;

import jakarta.inject.Singleton;
import unam.diplomado.pixup.colonia.domain.Colonia;
import unam.diplomado.pixup.usuario.domain.Domicilio;
import unam.diplomado.pixup.usuario.domain.TipoDomicilio;
import unam.diplomado.pixup.usuario.domain.Usuario;

@Singleton
public class RegistroUsuarioMapper {

    public UsuarioResponseDTO toResponseDTO(Usuario usuario) {
        return UsuarioResponseDTO.builder()
                .id(usuario.getId())
                .email(usuario.getEmail())
                .build();
    }

    public Usuario toUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        return Usuario.builder()
                .nombre(usuarioRequestDTO.getNombre())
                .primerApellido(usuarioRequestDTO.getPrimerApellido())
                .segundoApellido(usuarioRequestDTO.getSegundoApellido())
                .password(usuarioRequestDTO.getPassword())
                .email(usuarioRequestDTO.getEmail())
                .rfc(usuarioRequestDTO.getRfc())
                .build();
    }

    public Domicilio toDomicilio(DomicilioDTO domicilioDTO) {
        return Domicilio.builder()
                .calle(domicilioDTO.getCalle())
                .numExterior(domicilioDTO.getNumExterior())
                .numInterior(domicilioDTO.getNumInterior())
                .colonia(Colonia.builder().id(domicilioDTO.getColonia()).build())
                .tipoDomicilio(TipoDomicilio.builder().id(domicilioDTO.getTipoDomicilio()).build())
                .build();
    }

}
