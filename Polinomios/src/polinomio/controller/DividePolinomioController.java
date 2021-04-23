package controller;

import model.operations.Division;
import view.DividePolinomioView;
import model.Polinomios;
import model.entities.Polinomio;


public class DividePolinomioController {
   
    public static void index(){
        
        DividePolinomioView.index(Polinomios.polinomios.size(), Polinomios.polinomios.toString());  
    }

    
    /** 
     * @param selectedPols
     */
    public static void div(int[] selectedPols) {

        if (selectedPols[0] != 0 && selectedPols[1] != 0) {
            //Division division = new Division();
            String result;// en mi caso el retorno de la división no es string
            Polinomio pol1 = Polinomios.polinomios.get(selectedPols[0]-1);
            Polinomio pol2 = Polinomios.polinomios.get(selectedPols[1]-1);
            result = Division.divide2Poly(pol1, pol2).toString();
            DividePolinomioView.result(result);
        }

        

    }
}

    
