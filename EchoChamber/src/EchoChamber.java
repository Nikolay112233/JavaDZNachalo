import java.util.ArrayList;
import java.util.Scanner;

public class EchoChamber {

        public static void main(String[] args) {
            Scanner console = new Scanner(System.in);
            ArrayList<String> strings = new ArrayList<>();
            for (int i = 0; i >= 0; i++) {
                String string = console.nextLine();
                strings.add(string);
                if (string == "") {
                    i = -10;
                }
            }
            for (String result : strings) {
                System.out.println(result);
            }
        }
    }
