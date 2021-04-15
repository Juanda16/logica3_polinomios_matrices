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
   
    public int getGrado() throws Exception {

        Nodo primero = cabeza.getLiga();
        if (primero == null) {
            return 0;
        }
        return primero.getTermino().getExp();
    }

    public double getCoeficiente(int exponente) {
        // Variables para los recorridos en polinomios a,b y c
       
        Nodo prA = this.getCabeza().getLiga();

        double coeficiente = 0;
        while (!finRecorrido(prA)) {
            if (prA.getTermino().getExp()== exponente) {
                return prA.getTermino().getCoef();
            }
            prA = prA.getLiga();
        }
        return coeficiente;
    }

    //retorna el número de terminos del polinomio
    public int getSize(){

        Nodo nodoRecorrido = this.getCabeza().getLiga();
        int size=0; 
          
         // Recorrido de los terminos en alguna de las dos listas
         while (!finRecorrido(nodoRecorrido)){
            nodoRecorrido = nodoRecorrido.getLiga();
            size++;
        } // recorro la lista polinomio de a

        return size;
    }


    private boolean finRecorrido(Nodo liga) {
        return liga == null;
    }
    
    public Nodo insertTermn(Termino termn, Nodo last){
        Nodo newNodo = new Nodo(termn);
        last.setLiga(newNodo);
        return newNodo;
        
    }

    public void simplify (){
        //TODO. simplificar el polinomio
    }

    public void sort(){
            //TODO. organizar el polinomio en porma decendente ej: x^4 + x^3 + x^2 + x^1 + x^0
    }
    @Override
    public String toString() {
        StringBuilder polinomio = new StringBuilder();
        Nodo liga = cabeza.getLiga();
        while (!finRecorrido(liga)) {
            Termino termino = liga.getTermino();
            int coef = termino.getCoef();
            int exp = termino.getExp();
            // Para adicionar el simbolo del coeficiente para numeros positivos, excluyendo el simbolo + del primer termino si es positivo.
            if (coef >= 0) {
                polinomio.append("+");
            }
            polinomio.append(coef).append("X^").append(exp).append(" ");
            liga = liga.getLiga();
        }
        return polinomio.toString();
    }

    
           
    

    

}
