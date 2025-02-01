package unam.diplomado.pixup.colonia.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import unam.diplomado.pixup.colonia.domain.*;
import unam.diplomado.pixup.colonia.repository.ColoniaRepository;
import unam.diplomado.pixup.colonia.repository.MunicipioRepository;

import java.util.Optional;

@Stateless
public class ColoniaServiceImpl implements ColoniaService {

    @Inject
    private ColoniaRepository coloniaRepository;

    @Inject
    private MunicipioRepository municipioRepository;

    @Override
    public Colonia getColoniaById(Integer id) {
        Optional<Colonia> colonia = coloniaRepository.findById(id);
        if (colonia.isPresent()) {
            return colonia.get();
        }
        // En una arquitectura por capas, la capa de negocio está obligada a responder con excepciones de negocio cuando hay algún error (para cada uno de los escenarios que tengo que reportar)
        throw new ColoniaNotFoundException(id);
    }

    @Override
    public Colonia createColonia(Colonia colonia) {
        Optional<Colonia> coloniaExistente = coloniaRepository.findByCpAndNombre(colonia.getCp(), colonia.getNombre());
        if (coloniaExistente.isPresent()) {
            throw new ColoniaAlreadyExistsException(colonia.getCp(), colonia.getNombre());
        }
        Optional<Municipio> municipioExistente = municipioRepository.findById(colonia.getMunicipio().getId());
        if (municipioExistente.isEmpty()) {
            throw new MunicipioNotFoundException(colonia.getMunicipio().getId());
        }

        colonia.setMunicipio(municipioExistente.get());
        return coloniaRepository.saveOrUpdate(colonia);
    }

    @Override
    public Colonia updateColonia(Colonia colonia) {
        Colonia coloniaExistente = coloniaRepository.findById(colonia.getId()).orElseThrow(() -> new ColoniaNotFoundException(colonia.getId()));

        Optional<Colonia> coloniaExistenteUk = coloniaRepository.findByCpAndNombre(colonia.getCp(), colonia.getNombre());
        if (coloniaExistenteUk.isPresent()) {
            throw new ColoniaAlreadyExistsException(colonia.getCp(), colonia.getNombre());
        }
        Optional<Municipio> municipioExistente = municipioRepository.findById(colonia.getMunicipio().getId());
        if (municipioExistente.isEmpty()) {
            throw new MunicipioNotFoundException(colonia.getMunicipio().getId());
        }

        coloniaExistente.setMunicipio(municipioExistente.get());
        coloniaExistente.setCp(colonia.getCp());
        coloniaExistente.setNombre(colonia.getNombre());

        return coloniaRepository.saveOrUpdate(coloniaExistente);
    }

    @Override
    public void deleteColoniaById(Integer id) {
        coloniaRepository.findById(id).ifPresent(coloniaRepository::delete);
    }
}

