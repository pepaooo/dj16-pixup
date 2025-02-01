package unam.diplomado.pixup.colonia.service;

import jakarta.ejb.Local;
import unam.diplomado.pixup.colonia.domain.Colonia;

@Local
public interface ColoniaService {

    Colonia getColoniaById(Integer id);

    Colonia createColonia(Colonia colonia);

    Colonia updateColonia(Colonia colonia);

    void deleteColoniaById(Integer id);

}
