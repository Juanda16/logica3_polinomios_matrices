package model.operations;

import model.entities.Polinomio;

public class Multiplication {
     
     Polinomio multiply(Polinomio pol1 , Polinomio pol2){
          Polinomio result=null;
          int gradoPol1 = pol1.
          int gradoPol2= pol2.getGrado();
          
          for (int j = 0; j < b.length(); j++) {
               for (int i = 0; i < a.length(); i++) {
                   int tempExp = (a.getTermino(i).getExponente()) + (b.getTermino(j).getExponente());
                   double tempCoef = a.getTermino(i).getCoeficiente() * (b.getTermino(j).getCoeficiente());
                   resultado.insertarTermino(new Termino(tempCoef, tempExp));
               }
           }
           
           
       }

          return result.;
     }
}
