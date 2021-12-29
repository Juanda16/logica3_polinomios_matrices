package view;

import java.util.Scanner;
import controller.MainController;
import view.constants.MainConstants;

public class Index {
    static Scanner read = new Scanner(System.in);

    public static void mainScreen() {
        System.out.println(MainConstants.LOGO3);
        System.out.println(MainConstants.SUBTITLE);
        for (String author : MainConstants.AUTHORS)
            System.out.print(author);
        System.out.println("\n");

        char select;
        do {
            for (String option : MainConstants.MAIN_MENU_OPTIONS) {
                System.out.println(option);
            }

            select = read.next().charAt(0);
            MainController.index(select);

        } while (select != '.');
    }
}