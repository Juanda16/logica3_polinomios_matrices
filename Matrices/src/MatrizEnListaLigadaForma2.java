import static util.Matriz.MATRIZTEXTO;
// import util.Matriz;
import util.NodoDoble;
import util.Tripleta;

public class MatrizEnListaLigadaForma2 {
    
    NodoDoble nodoConfiguracion; // en el libro se llama mat

    /**
     * Constructor de la matriz sin elementos
     *
     * @param numeroFilas cantidad de filas de la matriz
     * @param numeroColumnas cantidad de columnas de la matriz
     */
    public MatrizEnListaLigadaForma2(int numeroFilas, int numeroColumnas) {
        construirNodosCabeza(numeroFilas, numeroColumnas);
    }

    /**
     * Métdo que construye el nodo configuración y nodo cabeza
     *
     * @param numeroFilas
     * @param numeroColumnas
     */
    private void construirNodosCabeza(int numeroFilas, int numeroColumnas) {
        Tripleta t = new Tripleta(numeroFilas, numeroColumnas, 0);
        nodoConfiguracion = new NodoDoble(t);

        //Creo el Nodo cabeza y lo configuro para que sea lista ligada circular
        NodoDoble cabeza = new NodoDoble(null);
        // Referencia circular por la liga filas y la liga columnas
        cabeza.setLigaC(cabeza);
        cabeza.setLigaF(cabeza);

        // conecto con el nodo de configuración
        nodoConfiguracion.setLigaC(cabeza);
        nodoConfiguracion.setLigaF(cabeza);
    }

    /**
     * Método para ingresar los datos de un nuevo registro e insertarlos en la
     * matriz
     *
     * @param fila fila donde se encuentra el dato
     * @param columna columnas donde se encuentra el dato
     * @param valor valor
     */
    public void setCelda(int fila, int columna, double valor) {
        Tripleta nuevoTripletaRegistro = new Tripleta(fila, columna, valor);
        setCelda(nuevoTripletaRegistro);
    }

    /**
     * Método para ingresar los datos de un nuevo registro e insertarlos en la
     * matriz
     *
     * @param t
     */
    public void setCelda(Tripleta t) {
        NodoDoble nuevoNodo = new NodoDoble(t);
        conectarFilas(nuevoNodo);
        conectarColumnas(nuevoNodo);
        int c = (Integer) nodoConfiguracion.getT().getValue();
        nodoConfiguracion.getT().setValue(c++);
    }

    /**
     * Método que ingresa un nodo recorriendo la lista de las filas
     *
     * @param nuevoNodo
     */
    private void conectarFilas(NodoDoble nuevoNodo) {
        // datos para la comparación
        int filaNuevoNodo = nuevoNodo.getT().getRow();
        int columnaNuevoNodo = nuevoNodo.getT().getColumn();

        // nodos para el recorrido
        NodoDoble cabeza = this.getCabeza();
        NodoDoble ultimo = cabeza;
        NodoDoble nodoRecorrido = cabeza.getLigaF();

        boolean siDebeInsertar = true;

        // Permite posicionar el nodoRecorrido en la fila correcta para ingresar 
        while (nodoRecorrido != null && nodoRecorrido != cabeza) {
            if (nodoRecorrido.getT().getRow() < filaNuevoNodo) {
                ultimo = nodoRecorrido;
                nodoRecorrido = nodoRecorrido.getLigaF();
            } else {
                break;
            }
        }

        while (nodoRecorrido != null && nodoRecorrido != cabeza) {
            if (nodoRecorrido.getT().getRow() == filaNuevoNodo) {
                if (nodoRecorrido.getT().getColumn() < columnaNuevoNodo) {
                    ultimo = nodoRecorrido;
                    nodoRecorrido = nodoRecorrido.getLigaF();
                } else if (nodoRecorrido.getT().getColumn() == columnaNuevoNodo) {
                    siDebeInsertar = false;
                    nodoRecorrido.getT().setValue(nuevoNodo.getT().getValue());
                    break;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        if (siDebeInsertar) {
            ultimo.setLigaF(nuevoNodo);
            nuevoNodo.setLigaF(nodoRecorrido);
        }
    }

    /**
     * Método que ingresa un nodo recorriendo la lista de las columnas
     *
     * @param nuevoNodo
     */
    private void conectarColumnas(NodoDoble nuevoNodo) {
        // datos para la comparación
        int filaNuevoNodo = nuevoNodo.getT().getRow();
        int columnaNuevoNodo = nuevoNodo.getT().getColumn();

        // nodos para el recorrido
        NodoDoble cabeza = getCabeza();
        NodoDoble ultimo = cabeza;
        NodoDoble nodoRecorrido = cabeza.getLigaC();

        boolean siDebeInsertar = true;

        while (nodoRecorrido != null && nodoRecorrido != cabeza) {
            if (nodoRecorrido.getT().getColumn() < columnaNuevoNodo) {
                ultimo = nodoRecorrido;
                nodoRecorrido = nodoRecorrido.getLigaC();
            } else {
                break;
            }
        }

        while (nodoRecorrido != null && nodoRecorrido != cabeza) {
            if (nodoRecorrido.getT().getColumn() == columnaNuevoNodo) {
                if (nodoRecorrido.getT().getRow() < filaNuevoNodo) {
                    ultimo = nodoRecorrido;
                    nodoRecorrido = nodoRecorrido.getLigaC();
                } else if (nodoRecorrido.getT().getRow() == filaNuevoNodo) {
                    siDebeInsertar = false;
                    nodoRecorrido.getT().setValue(nuevoNodo.getT().getValue());
                    break;
                } else {
                    break;
                }
            } else {
                break;
            }
        }

        if (siDebeInsertar) {
            ultimo.setLigaC(nuevoNodo);
            nuevoNodo.setLigaC(nodoRecorrido);
        }
    }

    
    /** 
     * @return NodoDoble
     */
    private NodoDoble getCabeza() {
        return nodoConfiguracion.getLigaC();
    }

    
    /** 
     * @return MatrizEnListaLigadaForma2
     */
    public static MatrizEnListaLigadaForma2 entregarMatrizRelacion() {

        String[] filas = MATRIZTEXTO.split("\n");
        int cpc = filas[0].length();
        int cln = filas.length;

        MatrizEnListaLigadaForma2 matrizEnListaLigadaForma2 = new MatrizEnListaLigadaForma2(cln, cpc);

        int i = 1;
        int j = 1;
        for (int x = 0; x < MATRIZTEXTO.length(); x++) {
            switch (MATRIZTEXTO.charAt(x)) {
                case '\n':
                    j = 1;
                    i++;
                    break;
                case '1':
                case '0':
                    int v = Integer.parseInt(x + "");
                    if (v != 0) {
                        matrizEnListaLigadaForma2.setCelda(new Tripleta(i, j, v));
                    }
                    j++;
                    break;
                default:
                    System.out.println("Extraño " + (int) MATRIZTEXTO.charAt(x));
            }
        }

        return matrizEnListaLigadaForma2;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder();
        // Obtengo la configuración de la matriz, fr y cr y la cantidadValores
        Tripleta configuracion = nodoConfiguracion.getT();
        int fr = configuracion.getRow();
        int cr = configuracion.getColumn();
        // Imprimir una línea con encabezado de las columnas
        cadena.append("\t");
        for (int i = 1; i <= cr; i++) {
            cadena.append(i + "\t");
        }
        cadena.append("\n");

        NodoDoble nodoCabeza = nodoConfiguracion.getLigaF();
        NodoDoble nodoRecorrido = nodoCabeza.getLigaF();
        // Recorrido por una matriz virtual m x n
        for (int fv = 1; fv <= fr; fv++) {
            cadena.append(fv + "\t");
            for (int cv = 1; cv <= cr; cv++) {
                if (nodoRecorrido != null && nodoRecorrido != nodoCabeza) {
                    Tripleta triMo = nodoRecorrido.getT();
                    int ft = triMo.getRow();
                    int ct = triMo.getColumn();
                    if (fv == ft) {
                        if (cv < ct) {
                            cadena.append("0\t");
                        } else if (cv == ct) {
                            Object vt = triMo.getValue();
                            if (vt != null) {
                                cadena.append(vt + "\t");
                            } else {
                                cadena.append("ERROR x COLUMNAS!!!!");
                            }
                            nodoRecorrido = nodoRecorrido.getLigaF();
                        } else {
                            cadena.append("ERROR x COLUMNAS se paso!!!!");
                        }
                    } else {
                        cadena.append("0\t");
                    }
                } else {
                    cadena.append("0\t");
                }
            }
            cadena.append("\n");
        }
        return cadena.toString();
    }
}
