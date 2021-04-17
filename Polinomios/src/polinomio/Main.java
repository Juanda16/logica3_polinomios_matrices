import model.entities.*;
import java.util.Scanner;
//import model.operations.Multiplication;
import model.util.StringToPolinomio;
//import view.Index;


public class Main {
    
    /**
     * Inicia la vista (formulario) principal
     * para la interacción con el usuario.
     * @param args the command line arguments
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        
        Scanner teclado = new Scanner(System.in);
        while (true) {
            

            System.out.println("Ingrese los polinomios a operar , para terminar de ingresar escriba *"  );
            try {
                System.out.println( "Introduzca su polinomio:  ");
                String polinomioIn = teclado.nextLine();
                Polinomio newPolinomio = StringToPolinomio.stringToPolinomio(polinomioIn);
                
                System.out.println(newPolinomio.toString());

                

            } catch (Exception error) {
                System.out.println(error);
            }
            //teclado.close();
        
        
        //Index.mainScreen();

        // Multiply test
        // Multiplication multiplication=new Multiplication();
        // Polinomio pA = new Polinomio();

        // Termino t = new Termino(2, 1);
        // Nodo n = new Nodo(t);
        // Nodo cA = pA.getCabeza();
        // cA.setLiga(n);
        // cA = n;

        // t = new Termino(3, 3);
        // n = new Nodo(t);
        // cA.setLiga(n);
        // cA=n;


        // t = new Termino(6,2);
        // n = new Nodo(t);
        // cA.setLiga(n);

        // Polinomio pB = pA;

        // System.out.println(pA);
        // System.out.println(pB);

        // Polinomio pC = multiplication.multiply2Poly(pA, pB);
        // System.out.println(pC);

        
        
        }           
    }
}
    

