package model.util;
import java.util.Arrays;
import javax.sql.PooledConnection;
import model.entities.Nodo;
import model.entities.Polinomio;
import model.entities.Termino;


/*Examples:
insertTermnByInt(Double coef, int exp)  ok
52x^2 + 25x^1 - 65  ok
52x^2-25x^1-65      java.lang.NumberFormatException: For input string: "2-25"
34x^4-345x^3 +12x^2+ 123x + 0  java.lang.NumberFormatException: For input string: "4-345"
25x^2 + 10x^1 + 20 ok
3x^2+2x^1-8
1x^1 + 2
2x^2-15x^1+25
1x^1 - 5
*/

public class StringToPolinomio{
   

    
    /** 
     * @param rawPolinomio
     * @return Polinomio
     */
    public static Polinomio stringToPolinomio(String rawPolinomio) {
        Polinomio polinomio = new Polinomio();
        try {
            rawPolinomio =rawPolinomio.replaceAll(" ", "");
            //System.out.println(rawPolinomio);
            String parts[] = rawPolinomio.split("(?=\\+)|(?=-)"); 
            
            double coef=0;
            int exp=0;
            String term[]= {"0","0","0"};
            Termino termino1 = new Termino(coef, exp);
            Nodo nodo1 = new Nodo(termino1);
            Nodo nodoRecu = polinomio.getCabeza();
            for (int i = 0; i < parts.length; i++) { 
                term = parts[i].split("(?=\\+)|(?=-)|x\\^");
                if (term.length==1) {
                    coef = Integer.parseInt(term[0]);
                    exp=0;
                    //System.out.println(parts[i]);
                    
                }else{
                //System.out.println(parts[i]);
                coef = Integer.parseInt(term[0]);
                exp = Integer.parseInt(term[1]); 
                }
                /* * Se */
                /*
                */
                termino1 = new Termino(coef, exp);
                nodo1 = new Nodo(termino1);
                nodoRecu.setLiga(nodo1);
                nodoRecu = nodo1;
            
                //System.out.println(termino1.getCoef());
                //System.out.println(termino1.getExp());

                
            }
            polinomio.simplify();
            polinomio.sort();
            return polinomio;   

        }catch (Exception error) {
            System.out.println(error);
            return null;
            }
            
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
 

        
    }
