package th.ku;

import org.springframework.stereotype.Component;
import th.ku.db.Source;
import th.ku.db.TextFileReader;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Component
public class DataSource {

    private Source source;

    public DataSource() {
        this.source = new TextFileReader("customers.txt");

    }

    public DataSource(Source source){
        this.source = source;
    }

    /**
     * @param filename the name of the customer file
     */
    public DataSource(String filename) {
        this.source = new TextFileReader(filename);
    }

    /**
     * Reads the customer numbers and pins
     * and initializes the bank accounts.
     */
//    public Map<Integer, Customer> readCustomers() throws IOException {
//        Map<Integer, Customer> customers = new HashMap<Integer, Customer>();
//
//        Scanner in = new Scanner(new FileReader(filename));
//        while (in.hasNext()) {
//            int number = in.nextInt();
//            int pin = in.nextInt();
//            double currentBalance = in.nextDouble();
//            Customer c = new Customer(number, pin, currentBalance);
//            customers.put(c.getCustomerNumber(), c);
//        }
//        in.close();
//        return customers;
//    }

    public Map<Integer, Customer> readCustomers() throws IOException, SQLException {

        return source.readCustomers();

    }

}
