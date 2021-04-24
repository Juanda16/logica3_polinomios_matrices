package model.operations;
import model.entities.*;

public class Suma {
    
    /** 
     * @param pol1
     * @param pol2
     * @return Polinomio
     */
    public static Polinomio sumar(Polinomio pol1, Polinomio pol2){
    
        Polinomio pol3 = new Polinomio();
        /* *extraigo variables */
        Nodo recorrido1 = pol1.getCabeza().getLiga();
        Nodo recorrido2 = pol2.getCabeza().getLiga();
        
        Nodo ultimo3 = pol3.getCabeza();


        /* *Recorrido de listas */
        while(recorrido1 != null && recorrido2 != null ){
            if (recorrido1.getTermino().getExp() > recorrido2.getTermino().getExp()) {
                
                /* *Hago SetLiga Creando un nuevo nodo, con un nuevo termino y le asigno exp y coef */
                ultimo3.setLiga(new Nodo( new Termino( recorrido1.getTermino().getCoef(), recorrido1.getTermino().getExp()))); 
                ultimo3 = ultimo3.getLiga();
                recorrido1 = recorrido1.getLiga();
                

            } else if (recorrido1.getTermino().getExp() < recorrido2.getTermino().getExp()){
                
                /* *Hago SetL Creando un nuevo nodo, con un nuevo termino y le asigno exp y coef */
                ultimo3.setLiga(new Nodo( new Termino( recorrido2.getTermino().getCoef(), recorrido2.getTermino().getExp())));
                ultimo3 = ultimo3.getLiga();
                recorrido2 = recorrido2.getLiga();
                

            } else {
                if ((recorrido1.getTermino().getCoef() + recorrido2.getTermino().getCoef()) != 0) {
                    /* *Hago SetL Creando un nuevo nodo, con un nuevo termino y le asigno exp y coef */
                    ultimo3.setLiga(new Nodo( new Termino(recorrido1.getTermino().getCoef() + recorrido2.getTermino().getCoef(),
                    recorrido2.getTermino().getExp())));   
                    ultimo3 = ultimo3.getLiga(); 
                }
              
                recorrido1 = recorrido1.getLiga();
                recorrido2 = recorrido2.getLiga();
            }
               
        }

        /* *REcorro A porque aún no se agota */
        while(recorrido1 != null){
            /* *Hago SetL Creando un nuevo nodo, con un nuevo termino y le asigno exp y coef */
            ultimo3.setLiga(new Nodo( new Termino( recorrido1.getTermino().getCoef(), recorrido1.getTermino().getExp()))); 
            ultimo3 = ultimo3.getLiga();
            recorrido1 = recorrido1.getLiga();
        }

         /* *REcorro A porque aún no se agota */
         while(recorrido2 != null ){
             /* *Hago SetL Creando un nuevo nodo, con un nuevo termino y le asigno exp y coef */
            ultimo3.setLiga(new Nodo( new Termino( recorrido2.getTermino().getCoef(), recorrido2.getTermino().getExp())));
            ultimo3 = ultimo3.getLiga();
            recorrido2 = recorrido2.getLiga();
        }


    return pol3;
    }
}
    

