package main;

public class Customer {

    private String values;

    public Customer(String line) {
        String[] customer = line.split("\n");
        values = customer[0];
    }
    public String getValues() {
        return values;
    }
}