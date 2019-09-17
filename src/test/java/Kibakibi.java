import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

public class Kibakibi {

    public static void main(String[] args) {

        try {
            String textData = new String(Files.readAllBytes(Paths.get("/home/samim/Downloads/523_m3_assignds_Calculate Maximum Temperature_4.0/Module-3 Assignment Dataset - Calculate Maximum Temperature/Temperature.txt")));

            StringTokenizer tokenizer = new StringTokenizer(textData, "\n");

            while (tokenizer.hasMoreElements()) {

                String[] split = tokenizer.nextToken().trim().split(" ");
                String data = split[0] + ":" + split[1];
                System.out.println(data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
