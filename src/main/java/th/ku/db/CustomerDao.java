package th.ku.db;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import th.ku.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerDao implements Source {

    private JdbcTemplate db;

    public CustomerDao(JdbcTemplate db){

        this.db = db;

    }

    public Map<Integer, Customer> readCustomers() throws SQLException {

        Map<Integer, Customer> customers = new HashMap<Integer, Customer>();
        String query = "SELECT * FROM customers";

        List<Customer> list_customers = db.query(query, new CustomerMapper());
        for (Customer c: list_customers) {
            customers.put(c.getCustomerNumber(), c);
        }

        return customers;


    }

    class CustomerMapper implements RowMapper<Customer> {
        public Customer mapRow(ResultSet rs, int rowNum)
                throws SQLException {
            int id = rs.getInt("id");
            int pin = rs.getInt("pin");
            double balance = rs.getDouble("balance");

            Customer c = new Customer(id, pin, balance);
            return c;
        }
    }

}
