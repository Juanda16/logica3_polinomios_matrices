package view;

import view.constants.EvalConstants;
import java.util.Scanner;
import controller.EvalPolinomioController;

public class EvalPolinomioView {

    static Scanner read = new Scanner(System.in);

    
    /** 
     * @param size
     * @param polinomios
     */
    public static void index(int size, String polinomios){

        int selectedPol = 0;

        System.out.println(EvalConstants.TITLE);
        System.out.println(EvalConstants.SUBTITLE);
        System.out.println("\n");
        System.out.println(polinomios);

        int select;
        int nEval;
        try {
            if (size > 0) {
                    System.out.println(EvalConstants.NOTES + size);
                    select = read.nextInt();
                          
                    System.out.println(EvalConstants.NOTES_EVAL);
                    nEval = read.nextInt();
                    //return nEval;
                                                     
                    if (select < 0 || select > size ||select == 0 ) {
                            System.out.println(EvalConstants.ERROR);

                        }else {
                            selectedPol= select;

                        }
                    EvalPolinomioController.Eval(selectedPol, nEval);
           
                } else{

                 System.out.println(EvalConstants.ERROR_EMPTY);
                }

    
        }catch (Exception e) {
            System.out.println("Error: Debe ingresar un valor numérico " + e);
        //return 0;
            }
    }

    
    /** 
     * @param result
     */
    public static void result(double result) {

        System.out.println(EvalConstants.RESULT);
        System.out.println(result);

        char select;
        do {
            System.out.print(EvalConstants.OUT);
            select = read.next().charAt(0);
            read.nextLine();

        } while (select != '.');
    }
}
