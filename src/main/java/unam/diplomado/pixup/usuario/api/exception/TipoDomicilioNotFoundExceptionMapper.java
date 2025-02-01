package unam.diplomado.pixup.usuario.api.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import unam.diplomado.pixup.usuario.domain.TipoDomicilioNotFoundException;

@Provider
public class TipoDomicilioNotFoundExceptionMapper implements ExceptionMapper<TipoDomicilioNotFoundException> {

    @Override
    public Response toResponse(TipoDomicilioNotFoundException e) {
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
