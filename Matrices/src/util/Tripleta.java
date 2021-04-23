package util;

//import java.io.*;
import java.util.Scanner;

public class Tripleta {

    int row = 0, column = 0;
    Object value;

    /**
     * @param row
     * @param column
     * @param value
     */
    public Tripleta(int row, int column, Object value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    /**
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * @param row the row to set
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * @return the column
     */
    public int getColumn() {
        return column;
    }

    /**
     * @param column the column to set
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * @return the value
     */
    public Object getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Object value) {
        this.value = value;
    }

    
    /** 
     * @return Tripleta
     */
    public static Tripleta ingresarTripletaPorPantalla() {
        Scanner sc;
        sc = new Scanner(System.in);

        System.out.println("Ingrese la tripleta separada por (coma ,) [ Ejemplo: 2,3,5] :");
        String datos[] = sc.next().split(",");
        Tripleta t = null;
        int f = Integer.valueOf(datos[0]);
        int c = Integer.valueOf(datos[1]);
        int v = Integer.valueOf(datos[2]);
        if (!(f == 0 || c == 0 || v == 0)) {
            t = new Tripleta(f, c, v);
        }
        sc.close();
        return t;
    }

    
    /** 
     * @return Tripleta
     */
    public Tripleta clonar() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

}
