package unam.diplomado.pixup.disco.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import unam.diplomado.pixup.disco.domain.Disco;
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

        return null;
    }
}
