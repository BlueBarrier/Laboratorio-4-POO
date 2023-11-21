/**
 * Universidad del Valle de Guatemala
 * Departamento de Ciencias de la Computación
 * Programación Orientada a Objetos
 * 
 * Esta clase proporciona métodos para la entrada de datos desde la consola.
 * 
 * @author: Erick Barrera, Marian Montejo, Isabella Ramírez
 * @version: 1.0.0
 * @date: 12/11/23
 */
import java.util.Scanner;

public class EntradaDatos {
    Scanner scan = new Scanner(System.in);

    /**
     * Solicita y devuelve el nombre ingresado por el usuario.
     * 
     * @return El nombre ingresado por el usuario.
     */
    public String pedirNombre(){
        System.out.println("Ingrese su nombre: ");
        try {
            String var = scan.nextLine().trim();
            return var;
        } catch (Exception e) {
            System.out.println("Ingreso inválido");
            pedirNombre();
        }
        return "";
    }

    /**
     * Solicita y devuelve el correo ingresado por el usuario.
     * 
     * @return El correo ingresado por el usuario.
     */
    public String pedirCorreo(){
        System.out.println("Ingrese su correo: ");
        try {
            String var = scan.nextLine().trim();
            return var;
        } catch (Exception e) {
            System.out.println("Ingreso inválido");
            pedirCorreo();
        }
        return "";
    }

    /**
     * Solicita y devuelve la contraseña ingresada por el usuario.
     * 
     * @return La contraseña ingresada por el usuario.
     */
    public String pedirPassword(){
        System.out.println("Ingrese su contraseña: ");
        try {
            String var = scan.nextLine().trim();
            return var;
        } catch (Exception e) {
            System.out.println("Ingreso inválido");
            pedirPassword();
        }
        return "";
    }

    /**
     * Solicita y devuelve el tipo de membresía deseado por el usuario.
     * 
     * @return El tipo de membresía seleccionado por el usuario ("Premium" o "No Premium").
     */
    public String pedirTipo(){
        System.out.println("¿Quisiera obtener todos los beneficios de una membresía Premium?");
        System.out.println("1. Si - costo Q500 x mes"+
                           "\n2. No - gratis"+
                           "Ingrese una opción numérica");
        try {
            int op = scan.nextInt();
            scan.nextLine();
            System.out.println("Presione enter para continuar...");
            if (op == 1 || op == 2 ) {
                if (op == 1) {
                    System.out.println("Se le cobraran Q500 x mes");
                    return "Premium";
                } else if (op == 2) {
                    return "No Premium";
                }
            } else {
                pedirTipo();
            }
        } catch (Exception e) {
            System.out.println("Ingreso inválido");
            pedirTipo();
        }
        return "";
    }
}
