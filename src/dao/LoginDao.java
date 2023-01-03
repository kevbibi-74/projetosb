/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import model.loginModel;

/**
 *
 * @kevbibi-74

 */
public class LoginDao {

    private java.sql.Connection con;

    public LoginDao() {

        this.con = new conexao().getConnection();

    }

    public void cadastrar(loginModel obj) {
        try {
            String sql = "insert into tb_usuario(nomecard,fun_designer,email,quantidade,qtd_cards,total,tipo,senha)value(?,?,?,?,?,?,?,?)";

            // conectar ao banco e organizar comando sql 
            PreparedStatement stmt = con.prepareStatement(sql);

      
            stmt.setString(1, obj.getNomecard());
            stmt.setString(2, obj.getFun_designer());
            stmt.setString(3, obj.getEmail());
            stmt.setInt(4, obj.getQuantidad());
            stmt.setInt(5, obj.getQntcards());
            stmt.setDouble(6, obj.getTotal());
            stmt.setString(7, obj.getTipo());
            stmt.setString(8, obj.getSenha());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, " Plano cadastrado com Sucesso");
        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "Erro" + erro);
        }

    }

    public void excluir(loginModel obj) {
        try {
            // criação do comando sql    
            String sql = "delete from tb_usuario where id =?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Excluido com Sucesso");
        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "ERRO" + erro);
        }

    }

    
    //metodo listar // importar java.util 

    public List<loginModel> listarCadastro() {

        try {
            // criar a lista // importar javalist 

            List<loginModel> lista = new ArrayList<>();

            // criar comando sql 
            String sql = "select * from tb_usuario";

            PreparedStatement stmt = con.prepareStatement(sql);

            // CLASSE DO JAVA ResultSer quando usar select 
            ResultSet rs = stmt.executeQuery();
            // em quanto ele percorrer 
            while (rs.next()) {

                loginModel obj = new loginModel();

                obj.setId(rs.getInt("id"));
                obj.setNomecard(rs.getString("nomecard"));
                obj.setTipo(rs.getString("tipo"));
                obj.setFun_designer(rs.getString("fun_designer"));                       
                obj.setEmail(rs.getString("email"));
                obj.setQuantidad(rs.getInt("quantidade"));
                obj.setQntcards(rs.getInt("qtd_cards"));
                obj.setTotal(rs.getDouble("total"));
                obj.setSenha(rs.getString("senha"));

                lista.add(obj);
            }
            return lista;
            
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "nome não encontrado "+ erro);
            return null;
        }

    }
     public void alterar(loginModel obj) {
        try {
            String sql = "update tb_usuario set nomecard=?,fun_designer=?,email=?,quantidade=?,qtd_cards=?,total=?,tipo=?,senha=? where id=?";

            // conectar ao banco e organizar comando sql 
            PreparedStatement stmt = con.prepareStatement(sql);

      
            stmt.setString(1, obj.getNomecard());
            stmt.setString(2, obj.getFun_designer());
            stmt.setString(3, obj.getEmail());
            stmt.setInt(4, obj.getQuantidad());
            stmt.setInt(5, obj.getQntcards());
            stmt.setDouble(6, obj.getTotal());
            stmt.setString(7, obj.getTipo());
            stmt.setString(8, obj.getSenha());
            stmt.setInt(9,obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, " alterado com Sucesso");
        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "Erro" + erro);
        }

    }
      public void novoCadastro() {

    }
      public List<loginModel> buscaporNome(String nomecard) {

        try {
            // criar a lista // importar javalist 

            List<loginModel> lista = new ArrayList<>();

            // criar comando sql 
            String sql = "select * from tb_usuario where nomecard like ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nomecard);

            // CLASSE DO JAVA ResultSer quando usar select 
            ResultSet rs = stmt.executeQuery();
            // em quanto ele percorrer 
            while (rs.next()) {

                loginModel obj = new loginModel();

                obj.setId(rs.getInt("id"));
                obj.setNomecard(rs.getString("nomecard"));
                obj.setTipo(rs.getString("tipo"));
                obj.setFun_designer(rs.getString("fun_designer"));                       
                obj.setEmail(rs.getString("email"));
                obj.setQuantidad(rs.getInt("quantidade"));
                obj.setQntcards(rs.getInt("qtd_cards"));
                obj.setTotal(rs.getDouble("total"));
                obj.setSenha(rs.getString("senha"));

                lista.add(obj);
            }
            return lista;
            
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "nome não encontrado "+ erro);
            return null;
        }

    }


}
