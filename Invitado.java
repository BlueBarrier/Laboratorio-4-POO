/**
 * Universidad del Valle de Guatemala
 * Departamento de Ciencias de la Computación
 * Programación Orientada a Objetos
 * 
 * clase para almacenar la información de la bd de los invitados
 * 
 * 
 * @author: Erick Barrera, Marian Montejo, Isabella Ramírez
 * @version: 1.0.0
 * @date: 12/11/23
 */
public class Invitado {
    private String nombre, reunion;

    /**
     * Constructor para la clase invitado
     * 
     * @param nombre
     * @param reunion
     */
    public Invitado(String nombre, String reunion){
        this.nombre = nombre;
        this.reunion = reunion;
    }

    // getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getReunion() {
        return reunion;
    }
    public void setReunion(String reunion) {
        this.reunion = reunion;
    }
}
