package unam.diplomado.pixup.disco.repository;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import unam.diplomado.pixup.disco.domain.GeneroMusical;

import javax.swing.text.html.parser.Entity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JpaGeneroMusicalRepositoryTest {

    @InjectMocks
    private JpaGeneroMusicalRepository jpaGeneroMusicalRepository;

    @Mock
    EntityManager entityManager;

    @Test
    void when_findById_notFound() {
        // Expected values - Initialization
        when(entityManager.find(ArgumentMatchers.<Class<GeneroMusical>>any(), anyInt())).thenReturn(null);

        // Test
        Optional<GeneroMusical> generoMusical = jpaGeneroMusicalRepository.findById(1);

        // Verify
        assertNotNull(generoMusical);
        assertTrue(generoMusical.isEmpty());
    }

    @Test
    void when_findById_foundIt() {
        // Expected values - Initialization
        GeneroMusical mockGeneroMusical = GeneroMusical.builder().id(1).build();
        when(entityManager.find(ArgumentMatchers.<Class<GeneroMusical>>any(), anyInt())).thenReturn(mockGeneroMusical);

        // Test
        Optional<GeneroMusical> generoMusical = jpaGeneroMusicalRepository.findById(1);

        // Verify
        assertNotNull(generoMusical);
        assertFalse(generoMusical.isEmpty());
        assertEquals(mockGeneroMusical, generoMusical.get());
    }

}