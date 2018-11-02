package agenda.excepciones;

public class EventoNotFoundException extends RuntimeException {

    private EventoNotFoundException(String mensaje) {
        super(mensaje);
    }

    public static EventoNotFoundException deId(Long id) {
        return new EventoNotFoundException("Evento con id " + id.toString() + " no encontrado");
    }
}
