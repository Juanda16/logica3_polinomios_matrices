package controller;

import model.Polinomios;
import view.NewPolinomioView;
import model.util.StringToPolinomio;
import model.entities.*;

public class NewPolinomioController {

    public static void index() {
        NewPolinomioView.index();

    }

    
    /** 
     * @param rawPolinomio
     */
    public static void store(String rawPolinomio) {

        Polinomios.polinomios.add(StringToPolinomio.stringToPolinomio(rawPolinomio));


        //Insert 10 pol test 
        // for (int i = 0; i < 10; i++) {
        //     Polinomio pA = new Polinomio();

        //     Termino t = new Termino(2, 1);
        //     Nodo n = new Nodo(t);
        //     Nodo cA = pA.getCabeza();
        //     cA.setLiga(n);
        //     cA = n;

        //     t = new Termino(3, 3);
        //     n = new Nodo(t);
        //     cA.setLiga(n);
        //     cA = n;

        //     t = new Termino(6, 2);
        //     n = new Nodo(t);
        //     cA.setLiga(n);

        //     Polinomios.polinomios.add(pA);

        // }

    }

}
