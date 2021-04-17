package controller;

import view.ShowPolinomioView;

public class ShowPolinomioController {
    public static void index() {
        // TODO .Fetch the poly from the polys list and then send it to show polinomio
        // view
        
        ShowPolinomioView.index();

    }

    public static void options(char select) {
        switch (select) {
        case '0':
            //ControllerPolinomio.index();
            break;
        case '.':
            break;
        default:
            int id = Character.getNumericValue(select);
            // TODO obtener polinomio específico 
            break;
        }
    }
}
