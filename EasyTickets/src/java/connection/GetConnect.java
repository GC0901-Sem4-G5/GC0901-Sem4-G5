/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Hoang Ha Nguyen
 */
public class GetConnect {

    private Connection conn;

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

//    public Connection getConnection() {
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            String url = "jdbc:sqlserver://TIENDAT;databaseName=EasyTicket";
//            String id = "sa";
//            String pass = "123456";
//            conn = DriverManager.getConnection(url, id, pass);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return conn;
//    }
    
    public Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://INSPIRON-5520\\HUNGVM:1433;databaseName=EasyTicket";
            String id = "sa";
            String pass = "123456";
            conn = DriverManager.getConnection(url, id, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
