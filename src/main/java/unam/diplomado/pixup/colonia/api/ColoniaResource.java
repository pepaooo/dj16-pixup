package unam.diplomado.pixup.colonia.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import unam.diplomado.pixup.colonia.api.dto.ColoniaDTO;
import unam.diplomado.pixup.colonia.api.dto.ColoniaMapper;
import unam.diplomado.pixup.colonia.domain.Colonia;
import unam.diplomado.pixup.colonia.repository.ColoniaRepository;
import unam.diplomado.pixup.colonia.service.ColoniaService;

import java.util.Collection;

public class ColoniaResource implements ColoniaApi {

    @Inject
    private ColoniaRepository repository;

    @Inject
    private ColoniaService coloniaService;

    @Inject
    private ColoniaMapper mapper;

    @Override
    public Colonia getColoniaById(Integer id) {
        return coloniaService.getColoniaById(id);
    }

    @Override
    public Collection<ColoniaDTO> getColoniasByCp(String cp) {
        return repository.findByCp(cp)
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Override
    public Response createColonia(Colonia colonia) {
        Colonia coloniaCreada = coloniaService.createColonia(colonia);
        return Response.status(Response.Status.CREATED).entity(coloniaCreada).build();
    }

    @Override
    public Colonia updateColonia(Integer id, Colonia colonia) {
        colonia.setId(id);
        return coloniaService.updateColonia(colonia);
    }

    @Override
    public void deleteColoniaById(Integer id) {
        coloniaService.deleteColoniaById(id);
    }

}
