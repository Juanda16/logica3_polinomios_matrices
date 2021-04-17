package view;

import view.constants.MultiplicationConstants;
import java.util.Scanner;
import controller.MultiplyPolinomioController;

public class MultiplyPolinomioView {
    static Scanner read = new Scanner(System.in);

    public static void index(int size, String polinomios) {
        int selectedPols[] = { 0, 0 };

        System.out.println(MultiplicationConstants.TITLE);
        System.out.println(MultiplicationConstants.SUBTITLE);
        System.out.println("\n");
        System.out.println(polinomios);

        int select;
        if (size > 0) {
            for (int i = 0; i < 2; i++) {
                System.out.println(MultiplicationConstants.NOTES + size);
                select = read.nextInt();
                if (select < 0 || select > size) {
                    System.out.println(MultiplicationConstants.ERROR);

                } else {
                    selectedPols[i + 1] = select;
                }
            }

            MultiplyPolinomioController.multiply(selectedPols);
        }else System.out.println(MultiplicationConstants.ERROR_EMPTY);
    }
    
    public static void result(String result) {
        
        System.out.println(MultiplicationConstants.RESULT);
        
        System.out.println(result);
        
    }
}
