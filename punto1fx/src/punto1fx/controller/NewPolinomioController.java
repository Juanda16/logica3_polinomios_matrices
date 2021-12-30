package controller;

import model.Polinomios;
import model.entities.Nodo;
import model.entities.Polinomio;
import model.entities.Termino;
import view.NewPolinomioView;
import model.util.StringToPolinomio;

public class NewPolinomioController {

    public static void index() {
        NewPolinomioView.index();

    }

    /**
     * @param rawPolinomio
     */
    public static boolean store(String rawPolinomio) {
        boolean saved = false;
        Polinomio polinomioToSave = StringToPolinomio.stringToPolinomio(rawPolinomio);
        if (polinomioToSave != null) {
            Polinomios.polinomios.add(polinomioToSave);
            saved = true;

        }
        
        // Insert 10 pol test
//        for (int i = 0; i < 10; i++) {
//            Polinomio pA = new Polinomio();
//
//            Termino t = new Termino(2, 1);
//            Nodo n = new Nodo(t);
//            Nodo cA = pA.getCabeza();
//            cA.setLiga(n);
//            cA = n;
//
//            t = new Termino(3, 3);
//            n = new Nodo(t);
//            cA.setLiga(n);
//            cA = n;
//
//            t = new Termino(6, 2);
//            n = new Nodo(t);
//            cA.setLiga(n);
//
//            Polinomios.polinomios.add(pA);
//
//        }
        return saved;
    }

}
