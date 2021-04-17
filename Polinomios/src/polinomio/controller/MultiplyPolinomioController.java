package controller;

import model.operations.Multiplication;
import view.MultiplyPolinomioView;
import model.Polinomios;
import model.entities.Polinomio;


public class MultiplyPolinomioController {

    public static void index() {
        
        MultiplyPolinomioView.index(Polinomios.polinomios.size(),Polinomios.polinomios.toString());
             
    }

    public static void multiply(int[] selectedPols) {

        if (selectedPols[0] != 0 && selectedPols[1] == 0) {
            Multiplication multiplication = new Multiplication();
            String result;
            Polinomio pol1 = Polinomios.polinomios.get(selectedPols[1]);
            Polinomio pol2 = Polinomios.polinomios.get(selectedPols[2]);
            result = multiplication.multiply2Poly(pol1, pol2).toString();
            MultiplyPolinomioView.result(result);
        }

        

    }
}
