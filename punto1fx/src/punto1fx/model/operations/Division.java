package model.operations;

import model.entities.*;

public class Division {

     /**
      * @param pol1
      * @param pol2
      * @return Polinomio
      */
     public static Polinomio divide2Poly(Polinomio pol1, Polinomio pol2) {

          Polinomio resultD = new Polinomio();// resultado división
          Nodo nodoRecord1 = pol1.getCabeza().getLiga();
          Nodo nodoRecord2 = pol2.getCabeza().getLiga();
          Nodo last = resultD.getCabeza();
          int sizePol1 = pol1.getSize();
          int sizePol2 = pol2.getSize();
          Polinomio result = new Polinomio(); // cambio de termino a pol
          Nodo newNodo;

          try {

               if (pol1.equals(pol2)) {
                    resultD.insertTermn(new Termino(1, 0), last);
                    return resultD;
               }

               Termino a = new Termino(0, 0);
               Termino b = new Termino(0, 0);
               while (pol1.getGrado() >= pol2.getGrado() && nodoRecord1 != null) {
                    if (nodoRecord1 != null && nodoRecord2 != null) {
                         a = new Termino((nodoRecord1.getTermino().getCoef()),
                                   nodoRecord1.getTermino().getExp());
                         b = new Termino((nodoRecord2.getTermino().getCoef()),
                                   nodoRecord2.getTermino().getExp());
                    }

                    Termino resultado = Termino.dividirTermino(a, b);
                    newNodo = resultD.insertTermn(resultado, last);
                    last = newNodo;
                    /* convierto el termino en pol */
                    result.TermnToPol(resultado.getCoef(), resultado.getExp());
                    Polinomio producto = Multiplication.multiply2Poly(result, pol2);
                    Polinomio polNegativo = new Polinomio();
                    polNegativo.TermnToPol(-1.0, 0);
                    producto = Multiplication.multiply2Poly(polNegativo, producto);
                    pol1 = Suma.sumar(pol1, producto);// aqui está el problema
                    nodoRecord1 = pol1.getCabeza().getLiga();

               }
               resultD.simplify();
               resultD.sort();
               return resultD;

          } catch (Exception exception) {
               System.out.println("Error: " + exception);
               return null;
          }
     }
}
