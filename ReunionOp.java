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
public class ReunionOp {
    private String url = "jdbc:sqlite:./db/users.db";
    private static Connection conect = null;
    ResultSet rst = null;
    EntradaDatos entrada = new EntradaDatos();
    
    public void guardarReunion(String usuario){
        String fecha = entrada.fechaR();
        String titulo = entrada.titulo();
        int pin = entrada.pin();
        int duracion = entrada.duracion();
        

        try {
            Class.forName("org.sqlite.JDBC");
            conect = DriverManager.getConnection(url);
            Statement stmt = conect.createStatement();
            stmt.executeUpdate("INSERT INTO Reuniones('usuario','fecha','titulo','pin','duracion') VALUES ('"+
            usuario+"','"+fecha+"','"+titulo+"','"+pin+"','"+duracion+"')");
            System.out.println("Reunión agregada!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void 
}
