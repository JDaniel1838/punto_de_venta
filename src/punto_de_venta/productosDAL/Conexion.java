/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto_de_venta.productosDAL;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
    String strConexionDB="jdbc:sqlite:C:/Users/Daniel/Documents/NetBeansProjects/Punto_De_Venta/src/db.s3db";
    Connection conn=null;
    
    public Conexion(){//Establece conexion con DB 
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(strConexionDB);
            
            System.out.println("Conexion establecida");
            
        } catch (Exception e) {
            
            System.out.println("Error de Conexion"+e);
        }
    }
    
    public int ejecutarSentenciaSQL (String strSentenciaSQL){//Insertar Datos Return Exito:1 -- Errror:0
         try {
            PreparedStatement pstm= conn.prepareStatement (strSentenciaSQL);
            pstm.execute();
            System.out.println("Dato insertado");
            return 1;
            
         } catch (SQLException e) {//ERROR MANDAR MESSAGE DIALOG
             System.out.println(e);
             return 0;
         }
     }
    
    public ResultSet consultarRegistros (String strSentenciaSQL){//EJECUTA SENTENCIAS Y RETORNA LA RESPUESTA
         try {
              PreparedStatement pstm= conn.prepareStatement(strSentenciaSQL);
              ResultSet respuesta=pstm.executeQuery();
              return respuesta;
  
         } catch (SQLException e) {//NO HAY DATOS O HUBO ERROR
             System.out.println(e);
             return null;
         }
         
     }

}
