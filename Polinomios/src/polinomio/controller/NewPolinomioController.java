package controller;

import model.Polinomios;
import view.NewPolinomioView;
import model.util.StringToPolinomio;

public class NewPolinomioController {

    public static void index() {
        NewPolinomioView.index();

    }
    
    public static void store(String rawPolinomio) {
        
        
        Polinomios.polinomios.add(StringToPolinomio.StringToPolinomio(rawPolinomio));
        

    }
        
}
