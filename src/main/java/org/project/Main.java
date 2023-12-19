package org.project;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbcdemo";
        String user = "user";
        String password = "123";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
//            System.out.println(connection.getCatalog());
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM product";
            ResultSet result = statement.executeQuery(query);
            ArrayList<Integer> ids = new ArrayList<>();
            ArrayList<String> names = new ArrayList<>();
            ArrayList<Float> prices = new ArrayList<>();
            ArrayList<Timestamp> timestamps = new ArrayList<>();
            while (result.next()){
                int id = result.getInt(1);
                String name = result.getString(2);
                float price = result.getFloat(3);
                Timestamp time = result.getTimestamp(4);
                System.out.println(
                        id
                        +" "+name
                        +" "+price
                        +" "+time
                );
                ids.add(id); names.add(name); prices.add(price); timestamps.add(time);
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
