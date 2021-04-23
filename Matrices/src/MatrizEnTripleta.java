
// import java.util.Scanner;
import util.Tripleta;

public class MatrizEnTripleta {

    protected Tripleta tripletas[];

    /**
     * @param tripletas
     */
    public MatrizEnTripleta(int row, int column) {
        this.tripletas = new Tripleta[1];
        Tripleta tripletaConfig = new Tripleta(row, column, (int) 0);
        tripletas[0] = tripletaConfig;
    }

    
    /** 
     * @param row
     * @param column
     * @param data
     */
    public void setElement(int row, int column, double data) {
        int p = 0;
        Tripleta tripletaConfig = tripletas[0];
        int rows = tripletaConfig.getRow();
        int columns = tripletaConfig.getColumn();
        int elements = (int) tripletaConfig.getValue();
        int possition = elements + 1;
        boolean done = false;

        if (rows < row || columns < column) {
            System.out.println("possition out of range");
        }
        if (elements > 0) {
            for (int i = 1; i <= elements; i++) {

                if (tripletas[i].getRow() < row) {
                    possition = i + 1;
                } else if (tripletas[i].getRow() == row) {

                    if (tripletas[i].getColumn() < column) {
                        possition = i + 1;

                    } else if (tripletas[i].getColumn() == column) {
                        tripletas[i].setValue(data);
                        done = true;
                        break;

                    } else {
                        // possition = i;

                    }

                } else {
                    // possition = i;

                }

            }
        }
        if (!done) {
            Tripleta newElement = new Tripleta(row, column, data);
            Tripleta[] newTripletas = new Tripleta[elements + 2];
            tripletaConfig.setValue((int) (elements + 1));

            for (p = 0; p < possition; p++) {
                newTripletas[p] = tripletas[p];
            }

            newTripletas[p] = newElement;

            for (p = possition + 1; p <= tripletas.length; p++) {
                newTripletas[p] = tripletas[p - 1];

            }

            tripletas = newTripletas;
        }
    }

    
    /** 
     * @return String
     */
    /*
     * void addTripleta (int possition){ int i Tripleta newElement = new
     * Tripleta(row, column, data); Tripleta[] newTripletas = new Tripleta[elements
     * + 2]; tripletaConfig.setValue((int) (elements + 1));
     * 
     * for(i = 0; i<possition; i++){ newTripletas[i] = tripletas[i]; }
     * 
     * newTripletas[i] = newElement; tripletas = newTripletas; }
     */

    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder();
        // Obtengo la configuración de la matriz, fr y cr y la cantidadValores
        Tripleta configuracion = this.tripletas[0];
        int cantidadFilasMatriz = configuracion.getRow();
        int cantidadColumnasMatriz = configuracion.getColumn();
        int valoresDiferentesCero = (Integer) configuracion.getValue();

        int posicionArreglo = 1;

        // Recorrido por una matriz virtual m x n
        for (int filasVirtuales = 0; filasVirtuales < cantidadFilasMatriz; filasVirtuales++) {
            for (int columnasVirtuales = 0; columnasVirtuales < cantidadColumnasMatriz; columnasVirtuales++) {
                if (posicionArreglo <= valoresDiferentesCero) {
                    // Estoy en una posicion valida en el arreglo
                    Tripleta posibleTripletaMostrar = tripletas[posicionArreglo];
                    int filaCeldaMostrar = posibleTripletaMostrar.getRow();
                    int columnaCeldaMostrar = posibleTripletaMostrar.getColumn();
                    if (filasVirtuales == filaCeldaMostrar) {
                        if (columnasVirtuales == columnaCeldaMostrar) {
                            Object valorCeldaMostrar = posibleTripletaMostrar.getValue();
                            if (valorCeldaMostrar != null) {
                                cadena.append(" " + valorCeldaMostrar + " ");
                            } else {
                                cadena.append(" 0.0 ");
                            }
                            posicionArreglo++;
                        } else {
                            cadena.append(" 0.0 ");
                        }
                    } else {
                        cadena.append(" 0.0 ");
                    }
                } else {
                    cadena.append(" 0.0 ");
                }
            }
            cadena.append("\n");
        }

        return cadena.toString();
    }

}