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
