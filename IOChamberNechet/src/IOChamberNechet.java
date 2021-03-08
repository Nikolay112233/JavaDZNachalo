import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class IOChamberNechet {

    public static void main(String[] args) {

        try {
            File file = new File(args[0]);
            ArrayList<Customer> customers = new ArrayList<>();
            try (InputStream inputStream = new FileInputStream(file)) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
                String currentLine;
                while ((currentLine = bufferedReader.readLine()) != null) {
                    customers.add(new Customer(currentLine));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            ArrayList<String> customersGeneral = new ArrayList<>();

            for (int i = 0; i < customers.size(); i++) {
                Customer customer = customers.get(i);
                customersGeneral.add(customer.getValues());
            }
            for (int i = 0; i <= customersGeneral.size(); i = i + 2) {
                try {
                    System.out.println(customersGeneral.get(i));
                } catch (IndexOutOfBoundsException e1) {}
            }

        } catch (Exception e) {
            System.out.println("Файл не распознан. Введите ваши сообщения");
            Scanner console = new Scanner(System.in);
            ArrayList<String> strings = new ArrayList<>();
            for (int i = 0; i >= 0; i++) {
                String string = console.nextLine();
                strings.add(string);
                if (string == "") {
                    i = -10;
                }
            }
            for (int i = 0; i <= strings.size(); i = i + 2) {
                try {
                    System.out.println(strings.get(i));
                } catch (IndexOutOfBoundsException e1) {}
            }
        }
    }
}
