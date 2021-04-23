
    import util.Matriz;
    import util.NodoDoble;
    import util.Tripleta;

public class MatrizEnListaLigadaForma1 {
    NodoDoble nodoCabezaMatriz;

    /**
     * Constructor de la matriz sin elementos
     *
     * @param numeroFilas    cantidad de filas de la matriz
     * @param numeroColumnas cantidad de columnas de la matriz
     */
    MatrizEnListaLigadaForma1(int numeroFilas, int numeroColumnas) {
        construyeNodosCabeza(numeroFilas, numeroColumnas);
    }

    /**
     *
     * @param numeroFilas
     * @param numeroColumnas
     */
    private void construyeNodosCabeza(int numeroFilas, int numeroColumnas) {
        Tripleta tripletaConfiguracion = new Tripleta(numeroFilas, numeroColumnas, null);
        nodoCabezaMatriz = new NodoDoble(tripletaConfiguracion);

        // Depende de las f y c
        int max = (numeroFilas > numeroColumnas) ? numeroFilas : numeroColumnas;

        // Creo los nodos Cabeza de las listas de filas y columas
        // Estas a su vez hacen parte de la lista circular de nodos cabeza
        NodoDoble ultimo = nodoCabezaMatriz;
        for (int i = 1; i <= max; i++) {
            NodoDoble nuevoNodoRegistroCabeza = new NodoDoble(new Tripleta(i, i, null));
            // Estoy creando la referencia circular inicial para la lista de columnas(la
            // oreja)
            nuevoNodoRegistroCabeza.setLigaC(nuevoNodoRegistroCabeza);
            // Estoy creando la referencia circular inicial para la lista de filas(la oreja)
            nuevoNodoRegistroCabeza.setLigaF(nuevoNodoRegistroCabeza);
            // Liga del ultimo con el nuevo
            setLigaNodoCabeza(ultimo, nuevoNodoRegistroCabeza);
            // Este es el nuevo ultimo
            ultimo = nuevoNodoRegistroCabeza;
        }
        // Establezco la referencia de la lista circular
        setLigaNodoCabeza(ultimo, nodoCabezaMatriz);
    }

    /**
     * Crea la liga en los nodos cabeza, se reutiliza el Object de la tripleta del
     * Nodo.
     *
     * @param a
     * @param b
     */
    private static void setLigaNodoCabeza(NodoDoble a, NodoDoble b) {
        a.getT().setValue(b);
    }

    
    /** 
     * @param a
     * @return NodoDoble
     */
    private NodoDoble getLigaNodoCabeza(NodoDoble a) {
        return (NodoDoble) a.getT().getValue();
    }

    /**
     * Retorna el nodo cabeza de la matriz
     *
     * @return
     */
    public NodoDoble getNodoCabezaMatriz() {
        return nodoCabezaMatriz;
    }

    private MatrizEnListaLigadaForma1(NodoDoble nc) {
        this.nodoCabezaMatriz = nc;
    }

    /**
     * Método para ingresar los datos de un nuevo registro e insertarlos en la
     * matriz
     *
     * @param fila    fila donde se encuentra el dato
     * @param columna columnas donde se encuentra el dato
     * @param valor   valor
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

        // Creo el NodoDoble con los valores a ingresar
        NodoDoble nuevoNodoRegistro = new NodoDoble(t);

        // Obtengo un nodo cabeza para recorrer la lista de nodos cabeza
        NodoDoble nodoCabezaDeRecorridoLocalizado = getLigaNodoCabeza(nodoCabezaMatriz);

        // Buscar el nodo cabeza correspondiente a la Fila del registro que
        // estamos insertando y cuando lo encuentra inserta el registro en la lista
        // de esa fila
        while (nodoCabezaDeRecorridoLocalizado != nodoCabezaMatriz && nodoCabezaDeRecorridoLocalizado != null) {
            if (nodoCabezaDeRecorridoLocalizado.getT().getRow() == t.getRow()) {
                // Eureka, encontre el Nodo cabeza de la fila
                conectaPorFilas(nodoCabezaDeRecorridoLocalizado, nuevoNodoRegistro);
                break;
            }
            nodoCabezaDeRecorridoLocalizado = getLigaNodoCabeza(nodoCabezaDeRecorridoLocalizado);
        }

        // Obtengo un nodo cabeza para recorrer la lista de nodos cabeza
        nodoCabezaDeRecorridoLocalizado = getLigaNodoCabeza(nodoCabezaMatriz);
        // Buscar el nodo cabeza correspondiente a la Columna del registro que
        // estamos insertando y cuando lo encuentra inserta el registro en la lista
        // por columna
        while (nodoCabezaDeRecorridoLocalizado != nodoCabezaMatriz && nodoCabezaDeRecorridoLocalizado != null) {
            if (nodoCabezaDeRecorridoLocalizado.getT().getColumn() == t.getColumn()) {
                conectaPorColumnas(nodoCabezaDeRecorridoLocalizado, nuevoNodoRegistro);
                break;
            }
            nodoCabezaDeRecorridoLocalizado = getLigaNodoCabeza(nodoCabezaDeRecorridoLocalizado);
        }
    }

    /**
     * Método para conectar un nuevo nodo por las filas
     *
     * @param nodoCabezaDeRecorridoLocalizado
     * @param nnuevo
     */
    private void conectaPorFilas(NodoDoble nodoCabezaDeRecorridoLocalizado, NodoDoble nuevoNodoRegistro) {
        NodoDoble nodoRecorridoEnLaFila = nodoCabezaDeRecorridoLocalizado.getLigaF();
        NodoDoble ultimoNodoDeFila = nodoCabezaDeRecorridoLocalizado;
        boolean siDebeInsertar = true;
        while (nodoRecorridoEnLaFila != null && nodoRecorridoEnLaFila != nodoCabezaDeRecorridoLocalizado) {
            int columnaNuevoRegistro = nuevoNodoRegistro.getT().getColumn();
            int columnaNodoRestroRecorrido = nodoRecorridoEnLaFila.getT().getColumn();
            if (columnaNuevoRegistro > columnaNodoRestroRecorrido) {
                ultimoNodoDeFila = nodoRecorridoEnLaFila;
                nodoRecorridoEnLaFila = nodoRecorridoEnLaFila.getLigaF();
            } else if (columnaNuevoRegistro == columnaNodoRestroRecorrido) {
                siDebeInsertar = false;
                nodoRecorridoEnLaFila.getT().setValue(nuevoNodoRegistro.getT().getValue());
                break;
            } else {
                break;
            }
        }
        if (siDebeInsertar) {
            nuevoNodoRegistro.setLigaF(nodoRecorridoEnLaFila);
            ultimoNodoDeFila.setLigaF(nuevoNodoRegistro);
        }
    }

    /**
     * Método para conectar un nuevo nodo por las columnas
     *
     * @param nodoCDeRecorrido
     * @param nnuevo
     */
    private void conectaPorColumnas(NodoDoble nodoCabezaDeRecorridoLocalizado, NodoDoble nuevoNodoRegistro) {
        NodoDoble nodoRecorridoEnLaColumna = nodoCabezaDeRecorridoLocalizado.getLigaC();
        NodoDoble ultimoNodoDeColumna = nodoCabezaDeRecorridoLocalizado;
        boolean siDebeInsertar = true;

        while (nodoRecorridoEnLaColumna != null && nodoRecorridoEnLaColumna != nodoCabezaDeRecorridoLocalizado) {
            int filaNuevoRegistro = nuevoNodoRegistro.getT().getRow();
            int filaNodoRecorrido = nodoRecorridoEnLaColumna.getT().getRow();

            if (filaNuevoRegistro > filaNodoRecorrido) {
                ultimoNodoDeColumna = nodoRecorridoEnLaColumna;
                nodoRecorridoEnLaColumna = nodoRecorridoEnLaColumna.getLigaC();
            } else if (filaNuevoRegistro == filaNodoRecorrido) {
                siDebeInsertar = false;
                nodoRecorridoEnLaColumna.getT().setValue(nuevoNodoRegistro.getT().getValue());
                break;
            } else {
                break;
            }
        }
        if (siDebeInsertar) {
            nuevoNodoRegistro.setLigaC(nodoRecorridoEnLaColumna);
            ultimoNodoDeColumna.setLigaC(nuevoNodoRegistro);
        }
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder();
        // Obtengo la configuración de la matriz, fr y cr
        Tripleta configuracion = nodoCabezaMatriz.getT();
        int cantidadFilasMatriz = configuracion.getRow();
        int cantidadColumnasMatriz = configuracion.getColumn();
        // Imprimir una línea con encabezado de las columnas
        cadena.append("\t");
        for (int i = 1; i <= cantidadColumnasMatriz; i++) {
            cadena.append(i + "\t");
        }
        cadena.append("\n");

        NodoDoble nodoRecorridoCabeza = getLigaNodoCabeza(nodoCabezaMatriz);

        // Recorrido por una matriz virtual m x n
        for (int fv = 1; fv <= cantidadFilasMatriz; fv++) {
            cadena.append(fv + "\t");
            if (nodoRecorridoCabeza != null && nodoRecorridoCabeza != nodoCabezaMatriz) {
                NodoDoble nodoRecorridoCeldas = nodoRecorridoCabeza.getLigaF();
                for (int cv = 1; cv <= cantidadColumnasMatriz; cv++) {
                    if (nodoRecorridoCeldas != null && nodoRecorridoCeldas != nodoRecorridoCabeza) {
                        Tripleta triMo = nodoRecorridoCeldas.getT();
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
                                nodoRecorridoCeldas = nodoRecorridoCeldas.getLigaF();
                            }
                        } else {
                            cadena.append("ERROR x FILAS !!!!");
                        }
                    } else {
                        cadena.append("0\t");
                    }
                }
            }
            nodoRecorridoCabeza = getLigaNodoCabeza(nodoRecorridoCabeza);
            cadena.append("\n");
        }
        return cadena.toString();
    }

    
    /** 
     * @return MatrizEnListaLigadaForma1
     */
    public MatrizEnListaLigadaForma1 obtenerIdentidad() {
        Tripleta configuracion = nodoCabezaMatriz.getT();
        int filas = configuracion.getRow();
        int cols = configuracion.getColumn();
        MatrizEnListaLigadaForma1 mI = crearIdentidad(filas, cols);
        return mI;
    }

    
    /** 
     * @param f
     * @param c
     * @return MatrizEnListaLigadaForma1
     */
    public static MatrizEnListaLigadaForma1 crearIdentidad(int f, int c) {
        Tripleta tripletaConfiguracion = new Tripleta(f, c, f);
        NodoDoble nc;
        nc = new NodoDoble(tripletaConfiguracion);
        MatrizEnListaLigadaForma1 mI = new MatrizEnListaLigadaForma1(nc);

        // Creo los nodos Cabeza de las listas de filas y columnas
        // Estas a su vez hacen parte de la lista circular de nodos cabeza
        NodoDoble ultimo = nc;
        for (int i = 1; i <= f; i++) {
            // Este es el nodo cabeza de la lista circular de fila y de columna
            NodoDoble nca = new NodoDoble(new Tripleta(i, i, 0));
            // Creo el NodoDoble con los valores 1 a ingresar
            NodoDoble nnuevo = new NodoDoble(new Tripleta(1, 1, 1));
            // Creo la lista circular tanto para la final como para la columna
            // Para la columna
            nca.setLigaC(nnuevo);
            nnuevo.setLigaC(nca);
            // Para la fila
            nca.setLigaF(nnuevo);
            nnuevo.setLigaF(nca);

            // Lista circular de cabezas
            setLigaNodoCabeza(ultimo, nca);

            ultimo = nca;
        }
        // Establezco la referencia de la lista circular
        setLigaNodoCabeza(ultimo, nc);

        return mI;
    }

    
    /** 
     * @return int
     */
    public int getRowilas() {
        return nodoCabezaMatriz.getT().getRow();
    }

    /**
     * Busca el valor de una celda i,j de la matriz o 0 en caso contrario
     *
     * @param i
     * @param j
     * @return
     */
    public int getCelda(int i, int j) {
        int valor = 0;

        // Obtengo un nodo cabeza para recorrer la lista de nodos cabeza
        NodoDoble nCDeRecorrido = getLigaNodoCabeza(nodoCabezaMatriz);

        /**
         * Buscar el nodo cabeza correspondiente a la Fila del registro que estamos
         * buscando y cuando lo encuentra buscar el registro en la lista de columnas de
         * esa fila
         */
        while (nCDeRecorrido != nodoCabezaMatriz && nCDeRecorrido != null) {
            // Cuando localice la fila busco la columna
            if (nCDeRecorrido.getT().getRow() == i) {
                NodoDoble nodoRecorrido = nCDeRecorrido.getLigaF();
                NodoDoble cabezaRecorrido = (NodoDoble) nCDeRecorrido;
                while (nodoRecorrido != null && nodoRecorrido != cabezaRecorrido) {
                    if (j > nodoRecorrido.getT().getColumn()) {
                        nodoRecorrido = nodoRecorrido.getLigaF();
                    } else {
                        // Cuando no es mayor valido si estoy en la columna
                        if (j == nodoRecorrido.getT().getColumn()) {
                            valor = (int) nodoRecorrido.getT().getValue();
                        }
                        break;
                    }
                }
            }

            nCDeRecorrido = getLigaNodoCabeza(nCDeRecorrido);
        }

        return valor;

    }

    
    /** 
     * @return int
     */
    public int getColumnas() {
        return nodoCabezaMatriz.getT().getColumn();
    }

    
    /** 
     * @param nCDeRecorrido
     * @return NodoDoble
     */
    public static NodoDoble getCopiaListaFila(NodoDoble nCDeRecorrido) {

        NodoDoble copiaFila = new NodoDoble(nCDeRecorrido.getT().clonar());
        copiaFila.setLigaF(copiaFila);
        NodoDoble ultimoNodoDeFilaCopia = (NodoDoble) copiaFila;

        NodoDoble nodoRecorrido = nCDeRecorrido.getLigaF();
        NodoDoble cabezaRecorrido = (NodoDoble) nCDeRecorrido;
        while (nodoRecorrido != null && nodoRecorrido != cabezaRecorrido) {
            Tripleta tripletaCopia = nodoRecorrido.getT().clonar();
            NodoDoble nuevoNodocopia = new NodoDoble(tripletaCopia);
            ultimoNodoDeFilaCopia.setLigaF(nuevoNodocopia);
            ultimoNodoDeFilaCopia = nuevoNodocopia;
            nodoRecorrido = nodoRecorrido.getLigaF();
        }
        return copiaFila;
    }

    
    /** 
     * @param x
     * @param nCDeRecorrido
     */
    public static void multiplicarFila(int x, NodoDoble nCDeRecorrido) {
        NodoDoble nodoRecorrido = nCDeRecorrido.getLigaF();
        NodoDoble cabezaRecorrido = (NodoDoble) nCDeRecorrido;
        while (nodoRecorrido != null && nodoRecorrido != cabezaRecorrido) {
            Tripleta t = nodoRecorrido.getT();
            int nv = (int) t.getValue() * x;
            t.setValue(nv);
            nodoRecorrido = nodoRecorrido.getLigaF();
        }
    }

    
    /** 
     * @return MatrizEnListaLigadaForma1
     */
    public static MatrizEnListaLigadaForma1 entregarMatrizRelacion() {

        String[] filas = Matriz.MATRIZTEXTO.split("\n");
        int cpc = filas[0].length();
        int cln = filas.length;
        System.out.println("Filas " + cln);
        System.out.println("Columnas " + cpc);

        MatrizEnListaLigadaForma1 matrizEnListaLigadaForma1 = new MatrizEnListaLigadaForma1(cln, cpc);

        int i = 1;
        int j = 1;
        for (int x = 0; x < Matriz.MATRIZTEXTO.length(); x++) {
            switch (Matriz.MATRIZTEXTO.charAt(x)) {
            case '\n':
                j = 1;
                i++;
                break;
            case '1':
            case '0':
                int v = Integer.parseInt(x + "");
                if (v != 0) {
                    System.out.println("Adicionando valor en [" + i + "," + j + "]");
                    matrizEnListaLigadaForma1.setCelda(new Tripleta(i, j, v));
                }
                j++;
                break;
            default:
                System.out.println("Extraño " + (int) Matriz.MATRIZTEXTO.charAt(x));
            }
        }

        return matrizEnListaLigadaForma1;
    }

    
    /** 
     * @param i
     * @return NodoDoble
     */
    public NodoDoble getRowila(int i) {
        // Obtengo un nodo cabeza para recorrer la lista de nodos cabeza

        NodoDoble nCDeRecorrido = getLigaNodoCabeza(nodoCabezaMatriz);

        /**
         * Buscar el nodo cabeza correspondiente a la Fila del registro que estamos
         * buscando y cuando lo encuentra clonar
         */
        while (nCDeRecorrido != nodoCabezaMatriz && nCDeRecorrido != null) {
            // Cuando localice la fila
            if (nCDeRecorrido.getT().getRow() == i) {
                return nCDeRecorrido;
            }
        }
        return nCDeRecorrido;
    }
}
