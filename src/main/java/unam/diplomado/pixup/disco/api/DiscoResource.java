package unam.diplomado.pixup.disco.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import unam.diplomado.pixup.disco.domain.*;
import unam.diplomado.pixup.disco.service.DiscoService;

public class DiscoResource implements DiscoApi {

    @Inject
    private DiscoService discoService;

    @Override
    public Response altaDisco(Disco disco) {
        try {
            discoService.registrarDisco(disco);
        } catch (Exception e) {
            if (e.getCause() instanceof DiscoAlreadyExistsException) {
                return Response
                        .status(Response.Status.CONFLICT)
                        .entity(e.getCause().getMessage())
                        .build();
            } else if (e.getCause() instanceof DisqueraNotFoundException || e.getCause() instanceof ArtistaNotFoundException || e.getCause() instanceof GeneroMusicalNotFoundException) {
                return Response
                        .status(Response.Status.PRECONDITION_REQUIRED)
                        .entity(e.getCause().getMessage())
                        .build();
            }
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(e.getCause().getMessage())
                    .build();
        }
        return Response
                .status(Response.Status.CREATED)
                .entity(disco)
                .build();
    }
}
