package agenda.controladores;

import agenda.modelos.Contacto;
import agenda.modelos.Evento;
import agenda.modelos.TipoDeEvento;
import agenda.repositorios.ContactoRepository;
import agenda.repositorios.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/eventos")
public class EventosController {

    @Autowired
    EventoRepository repositorioDeEventos;

    @Autowired
    ContactoRepository repositorioDeContactos;

    @GetMapping
    private List<Evento> todosLosEventos(@RequestParam Optional<String> publicados,
                                         @RequestParam Optional<String> destacados,
                                         @RequestParam Optional<TipoDeEvento> tipo,
                                         @RequestParam Optional<String> busqueda) {
        Optional<Boolean> estaPublicado = publicados.map(parametro -> parametro.equals("true"));
        Optional<Boolean> esDestacado = destacados.map(parametro -> parametro.equals("true"));
        return repositorioDeEventos.findAllMaybeFiltered(busqueda, estaPublicado, esDestacado, tipo);
    }

    @PostMapping
    private void crearEvento(@Valid @RequestBody Evento unEventoParaCrear) {
        Contacto contactoDelEvento = unEventoParaCrear.getContacto();
        repositorioDeContactos.findByEmail(contactoDelEvento.getEmail()).ifPresent(unEventoParaCrear::setContacto);
        repositorioDeEventos.save(unEventoParaCrear);
    }

    @GetMapping("/{id}")
    private Optional<Evento> obtenerEvento(@PathVariable Long id) {
        return repositorioDeEventos.findById(id);
    }
}
