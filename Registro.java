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
    private Usuario usuario = new Usuario(null, null, null, null, null);
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
            conect.close();
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
            conect.close();
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
                    conect.close();
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Usuario no encontrado!");
        return false;
    }

    /**
     *  cambiar plan
     */
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

    /**
     *  cambiar contraseña
     */
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
     * Método getter para el objeto Usuario.
     * 
     * @return El objeto Usuario.
     */
    public Usuario getUsuario() {
        return usuario;
    }
}
