
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1037100
 */
public class ConexaoBD {
    
    String driver = "com.mysql.jdbc.Driver";
    String host = "localhost";
    String banco = "pabd";
    String str_con = "jdbc:mysql://"+host+":3306/"+banco;
    String usuario = "root";
    String senha = "";
    
    
    Connection con;
    PreparedStatement estado;
    
    
    public void conectar(){
        
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(str_con, usuario, senha);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Problema ao encontrar o driver");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Problema ao conectar");
        }
        
        
    }
    
    public void fecharConexao(){
        try {
            estado.close();
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao fechar a conexão");
        }
        
    }
    
    
}
