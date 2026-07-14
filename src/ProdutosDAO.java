/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public boolean cadastrarProduto (ProdutosDTO produto){
        
        boolean sucesso = false;
        
        try {
            conn = new conectaDAO().connectDB();
            
            if (conn == null) {
                return false;
            }
            
            String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";
            prep = conn.prepareStatement(sql);
            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor());
            prep.setString(3, produto.getStatus());
            
            prep.executeUpdate();
            sucesso = true;
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto: " + erro.getMessage());
        } finally {
            try {
                if (prep != null) prep.close();
                if (conn != null) conn.close();
            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + erro.getMessage());
            }
        }
        
        return sucesso;
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        listagem = new ArrayList<>();
        
        try {
            conn = new conectaDAO().connectDB();
            
            if (conn == null) {
                return listagem;
            }
            
            String sql = "SELECT id, nome, valor, status FROM produtos";
            prep = conn.prepareStatement(sql);
            resultset = prep.executeQuery();
            
            while (resultset.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(resultset.getInt("id"));
                produto.setNome(resultset.getString("nome"));
                produto.setValor(resultset.getInt("valor"));
                produto.setStatus(resultset.getString("status"));
                listagem.add(produto);
            }
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar produtos: " + erro.getMessage());
        } finally {
            try {
                if (resultset != null) resultset.close();
                if (prep != null) prep.close();
                if (conn != null) conn.close();
            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + erro.getMessage());
            }
        }
        
        return listagem;
    }
    
    public boolean venderProduto(int id){
        
        boolean sucesso = false;
        
        try {
            conn = new conectaDAO().connectDB();
            
            if (conn == null) {
                return false;
            }
            
            String sql = "UPDATE produtos SET status = ? WHERE id = ?";
            prep = conn.prepareStatement(sql);
            prep.setString(1, "Vendido");
            prep.setInt(2, id);
            
            int linhasAfetadas = prep.executeUpdate();
            sucesso = linhasAfetadas > 0;
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao vender produto: " + erro.getMessage());
        } finally {
            try {
                if (prep != null) prep.close();
                if (conn != null) conn.close();
            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + erro.getMessage());
            }
        }
        
        return sucesso;
    }
    
}

