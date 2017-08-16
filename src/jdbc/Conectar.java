package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conectar {
    
    //Conexão SQL Server
//    public Connection connection = null;
//    private final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//    private final String dbname = "db_projetorancho";
//    private final String usuario = "sa";
//    private final String senha = "1234";
//    private final String url = "jdbc:sqlserver://localhost:1433;databaseName="+dbname+";";
    
    
    //Conexão MySQL
    public Connection connection = null;
    private final String driver = "com.mysql.jdbc.Driver";
    private final String usuario = "root";
    private final String senha = "123456";
    private final String url = "jdbc:mysql://localhost:3306/db_projetorancho";
    
    public Connection getConnection(){
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url,usuario,senha);
            return connection;
        }catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Driver não encontrado!");
            return null;
        }catch(SQLException s){
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o Banco de Dados! " + s.getMessage());
            return null;
        }
    }
    public void close(){
        try{
            connection.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro!"+e.getMessage());
        }
    }
}