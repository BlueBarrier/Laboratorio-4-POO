import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Universidad del Valle de Guatemala
 * Departamento de Ciencias de la Computación
 * Programación Orientada a Objetos
 * 
 * clase para almacenar la información de la bd de las reuniones
 * 
 * @author: Erick Barrera, Marian Montejo, Isabella Ramírez
 * @version: 1.0.0
 * @date: 12/11/23
 */
public class Reunion {
    private String usuario, titulo;
    private LocalDateTime fechaHora;
    private int pin, duracion;
    private ArrayList<String> notas;
    private ArrayList<Invitado> invitados;

    /**
     * Constructor de la clase Reunion
     * 
     * @param usuario
     * @param fechaHora
     * @param titulo
     * @param pin
     * @param notas
     * @param duracion
     * @param invitados
     */
    public Reunion(String usuario, LocalDateTime fechaHora, String titulo, int pin, ArrayList<String> notas, int duracion, ArrayList<Invitado> invitados){
        this.usuario = usuario;
        this.fechaHora = fechaHora;
        this.titulo = titulo;
        this.pin = pin;
        this.notas = notas;
        this.duracion = duracion;
        this.invitados = invitados;
    }

    // getters y setters

    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPin() {
        return pin;
    }
    public void setPin(int pin) {
        this.pin = pin;
    }

    public ArrayList<String> getNotas() {
        return notas;
    }
    public void setNotas(ArrayList<String> notas) {
        this.notas = notas;
    }
    
    public int getDuracion() {
        return duracion;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public ArrayList<Invitado> getInvitados() {
        return invitados;
    }
    public void setInvitados(ArrayList<Invitado> invitados) {
        this.invitados = invitados;
    }

    @Override 
    public String toString(){
        return "";
    }
}
    