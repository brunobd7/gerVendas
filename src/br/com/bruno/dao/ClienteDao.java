package br.com.bruno.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.bruno.entidade.Cliente;
import br.com.bruno.util.Conexao;

public class ClienteDao {

	private Connection  conexao;

	public ClienteDao() {
		conexao = Conexao.getConnection();
	}

	public void addCliente(Cliente cliente)throws SQLException {
		try {

			PreparedStatement prd = conexao.prepareStatement("insert into cliente(nome_completo,cpf,data_nascimento) values (?,?,?)");

			prd.setString(1, cliente.getNomeCompleto());
			prd.setString(2, cliente.getCpf());
			prd.setDate(3, new java.sql.Date(cliente.getDataNascimento().getTime()));
			prd.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"");
		}

	}

	public void updateCliente(Cliente cliente) {

		try {

			PreparedStatement prd = conexao.prepareStatement(" update cliente set nome_completo=?, cpf=?, data_nascimento=? where id=?");
			
			prd.setString(1, cliente.getNomeCompleto());
			prd.setString(2, cliente.getCpf());
			prd.setDate(3, new java.sql.Date(cliente.getDataNascimento().getTime()));
			prd.setInt(4, cliente.getId());
			prd.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"");
		}
	}
	
	public void deleteCliente(Integer id) {
		
		try {

			PreparedStatement prd = conexao.prepareStatement(" delete from cliente where id=?");
			
			prd.setInt(1, id);
			prd.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"");
		}
		
		
	}
	
	public List<Cliente> listCliente(){
		
		List<Cliente> lista = new ArrayList<Cliente>();
		try {

			Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM cliente");
			
		
            while(rs.next()) {
            	Cliente cliente = new Cliente();
            	
            	cliente.setId(rs.getInt("id"));
            	cliente.setNomeCompleto(rs.getString("nome_completo"));
            	cliente.setCpf(rs.getString("cpf"));
            	cliente.setDataNascimento(rs.getDate("data_nascimento"));
            	lista.add(cliente);
            }
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"");
		}
		
		return lista;
		
		
	}
	
public Cliente listClienteById(Integer id){
		
		Cliente cliente = new Cliente();
		try {

			PreparedStatement prd = conexao.prepareStatement("select * from cliente where id=?");
			prd.setInt(1, id);
			
			ResultSet rs = prd.executeQuery();
		
			if(rs.next()) {
				cliente.setId(rs.getInt("id"));
            	cliente.setNomeCompleto(rs.getString("nome_completo"));
            	cliente.setCpf(rs.getString("cpf"));
            	cliente.setDataNascimento(rs.getDate("data_nascimento"));
            }
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"");
		}
		
		return cliente;
		
		
	}

}
