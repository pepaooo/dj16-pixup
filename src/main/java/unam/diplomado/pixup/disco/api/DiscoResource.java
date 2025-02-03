package unam.diplomado.pixup.disco.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import unam.diplomado.pixup.disco.api.dto.DiscoMapper;
import unam.diplomado.pixup.disco.api.dto.DiscoRequestDTO;
import unam.diplomado.pixup.disco.api.dto.DiscoResponseDTO;
import unam.diplomado.pixup.disco.domain.*;
import unam.diplomado.pixup.disco.service.DiscoService;

public class DiscoResource implements DiscoApi {

    @Inject
    private DiscoService discoService;

    @Inject
    DiscoMapper discoMapper;

    @Override
    public Response altaDisco(DiscoRequestDTO discoRequestDTO) {
        // Transformación DTO - Entity
        Disco disco = discoMapper.toDisco(discoRequestDTO);

        // Invocación de servicio de negocio
        Disco discoCreado = discoService.registrarDisco(disco);

        // Transformación Entity - DTO
        DiscoResponseDTO discoResponseDTO = discoMapper.toResponseDTO(discoCreado);

        return Response
                .status(Response.Status.CREATED)
                .entity(discoResponseDTO)
                .build();

    }
}
