package unam.diplomado.pixup.colonia.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ColoniaAlreadyExistsException extends RuntimeException {
    public ColoniaAlreadyExistsException(String cp, String nombre) {
        super("Ya existe una colonia con el cp " + cp + " y el nombre " + nombre + ".");
    }
}
