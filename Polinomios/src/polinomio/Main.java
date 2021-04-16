import model.entities.*;
import model.operations.Multiplication;
import view.Index;

public class Main {
    
    /**
     * Inicia la vista (formulario) principal
     * para la interacción con el usuario.
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        //Index.mainScreen();

        // Multiply test
        Multiplication multiplication=new Multiplication();
        Polinomio pA = new Polinomio();

        Termino t = new Termino(3, 3);
        Nodo n = new Nodo(t);
        Nodo cA = pA.getCabeza();
        cA.setLiga(n);
        cA = n;

        t = new Termino(6, 2);
        n = new Nodo(t);
        cA.setLiga(n);
        cA=n;


        t = new Termino(2, 1);
        n = new Nodo(t);
        cA.setLiga(n);

        Polinomio pB = pA;

        System.out.println(pA);
        System.out.println(pB);

        Polinomio pC = multiplication.multiply2Poly(pA, pB);
        System.out.println(pC);

        
        
                
    }
    
}
