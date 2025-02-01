package unam.diplomado.pixup.colonia.repository;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import unam.diplomado.pixup.colonia.domain.Colonia;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Singleton
public class JpaColoniaRepository implements ColoniaRepository {

    @PersistenceContext(unitName = "pixup")
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

    @Override
    public Colonia saveOrUpdate(Colonia colonia) {
        entityManager.persist(colonia);
        return colonia;
    }

    @Override
    public void delete(Colonia colonia) {
        entityManager.remove(colonia);
    }

    @Override
    public Optional<Colonia> findByCpAndNombre(String cp, String nombre) {
        TypedQuery<Colonia> query = entityManager.createQuery("select c from Colonia c where c.cp = :cp and c.nombre = :nombre", Colonia.class);
        query.setParameter("cp", cp);
        query.setParameter("nombre", nombre);
        List<Colonia> colonias = query.getResultList();
        return colonias.isEmpty() ? Optional.empty() : Optional.of(colonias.get(0));
    }
}
