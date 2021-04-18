package view;
import view.constants.ShowPolinomioConstants;
import java.util.Scanner;

public class ShowPolinomioView {
    static Scanner read = new Scanner (System.in);
    /**
     * Formulario para mostrar polinomios
     */
    public static void index() {

        System.out.print(ShowPolinomioConstants.TITLE);
        for (String option : ShowPolinomioConstants.OPTIONS) {
            System.out.println(option);
        }

        char select;

        do {
            System.out.print("choice: ");
            select = read.next().charAt(0);
            controller.ShowPolinomioController.options(select);

        } while (select != '.');
    }

    public static void printPolinomios(String polinomios) {
        
        System.out.println(ShowPolinomioConstants.RESULT);
        System.out.println(polinomios);

        char select;
        do {
            System.out.print(ShowPolinomioConstants.OUT);
            select = read.next().charAt(0);
            read.nextLine();

        } while (select != '.');
    }
  
      
}
