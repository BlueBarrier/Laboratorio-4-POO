import java.sql.*;

/**
 * Universidad del Valle de Guatemala
 * Departamento de Ciencias de la Computación
 * Programación Orientada a Objetos
 * 
 * @author Erick Barrera, Marian Montejo, Isabella Ramírez
 * @version 1.0.0
 * @date 12/11/23
 */
public class Registro {
    // Variables de instancia
    private Usuario usuario = null;
    private String url = "jdbc:sqlite:./db/users.db";
    private static Connection conect = null;
    ResultSet rst = null;
    EntradaDatos entrada = new EntradaDatos();

    /**
     * Método para guardar un usuario en la base de datos.
     * 
     * @param estado El estado del usuario.
     */
    public void guardarUsuario(String estado){
        // Ingresar detalles del usuario
        String nombre = entrada.pedirNombre();
        String correo = entrada.pedirCorreo();
        String password = entrada.pedirPassword();
        String tipo = entrada.pedirTipo();

        try {
            // Establecer conexión con la base de datos
            Class.forName("org.sqlite.JDBC");
            conect = DriverManager.getConnection(url);
            Statement stmt = conect.createStatement();

            // Ejecutar consulta SQL para insertar usuario en la base de datos
            stmt.executeUpdate("INSERT INTO Users('nombre','correo','password','membresia','estado') VALUES ('"+
            nombre+"','"+correo+"','"+password+"','"+tipo+"','"+estado+"')");
            System.out.println("Usuario agregado!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Método para actualizar la información del usuario en la base de datos.
     */
    public void actualizarUsuario(){
        // Extraer detalles del usuario
        String nombre = usuario.getNombre();
        String correo = usuario.getCorreo();
        String password = usuario.getPassword();
        String tipo = usuario.getTipo();
        String estado = usuario.getEstado();

        try {
            // Establecer conexión con la base de datos
            Class.forName("org.sqlite.JDBC");
            conect = DriverManager.getConnection(url);
            Statement stmt = conect.createStatement();

            // Ejecutar consulta SQL para actualizar la información del usuario
            stmt.executeUpdate("INSERT INTO Users('nombre','correo','password','membresia','estado') VALUES ('"+
            nombre+"','"+correo+"','"+password+"','"+tipo+"','"+estado+"')");
            System.out.println("Usuario actualizado!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Método para cargar un usuario desde la base de datos basado en correo y contraseña.
     * 
     * @param correo El correo del usuario.
     * @param password La contraseña del usuario.
     * @return True si se encuentra al usuario, false de lo contrario.
     */
    public boolean cargarUsuario(String correo, String password){
        try {
            // Establecer conexión con la base de datos
            Class.forName("org.sqlite.JDBC");
            conect = DriverManager.getConnection(url);
            Statement stmt = conect.createStatement();
            rst = stmt.executeQuery("select * from Users");
            
            while (rst.next()) {
                // Verificar si el correo y la contraseña coinciden
                if (rst.getString("password").equals(password)
                && rst.getString("correo").equals(correo)) 
                {
                    // Crear un objeto de usuario con la información recuperada
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

    // Otros métodos para cambiar plan y contraseña...

    /**
     * Método getter para el objeto Usuario.
     * 
     * @return El objeto Usuario.
     */
    public Usuario getUsuario() {
        return usuario;
    }
}
