/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conexionBD;
import java.sql.*;
import javax.swing.JOptionPane;
 
/**
 * Clase que permite conectar con la base de datos
 * @author chenao
 *
 */
public class DbConnection {
   /**Parametros de conexion*/
   static String bd = "Secundaria";
   static String login = "postgres";
   static String password = "edsc14";
   static String url = "jdbc:postgresql://localhost:5432/****".replace("****", bd);
 
   Connection connection = null;
 
   /** Constructor de DbConnection */
   public DbConnection() {
      try{
         //obtenemos el driver de para mysql
         Class.forName("org.postgresql.Driver");
         //obtenemos la conexión
          //System.out.println(url);
         connection = DriverManager.getConnection(url,login,password);
 
         
      }
      catch(SQLException e){
         JOptionPane.showMessageDialog(null,e.getSQLState(),"no se pudo conectar la Base de Datos Topicos ", 0);
      }catch(ClassNotFoundException e){
         JOptionPane.showMessageDialog(null,e.getMessage(),"no se pudo conectar la Base de Datos Topicos ", 0);
      }catch(Exception e){
         JOptionPane.showMessageDialog(null,e.getMessage(),"no se pudo conectar la Base de Datos Topicos ", 0);
      }
   }
   
   /**Permite retornar la conexión*/
   public Connection getConnection(){
      return connection;
   }
 
   public void desconectar(){
      connection = null;
   }
   
}