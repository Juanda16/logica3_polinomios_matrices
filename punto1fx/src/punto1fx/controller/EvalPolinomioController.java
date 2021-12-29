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
     */
    public static void Eval(int selectedPol, int nEval) {

        if (selectedPol != 0 ) {
            //Evaluation evaluation = new Evaluation();
            double result;// en mi caso el retorno de la división no es string
            Polinomio pol1 = Polinomios.polinomios.get(selectedPol-1);
            result = Evaluation.evalPol(pol1, nEval);
            EvalPolinomioView.result(result);
        }

        

    }
}
    

