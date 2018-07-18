package br.com.bruno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.bruno.entidade.Vendas;
import br.com.bruno.util.Conexao;

public class VendasDao {

	private Connection conexao;

	public VendasDao() {
		super();

		conexao= Conexao.getConnection();
	}


	public void addVendas(Vendas venda)throws SQLException {

		try {
			PreparedStatement prd = conexao.prepareStatement("INSERT INTO vendas(desconto,qtde_parcelas,codigo_produto,codigo_cliente,qtde_produto"
					+ "totalc_desconto,valor_desconto,totals_desconto,parcelac_desconto, valor_unitario) values(?,?,?,?,?,?,?,?,?,?)");

			prd.setInt(1, venda.getDesconto());
			prd.setInt(2, venda.getQtdeParcelas());
			prd.setInt(3, venda.getIdProduto());
			prd.setInt(4, venda.getIdCliente());
//			prd.setInt(3, venda.getProduto().getId());
//			prd.setInt(4, venda.getCliente().getId());
			prd.setInt(5, venda.getQuantidade());

			prd.setDouble(6, venda.getTotalComDesconto());
			prd.setDouble(7, venda.getValorDesconto());
			prd.setDouble(8,  venda.getTotalSemDesconto());
			prd.setDouble(9, venda.getParcelaComDesconto());
			prd.setDouble(10, venda.getValorUnitario());

			prd.executeUpdate();
		}catch (SQLException e) {
			System.out.println("Erro no metodo addVendas : " + e.getMessage());
		}
	}

	public void updateVendas(Vendas venda)throws SQLException{

		try {

			PreparedStatement prd = conexao.prepareStatement("UPDATE vendas SET desconto=?,qtde_parcelas=?,codigo_produto=?,codigo_cliente=?,qtde_produto=?" + 
					"totalc_desconto=?,valor_desconto=?,totals_desconto=?,parcelac_desconto=?,valor_unitario=? WHERE id=?");

			prd.setInt(1, venda.getDesconto());
			prd.setInt(2, venda.getQtdeParcelas());
			prd.setInt(3, venda.getIdProduto());
			prd.setInt(4, venda.getIdCliente());
//			prd.setInt(3, venda.getProduto().getId());
//			prd.setInt(4, venda.getCliente().getId());
			prd.setInt(5, venda.getQuantidade());

			prd.setDouble(6, venda.getTotalComDesconto());
			prd.setDouble(7, venda.getValorDesconto());
			prd.setDouble(8,  venda.getTotalSemDesconto());
			prd.setDouble(9, venda.getParcelaComDesconto());
			prd.setDouble(10, venda.getValorUnitario());

		} catch (SQLException e) {
			System.out.println("Erro no metodo updateVendas : " + e.getMessage());
		}
	}

	public void deleteVendas(Integer id) throws SQLException {
		try {

			PreparedStatement prd = conexao.prepareStatement("DELETE FROM vendas WHERE id=?");
			prd.setInt(1, id);
			prd.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Erro no metodo DELETAR : " + e.getMessage());
		}


	}

	public List<Vendas> listVendas(){
		List<Vendas> lista = new ArrayList<Vendas>();

		try {
			Statement stm = conexao.createStatement();
			ResultSet rs =  stm.executeQuery(" SELECT * FROM vendas ");

			while(rs.next()) {
				Vendas vendas = new Vendas();
//				ProdutoDao produtoDao = new ProdutoDao();
//				ClienteDao clienteDao = new ClienteDao();

				vendas.setId(rs.getInt("id"));
				vendas.setDesconto(rs.getInt("desconto"));
				vendas.setQtdeParcelas(rs.getInt("qtde_parcelas"));
				vendas.setIdProduto(rs.getInt("codigo_produto"));
				vendas.setIdCliente(rs.getInt("codigo_cliente"));
//				vendas.setProduto(produtoDao.listProdutoById(rs.getInt("id")));
//				vendas.setCliente(clienteDao.listClienteById(rs.getInt("id")));
				vendas.setQuantidade(rs.getInt("qtde_produto"));
				vendas.setTotalComDesconto(rs.getDouble("totalc_desconto"));
				vendas.setValorDesconto(rs.getDouble("valor_desconto"));
				vendas.setTotalSemDesconto(rs.getDouble("totals_desconto"));
				vendas.setParcelaComDesconto(rs.getDouble("parcelac_desconto"));
				vendas.setValorUnitario(rs.getDouble("valor_unitario"));

				lista.add(vendas);
			}

		} catch (SQLException e) {
			System.out.println("Erro no metodo listVendas : " + e.getMessage());
		}

		return lista;
	}

	public Vendas listVendasById(int id) {
		Vendas vendas = new Vendas();
		try {
			PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM vendas WHERE id=?");
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
//				ProdutoDao produtoDao = new ProdutoDao();
//				ClienteDao clienteDao = new ClienteDao();

				vendas.setId(rs.getInt("id"));
				vendas.setDesconto(rs.getInt("desconto"));
				vendas.setQtdeParcelas(rs.getInt("qtde_parcelas"));
				vendas.setIdProduto(rs.getInt("codigo_produto"));
				vendas.setIdCliente(rs.getInt("codigo_cliente"));
//				vendas.setProduto(produtoDao.listProdutoById(rs.getInt("id")));
//				vendas.setCliente(clienteDao.listClienteById(rs.getInt("id")));
				vendas.setQuantidade(rs.getInt("qtde_produto"));
				vendas.setTotalComDesconto(rs.getDouble("totalc_desconto"));
				vendas.setValorDesconto(rs.getDouble("valor_desconto"));
				vendas.setTotalSemDesconto(rs.getDouble("totals_desconto"));
				vendas.setParcelaComDesconto(rs.getDouble("parcelac_desconto"));
				vendas.setValorUnitario(rs.getDouble("valor_unitario"));
			}
		} catch (SQLException e) {
			System.out.println("Erro no metodo listTodosVendasById : " + e.getMessage());
		}

		return vendas;
	}    
}
