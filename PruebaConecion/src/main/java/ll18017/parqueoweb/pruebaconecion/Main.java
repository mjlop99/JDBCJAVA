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
        Statement stm = null;
        ResultSet rs = null;
        
        PreparedStatement pstm = null;

        try {
            mysConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/parqueo", "postgres", "12345");
            System.out.println("no nos hemos conectado");
          
            stm=mysConnection.createStatement();
            int rowsAffected=stm.executeUpdate("UPDATE tipo_espacio"+" set nombre='usuario cambiando de platzi' WHERE id_tipo_espacio='40'");
            
            pstm=mysConnection.prepareStatement("Delete from tipo_espacio WHERE id_tipo_espacio='3'");
            int deleted = pstm.executeUpdate();
            if (deleted>0) {
                System.out.println("se borro registro");
            }
            
            rs=stm.executeQuery("SELECT * FROM tipo_espacio WHERE id_tipo_espacio<='40' order by id_tipo_espacio DESC");
            while(rs.next()) {
                System.out.println(rs.getString("nombre")+" ID:"+rs.getInt(1));
    
            }
            
            
            
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("algo salio mal");
        }
    }
}
