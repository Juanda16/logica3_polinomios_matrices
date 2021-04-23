package model.operations;
import java.security.Policy;
import model.entities.Polinomio;
import model.util.StringToPolinomio;


public class Evaluation {
    
     
     /** 
      * @param polinomio
      * @param x
      * @return double
      */
     public static double evalPol(Polinomio polinomio, int x) {
          double valor = 0;
          int Size = polinomio.getSize();
          
          try {
               for (int i = 0; i < Size; i++) {
                    double a = x;
                    double b = i;
                    double factor = Math.pow(a, b);
                    int factor2= (int)factor;
                    valor= (valor + (polinomio.getCoeficiente(i) * factor2));
                                  
               }
               return valor;
          } catch (Exception exception) {
          System.out.println("Error: " + exception);
          return 0;
          }
     }
}
