package model;

import java.util.*;
// vamos a trabajar lista ligada con cabeza

import model.entities.Nodo;

public class PolinomioListaLigada {

    private final Nodo cabeza;

    /**
     * @param cabeza
     */
    public PolinomioListaLigada(Nodo cabeza) {
        this.cabeza = cabeza;
    }

    /**
     * 
     */
    public PolinomioListaLigada() {

        cabeza = new Nodo(null);

    }

}
