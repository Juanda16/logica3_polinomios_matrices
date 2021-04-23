package util;


public class NodoDoble {

    private final Tripleta t;
    private NodoDoble ligaF;
    private NodoDoble ligaC;

    public NodoDoble(Tripleta t) {
        this.t = t;
    }

    
    /** 
     * @return NodoDoble
     */
    public NodoDoble getLigaC() {
        return ligaC;
    }

    
    /** 
     * @return Tripleta
     */
    public Tripleta getT() {
        return t;
    }

    
    /** 
     * @return NodoDoble
     */
    public NodoDoble getLigaF() {
        return ligaF;
    }

    
    /** 
     * @param ligaC
     */
    public void setLigaC(NodoDoble ligaC) {
        this.ligaC = ligaC;
    }

    
    /** 
     * @param ligaF
     */
    public void setLigaF(NodoDoble ligaF) {
        this.ligaF = ligaF;
    }
    
}
