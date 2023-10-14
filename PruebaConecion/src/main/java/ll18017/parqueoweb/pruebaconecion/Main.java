/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ll18017.parqueoweb.pruebaconecion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mjlopez
 */
public class Main {

    public static void main(String[] args) {
        Connection mysConnection = null;
        Statement stm = null;
        ResultSet rs = null;

        try {
            mysConnection = DriverManager.getConnection("jdbc:mysql//localhost:3306/platziDB", "root", "12345");
            System.out.println("no hemos conectado");
            
            stm=mysConnection.createStatement();
            rs=stm.executeQuery("SELECT * FROM empleados");
            
            while (rs.next()) {
                System.out.println(rs.getString("nombre"));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("algo salio mal");
        }
    }
}
