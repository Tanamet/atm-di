package th.ku.db;

import java.sql.*;

public class Sqlite {

    Connection c = null;
    Statement stmt = null;

    public Sqlite(String table){

        try{

            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:" + table + ".sqlite");

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public ResultSet execute(String query){

        try{

            this.stmt = c.createStatement();
            ResultSet re = stmt.executeQuery(query);
            return re;

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;

    }

    public void closeConnection(){
        try {
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
