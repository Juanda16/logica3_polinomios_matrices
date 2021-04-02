
public class App {
    public static void main(String[] args) throws Exception {
        MatrizEnTripleta matriz = new MatrizEnTripleta(10, 10);
        matriz.setElement(0, 0, 5);
        matriz.setElement(1, 7, 1);
        matriz.setElement(2, 7, 1);
        matriz.setElement(3, 7, 1);
        matriz.setElement(4, 7, 1);
        matriz.setElement(5, 7, 1);
        matriz.setElement(6, 7, 1);
        matriz.setElement(7, 7, 1);
        matriz.setElement(8, 7, 1);
        matriz.setElement(9, 7, 1);
        matriz.setElement(3, 3, 1);
        matriz.setElement(9, 9, 2);
        matriz.setElement(3, 5, 2);
        matriz.setElement(3, 5, 2);
        System.out.println(matriz);
    }
}
