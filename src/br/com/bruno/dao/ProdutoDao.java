package br.com.bruno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.bruno.entidade.Produto;
import br.com.bruno.util.Conexao;

public class ProdutoDao {
	
	public Connection conexao;

	public ProdutoDao() {
		super();
		conexao = Conexao.getConnection();
	}
	
	
	public void addProduto(Produto produto)throws SQLException {
		try {
			PreparedStatement prd = conexao.prepareStatement("INSERT INTO produto(nome,descricao,peso,preco) VALUES (?,?,?,?)" );
			
			prd.setString(1, produto.getNome());
			prd.setString(2, produto.getDescricao());
			prd.setDouble(3, produto.getPeso());
			prd.setDouble(4, produto.getPreco());
			
			prd.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Erro na transaçao com o banco " + e.getMessage());
		}
	}
	
	public void updateProduto(Produto produto)throws SQLException{
		
		try {
			PreparedStatement prd = conexao.prepareStatement("UPDATE produto SET nome=?,descricao=?,peso=?,preco=? WHERE id=?");
			
			prd.setString(1, produto.getNome());
			prd.setString(2, produto.getDescricao());
			prd.setDouble(3, produto.getPeso());
			prd.setDouble(4, produto.getPreco());
			prd.setInt(5, produto.getId());
			
			prd.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Erro na transaçao de UPDATE com o banco " + e.getMessage());
		}
		
	}
	
	public void deleteProduto(Integer id) {
		
		try {
			PreparedStatement prd = conexao.prepareStatement("DELETE FROM produto WHERE id=?");

			prd.setInt(1, id);
			prd.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Erro na transaçao com o banco " + e.getMessage());
		}
		
	}
	
	public List<Produto> listProduto(){
		List<Produto> lista = new ArrayList<Produto>();
		
		try {
			Statement stm= conexao.createStatement();
			ResultSet rs= stm.executeQuery("SELECT * FROM produto");
			
			while(rs.next()) {
				
				Produto produto = new Produto();
				
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setPeso(rs.getDouble("peso"));
				produto.setPreco(rs.getDouble("preco"));
				
				lista.add(produto);
				
			}
			
			
		} catch (SQLException e) {
			System.out.println("Erro na transaçao com o banco " + e.getMessage());
		}
		
		return lista;
		
	}
	
	public Produto listProdutoById(Integer id){
		
		Produto produto= new Produto();
		
		try {
			PreparedStatement prd = conexao.prepareStatement("SELECT * FROM produto WHERE id=?");
			prd.setInt(1, id);
			ResultSet rs= prd.executeQuery();
			
			while(rs.next()) {
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setPeso(rs.getDouble("peso"));
				produto.setPreco(rs.getDouble("preco"));
				
			}
			
			
		} catch (SQLException e) {
			System.out.println("Erro na transaçao com o banco " + e.getMessage());
		}
		
		return produto;
		
	}

}
