package main;

import ru.pflb.mq.dummy.implementation.ConnectionImpl;
import ru.pflb.mq.dummy.implementation.DestinationImpl;
import ru.pflb.mq.dummy.implementation.ProducerImpl;
import ru.pflb.mq.dummy.implementation.SessionImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws Exception {

        List<String> messages = new ArrayList<>();
        messages.add("Раз");
        messages.add("Два");
        messages.add("Три");

        ConnectionImpl connectionimpl = new ConnectionImpl();

        connectionimpl.start();

        SessionImpl sessionImpl = (SessionImpl) connectionimpl.createSession(true);

        DestinationImpl destinationImpl = (DestinationImpl) sessionImpl.createDestination("RazDwaTri");

        ProducerImpl producerimpl = (ProducerImpl) sessionImpl.createProducer(destinationImpl);

        Iterator iterator = messages.iterator();
        while (iterator.hasNext()) {
            producerimpl.send((String) iterator.next());
            TimeUnit.SECONDS.sleep(2);
        }
        sessionImpl.close();
        connectionimpl.close();

    }
}
