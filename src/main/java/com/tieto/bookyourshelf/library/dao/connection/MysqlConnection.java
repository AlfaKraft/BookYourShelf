package com.tieto.bookyourshelf.library.dao.connection;
import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class MysqlConnection {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Unable to load MySQL Driver");

        }
    }

    public Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://192.168.1.201:3306/bys_db", "alfa", "bys1");
        return con;

    }

    public static void main(String[] args) throws Exception {
        //String jdbcUrl = "jdbc:mysql://192.168.1.201:3306/bys_db?user=user&password=bys1";
        Connection con = DriverManager.getConnection("jdbc:mysql://192.168.1.201:3306/bys_db", "alfa", "bys1");
        //Connection con = DriverManager.getConnection(jdbcUrl);
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from books");
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));

        }
        con.close();


    }
}
