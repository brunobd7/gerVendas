package br.com.bruno.controller;

import javax.servlet.http.HttpServletRequest;

import br.com.bruno.dao.ClienteDao;
import br.com.bruno.dao.ProdutoDao;
import br.com.bruno.dao.VendasDao;
import br.com.bruno.entidade.Vendas;
import br.com.bruno.util.GeradorHtlm;

public class VendasController extends GeradorHtlm{

	public String adicionarVenda(HttpServletRequest req) {

		try {

			String desconto = req.getParameter("desconto");
			String qtdeParcelas= req.getParameter("qtdeParcelas");
			String codigoProduto = req.getParameter("codigoProduto");
			String codigoCliente = req.getParameter("codigoCliente");
			String quantidade = req.getParameter("quantidadeProduto");
			String totalComDesconto = req.getParameter("totalcDesconto");
			String valorDesconto = req.getParameter("valorDesconto");
			String totalSemDesconto= req.getParameter("totalsDesconto");
			String parcelaComDesconto = req.getParameter("parcelacDesconto");
			String valorUnitario = req.getParameter("valorUnitario");

			//			ClienteDao clienteDao = new ClienteDao();
			//			ProdutoDao produtoDao = new ProdutoDao();

			Vendas v = new Vendas();
			v.setDesconto(Integer.parseInt(desconto));
			v.setQtdeParcelas(Integer.parseInt(qtdeParcelas));
			v.setQuantidade(Integer.parseInt(quantidade));
			v.setIdProduto(Integer.parseInt(codigoProduto));
			v.setIdCliente(Integer.parseInt(codigoCliente));
			
			v.setTotalComDesconto(Integer.parseInt(totalComDesconto));
			v.setValorDesconto(Integer.parseInt(valorDesconto));
			v.setTotalSemDesconto(Integer.parseInt(totalSemDesconto));
			v.setParcelaComDesconto(Integer.parseInt(parcelaComDesconto));
			v.setValorUnitario(Integer.parseInt(valorUnitario));

			VendasDao dao = new VendasDao();
			dao.addVendas(v);


			return "Cadastro realizado com sucesso ";

		} catch (Exception e) {
			return "Erro adicionar na controller: " + e.getMessage();
		}

	}

	public String updateVenda(HttpServletRequest req) {


		try {

			String id = req.getParameter("id");
			String desconto = req.getParameter("desconto");
			String qtdeParcelas= req.getParameter("qtdeParcelas");
			String codigoProduto = req.getParameter("codigoProduto");
			String codigoCliente = req.getParameter("codigoCliente");
			String quantidade = req.getParameter("quantidadeProduto");
			
			String totalComDesconto = req.getParameter ("totalcDesconto");
			String valorDesconto = req.getParameter("valorDesconto");
			String totalSemDesconto= req.getParameter("totalsDesconto");
			String parcelaComDesconto = req.getParameter("parcelacDesconto");
			String valorUnitario = req.getParameter("valorUnitario");

			//			ClienteDao clienteDao = new ClienteDao();
			//			ProdutoDao produtoDao = new ProdutoDao();

			Vendas v = new Vendas();

			v.setId(Integer.parseInt(id));
			v.setDesconto(Integer.parseInt(desconto));
			v.setQtdeParcelas(Integer.parseInt(qtdeParcelas));
			v.setQuantidade(Integer.parseInt(quantidade));
			v.setIdProduto(Integer.parseInt(codigoProduto));
			v.setIdCliente(Integer.parseInt(codigoCliente));
			v.setTotalComDesconto(Integer.parseInt(totalComDesconto));
			v.setValorDesconto(Integer.parseInt(valorDesconto));
			v.setTotalSemDesconto(Integer.parseInt(totalSemDesconto));
			v.setParcelaComDesconto(Integer.parseInt(parcelaComDesconto));
			v.setValorUnitario(Integer.parseInt(valorUnitario));

			VendasDao dao = new VendasDao();
			dao.updateVendas(v);


			return "Atualizaçao realizada com sucesso ";

		} catch (Exception e) {
			return "Erro controller em atualizar: " + e.getMessage();
		}
	}

	public String removerVenda(HttpServletRequest req) {

		try {

			String id = req.getParameter("id");

			VendasDao dao = new VendasDao();
			dao.deleteVendas(Integer.parseInt(id));

			return "Exclusao de Venda realizada";

		} catch (Exception e) {
			return "Erro controller em remover: " + e.getMessage();
		}
	}

	public String getVendasAll() {

		try {

			VendasDao dao = new VendasDao();
			return html.getListVendas(dao.listVendas());

		} catch (Exception e) {
			return "Erro controller em Listar todas as vendas : " + e.getMessage();
		}

	}
	
	public String getVendasSingle(HttpServletRequest req) {

		try {
			
			String id = req.getParameter("codigoVenda");
			VendasDao dao = new VendasDao();
			return html.getFormAtualizarVenda(dao.listVendasById(Integer.parseInt(id)));

		} catch (Exception e) {
			return "Erro controller em remover: " + e.getMessage();
		}

	}

}