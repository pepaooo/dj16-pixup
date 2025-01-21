package unam.diplomado.pixup.disco.repository;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceUnit;
import jakarta.persistence.TypedQuery;
import unam.diplomado.pixup.disco.domain.Disco;

import java.util.Optional;

@Singleton
public class JpaDiscoRepository implements DiscoRepository {

    @PersistenceUnit(unitName = "pixup")
    private EntityManager entityManager;

    @Override
    public Optional<Disco> findByTituloAndArtista(String titulo, Integer idArtista) {
        TypedQuery<Disco> query = entityManager.createQuery("select d from Disco d where d.titulo = :titulo and d.idArtista = :idArtista", Disco.class);
        query.setParameter("titulo", titulo);
        query.setParameter("idArtista", idArtista);
        return Optional.ofNullable(query.getSingleResult());
    }
}
