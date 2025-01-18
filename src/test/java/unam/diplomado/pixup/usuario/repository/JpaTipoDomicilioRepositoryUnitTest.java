package unam.diplomado.pixup.usuario.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import unam.diplomado.pixup.usuario.domain.TipoDomicilio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class JpaTipoDomicilioRepositoryUnitTest {

    @InjectMocks
    private JpaTipoDomicilioRepository jpaTipoDomicilioRepository;

    @Mock
    private EntityManager entityManager;

    @Mock
    private TypedQuery<TipoDomicilio> typedQuery;

    // Nomenclatura BDD. En este ejemplo notFound es el branch de ejecución del metodo.
    @Test
    void when_findById_notFound() {
        // Expected values - Initialization
        when(entityManager.find(ArgumentMatchers.<Class<TipoDomicilio>>any(), anyInt())).thenReturn(null);


        // Test
        Optional<TipoDomicilio> tipoDomicilio = jpaTipoDomicilioRepository.findById(1);

        // Verify
        assertNotNull(tipoDomicilio);
        assertTrue(tipoDomicilio.isEmpty());

    }

    @Test
    void when_findById_foundIt() {
        // Expected values - Initialization
        TipoDomicilio mockTipoDomicilio = TipoDomicilio.builder().id(1).descripcion("casa").build();
        when(entityManager.find(ArgumentMatchers.<Class<TipoDomicilio>>any(), anyInt())).thenReturn(mockTipoDomicilio);


        // Test
        Optional<TipoDomicilio> tipoDomicilio = jpaTipoDomicilioRepository.findById(1);

        // Verify
        assertNotNull(tipoDomicilio);
        assertFalse(tipoDomicilio.isEmpty());
        assertEquals(mockTipoDomicilio, tipoDomicilio.get());

    }

    @Test
    void when_findAll_getTiposDomicilio() {
        // Expected values - Initialization
        List<TipoDomicilio> mockTiposDomicilio = new ArrayList<>();
        TipoDomicilio mockTipoDomicilio1 = TipoDomicilio.builder().id(1).descripcion("casa").build();
        TipoDomicilio mockTipoDomicilio2 = TipoDomicilio.builder().id(2).descripcion("oficina").build();
        mockTiposDomicilio.add(mockTipoDomicilio2);
        mockTiposDomicilio.add(mockTipoDomicilio1);
        when(entityManager.createQuery(anyString(), ArgumentMatchers.<Class<TipoDomicilio>>any())).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(mockTiposDomicilio);


        // Test
        Collection<TipoDomicilio> tiposDomicilio = jpaTipoDomicilioRepository.findAll();

        // Verify
        assertNotNull(tiposDomicilio);
        assertEquals(2, tiposDomicilio.size());
        assertTrue(tiposDomicilio.containsAll(mockTiposDomicilio));
    }
}