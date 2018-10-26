package agenda.modelos;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Evento {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    @NotNull
    private String titulo;

    @Column
    @NotNull
    private String descripcion;

    @Column
    private boolean publicado;

    @Column
    private boolean destacado;

    @Column
    @NotNull
    private String localidad;

    @Column
    private Long precio; // Hay gente que no lo dice

    @Column
    @NotNull
    private String link;

    @Column
    @NotNull
    private LocalDateTime fechaYHoraDeInicio;

    @Column
    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoDeEvento tipo;

    @JoinColumn
    @ManyToOne
    @NotNull
    private Contacto contacto;

    public Evento(String unTitulo, String unaDescripcion, String unaLocalidad, String unLink, LocalDateTime unaFechaYHora, TipoDeEvento tipo, Contacto unContacto) {
        this.titulo = unTitulo;
        this.descripcion = unaDescripcion;
        this.publicado = false;
        this.destacado = false;
        this.localidad = unaLocalidad;
        this.link = unLink;
        this.fechaYHoraDeInicio = unaFechaYHora;
        this.tipo = tipo;
        this.contacto = unContacto;
    }

    public Evento() {
    }

    public Long getId() {
        return this.id;
    }

    public boolean getPublicado() {
        return this.publicado;
    }

    public boolean estaPublicado() {
        return this.publicado;
    }

    public void publicar() {
        this.publicado = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isDestacado() {
        return destacado;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getLink() {
        return link;
    }

    public LocalDateTime getFechaYHoraDeInicio() {
        return fechaYHoraDeInicio;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public TipoDeEvento getTipo() {
        return tipo;
    }
}
