package unam.diplomado.pixup.disco.repository;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import unam.diplomado.pixup.disco.domain.Artista;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JpaArtistaRepositoryTest {

    @InjectMocks
    private JpaArtistaRepository jpaArtistaRepository;

    @Mock
    private EntityManager entityManager;

    @Test
    void when_findById_notFound() {
        // Expected values - Initialization
        when(entityManager.find(ArgumentMatchers.<Class<Artista>>any(), anyInt())).thenReturn(null);

        // Test
        Optional<Artista> artista = jpaArtistaRepository.findById(1);

        // Verify
        assertNotNull(artista);
        assertTrue(artista.isEmpty());
    }

    @Test
    void when_findById_foundIt() {
        // Expected values - Initialization
        Artista mockArtista = Artista.builder()
                .id(1)
                .nombre("Artista 1")
                .build();
        when(entityManager.find(ArgumentMatchers.<Class<Artista>>any(), anyInt())).thenReturn(mockArtista);

        // Test
        Optional<Artista> artista = jpaArtistaRepository.findById(1);

        // Verify
        assertNotNull(artista);
        assertFalse(artista.isEmpty());
        assertEquals(mockArtista, artista.get());
    }
}