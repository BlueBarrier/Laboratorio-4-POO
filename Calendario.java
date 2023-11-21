import java.util.ArrayList;
import java.util.Collections;

/**
 * Universidad del Valle de Guatemala
 * Departamento de Ciencias de la Computación
 * Programación Orientada a Objetos
 * 
 * @author: Erick Barrera, Marian Montejo, Isabella Ramírez
 * @version: 1.0.0
 * @date: 12/11/23
 */
public class Calendario {
    ReunionOp reune = new ReunionOp();

    public void listarReuniones(Usuario user){
        if (reune.comprobarPlan(user)) {
            reune.cargarReunion(user);
            ArrayList<Reunion> reuniones = user.getReuniones();
            Collections.reverse(reuniones);
            System.out.println("\n--Reuniones--");
            for (int i = 0; i < 10; i++) {
                System.out.println("\n"+reuniones.get(i).toString());
            }
        }else{
            reune.cargarReunion(user);
            ArrayList<Reunion> reuniones = user.getReuniones();
            Collections.reverse(reuniones);
            System.out.println("\n--Reuniones--");
            for (int i = 0; i < 3; i++) {
                System.out.println("\n"+reuniones.get(i).toString());
            }
        }
    }

    public void listarContactos(Usuario user){
        int conteo = 0;
        if (reune.comprobarPlan(user)) {
            reune.cargarReunion(user);
            ArrayList<Reunion> reuniones = user.getReuniones();
            Collections.reverse(reuniones);
            for (Reunion reunion : reuniones) {
                for (Invitado invitado : reunion.getInvitados()) {
                    if (conteo <= 60) {
                        System.out.println(invitado.toString());
                    }
                }
            }
        }else{
            reune.cargarReunion(user);
            ArrayList<Reunion> reuniones = user.getReuniones();
            Collections.reverse(reuniones);
            for (Reunion reunion : reuniones) {
                for (Invitado invitado : reunion.getInvitados()) {
                    if (conteo <= 15) {
                        System.out.println(invitado.toString());
                    }
                }
            }
        }
    }    
}
