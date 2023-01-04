

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlQuery {
    public static ResultSet getResult(String query) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/game", "root", "root");
            Statement stmt = con.createStatement();
            return stmt.executeQuery(query);

        } catch (Exception e) {
            return null;
        }

    }


    public static boolean UpdateData(String query) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/game", "root", "root");
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
            return true;




        } catch (Exception ignored) {
            return false;
        }

    }

    public static String getValeusFromSQL(String query, String label) {
        String temp = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/game", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                temp = rs.getString(label);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }
    public static int getValuesFromSQL(String query, String label)
    {
        int temp = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/game", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                temp = rs.getInt(label);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

}
