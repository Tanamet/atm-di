package th.ku.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Sqlite {

    Connection c = null;
    Statement stmt = null;

    public Sqlite(String table){

        try{

            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:" + table + ".sqlite");
            System.out.println("connected");
            c.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

}
