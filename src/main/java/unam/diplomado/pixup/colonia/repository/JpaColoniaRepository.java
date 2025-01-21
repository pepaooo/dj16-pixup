package unam.diplomado.pixup.colonia.repository;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceUnit;
import jakarta.persistence.TypedQuery;
import unam.diplomado.pixup.colonia.domain.Colonia;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Singleton
public class JpaColoniaRepository implements ColoniaRepository {

    @PersistenceUnit(unitName = "pixup")
    private EntityManager entityManager;

    @Override
    public Collection<Colonia> findByCp(String cp) {
        TypedQuery<Colonia> query = entityManager.createQuery("select c from Colonia c where c.cp = :cp", Colonia.class);
        query.setParameter("cp", cp);
        return query.getResultList();
    }

    @Override
    public Optional<Colonia> findById(Integer id) {
        Colonia query = entityManager.find(Colonia.class, id);
        return Optional.ofNullable(query);
    }
}
