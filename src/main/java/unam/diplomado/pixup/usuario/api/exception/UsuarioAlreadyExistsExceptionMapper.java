package unam.diplomado.pixup.usuario.api.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import unam.diplomado.pixup.usuario.domain.UsuarioAlreadyExistsException;

@Provider
public class UsuarioAlreadyExistsExceptionMapper implements ExceptionMapper<UsuarioAlreadyExistsException> {

    @Override
    public Response toResponse(UsuarioAlreadyExistsException e) {
        return Response
                .status(Response.Status.CONFLICT)
                .entity(ErrorResponse.builder()
                        .estatus(Response.Status.CONFLICT.getStatusCode())
                        .tipo("BUSINESS_RULE")
                        .mensaje(e.getMessage())
                        .build())
                .build();
    }

}
