package unam.diplomado.pixup.colonia.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import unam.diplomado.pixup.colonia.domain.Colonia;
import unam.diplomado.pixup.colonia.domain.Estado;
import unam.diplomado.pixup.colonia.domain.Municipio;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JpaColoniaRepositoryUnitTest {

    @InjectMocks
    private JpaColoniaRepository jpaColoniaRepository;

    @Mock
    EntityManager entityManager;

    @Mock
    TypedQuery<Colonia> typedQuery;

    @Test
    void when_findById_notFound() {
        // Expected values - Initialization
        when(entityManager.find(ArgumentMatchers.<Class<Colonia>>any(), anyInt())).thenReturn(null);

        // Test
        Optional<Colonia> colonia = jpaColoniaRepository.findById(1);

        // Verify
        assertNotNull(colonia);
        assertTrue(colonia.isEmpty());

    }

    @Test
    void when_findById_foundIt() {
        // Expected values - Initialization
        Colonia mockColonia = Colonia.builder().id(1).build();
        when(entityManager.find(ArgumentMatchers.<Class<Colonia>>any(), anyInt())).thenReturn(mockColonia);

        // Test
        Optional<Colonia> colonia = jpaColoniaRepository.findById(1);

        // Verify
        assertNotNull(colonia);
        assertFalse(colonia.isEmpty());
        assertEquals(mockColonia, colonia.get());
    }

    @Test
    void when_findByCp_foundIt() {
        // Expected values - Initialization
        Estado mexico = Estado.builder().id(1).nombre("Mexico").build();
        Municipio tecamac = Municipio.builder().id(1).nombre("Tecamac").estado(mexico).build();
        Colonia colonia1 = Colonia.builder().id(1).nombre("Colonia 1").cp("12345").municipio(tecamac).build();
        Colonia colonia2 = Colonia.builder().id(2).nombre("Colonia 2").cp("23456").municipio(tecamac).build();
        when(entityManager.createQuery(anyString(), ArgumentMatchers.<Class<Colonia>>any())).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(List.of(colonia1, colonia2));

        // Test
        Collection<Colonia> colonias = jpaColoniaRepository.findByCp("12345");

        // Verify
        assertNotNull(colonias);
        assertEquals(2, colonias.size());
        assertTrue(colonias.containsAll(List.of(colonia1, colonia2)));

    }
}