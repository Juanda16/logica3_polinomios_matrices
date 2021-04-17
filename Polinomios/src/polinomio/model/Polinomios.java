package model;

import java.util.ArrayList;
import model.entities.Polinomio;

public class Polinomios {

    public static ArrayList<Polinomio> polinomios = new ArrayList<Polinomio>();

    ArrayList<Polinomio> getAll() {
        return polinomios;
    }

    Polinomio getById(int index) {
        
        return polinomios.get(index);
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