package unam.diplomado.pixup.disco.repository;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceUnit;
import unam.diplomado.pixup.disco.domain.Artista;

import java.util.Optional;

@Singleton
public class JpaArtistaRepository implements ArtistaRepository {

    @PersistenceUnit(unitName = "pixup")
    private EntityManager entityManager;

    @Override
    public Optional<Artista> findById(Integer id) {
        Artista query = entityManager.find(Artista.class, id);
        return Optional.ofNullable(query);
    }
}
