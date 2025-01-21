package unam.diplomado.pixup.disco.repository;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceUnit;
import unam.diplomado.pixup.disco.domain.GeneroMusical;

import java.util.Optional;

@Singleton
public class JpaGeneroMusicalRepository implements GeneroMusicalRepository {

    @PersistenceUnit(unitName = "pixup")
    private EntityManager entityManager;

    @Override
    public Optional<GeneroMusical> findById(Integer id) {
        GeneroMusical query = entityManager.find(GeneroMusical.class, id);
        return Optional.ofNullable(query);
    }
}
