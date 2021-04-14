package model;

import java.util.ArrayList;

import model.entities.Polinomio;

class Polinomios {

    private static ArrayList<Polinomio> polinomios = new ArrayList<Polinomio>();

    void getAll() {
        // TODO devolver todos os polinomios
    }

    Polinomio getById(int id) {
        // TODO. devolver 1 polinomio
        return null;
    }

    void add(Polinomio polinomio) {
        try {
            polinomios.add(polinomio);
        } catch (Exception exception) {
            System.out.println("Error: " + exception);
        }
    }

    void deleteById(int id) {
        try {
            polinomios.remove(id);
        } catch (Exception exception) {
            System.out.println("Error: " + exception);
        }
    }

    int getSize(){
        return polinomios.size();
    }

    
}