package unam.diplomado.pixup.disco.repository;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import unam.diplomado.pixup.disco.domain.Disquera;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JpaDisqueraRepositoryTest {

    @InjectMocks
    private JpaDisqueraRepository jpaDisqueraRepository;

    @Mock
    private EntityManager entityManager;

    @Test
    void when_findById_notFound() {
        // Expected values - Initialization
        when(entityManager.find(ArgumentMatchers.<Class<Object>>any(), anyInt())).thenReturn(null);

        // Test
        Optional<Disquera> disquera = jpaDisqueraRepository.findById(1);

        // Verify
        assertNotNull(disquera);
        assertTrue(disquera.isEmpty());
    }

    @Test
    void when_findById_foundIt() {
        // Expected values - Initialization
        Disquera mockDisquera = Disquera.builder()
                .id(1)
                .nombre("Disquera 1")
                .build();
        when(entityManager.find(ArgumentMatchers.<Class<Disquera>>any(), anyInt())).thenReturn(mockDisquera);

        // Test
        Optional<Disquera> disquera = jpaDisqueraRepository.findById(1);

        // Verify
        assertNotNull(disquera);
        assertFalse(disquera.isEmpty());
        assertEquals(mockDisquera, disquera.get());
    }
}