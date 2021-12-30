package controller;

import model.operations.Suma;
import view.MultiplyPolinomioView;
import model.Polinomios;
import model.entities.*;


public class AddPolinomioController {

    public static void index() {
        
        MultiplyPolinomioView.index(Polinomios.polinomios.size(),Polinomios.polinomios.toString());
             
    }

    
    /** 
     * @param selectedPols
     * @return 
     */
    public static String add2Pol(int[] selectedPols) {
        String result ="no result";
        System.out.println(Polinomios.polinomios.get(selectedPols[0]).toString());
        System.out.println(Polinomios.polinomios.get(selectedPols[1]).toString());
        
        if (selectedPols.length!= 0){ 
             //System.out.println("entré");
//Multiplication multiplication = new Multiplication();
            
            Polinomio pol1 = Polinomios.polinomios.get(selectedPols[0]);
            Polinomio pol2 = Polinomios.polinomios.get(selectedPols[1]);
            result = Suma.sumar(pol1, pol2).toString();
        }
       
        System.out.println(result);
        
        return result;

        

    }
}
