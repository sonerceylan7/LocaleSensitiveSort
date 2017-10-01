import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
 
public class Sorting {
    public static void main(String[] args) throws IOException {

        String fileName = args[0];
        String localeArgs = args[1];

        String[] locale = localeArgs.split("-");

        List<String> friends = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            String line = br.readLine();

            while (line != null) {
                friends.add(line);
                line = br.readLine();
            }
        } finally {
            br.close();
        }
        Locale trlocale= new Locale(locale[0], locale[1]);
        Collator coll = Collator.getInstance(trlocale);
        coll.setStrength(Collator.PRIMARY);
        Collections.sort(friends, coll);

        try{
            PrintWriter writer = new PrintWriter("sorted.txt", "UTF-8");
            for (String friend : friends) {
                writer.println(friend);
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(friends);
        }
    }
}
