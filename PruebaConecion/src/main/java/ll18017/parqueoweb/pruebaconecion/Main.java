/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ll18017.parqueoweb.pruebaconecion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            mysConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/parqueo", "postgres", "12345");
            System.out.println("no nos hemos conectado");
            
            String sql="INSERT INTO tipo_espacio (id_tipo_espacio,nombre) VALUES (?,?)";
            stm=mysConnection.prepareStatement(sql);
            stm.setInt(1, 41);
            stm.setString(2, "platzi");
            int rowsAffected = stm.executeUpdate();
            
            if (rowsAffected>0) {
                System.out.println("se creo un nuevo usuario");
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("algo salio mal");
        }
    }
}
