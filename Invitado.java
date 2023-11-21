/**
 * Universidad del Valle de Guatemala
 * Departamento de Ciencias de la Computación
 * Programación Orientada a Objetos
 * 
 * Clase para almacenar la información de los invitados en la base de datos.
 * 
 * @author: Erick Barrera, Marian Montejo, Isabella Ramírez
 * @version: 1.0.0
 * @date: 12/11/23
 */
public class Invitado {
    private String nombre, reunion;

    /**
     * Constructor para la clase Invitado.
     * 
     * @param nombre El nombre del invitado.
     * @param reunion El nombre de la reunión a la que asistirá el invitado.
     */
    public Invitado(String nombre, String reunion){
        this.nombre = nombre;
        this.reunion = reunion;
    }

    /**
     * Obtiene el nombre del invitado.
     * 
     * @return El nombre del invitado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del invitado.
     * 
     * @param nombre El nuevo nombre del invitado.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el nombre de la reunión a la que asistirá el invitado.
     * 
     * @return El nombre de la reunión del invitado.
     */
    public String getReunion() {
        return reunion;
    }

    /**
     * Establece el nombre de la reunión a la que asistirá el invitado.
     * 
     * @param reunion El nuevo nombre de la reunión del invitado.
     */
    public void setReunion(String reunion) {
        this.reunion = reunion;
    }
}
