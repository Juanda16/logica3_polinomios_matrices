package controller;

import model.operations.Evaluation;
import view.EvalPolinomioView;
import model.Polinomios;
import model.entities.Polinomio;

public class EvalPolinomioController {

    public static void index(){
        
        EvalPolinomioView.index(Polinomios.polinomios.size(), Polinomios.polinomios.toString());  
    }

    
    /** 
     * @param selectedPol
     * @param nEval
     * @return 
     */
    public static String Eval(int selectedPol, int nEval) {
        String result="no result";
        if (selectedPol >= 0 ) {
            //Evaluation evaluation = new Evaluation();
            
            Polinomio pol1 = Polinomios.polinomios.get(selectedPol);
            System.out.println(pol1.toString());
            result =String.valueOf(Evaluation.evalPol(pol1, nEval));
            
        }

        return result;

    }
}
    

