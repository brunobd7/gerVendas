package br.com.bruno.controller;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import br.com.bruno.dao.ClienteDao;
import br.com.bruno.entidade.Cliente;
import br.com.bruno.util.GeradorHtlm;

public class ClienteController extends GeradorHtlm{
	
	public String cadastrarCliente(HttpServletRequest req) {
		try {
			
			String nomeCompleto = req.getParameter("nome");
            String cpf = req.getParameter("cpf");
            String dataNascimento = req.getParameter("dataNascimento");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            
            Cliente c = new Cliente();
            c.setNomeCompleto(nomeCompleto);
            c.setCpf(cpf);
            c.setDataNascimento(new java.sql.Date(sdf.parse(dataNascimento).getTime()));
            
           
            ClienteDao dao = new ClienteDao();
            dao.addCliente(c);
			
			
		} catch (Exception e) {
			
			return "Erro : " +e.getMessage();
		}
		
		
		return "Cadastro Realizado";
		
	}
	
	public String  atualizarCliente(HttpServletRequest req) {
		
		try {
			
			String id = req.getParameter("codigoCliente");
			String nomeCompleto = req.getParameter("nome");
            String cpf = req.getParameter("cpf");
            String dataNascimento = req.getParameter("dataNascimento");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            
            Cliente c = new Cliente();
            c.setId(Integer.parseInt(id));
            c.setNomeCompleto(nomeCompleto);
            c.setCpf(cpf);
            c.setDataNascimento(new java.sql.Date(sdf.parse(dataNascimento).getTime()));
            
           
            ClienteDao dao = new ClienteDao();
            dao.updateCliente(c);
            
            
			
            return "Cadastro de Cliente Atualizado";
            
		} catch (Exception e) {
			return "Erro na atualizaçao " +e.getMessage();
		}
		
	}
	
	public String excluirCliente(HttpServletRequest req) {
		try {
			
			String id = req.getParameter("codigoCliente");
			
			ClienteDao dao = new ClienteDao();
			dao.deleteCliente(Integer.parseInt(id));
			
			return "Exclusão realizada com Sucesso";
		} catch (Exception e) {
			return " Erro na exclusao : "+e.getMessage();
		}
	}
	
	public String getClienteSingle(HttpServletRequest req) {
		try {
			
			String id = req.getParameter("codigoCliente");
			
			ClienteDao dao = new ClienteDao();
				
			return html.getFormAtualizarCliente(dao.listClienteById(Integer.parseInt(id)));
			
		} catch (Exception e) {
			return " Erro na listagem por codigo : "+e.getMessage();
		}
	}
	
	public String getClienteAll() {
		
		try {
			ClienteDao dao = new ClienteDao();
			
			return html.getListCliente(dao.listCliente());
			
			
		} catch (Exception e) {
			return " Erro na listagem dos clientes : "+e.getMessage();
		}
		
	}
	
}