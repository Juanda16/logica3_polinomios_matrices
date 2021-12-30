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
            char select;

        do {
            for (String option : ShowPolinomioConstants.OPTIONS) {
                System.out.println(option);
            }
            System.out.print("choice: ");
            select = read.next().charAt(0);
            controller.ShowPolinomioController.options(select);

        } while (select != '.');
    }

    
    /** 
     * @param polinomios
     */
    public static void printPolinomios(String polinomios) {
        
        System.out.println(ShowPolinomioConstants.RESULT);
        polinomios =polinomios.replaceAll("\\[", "").replaceAll("\\]","");
        String [] polinomioList = polinomios.split(",");

        for (String currentPolinomio : polinomioList) {
            System.out.println(currentPolinomio);



        }
        
    

        char select;
        do {
            System.out.print(ShowPolinomioConstants.OUT);
            select = read.next().charAt(0);
            read.nextLine();

        } while (select != '.');
    }
  
      
}
