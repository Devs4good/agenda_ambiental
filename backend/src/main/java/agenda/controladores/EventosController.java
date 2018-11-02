package agenda.controladores;

import agenda.excepciones.EventoNotFoundException;
import agenda.modelos.Contacto;
import agenda.modelos.Evento;
import agenda.repositorios.ContactoRepository;
import agenda.repositorios.EventoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.querydsl.core.types.Predicate;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/eventos")
public class EventosController {

    @Autowired
    EventoRepository repositorioDeEventos;

    @Autowired
    ContactoRepository repositorioDeContactos;

    @Autowired
    ObjectMapper mapeadorDeObjetos;

    @GetMapping
    private Page<Evento> todosLosEventos(Pageable pagina, @QuerydslPredicate(root = Evento.class) Predicate predicado) {
        return repositorioDeEventos.findAll(predicado, pagina);
    }

    @PostMapping
    private ResponseEntity crearEvento(@Valid @RequestBody Evento unEventoParaCrear) {
        Contacto contactoDelEvento = unEventoParaCrear.getContacto();
        repositorioDeContactos.findByEmail(contactoDelEvento.getEmail()).ifPresent(unEventoParaCrear::setContacto);
        repositorioDeContactos.save(unEventoParaCrear.getContacto());
        repositorioDeEventos.save(unEventoParaCrear);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    private Evento obtenerEvento(@PathVariable Long id) {
        return repositorioDeEventos.findById(id).orElseThrow(() -> EventoNotFoundException.deId(id));
    }

    @PatchMapping("/{id}")
    private ResponseEntity patchearEvento(@PathVariable Long id, HttpServletRequest request) throws IOException, EventoNotFoundException {
        Evento eventoOriginal = repositorioDeEventos.findById(id).orElseThrow(() -> EventoNotFoundException.deId(id));
        Evento eventoActualizado = mapeadorDeObjetos.readerForUpdating(eventoOriginal).readValue(request.getReader());
        repositorioDeEventos.save(eventoActualizado);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
