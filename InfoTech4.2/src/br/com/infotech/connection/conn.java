
        
package br.com.infotech.connection;
import com.microsoft.sqlserver.jdbc.*;
import  java.sql.*;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Gilberto
 *
 * Antes de tentar fazer a conexão por favor certificar que a porta 1433 e o ip local host esta desbloqueado
 *  no Banco Sql Server, para certificar somente ir as ferramentas administradosras do Sql, caso nao ache ir
 * na url : para SQL Server 2017	C:\Windows\SysWOW64\SQLServerManager14.msc
            para SQL Server 2016	C:\Windows\SysWOW64\SQLServerManager13.msc
            para SQL Server 2014	C:\Windows\SysWOW64\SQLServerManager12.msc
            para SQL Server 2012	C:\Windows\SysWOW64\SQLServerManager11.msc
 * 
 * procurar  configuração de rede sqlServer/ protocolos de rede 'Nome Do seu banco que pretende usar', botao 
 * direito do protocolo tcp/ip /propriedades / endereço ip/ active = sim , anbled = sim, e colocar a port=
 * 1433 em todos protocolos.
 *
 * By Giba 
 * è noiz.. :):):):):):)
 * 
 */
public class conn {

 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

   //declaração dos parametros de conexão , alterações fazer aqui.
    
   private static String DRIVE = "com.microsoft.sqlserver.jdbc.SQLServerDriver";   
   private static String ip  ="127.0.0.1"    ;
   private static String usuario="sa" ;
   private static String senha ="123456" ;
   private static String database ="InfoTech" ;
   private static String porta="1433" ; 

   private static  String stringConnection= "jdbc:sqlserver://"+ip+":"+porta+";datbasename= "+database+";" ;
     
     
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

   
   //Gera conexão e retorna conexão ao Obter COnexão.... NÃO MEXER ESTA FUNCIONANDO!
   private static Connection  getConnection(){       
       
       
           
       try {
           Class.forName(DRIVE);
           return DriverManager.getConnection(stringConnection, usuario ,senha);
       }
       catch (ClassNotFoundException | SQLException ex) {
         JOptionPane.showMessageDialog(null,"Ocorreu Um Erro Na Conexao"+ex);
         return null;
       }
   }
  
   
   //Pede conexão ao getConnection e pega seu retorno
   public static Connection obterConexão(){  
 
   return getConnection();   
   
   }
   
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
   
   //Fecha conexao normalmente... NÃO MEXER ESTA FUNCIONANDO!
   public static void fecharConexao(Connection conn){
     if (conn!=null){
       try {
           conn.close();
       } catch (SQLException ex) {
           
       }
     }   
   }
   
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  
   //fechar conexao com instancias de conexao ,istancias obrigratorias para o uso
      public static void fecharConexao(Connection conn, PreparedStatement stmt, ResultSet rs){
   
          try {
           
           if(stmt != null || conn!= null || rs != rs ){
           stmt.close();
           rs.close();
           conn.close();
           }
           
       } catch (SQLException ex) {
       throw new RuntimeException ("Ocorreu Um Erro :",ex);    
       }
   }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
      
         //fechar conexao com instancias de conexao , istancias obrigratorias para o uso
         public static void fecharConexao(Connection conn, PreparedStatement stmt){
   
          try {
           
           if(stmt != null || conn!= null ){
           stmt.close();
           
           conn.close();
           }
           
       } catch (SQLException ex) {
       throw new RuntimeException ("Ocorreu Um Erro :",ex);    
       }
   }
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  


}

