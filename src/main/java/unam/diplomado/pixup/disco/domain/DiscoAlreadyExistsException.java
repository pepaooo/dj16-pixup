package unam.diplomado.pixup.disco.domain;

public class DiscoAlreadyExistsException extends RuntimeException {
    public DiscoAlreadyExistsException(String titulo, Integer idArtista) {
        super("Ya existe un disco con el título " + titulo + " para el artista con id " + idArtista);
    }
}
