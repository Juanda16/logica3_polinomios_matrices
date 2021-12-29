package view;

import view.constants.DivideConstants;
import java.util.Scanner;
import controller.DividePolinomioController;

public class DividePolinomioView{
    static Scanner read = new Scanner(System.in);

    
    /** 
     * @param size
     * @param polinomios
     */
    public static void index(int size, String polinomios) {
        int selectedPols[] = { 0, 0 };

        System.out.println(DivideConstants.TITLE);
        System.out.println(DivideConstants.SUBTITLE);
        System.out.println("\n");
        System.out.println(polinomios);

        int select;
        if (size > 0) {
            for (int i = 0; i < 2; i++) {
                System.out.println(DivideConstants.NOTES + size);
                select = read.nextInt();
                if (select < 0 || select > size) {
                    System.out.println(DivideConstants.ERROR);

                } else if (select == 0)
                    break;
                else {
                    selectedPols[i] = select;

                }
            }
            DividePolinomioController.div(selectedPols);

        } else
            System.out.println(DivideConstants.ERROR_EMPTY);
    }

    
    /** 
     * @param result
     */
    public static void result(String result) {

        System.out.println(DivideConstants.RESULT);
        System.out.println(result);

        char select;
        do {
            System.out.print(DivideConstants.OUT);
            select = read.next().charAt(0);
            read.nextLine();

        } while (select != '.');
    }
}
    
