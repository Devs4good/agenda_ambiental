package agenda.controladores;

import agenda.modelos.Contacto;
import agenda.repositorios.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/contactos")
public class ContactoController {

    @Autowired
    private ContactoRepository repositorioDeContactos;

    @PostMapping
    public void crearContacto(@Valid @RequestBody Contacto contacto) {
        repositorioDeContactos.save(contacto);
    }

}
