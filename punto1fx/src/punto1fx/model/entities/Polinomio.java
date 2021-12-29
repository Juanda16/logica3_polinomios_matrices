package model.entities;

// vamos a trabajar lista ligada con cabeza

public class Polinomio {

    private Nodo cabeza;

    /**
     * @param cabeza
     */
    public Polinomio(Nodo cabeza) {
        this.cabeza = cabeza;
    }

    public Polinomio() {

        cabeza = new Nodo(null);
        cabeza.setLiga(null);
    }

    /**
     * @return the cabeza
     */
    public Nodo getCabeza() {
        return cabeza;
    }

    /**
     * @return int
     * @throws Exception
     */
    public int getGrado() throws Exception {

        Nodo primero = cabeza.getLiga();
        if (primero == null) {
            return 0;
        }
        return primero.getTermino().getExp();
    }

    /**
     * @param exponente
     * @return double
     */
    public double getCoeficiente(int exponente) {
        // Variables para los recorridos en polinomios a,b y c

        Nodo prA = this.getCabeza().getLiga();

        double coeficiente = 0;
        while (!finRecorrido(prA)) {
            if (prA.getTermino().getExp() == exponente) {
                return prA.getTermino().getCoef();
            }
            prA = prA.getLiga();
        }
        return coeficiente;
    }

    /**
     * @return int
     */
    // retorna el número de terminos del polinomio
    public int getSize() {

        Nodo nodoRecorrido = this.getCabeza().getLiga();
        int size = 0;

        // Recorrido de los terminos en alguna de las dos listas
        while (!finRecorrido(nodoRecorrido)) {
            nodoRecorrido = nodoRecorrido.getLiga();
            size++;
        } // recorro la lista polinomio de a

        return size;
    }

    /**
     * @param liga
     * @return boolean
     */
    private boolean finRecorrido(Nodo liga) {
        return liga == null;
    }

    /**
     * @param termn
     * @param last
     * @return Nodo
     */
    public Nodo insertTermn(Termino termn, Nodo last) {
        Nodo newNodo = new Nodo(termn);
        last.setLiga(newNodo);
        return newNodo;

    }

    /**
     * @param coef
     * @param exp
     */
    public void TermnToPol(Double coef, int exp) {
        // TODO. falta terminarla y definir si si es necesario este método
        Termino termino1 = new Termino(coef, exp);
        Nodo nodo = new Nodo(termino1);
        Nodo cA = this.getCabeza();
        cA.setLiga(nodo);
        cA = nodo;

        // hacer esto para insertar x cantidad de términos
        // for(){
        // termn = new Termino(6, 2);
        // nodo = new Nodo(termn);
        // cA.setLiga(nodo);
        // cA=nodo;}

    }

    public void simplify() {
        Polinomio temp = new Polinomio();
        int size = this.getSize();
        Nodo nodoRecord = this.getCabeza().getLiga();
        Nodo last = temp.getCabeza();
        Nodo newNodo;

        for (int i = 0; i < size; i++) {
            Termino termino = nodoRecord.getTermino();
            double coeficiente = termino.getCoef();
            int exp = termino.getExp();

            Nodo recordTemp = nodoRecord;
            for (int j = i + 1; j < size; j++) {
                Termino nextTermn = recordTemp.getLiga().getTermino();
                int nextExp = nextTermn.getExp();
                if (exp == nextExp && coeficiente != 0) {
                    coeficiente += nextTermn.getCoef();
                    recordTemp.getLiga().setTermino(new Termino(0, 0));
                }
                recordTemp = recordTemp.getLiga();
            }

            if (coeficiente != 0) { // controlar que se guarda
                Termino newTermino = new Termino(coeficiente, exp);
                newNodo = temp.insertTermn(newTermino, last); //
                last = newNodo;
            }
            nodoRecord = nodoRecord.getLiga();
        }
        this.cabeza = temp.cabeza;
    }

    public void sort() {

        int size = this.getSize();
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size - j - 1; i++) {

                if (getTermnN(i).getExp() < getTermnN(i + 1).getExp()) {
                    int exponente = getTermnN(i + 1).getExp();
                    double coeficiente = getTermnN(i + 1).getCoef();

                    getTermnN(i + 1).setExp(getTermnN(i).getExp());
                    getTermnN(i + 1).setCoef(getTermnN(i).getCoef());
                    getTermnN(i).setExp(exponente);
                    getTermnN(i).setCoef(coeficiente);
                }
            }
        }
    }

    /**
     * @param index
     * @return Termino
     */
    public Termino getTermnN(int index) {
        if (index <= this.getSize()) {
            Nodo nodoRecord = this.getCabeza().getLiga();

            for (int i = 0; i < index; i++) {
                nodoRecord = nodoRecord.getLiga();
            }
            Termino termino = nodoRecord.getTermino();
            return termino;

        } else
            return null;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder polinomio = new StringBuilder();
        Nodo liga = cabeza.getLiga();
        while (!finRecorrido(liga)) {
            Termino termino = liga.getTermino();
            double coef = termino.getCoef();
            int exp = termino.getExp();
            // Para adicionar el simbolo del coeficiente para numeros positivos, excluyendo
            // el simbolo + del primer termino si es positivo.
            if (coef >= 0) {
                polinomio.append("+");
            }
            polinomio.append(coef).append("X^").append(exp).append(" ");
            liga = liga.getLiga();
        }
        return polinomio.toString();
    }

    public boolean equals(Polinomio polinomio) throws Exception {
        boolean equals = false;
        this.simplify();
        this.sort();
        polinomio.simplify();
        polinomio.sort();
        if (this.getSize() == polinomio.getSize() && this != null && polinomio != null) {
            if (this.getGrado() == polinomio.getGrado()) {

                int size = this.getSize();
                Nodo nodoRecord1 = this.getCabeza().getLiga();
                Nodo nodoRecord2 = polinomio.getCabeza().getLiga();

                for (int i = 0; i < size; i++) {

                    if (nodoRecord1.getTermino().getCoef() == nodoRecord2.getTermino().getCoef()) {
                        equals = true;
                    } else {
                        equals = false;
                        break;
                    }

                    nodoRecord1 = nodoRecord1.getLiga();
                    nodoRecord2 = nodoRecord2.getLiga();
                }

            }

        }
        return equals;
    }
}
