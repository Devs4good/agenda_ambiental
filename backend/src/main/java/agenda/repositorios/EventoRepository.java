package agenda.repositorios;

import agenda.modelos.Evento;
import agenda.modelos.TipoDeEvento;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface EventoRepository extends CrudRepository<Evento, Long>, JpaSpecificationExecutor {

    default List<Evento> findAllMaybeFiltered(Optional<String> terminoDeBusqueda, Optional<Boolean> esPublicado, Optional<Boolean> esDestacado, Optional<TipoDeEvento> tipoDeEvento) {
        List<Predicate> predicados = new ArrayList<>();
        Specification especificacion = (Specification) (root, query, builder) -> {
            esPublicado.ifPresent(estadoDePublicacion -> predicados.add(builder.equal(root.get("publicado"), estadoDePublicacion)));
            esDestacado.ifPresent(estadoDestacado -> predicados.add(builder.equal(root.get("destacado"), estadoDestacado)));
            tipoDeEvento.ifPresent(evento -> predicados.add(builder.equal(builder.lower(root.get("tipo")), evento)));
            terminoDeBusqueda.ifPresent(busqueda -> predicados.add(builder.or(builder.like(builder.lower(root.get("titulo")), "%" + busqueda.toLowerCase() + "%"),
                                                                              builder.like(builder.lower(root.get("descripcion")), "%" + busqueda.toLowerCase() + "%"))));
            return builder.and(predicados.toArray(new Predicate[0]));
        };
        return this.findAll(especificacion);
    }

}