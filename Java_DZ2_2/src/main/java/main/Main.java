package main;

import ru.pflb.mq.dummy.implementation.ConnectionImpl;
import ru.pflb.mq.dummy.implementation.DestinationImpl;
import ru.pflb.mq.dummy.implementation.ProducerImpl;
import ru.pflb.mq.dummy.implementation.SessionImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws Exception {

        for (int j = 0; j < 1; j = 0) {
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

            ConnectionImpl connectionimpl = new ConnectionImpl();

            connectionimpl.start();

            SessionImpl sessionImpl = (SessionImpl) connectionimpl.createSession(true);

            DestinationImpl destinationImpl = (DestinationImpl) sessionImpl.createDestination("RazDwaTri");

            ProducerImpl producerimpl = (ProducerImpl) sessionImpl.createProducer(destinationImpl);

            Iterator iterator = customersGeneral.iterator();
            while (iterator.hasNext()) {
                producerimpl.send((String) iterator.next());
                TimeUnit.SECONDS.sleep(2);

            }
            sessionImpl.close();
            connectionimpl.close();

        }
    }
}
