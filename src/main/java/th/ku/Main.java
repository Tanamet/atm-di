package th.ku;

import config.JavaConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import th.ku.db.Sqlite;

public class Main {

    public static void main(String[] args) {

//        DataSource dataSource = new DataSource("customers.txt");
//        Bank bank = new Bank(dataSource);
//        ATM atm = new ATM(bank);
//        ATMSimulator atmSimulator = new ATMSimulator(atm);
//        atmSimulator.run();

//        ApplicationContext context = new ClassPathXmlApplicationContext("annotation-config.xml");
        ApplicationContext context = new ClassPathXmlApplicationContext("atm-config.xml");
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        ATMSimulator atmSimulator = context.getBean(ATMSimulator.class);

        atmSimulator.run();

    }

}
