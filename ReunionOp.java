import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

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
    private ArrayList<Reunion> reuniones = new ArrayList<>();
    private ArrayList<Invitado> invitados = new ArrayList<>();
    private ArrayList<String> notas = new ArrayList<>();
    private int conteo = reuniones.size();
    private int inviConteo = invitados.size();
    
    public void guardarReunion(Usuario usuario){
        cargarReunion(usuario);
        if (comprobarPlan(usuario)) {
            if (conteo>=5) {
                System.out.println("Ya excedio el número de reuniones por día");
            }else{
                conteo++;
                String fecha = entrada.fechaR();
                for (Reunion reune : reuniones) {
                    if (reune.getFechaHora().equals(LocalDateTime.parse(fecha))) {
                        System.out.println("Esta fecha ya existe!");
                        System.out.println("Ingrese otra fecha!");
                        fecha = entrada.fechaR();
                    }
                }
                String titulo = entrada.titulo();
                int pin = entrada.pin();
                int duracion = entrada.duracionPremium();
                
        
                try {
                    Class.forName("org.sqlite.JDBC");
                    conect = DriverManager.getConnection(url);
                    Statement stmt = conect.createStatement();
                    stmt.executeUpdate("INSERT INTO Reuniones('usuario','fecha','titulo','pin','duracion') VALUES ('"+
                    usuario.getCorreo()+"','"+fecha+"','"+titulo+"','"+pin+"','"+duracion+"')");
                    System.out.println("Reunión agregada!");
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }else{
            if (conteo>=2) {
                System.out.println("Ya excedio el número de reuniones por día");
            }else{
                conteo++;
                String fecha = entrada.fechaR();
                for (Reunion reune : reuniones) {
                    if (reune.getFechaHora().equals(LocalDateTime.parse(fecha))) {
                        System.out.println("Esta fecha ya existe!");
                        System.out.println("Ingrese otra fecha!");
                        fecha = entrada.fechaR();
                    }
                }
                String titulo = entrada.titulo();
                int pin = entrada.pin();
                int duracion = entrada.duracionNoPremium();
                
        
                try {
                    Class.forName("org.sqlite.JDBC");
                    conect = DriverManager.getConnection(url);
                    Statement stmt = conect.createStatement();
                    stmt.executeUpdate("INSERT INTO Reuniones('usuario','fecha','titulo','pin','duracion') VALUES ('"+
                    usuario.getCorreo()+"','"+fecha+"','"+titulo+"','"+pin+"','"+duracion+"')");
                    System.out.println("Reunión agregada!");
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    public void cargarReunion(Usuario usuario){
        try {
            Class.forName("org.sqlite.JDBC");
            conect = DriverManager.getConnection(url);
            String selectQuery = "select * from Reuniones where usuario = ?";
            PreparedStatement stmtPrep = conect.prepareStatement(selectQuery);
            stmtPrep.setString(1, usuario.getCorreo());
            ResultSet rst = stmtPrep.executeQuery();
            
            while (rst.next()) {
                cargarInvitado(rst.getString("titulo"));
                cargarNotas(rst.getString("titulo"));
                reuniones.add(new Reunion(rst.getString("usuario"),LocalDateTime.parse(rst.getString("fecha")),
                rst.getString("titulo"), rst.getInt("pin"),notas, rst.getInt("duracion"),invitados));
            }
        } catch (Exception e) {
            if (reuniones.isEmpty()) {
                System.out.println("Sin reuniones!");
            }else{
            e.printStackTrace();}
        }
    }

    public boolean comprobarPlan(Usuario user){
        if (user.getTipo().equals("Premium")) {
            return true;
        }else{
            return false;
        }
    }

    public void guardarNota(String reunion){
        String nota = entrada.nota();
        try {
            Class.forName("org.sqlite.JDBC");
            conect = DriverManager.getConnection(url);
            Statement stmt = conect.createStatement();
            stmt.executeUpdate("INSERT INTO Notas('reunion','nota') VALUES ('"+
            reunion+"','"+nota+"')");
            System.out.println("Nota agregada!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void cargarNotas(String reunion){
        try {
            Class.forName("org.sqlite.JDBC");
            conect = DriverManager.getConnection(url);
            String selectQuery = "select * from Notas where reunion = ?";
            PreparedStatement stmtPrep = conect.prepareStatement(selectQuery);
            stmtPrep.setString(1, reunion);
            ResultSet rst = stmtPrep.executeQuery();
            
            while (rst.next()) {
                notas.add(rst.getString("nota"));
            }
        } catch (Exception e) {
            if (notas.isEmpty()) {
                System.out.println("Sin notas aún!");
            }else{
            e.printStackTrace();}
        }
    }

    public void cambiarEstado(Usuario user){
        if (user.getEstado().equals("Disponible")) {
            user.setEstado("Ocupado");
            System.out.println("Usuario cambiado a ocupado!");
        }else{
            user.setEstado("Disponible");
            System.out.println("Usuario cambiado a disponible!");
        }
    }

    public void guardarInvitado(Usuario user, String reunion){
        cargarInvitado(reunion);
        if (comprobarPlan(user)) {
            if (inviConteo>=20) {
                System.out.println("Ha superado su limite de 20 invitados!!");
            }else{
                inviConteo++;
                String invitado = entrada.nombreInvitado();
                try {
                    Class.forName("org.sqlite.JDBC");
                    conect = DriverManager.getConnection(url);
                    Statement stmt = conect.createStatement();
                    stmt.executeUpdate("INSERT INTO Invitados('reunion','nombre') VALUES ('"+
                    reunion+"','"+invitado+"')");
                    System.out.println("Invitado agregad@!");
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }else{
            if (inviConteo>=5) {
                System.out.println("Ha superado su límite de 5 invitados!!");
            }else{
                inviConteo++;
                String invitado = entrada.nombreInvitado();
                try {
                    Class.forName("org.sqlite.JDBC");
                    conect = DriverManager.getConnection(url);
                    Statement stmt = conect.createStatement();
                    stmt.executeUpdate("INSERT INTO Invitados('reunion','nombre') VALUES ('"+
                    reunion+"','"+invitado+"')");
                    System.out.println("Invitado agregad@!");
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    public void cargarInvitado(String reunion){
        try {
            Class.forName("org.sqlite.JDBC");
            conect = DriverManager.getConnection(url);
            String selectQuery = "select * from Invitados where reunion = ?";
            PreparedStatement stmtPrep = conect.prepareStatement(selectQuery);
            stmtPrep.setString(1, reunion);
            ResultSet rst = stmtPrep.executeQuery();
            
            while (rst.next()) {
                invitados.add(new Invitado(rst.getString("nombre"), reunion));
            }
        } catch (Exception e) {
            if (invitados.isEmpty()) {
                System.out.println("Sin invitados aún!");
            }else{
            e.printStackTrace();}
        }
    }

    public ArrayList<Reunion> getReuniones() {
        return reuniones;
    }
}
