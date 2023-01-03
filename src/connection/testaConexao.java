/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import javax.swing.JOptionPane;

/**
 *
 * @kevbibi-74

 */
public class testaConexao {
    public static void main(String[] args) {
        try {
            new conexao().getConnection(); 
            JOptionPane.showMessageDialog(null,"Conectado com sucesso ");
        } catch (Exception erro) {
             JOptionPane.showMessageDialog(null,"erro de conexao " + erro);
        }
        
     
    
    }
}
