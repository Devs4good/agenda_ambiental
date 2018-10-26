package agenda.repositorios;

import agenda.modelos.Contacto;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ContactoRepository extends CrudRepository<Contacto, Long> {
    Optional<Contacto> findByEmail(String email);
}
