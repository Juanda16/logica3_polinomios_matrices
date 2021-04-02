/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

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
        //while(true){
        String PolinomioIn;
        Scanner teclado = new Scanner(System.in);

        int[] arregloA = { 6, 8, 1, 1, 4, 1, 1, -5 };
        // 25x2 + 10x + 20
        int[] arregloB = { 2, 25, 10, 20 };
        
        System.out.print("Introduzca su polinomio: ");
        PolinomioIn = teclado.nextLine();
        
        try {
            String parts[] = PolinomioIn.split("x\\^|\\+|\\ +|\\+ |x| ");
            int j = 0;
            int[] pol = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {

                // System.out.println(parts[i]);
                if (parts[i].equals("-")){
                    parts[i]=parts[i]+parts[i+1];
                    parts[i+1]="";
                }

                if (parts[i] != "" && !parts[i].equals("-") && parts[i] != " " ){
                    
                    pol[j] = Integer.parseInt(parts[i]);
                    System.out.println(pol[j]);
                    j++;
            }

            }

        } catch (Exception error) {
            System.out.println(error);
        }
        /*
         * System.out.println(parts[0]); System.out.println(parts[1]);
         * System.out.println(parts[2]); 52x^2 + 25x^1 + 65
         */

        System.out.println(PolinomioIn);
        teclado.close();
        
        
        /*
         * PolinomioVectorForma1 polinomioA = new PolinomioVectorForma1(arregloA);
         * PolinomioVectorForma1 polinomioB = new PolinomioVectorForma1(arregloB);
         * PolinomioVectorForma1 polinomioC = new PolinomioVectorForma1();
         * 
         * System.out.println(polinomioA); System.out.println(polinomioB);
         * System.out.println(polinomioC);
         * 
         * polinomioC =polinomioA.sumar(polino3xmioB); System.out.println(polinomioC);
         * System.out.println(polinomioA.getCoef(3));
         */
    
    
}}
