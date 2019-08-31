package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import th.ku.ATM;
import th.ku.ATMSimulator;
import th.ku.Bank;
import th.ku.DataSource;
import th.ku.db.CustomerDao;
import th.ku.db.Sqlite;

@Configuration
public class JavaConfig {

    @Bean
    public DataSource dataSource(){
//        return new DataSource("customers.txt");
        return new DataSource(new CustomerDao(new Sqlite("atm")));
    }

    @Bean
    public Bank bank(){
        return new Bank(dataSource());
    }

    @Bean
    public ATM atm(){
        return new ATM(bank());
    }

    @Bean
    public ATMSimulator atmSimulator(){
        return new ATMSimulator(atm());
    }

}