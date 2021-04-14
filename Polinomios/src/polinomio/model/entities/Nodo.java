package model.entities;

public class Nodo {


    private Termino termino;
    private Nodo liga;

    /**
     * @param termino
     * @param liga
     */     
    public Nodo(Termino termino, Nodo liga) {
        this.termino = termino;
        this.liga = liga;
    }

    /**
     * @param termino
     */
    public Nodo(Termino termino) {
        this.termino = termino;
    }

    /**
     * @return the termino
     */
    public Termino getTermino() {
        return termino;
    }
    /**
     * @param termino the termino to set
     */
    public void setTermino(Termino termino) {
        this.termino = termino;
    }
    /**
     * @return the liga
     */
    public Nodo getLiga() {
        return liga;
    }
    /**
     * @param liga the liga to set
     */
    public void setLiga(Nodo liga) {
        this.liga = liga;
    }


    

     


   
    
}
