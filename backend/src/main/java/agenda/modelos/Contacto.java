package agenda.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Contacto {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    @NotNull
    private String email;

    @Column
    @NotNull
    private String nombre;

    @Column
    @NotNull
    private String apellido;

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}
