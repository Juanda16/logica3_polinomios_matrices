package model.operations;
import model.entities.*;

public class Multiplication {

     
     /** 
      * @param pol1
      * @param pol2
      * @return Polinomio
      */
     public static Polinomio multiply2Poly(Polinomio pol1, Polinomio pol2) {

          Polinomio result = new Polinomio();

          try {
               Nodo nodoRecord1 = pol1.getCabeza().getLiga();
               Nodo nodoRecord2 = pol2.getCabeza().getLiga();
               Nodo last = result.getCabeza();
               int sizePol1 = pol1.getSize();
               int sizePol2 = pol2.getSize();
               Nodo newNodo;

               for (int j = 0; j < sizePol1; j++) {
                    int expPol1TermnJ = nodoRecord1.getTermino().getExp();
                    double coefPol1TermnJ = nodoRecord1.getTermino().getCoef();
                    for (int i = 0; i < sizePol2; i++) {
                         // Variables de exponente y coeficiente de terminos

                         int expPol2TermnJ = nodoRecord2.getTermino().getExp();
                         double coefPol2TermnJ = nodoRecord2.getTermino().getCoef();

                         int newExp = expPol1TermnJ + expPol2TermnJ;
                         double newCoef = coefPol1TermnJ * coefPol2TermnJ;
                         Termino newTermino = new Termino(newCoef, newExp);

                         newNodo = result.insertTermn(newTermino, last);
                         last = newNodo;
                         nodoRecord2 = nodoRecord2.getLiga();

                    }
                    nodoRecord1 = nodoRecord1.getLiga();
                    nodoRecord2 = pol2.getCabeza().getLiga();
               }

               result.simplify();
               result.sort();
               return result;
          } catch (Exception exception) {
               System.out.println("Error: " + exception);
               return null;
          }
     }

}
