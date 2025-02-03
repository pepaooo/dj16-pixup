package unam.diplomado.pixup.disco.api.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import unam.diplomado.pixup.disco.domain.ArtistaNotFoundException;
import unam.diplomado.pixup.usuario.api.exception.ErrorResponse;

@Provider
public class ArtistaNotFoundExceptionMapper implements ExceptionMapper<ArtistaNotFoundException> {

    @Override
    public Response toResponse(ArtistaNotFoundException e) {
        return Response
                .status(Response.Status.PRECONDITION_REQUIRED)
                .entity(ErrorResponse.builder()
                        .estatus(Response.Status.PRECONDITION_REQUIRED.getStatusCode())
                        .tipo("DATA_INCONSISTENCY")
                        .mensaje(e.getMessage())
                        .build())
                .build();
    }

}
