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
import java.time.LocalDateTime;
import java.util.Scanner;

public class EntradaDatos {
    Scanner scan = new Scanner(System.in);

    public int op(){
        System.out.println("--Menu--"+
                            "\n1. Registro"+
                            "\n2. Reuniones"+
                            "\n3. Calendario"+
                            "\n4. Perfil"+
                            "\n5. Salir");
        try {
            int op = scan.nextInt();
            return op;
        } catch (Exception e) {
            System.out.println("Invalido");
            op();
        }
        return 0;
    }

    public int Registro(){
        System.out.println("--Registro--"+
                            "\n1. Cambiar plan"+
                            "\n2. Crear usuario"+
                            "\n3. Salir");
        try {
            int op = scan.nextInt();
            return op;
        } catch (Exception e) {
            e.printStackTrace();
            Registro();
        }
        return 0;
    }

    public int Reuniones(){
        System.out.println("--Reunión--"+
                            "\n1. Crear reunión"+
                            "\n2. Cambiar disponibilidad"+
                            "\n3. Crear nota"+
                            "\n4. Mostrar notas"+
                            "\n5. Salir");
        try {
            int op = scan.nextInt();
            return op;
        } catch (Exception e) {
            e.printStackTrace();
            Reuniones();
        }
        return 0;
    }

    public int Calendario(){
        System.out.println("--Calendario--"+
                            "\n1. Listar reuniones"+
                            "\n2. Listar contactos"+
                            "\n3. Salir");
        try {
            int op = scan.nextInt();
            return op;
        } catch (Exception e) {
            e.printStackTrace();
            Calendario();
        }
        return 0;
    }

    public int Perfil(){
        System.out.println("--Perfil--"+
                            "\n1. Cambiar plan"+
                            "\n2. Cambiar contraseña"+
                            "\n3. Salir");
        try {
            int op = scan.nextInt();
            return op;
        } catch (Exception e) {
            e.printStackTrace();
            Perfil();
        }
        return 0;
    }



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

    public String titulo(){
        System.out.println("Ingrese un título para la reunón: ");
        try {
            String tit = scan.nextLine();
            return tit;
        } catch (Exception e) {
            System.out.println("Ingreso invalido!");
            titulo();
        }
        return "ERROR";
    }

    public int pin(){
        System.out.println("Ingrese un pin para la reunión: ");
        try {
            int pin = scan.nextInt();
            if (pin<=0) {
                System.out.println("Ingrese un pin mayor a 0");
                pin();
            }else{
                return pin;
            }
        } catch (Exception e) {
            System.out.println("Ingreso inválido!");
            pin();
        }
        return 0;
    }

    public int duracionPremium(){
        System.out.println("Ingrese la duración de la reunión en minutos: ");
        try {
            int dura = scan.nextInt();
            if (dura<=0) {
                System.out.println("Ingrese una duración mayor a 0 minutos");
                duracionPremium();
            }else if(dura<=60){
                return dura;
            }else{
                System.out.println("No exceda el limite de 60 min");
                duracionPremium();
            }
        } catch (Exception e) {
            System.out.println("Ingreso inválido!");
            duracionPremium();
        }
        return 0;
    }
    public int duracionNoPremium(){
        System.out.println("Ingrese la duración de la reunión en minutos: ");
        try {
            int dura = scan.nextInt();
            if (dura<=0) {
                System.out.println("Ingrese una duración mayor a 0 minutos");
                duracionNoPremium();
            }else if(dura<=15){
                return dura;
            }else{
                System.out.println("No exceda el limite de 15 min");
                duracionNoPremium();
            }
        } catch (Exception e) {
            System.out.println("Ingreso inválido!");
            duracionNoPremium();
        }
        return 0;
    }

    public String fechaR(){
        System.out.println("Ingrese el año: ");
        try {
            String year = scan.nextLine();
            int ano = Integer.parseInt(year);
            if (ano>=2023) {
                try {
                System.out.println("Ingrese el mes (04): ");
                    String mes = scan.nextLine();
                    int meses = Integer.parseInt(mes);
                    if (1<=meses && meses<=12) {
                        try {
                            System.out.println("Ingrese el día (06): ");
                            String dia = scan.nextLine();
                            int dias = Integer.parseInt(dia);
                            if (dias>=1 && dias<=31) {
                                try {
                                    System.out.println("Ingrese la hora (02): ");
                                    String hora = scan.nextLine();
                                    int horu = Integer.parseInt(hora);
                                    if (horu>=0 && horu <= 24) {
                                        try {
                                            System.out.println("Ingrese los minutos (05): ");
                                            String min = scan.nextLine();
                                            int minu = Integer.parseInt(min);
                                            if (0<=minu && minu<=60) {
                                                try {
                                                    LocalDateTime.parse(year+"-"+mes+"-"+dia+"T"+hora+":"+min);
                                                    return year+"-"+mes+"-"+dia+"T"+hora+":"+min;
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                            }else{
                                                System.out.println("Debe estar entre 00 y 60");
                                            }
                                        } catch (Exception e) {
                                            System.out.println("Ingreso inválido!");
                                            fechaR();
                                        }
                                    }else{
                                        System.out.println("Entre 00 - 24");
                                        fechaR();
                                    }
                                } catch (Exception e) {
                                    System.out.println("Ingreso inválido!");
                                    fechaR();
                                }
                            }else{
                                System.out.println("Entre 1 - 31");
                                fechaR();
                            }
                        } catch (Exception e) {
                            System.out.println("Ingreso inválido!");
                            fechaR();
                        }
                    }else{
                        System.out.println("Entre enero y diciembre (1 - 12)");
                        fechaR();
                    }
                } catch (Exception e) {
                    System.out.println("Ingreso inválido!");
                    fechaR();
                }
            }else{System.out.println("Deber ser el mismo año o posterior"); fechaR();}
        } catch (Exception e) {
            System.out.println("Ingreso inválido!");
            fechaR();
        }
        return "";
    }

    public String nota(){
        System.out.println("Ingrese su nota: ");
        try {
            String nota = scan.nextLine();
            return nota;
        } catch (Exception e) {
            System.out.println("Error! intente de nuevo");
            nota();
        }
        return "";
    }

    public String nombreInvitado(){
        System.out.println("Ingrese el nombre de su invitado: ");
        try {
            String nombre = scan.nextLine();
            scan.nextLine();
            return nombre;
        } catch (Exception e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
        return "";
    }


}
