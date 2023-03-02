import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

            Class<?> cls = Class.forName("Main");
            InputStream inputStream = cls.getClassLoader().getResourceAsStream("input.sql");
            assert inputStream != null;
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

            String line = "";
            String[] bloc = line.split("\\n\\n\\n");
            String[] blank = line.split(" ");
            String val = "";
            while((line = br.readLine()) != null) {
            for(String str : bloc) {
                for(String blk : blank) {
                    val += "_";
                }
                val += line + "_";
            }
            }

            List<String> listOfNbs = new ArrayList<>();
            String valeur = (val.substring(1,val.length()-1));

            String[] bar4 = valeur.split("____");
            for(String b : bar4) {
                listOfNbs.add(b);
            }

            Map<Integer, Integer> listOfValues = new HashMap();
            for(int i = 0; i < listOfNbs.size(); i++) {
                String[] bar2 = listOfNbs.get(i).split("__");
                for(String b : bar2) {
                    if(listOfValues.get(i) == null) {
                        listOfValues.put(i, Integer.parseInt(b));
                    } else {
                        listOfValues.put(i, listOfValues.get(i) + Integer.parseInt(b));
                    }
                }
            }

            List<Integer> listOfValuesFinal = new ArrayList<>(listOfValues.values());
            Integer maxValue = Collections.max(listOfValuesFinal);
            Integer minValue = Collections.min(listOfValuesFinal);

            int cnt = 0;
            for(Integer i : listOfValuesFinal) {
                cnt++;
                if(i.equals(maxValue)) {
                    System.out.println("Résultat :");
                    System.out.println("C'est la personne N°" + cnt + " qui transporte le plus de calories avec un total de " + maxValue + " calories.\n");
                } else if(i.equals(minValue)) {
                    System.out.println("Et c'est la personne N°" + cnt + " qui transporte le moins de calories avec un total de " + minValue + " calories.");
                }
            }
    }
}