package th.ku.db;

import th.ku.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CustomerDao implements Source {

    private Sqlite db;

    public CustomerDao(Sqlite db){

        this.db = db;

    }

    public Map<Integer, Customer> readCustomers() throws SQLException {

        Map<Integer, Customer> customers = new HashMap<Integer, Customer>();
        String query = "SELECT * FROM customers";

        ResultSet rs = this.db.execute(query);
        while (rs.next()) {

            int id = rs.getInt("id");
            int pin = rs.getInt("pin");
            double balance = rs.getDouble("balance");

            Customer c = new Customer(id, pin, balance);
            customers.put(c.getCustomerNumber(), c);

        }

        return customers;


    }

    protected void finalize(){

        this.db.closeConnection();

    }

}
