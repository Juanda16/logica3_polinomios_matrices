package model;

import java.util.ArrayList;
import model.entities.Polinomio;

public class Polinomios {

    public static ArrayList<Polinomio> polinomios = new ArrayList<Polinomio>();

    
    /** 
     * @return ArrayList<Polinomio>
     */
    ArrayList<Polinomio> getAll() {
        return polinomios;
    }

    
    /** 
     * @param index
     * @return Polinomio
     */
    Polinomio getById(int index) {
        
        return polinomios.get(index);
    }

    
    /** 
     * @param polinomio
     */
    void add(Polinomio polinomio) {
        try {
            polinomios.add(polinomio);
        } catch (Exception exception) {
            System.out.println("Error: " + exception);
        }
    }

    
    /** 
     * @param id
     */
    void deleteById(int id) {
        try {
            polinomios.remove(id);
        } catch (Exception exception) {
            System.out.println("Error: " + exception);
        }
    }

    
    /** 
     * @return int
     */
    int getSize(){
        return polinomios.size();
    }
    
}