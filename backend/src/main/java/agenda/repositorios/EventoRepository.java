package agenda.repositorios;

import agenda.modelos.Evento;
import agenda.modelos.QEvento;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.data.repository.CrudRepository;

public interface EventoRepository extends CrudRepository<Evento, Long>, QuerydslPredicateExecutor<Evento>, QuerydslBinderCustomizer<QEvento> {

    @Override
    default public void customize(QuerydslBindings bindings, QEvento evento) {
        bindings.bind(evento.titulo).first(StringExpression::contains);
        bindings.bind(evento.descripcion).first(StringExpression::contains);
        bindings.bind(String.class).first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
    }
}