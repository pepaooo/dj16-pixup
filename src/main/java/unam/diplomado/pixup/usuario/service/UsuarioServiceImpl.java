package unam.diplomado.pixup.usuario.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import unam.diplomado.pixup.colonia.domain.Colonia;
import unam.diplomado.pixup.colonia.domain.ColoniaNotFoundException;
import unam.diplomado.pixup.colonia.repository.ColoniaRepository;
import unam.diplomado.pixup.usuario.domain.*;
import unam.diplomado.pixup.usuario.repository.DomicilioRepository;
import unam.diplomado.pixup.usuario.repository.TipoDomicilioRepository;
import unam.diplomado.pixup.usuario.repository.UsuarioRepository;

import java.util.Optional;

@Stateless
public class UsuarioServiceImpl implements UsuarioService {

    @Inject
    private UsuarioRepository usuarioRepository;

    @Inject
    private TipoDomicilioRepository tipoDomicilioRepository;

    @Inject
    private ColoniaRepository coloniaRepository;

    @Inject
    private DomicilioRepository domicilioRepository;

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Usuario registrarUsuario(Usuario usuario, Domicilio domicilio) {
        // Validación de usuario duplicado
        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioExistente.isPresent()) {
            throw new UsuarioAlreadyExistsException(usuario.getEmail());
        }

        // Validación de existencia de tipo domicilio
        Optional<TipoDomicilio> tipoDomicilioExistente = tipoDomicilioRepository.findById(domicilio.getTipoDomicilio().getId());
        if (tipoDomicilioExistente.isEmpty()) {
            throw new TipoDomicilioNotFoundException(domicilio.getTipoDomicilio().getId());
        }
        domicilio.setTipoDomicilio(tipoDomicilioExistente.get());

        // Validación de existencia de colonia
        Optional<Colonia> coloniaExistente = coloniaRepository.findById(domicilio.getColonia().getId());
        if (coloniaExistente.isEmpty()) {
            throw new ColoniaNotFoundException(domicilio.getColonia().getId());
        }
        domicilio.setColonia(coloniaExistente.get());

        // Guardado de entidades - transaccion
        usuarioRepository.save(usuario);
        domicilio.setUsuario(usuario);
        domicilioRepository.save(domicilio);

        return usuario;
    }
}
