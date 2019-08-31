package th.ku.db;

import th.ku.Customer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

public interface Source {

    public Map<Integer, Customer> readCustomers() throws FileNotFoundException, IOException, SQLException;

}
