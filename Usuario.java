import java.util.ArrayList;

/**
 * Universidad del Valle de Guatemala
 * Departamento de Ciencias de la Computación
 * Programación Orientada a Objetos
 * 
 * 
 * clase para almacenar la información de la bd de los usuarios
 * 
 * @author: Erick Barrera, Marian Montejo, Isabella Ramírez
 * @version: 1.0.0
 * @date: 12/11/23
 */

public class Usuario {
    private String nombre, correo, password, tipo, estado;
    private ArrayList<Reunion> reuniones;

    /**
     * Constructor de la clase usuario
     * 
     * @param nombre
     * @param correo
     * @param password
     * @param tipo
     * @param estado
     * @param reuniones
     */
    public Usuario(String nombre, String correo, String password, String tipo, String estado){
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.tipo = tipo;
        this.estado = estado;
        this.reuniones = new ArrayList<>();
    }
    // getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<Reunion> getReuniones() {
        return reuniones;
    }
    public void setReuniones(ArrayList<Reunion> reuniones) {
        this.reuniones = reuniones;
    }

    @Override
    public String toString(){
        return "\nNombre: "+nombre+
               "\nCorreo: "+correo+"\t Contraseña: "+password+
               "\nCuenta: "+tipo+"\tDisponibilidad:"+estado;
    }
    
}