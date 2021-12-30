package model.operations;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.entities.Polinomio;

public class Evaluation {

    /**
     * @param polinomio
     * @param x
     * @return double
     */
    public static double evalPol(Polinomio polinomio, int x)  {
        double valor = 0;
        int grade =0;
        try {
            grade = polinomio.getGrado();
        } catch (Exception ex) {
            Logger.getLogger(Evaluation.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        System.out.println("size of the polinomio " + grade);
        System.out.println(polinomio.toString());
        System.out.println(x);
        try {
            for (int i = 0; i <= grade; i++) {
                double a = x;
                double b = i;
                double factor = Math.pow(a, b);
                int factor2 = (int) factor;
                System.out.println("factor" + factor);
                System.out.println("coef" + polinomio.getCoeficiente(i));
                valor = (valor + (polinomio.getCoeficiente(i) * factor2));
                System.out.println("acumulado" + valor);

            }
            return valor;
        } catch (Exception exception) {
            System.out.println("Error: " + exception);
            return 0;
        }
    }
}
