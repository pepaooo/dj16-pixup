package unam.diplomado.pixup.usuario.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import unam.diplomado.pixup.usuario.api.dto.RegistroUsuarioDTO;
import unam.diplomado.pixup.usuario.api.dto.RegistroUsuarioMapper;
import unam.diplomado.pixup.usuario.api.dto.UsuarioResponseDTO;
import unam.diplomado.pixup.usuario.domain.Domicilio;
import unam.diplomado.pixup.usuario.domain.Usuario;
import unam.diplomado.pixup.usuario.service.UsuarioService;

public class UsuarioResource implements UsuarioApi {

    @Inject
    private UsuarioService usuarioService;

    @Inject
    private RegistroUsuarioMapper mapper;

    @Override
    public Response registrarUsuario(RegistroUsuarioDTO registroUsuarioDTO) {
        // Transformación DTO - Entity
        Usuario usuario = mapper.toUsuario(registroUsuarioDTO.getUsuario());
        Domicilio domicilio = mapper.toDomicilio(registroUsuarioDTO.getDomicilio());

        // Invocación de servicio de negocio
        Usuario usuarioCreado = usuarioService.registrarUsuario(usuario, domicilio);

        // Transformación Entity - DTO
        UsuarioResponseDTO usuarioResponseDTO = mapper.toResponseDTO(usuarioCreado);

        return Response.status(Response.Status.CREATED)
                .entity(usuarioResponseDTO)
                .build();
    }
}
