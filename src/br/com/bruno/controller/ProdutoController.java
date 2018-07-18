package br.com.bruno.controller;
import javax.servlet.http.HttpServletRequest;

import br.com.bruno.dao.ProdutoDao;
import br.com.bruno.entidade.Produto;
import br.com.bruno.util.GeradorHtlm;

public class ProdutoController extends GeradorHtlm{

	public String cadastrarProduto(HttpServletRequest req) {

		try {

			String nome = req.getParameter("nome");
			String descricao = req.getParameter("descricao");
			String peso = req.getParameter("peso");
			String preco = req.getParameter("preco");

			Produto p = new Produto();

			p.setNome(nome);
			p.setDescricao(descricao);
			p.setPeso(Double.parseDouble(peso));
			p.setPreco(Double.parseDouble(preco));

			ProdutoDao dao = new ProdutoDao();
			dao.addProduto(p);


		} catch (Exception e) {

			return "Erro : " +e.getMessage();
		}


		return "Cadastro Realizado";

	}

	public String atualizarProduto(HttpServletRequest req) {

		try {
			String id= req.getParameter("codigoProduto");
			String nome = req.getParameter("nome");
			String descricao = req.getParameter("descricao");
			String peso = req.getParameter("peso");
			String preco = req.getParameter("preco");

			Produto p = new Produto();

			p.setId(Integer.parseInt(id));
			p.setNome(nome);
			p.setDescricao(descricao);
			p.setPeso(Double.parseDouble(peso));
			p.setPreco(Double.parseDouble(preco));

			ProdutoDao dao = new ProdutoDao();
			dao.updateProduto(p);


		} catch (Exception e) {

			return "Erro : " +e.getMessage();
		}


		return "Atualizaçao Realizada";

	}

	public String removerProduto(HttpServletRequest req) {
		try {

			String id = req.getParameter("codigoProduto");

			ProdutoDao dao = new ProdutoDao();
			dao.deleteProduto(Integer.parseInt(id));

		} catch (Exception e) {

			return "Erro : " +e.getMessage();
		}


		return "Exclusao Realizada";

	}

	public String getProdutoAll() {
		try {

			ProdutoDao dao = new ProdutoDao();

			return html.getListProduto(dao.listProduto());

		} catch (Exception e) {

			return "Erro : " +e.getMessage();
		}
	}

	public String getProdutoSingle(HttpServletRequest req) {
		try {
			String id = req.getParameter("codigoProduto");
			
			ProdutoDao dao = new ProdutoDao();

			return html.getFormAtualizarProduto(dao.listProdutoById(Integer.parseInt(id)));

		} catch (Exception e) {

			return "Erro : " +e.getMessage();
		}



	}
}