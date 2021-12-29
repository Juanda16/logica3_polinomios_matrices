package model.entities;

public class Termino {
    
    private int exp;
    private double coef;
    /**
     * @param exp
     * @param coef
     */
    public Termino(double coef,int exp) {
        this.exp = exp;
        this.coef = coef;
    }
    /**
     * @return the exp
     */
    public int getExp() {
        return exp;
    }
    /**
     * @param exp the exp to set
     */
    public void setExp(int exp) {
        this.exp = exp;
    }
    /**
     * @return the coef
     */
    public double getCoef() {
        return coef; 
    }
    /**
     * @param coef the coef to set
     */
    public void setCoef(double coef) {
        this.coef = coef;
    }  
    
    
    /** 
     * @param a
     * @param b
     * @return Termino
     */
    public static Termino dividirTermino(Termino a, Termino b) {
        double coeficiente = a.getCoef() / b.getCoef();
        int exponente = a.getExp() - b.getExp();
        return new Termino(coeficiente, exponente);
    }
    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder polinomio = new StringBuilder();
        polinomio.append(coef).append("X^").append(exp).append(" ");
        return polinomio.toString();
    }
    
}
