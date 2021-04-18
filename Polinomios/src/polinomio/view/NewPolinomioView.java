package view;
import java.util.Scanner;

import controller.NewPolinomioController;
import view.constants.NewPolinomioConstants;

public class NewPolinomioView {
    static Scanner read = new Scanner (System.in);

    /**
     * Formulario para la creacion de polinomios.
     */
    public static void index() {
        System.out.println(NewPolinomioConstants.TITLE);        
               
        char response;
        do {
            System.out.println(NewPolinomioConstants.SUBTITLE);
            System.out.println(NewPolinomioConstants.NOTES);
            String readPolinomio = read.nextLine();
            NewPolinomioController.store(readPolinomio);
            System.out.println("Polinomio: "+ readPolinomio +" guardado");
            do {
                System.out.print(NewPolinomioConstants.QUESTION);
                response = read.next().charAt(0);
                read.nextLine();
            } while (response != 'y' && response != 'n');
        } while (response == 'y');
        
    }
}
    

