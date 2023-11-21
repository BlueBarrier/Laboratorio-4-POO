import java.sql.*;

/**
 * Universidad del Valle de Guatemala
 * Departamento de Ciencias de la Computación
 * Programación Orientada a Objetos
 * 
 * @author: Erick Barrera, Marian Montejo, Isabella Ramírez
 * @version: 1.0.0
 * @date: 12/11/23
 */
public class Registro {
    // Instance variables
    private Usuario usuario = null;
    private String url = "jdbc:sqlite:./db/users.db";
    private static Connection conect = null;
    ResultSet rst = null;
    EntradaDatos entrada = new EntradaDatos();

    /**
     * Method to save a user to the database.
     * 
     * @param estado The state of the user.
     */
    public void guardarUsuario(String estado){
        // Input user details
        String nombre = entrada.pedirNombre();
        String correo = entrada.pedirCorreo();
        String password = entrada.pedirPassword();
        String tipo = entrada.pedirTipo();

        try {
            // Establish database connection
            Class.forName("org.sqlite.JDBC");
            conect = DriverManager.getConnection(url);
            Statement stmt = conect.createStatement();

            // Execute SQL query to insert user into the database
            stmt.executeUpdate("INSERT INTO Users('nombre','correo','password','membresia','estado') VALUES ('"+
            nombre+"','"+correo+"','"+password+"','"+tipo+"','"+estado+"')");
            System.out.println("Usuario agregado!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Method to update user information in the database.
     */
    public void actualizarUsuario(){
        // Extract user details
        String nombre = usuario.getNombre();
        String correo = usuario.getCorreo();
        String password = usuario.getPassword();
        String tipo = usuario.getTipo();
        String estado = usuario.getEstado();

        try {
            // Establish database connection
            Class.forName("org.sqlite.JDBC");
            conect = DriverManager.getConnection(url);
            Statement stmt = conect.createStatement();

            // Execute SQL query to update user information
            stmt.executeUpdate("INSERT INTO Users('nombre','correo','password','membresia','estado') VALUES ('"+
            nombre+"','"+correo+"','"+password+"','"+tipo+"','"+estado+"')");
            System.out.println("Usuario actualizado!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Method to load a user from the database based on email and password.
     * 
     * @param correo The user's email.
     * @param password The user's password.
     * @return True if user is found, false otherwise.
     */
    public boolean cargarUsuario(String correo, String password){
        try {
            Class.forName("org.sqlite.JDBC");
            conect = DriverManager.getConnection(url);
            Statement stmt = conect.createStatement();
            rst = stmt.executeQuery("select * from Users");
            
            while (rst.next()) {
                if (rst.getString("password").equals(password)
                && rst.getString("correo").equals(correo)) 
                {
                    usuario = new Usuario(
                    rst.getString("nombre"), 
                    rst.getString("correo"),
                    rst.getString("password"),
                    rst.getString("membresia"),
                    rst.getString("estado"));
                    System.out.println("Bienvenid@ "+ usuario.getNombre());
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Usuario no encontrado!");
        return false;
    }

    public void cambiarPlan(){
        if (usuario.getTipo().equals("No Premium")) {
            System.out.println("Se le cobraran Q500 x mes");
            usuario.setTipo("Premium");
            actualizarUsuario();
            cargarUsuario(usuario.getCorreo(), usuario.getPassword());
        }else if (usuario.getTipo().equals("Premium")) {
            System.out.println("Perdiste acceso a las funciones Premium");
            usuario.setTipo("No Premium");
            actualizarUsuario();
            cargarUsuario(usuario.getCorreo(), usuario.getPassword());
        }
    }

    public void cambiarPassword(){
        System.out.println("Ingrese su contraseña anterior");
        String contraAntes = entrada.pedirPassword();
        if (contraAntes.equals(usuario.getPassword())) {
            System.out.println("\nIngrese su nueva contraseña");
            String contraNueva = entrada.pedirPassword();
            usuario.setPassword(contraNueva);
            actualizarUsuario();
            cargarUsuario(usuario.getCorreo(), usuario.getPassword());
            System.out.println("Contraseña cambiada");
        }else{
            System.out.println("Contraseña incorrecta!");
            System.out.println("Vuelva a intentarlo");
        }
    }

    /**
     * @return usuarios
     */
    public Usuario getUsuario() {
        return usuario;
    }
}
