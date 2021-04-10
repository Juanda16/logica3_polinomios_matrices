package view;
import java.util.Scanner;
//import view.constants;


public class Index {
    static Scanner read = new Scanner (System.in);

    public static void mainScreen() {
        System.out.println(Constants.LOGO2);
        System.out.println(Constants.SUBTITLE);
        for(String author : Constants.AUTHORS )System.out.print(author+", ");
        System.out.println("\n");
        
        
        char select;

        do {
            for (String option : Constants.MAIN_MENU_OPTIONS){
                System.out.println(option);
                }
            
            select = read.next().charAt(0);
            

        } while (select != '.');
    }
    
}
