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
        switch (entrada.op()) {
            case 1:
                reunion.guardarReunion("test@test.com");
                break;
        
            default:
                break;
        }
    }
}
