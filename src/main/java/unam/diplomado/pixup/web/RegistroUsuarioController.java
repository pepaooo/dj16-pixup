package unam.diplomado.pixup.web;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import unam.diplomado.pixup.colonia.api.dto.ColoniaDTO;
import unam.diplomado.pixup.colonia.api.dto.ColoniaMapper;
import unam.diplomado.pixup.colonia.domain.Colonia;
import unam.diplomado.pixup.colonia.repository.ColoniaRepository;
import unam.diplomado.pixup.colonia.service.ColoniaService;
import unam.diplomado.pixup.usuario.domain.Domicilio;
import unam.diplomado.pixup.usuario.domain.TipoDomicilio;
import unam.diplomado.pixup.usuario.domain.Usuario;
import unam.diplomado.pixup.usuario.repository.TipoDomicilioRepository;
import unam.diplomado.pixup.usuario.service.UsuarioService;

import java.io.Serializable;
import java.util.Collection;

@Named("registro")
@ViewScoped
@Log
public class RegistroUsuarioController implements Serializable {

    // Input
    @Getter
    @Setter
    private Usuario usuario;
    @Getter
    @Setter
    private Domicilio domicilio;
    @Getter
    @Setter
    private String cp;
    @Getter
    @Setter
    private String coloniaId;
    @Getter
    @Setter
    private String tipoDomicilioId;

    // Output
    @Getter
    @Setter
    private Collection<ColoniaDTO> colonias;
    @Getter
    @Setter
    private Collection<TipoDomicilio> tiposDomicilio;

    @Inject
    transient private UsuarioService usuarioService;

    @Inject
    transient private ColoniaService coloniaService;

    @Inject
    transient private ColoniaRepository coloniaRepository;

    @Inject
    transient private TipoDomicilioRepository tipoDomicilioRepository;

    @Inject
    transient private ColoniaMapper coloniaMapper;

    @PostConstruct
    public void init() {
        this.usuario = new Usuario();
        this.domicilio = new Domicilio();
        this.tiposDomicilio = tipoDomicilioRepository.findAll();
    }

    public void findColoniaByCp() {
        log.info("cp seleccionado: " + this.cp);
        this.colonias = coloniaRepository.findByCp(this.cp)
                .stream()
                .map(coloniaMapper::toDTO)
                .toList();
    }

    public String altaUsuario() {
        // Domicilio
        this.domicilio.setColonia(Colonia.builder().id(Integer.valueOf(this.coloniaId)).build());
        this.domicilio.setTipoDomicilio(TipoDomicilio.builder().id(Integer.valueOf(this.tipoDomicilioId)).build());

        // Usuario
        Usuario usuarioCreado = usuarioService.registrarUsuario(this.usuario, this.domicilio);
        log.info("Usuario creado: " + usuarioCreado);

        return "/registro_resultado?faces-redirect=true";
    }
}
