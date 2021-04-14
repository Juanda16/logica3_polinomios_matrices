
/**Examples:
52x^2 + 25x^1 + 65  ok
52x^2 + 25x^1 - 65  ok
52x^2-25x^1-65      java.lang.NumberFormatException: For input string: "2-25"
34x^4-345x^3 +12x^2+ 123x + 0  java.lang.NumberFormatException: For input string: "4-345"
25x2 + 10x + 20 ok
*/

public class StringToPolinomio {

    int[] polinomio;

    public StringToPolinomio(String rawPolinomio) {

        try {
            String parts[] = rawPolinomio.split("x\\^|\\+|\\ +|\\+ |x| ");
            int j = 0;
            polinomio = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {

                // System.out.println(parts[i]);
                if (parts[i].equals("-")) {
                    parts[i] = parts[i] + parts[i + 1];
                    parts[i + 1] = "";
                }

                if (parts[i] != "" && !parts[i].equals("-") && parts[i] != " ") {

                    polinomio[j] = Integer.parseInt(parts[i]);
                    System.out.println(polinomio[j]);
                    j++;
                }

            }

        } catch (Exception error) {
            System.out.println(error);
        }

    }

}
