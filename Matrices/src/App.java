
// import java.util.*;
import java.io.*;
// import java.io.FileReader;
// import java.io.BufferedReader;

public class App {
    
    /** 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        /*
         * MatrizEnTripleta matriz = new MatrizEnTripleta(10, 10); matriz.setElement(0,
         * 0, 5); matriz.setElement(1, 7, 1); matriz.setElement(2, 7, 1);
         * matriz.setElement(3, 7, 1); matriz.setElement(4, 7, 1); matriz.setElement(5,
         * 7, 1); matriz.setElement(6, 7, 1); matriz.setElement(7, 7, 1);
         * matriz.setElement(8, 7, 1); matriz.setElement(9, 7, 1); matriz.setElement(3,
         * 3, 1); matriz.setElement(9, 9, 2); matriz.setElement(3, 5, 2);
         * matriz.setElement(3, 5, 2); System.out.println(matriz);
         */

        File file = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            file = new File("C:\\matriz.txt");
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null)
                System.out.println(linea);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }
}
