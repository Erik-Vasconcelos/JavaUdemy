
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ConexaoPessoa extends ConexaoBD{
    
    public void inserir(Pessoa p){
        String sql = "insert into pessoa values (?,?,?)";        
        conectar();        
        try {
            estado = con.prepareStatement(sql);
            estado.setString(1, p.getCpf());
            estado.setString(2, p.getNome());
            estado.setInt(3, p.getIdade());
            estado.execute();
            JOptionPane.showMessageDialog(null,"Cadastrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir");
        }
    }
    
}
