/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polinomios;


/**
 *
 * @author JD
 */
public class Polinomios {

    /**
     * @param args the command line arguments
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        
        int[] arregloA = {6, 8, 1, 1, 4, 1, 1, -5};
        // 25x2 + 10x + 20
        int[] arregloB = {2, 25, 10, 20};
        
       
        PolinomioVectorForma1 polinomioA = new PolinomioVectorForma1(arregloA);
        PolinomioVectorForma1 polinomioB = new PolinomioVectorForma1(arregloB);
        PolinomioVectorForma1 polinomioC = new PolinomioVectorForma1();

        System.out.println(polinomioA);
        System.out.println(polinomioB);
        System.out.println(polinomioC);

        polinomioC =polinomioA.sumar(polinomioB);
        System.out.println(polinomioC);
        System.out.println(polinomioA.getCoef(3));
    }
}
