package controller;

import model.operations.Multiplication;
import view.MultiplyPolinomioView;
import model.Polinomios;
import model.entities.Polinomio;


public class MultiplyPolinomioController {

    public static void index() {
        
        MultiplyPolinomioView.index(Polinomios.polinomios.size(),Polinomios.polinomios.toString());
             
    }

    
    /** 
     * @param selectedPols
     * @return 
     */
    public static String multiply(int[] selectedPols) {
        String result="no result";
        System.out.println(Polinomios.polinomios.get(selectedPols[0]).toString());
        System.out.println(Polinomios.polinomios.get(selectedPols[1]).toString());
        
        if (selectedPols.length!= 0) {
            //Multiplication multiplication = new Multiplication();
            
            Polinomio pol1 = Polinomios.polinomios.get(selectedPols[0]);
            Polinomio pol2 = Polinomios.polinomios.get(selectedPols[1]);
            result = Multiplication.multiply2Poly(pol1, pol2).toString();
            //MultiplyPolinomioView.result(result);
        }
        System.out.println(result);
        return result;

    }
}
