package unam.diplomado.pixup.disco.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import unam.diplomado.pixup.disco.domain.*;
import unam.diplomado.pixup.disco.repository.ArtistaRepository;
import unam.diplomado.pixup.disco.repository.DiscoRepository;
import unam.diplomado.pixup.disco.repository.DisqueraRepository;
import unam.diplomado.pixup.disco.repository.GeneroMusicalRepository;

import java.util.Optional;

@Stateless
public class DiscoServiceImpl implements DiscoService {

    @Inject
    private DisqueraRepository disqueraRepository;

    @Inject
    private ArtistaRepository artistaRepository;

    @Inject
    private GeneroMusicalRepository generoMusicalRepository;

    @Inject
    private DiscoRepository discoRepository;

    @Override
    public Disco registrarDisco(Disco disco) {
        // Validación de disco duplicado
        Optional<Disco> discoExistente = discoRepository.findByTituloAndArtista(disco.getTitulo(), disco.getArtista().getId());
        if (discoExistente.isPresent()) {
            throw new DiscoAlreadyExistsException(disco.getTitulo(), disco.getArtista().getId());
        }

        // Validación de disquera
        Disquera disquera = disqueraRepository.findById(disco.getDisquera().getId()).orElseThrow(() -> new DisqueraNotFoundException(disco.getDisquera().getId()));
        disco.setDisquera(disquera);

        // Validación de artista
        Artista artista = artistaRepository.findById(disco.getArtista().getId()).orElseThrow(() -> new ArtistaNotFoundException(disco.getArtista().getId()));
        disco.setArtista(artista);

        // Validación de género musical
        GeneroMusical generoMusical = generoMusicalRepository.findById(disco.getGeneroMusical().getId()).orElseThrow(() -> new GeneroMusicalNotFoundException(disco.getGeneroMusical().getId()));
        disco.setGeneroMusical(generoMusical);

        // Guardar disco
        discoRepository.save(disco);

        return disco;
    }
}
