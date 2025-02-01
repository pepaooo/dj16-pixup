package unam.diplomado.pixup.disco.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import unam.diplomado.pixup.disco.domain.Artista;
import unam.diplomado.pixup.disco.domain.Disco;
import unam.diplomado.pixup.disco.domain.Disquera;
import unam.diplomado.pixup.disco.domain.GeneroMusical;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JpaDiscoRepositoryTest {

    @InjectMocks
    private JpaDiscoRepository jpaDiscoRepository;

    @Mock
    EntityManager entityManager;

    @Mock
    TypedQuery<Disco> typedQuery;

    @Test
    void when_findById_notFound() {
        // Expected values - Initialization
        when(entityManager.createQuery(anyString(), ArgumentMatchers.<Class<Disco>>any())).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(List.of());

        // Test
        Optional<Disco> disco = jpaDiscoRepository.findByTituloAndArtista("Disco 1", 1);

        // Verify
        assertNotNull(disco);
        assertTrue(disco.isEmpty());
    }

    @Test
    void when_findById_foundIt() {
        // Expected values - Initialization
        Disquera mockDisquera = Disquera.builder()
                .id(1)
                .nombre("Disquera 1")
                .build();

        Artista mockArtista = Artista.builder()
                .id(1)
                .nombre("Artista 1")
                .build();

        GeneroMusical mockGeneroMusical = GeneroMusical.builder()
                .id(1)
                .descripcion("Genero Musical 1")
                .build();

        Disco mockDisco = Disco.builder()
                .id(1)
                .titulo("Disco 1")
                .existencia(1)
                .descuento(15.0f)
                .fechaLanzamiento(LocalDate.now())
                .imagen("imagen.jpg")
                .precio(250.0f)
                .idDisquera(mockDisquera)
                .idArtista(mockArtista)
                .idGeneroMusical(mockGeneroMusical)
                .build();
        when(entityManager.createQuery(anyString(), ArgumentMatchers.<Class<Disco>>any())).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(List.of(mockDisco));

        // Test
        Optional<Disco> disco = jpaDiscoRepository.findByTituloAndArtista("Disco 1", 1);

        // Verify
        assertNotNull(disco);
        assertFalse(disco.isEmpty());
        assertEquals(mockDisco, disco.get());
    }

}