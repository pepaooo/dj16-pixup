package unam.diplomado.pixup.disco.domain;

public class DisqueraNotFoundException extends RuntimeException {
    public DisqueraNotFoundException(Integer idDisquera) {
        super("No se encontró la disquera con id " + idDisquera);
    }
}
