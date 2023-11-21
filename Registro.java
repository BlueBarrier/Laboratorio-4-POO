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
            // Establish database connection
            Class.forName("org.sqlite.JDBC");
            conect = DriverManager.getConnection(url);
            Statement stmt = conect.createStatement();
            rst = stmt.executeQuery("select * from Users");
            
            while (rst.next()) {
                // Check if email and password match
                if (rst.getString("password").equals(password)
                && rst.getString("correo").equals(correo)) 
                {
                    // Create a user object with the retrieved information
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

    // Other methods for changing plan and password...

    /**
     * Getter method for the Usuario object.
     * 
     * @return The Usuario object.
     */
    public Usuario getUsuario() {
        return usuario;
    }
}
