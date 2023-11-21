import java.util.Scanner;

/**
 * Universidad del Valle de Guatemala
 * Departamento de Ciencias de la Computación
 * Programación Orientada a Objetos
 * 
 * @author: Erick Barrera, Marian Montejo, Isabella Ramírez
 * @version: 1.0.0
 * @date: 12/11/23
 */
public class Main {
    public static void main(String[] args) {
        EntradaDatos entrada = new EntradaDatos();
        ReunionOp reunion = new ReunionOp();
        Registro register = new Registro();
        Calendario calen = new Calendario();
        Scanner scan = new Scanner(System.in);
        Usuario user = new Usuario(null, null, null, null, null);

        boolean logIn = false;

        do {
            System.out.println("\n1. Ingresar");
            System.out.println("2. Crear Usuario");
            try {
                int log = scan.nextInt();
                if (log == 1) {
                    String correo = entrada.pedirCorreo();
                    String pass = entrada.pedirPassword();
                    logIn = register.cargarUsuario(correo, pass);
                    user = register.getUsuario();
                }else if (log == 2) {
                    register.guardarUsuario("Disponible");
                    logIn = true;
                    user = register.getUsuario();
                }
            } catch (Exception e) {
                System.out.println("Ingreso incorrecto");
            }
        } while (!logIn);




        boolean salir = false;

        while (!salir) {
            switch (entrada.op()) {
                case 1:
                    switch (entrada.Registro()) {
                        case 1:
                            register.cambiarPlan();
                            break;
                        case 2:
                            register.guardarUsuario("Disponible");
                            break;
                        case 3:
                            
                            break;
                    
                        default:
                            break;
                    }
                    break;
                case 2:
                    switch (entrada.Reuniones()) {
                        case 1:
                            String reune = reunion.guardarReunion(user);
                            System.out.println("Cuántos invitados desea agregar?");
                            try {
                                int op = scan.nextInt();
                                for (int i = 0; i < op; i++) {
                                    reunion.guardarInvitado(user, reune);
                                }
                            } catch (Exception e) {
                                System.out.println("Error");
                            }
                            break;
                        case 2:
                            reunion.cambiarEstado(user);
                            break;
                        case 3:
                            String titulo = entrada.titulo();
                            for (Reunion iter : user.getReuniones()) {
                                if (iter.getTitulo().equals(titulo)) {
                                    reunion.cargarNotas(iter.getTitulo());
                                }
                            }    
                            break;
                        case 4:
                            String name = entrada.titulo();
                            for (Reunion iter : user.getReuniones()) {
                                if (iter.getTitulo().equals(name)) {
                                    for (String string : iter.getNotas()) {
                                        System.out.println(string);
                                    }
                                }
                            } 
                            break;
                        case 5:
                            
                            break;
                        default:
                            break;
                    }
                    break;
                case 3:
                    switch (entrada.Calendario()) {
                        case 1:
                            calen.listarReuniones(user);
                            break;
                        case 2:
                            calen.listarContactos(user);
                            break;
                        case 3:
                            
                            break;
                    
                        default:
                            break;
                    }
                    break;
                case 4:
                    switch (entrada.Perfil()) {
                        case 1:
                            register.cambiarPlan();
                            break;
                        case 2:
                            register.cambiarPassword();
                            break;
                        case 3:
                            
                            break;
                    
                        default:
                            break;
                    }
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    salir = true;
                    break;
                default:
                System.out.println("Invalido");
                    break;
            }
        }
        scan.close();
    }
}
