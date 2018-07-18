package br.com.bruno.util;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import br.com.bruno.entidade.Cliente;
import br.com.bruno.entidade.Produto;
import br.com.bruno.entidade.Vendas;


public class GeraHtml {
	
	public String getFormAtualizarCliente(Cliente  c) {
        StringBuffer sb = new StringBuffer();

        String strDate = "Null Value";
        if (c.getDataNascimento()!= null) {
            strDate = new SimpleDateFormat("dd/MM/yyyy").format(c.getDataNascimento());
        }
        sb.append("<form action='actions/atualizarCliente.jsp' name='atualizarDados' method='post'>\n");
        sb.append("\t\t<h4>Informacoes de Cliente</h4>"
                + "<div class='form-group'>"
                + "<label>Codigo</label>"
                + "<input class='form-control' required value='" + c.getId()+ "' name='codigoCliente' type='text' readonly='true'  />"
                + "</div>"
                + "<div class='form-group'>"
                + "<label>Nome Completo</label>"
                + "<input class='form-control' required value='" + c.getNomeCompleto() + "' name='nome' type='text'/>"
                + "</div>"
                + "<div class='form-group'>"
                + "<label>CPF</label>"
                + "<input class='form-control' required value='" + c.getCpf() + "' name='cpf' type='text'/>"
                + "</div>"
                + "<div class='form-group'>"
                + "<label>Data Nascimento</label>"
                + "<input class='form-control' required value='"+ c.getDataNascimento() + "' name='dataNascimento' type='date'/>"
                + "<div>"
                + "<hr>"
                + "<input type='submit' class='btn btn-primary' value='Salvar'>");
        sb.append("\t</form>\r\n");
        return sb.toString();
    }
        
    public String getFormAtualizarProduto(Produto p) {
        StringBuffer sb = new StringBuffer();

        sb.append("<form action='actions/atualizarProduto.jsp' name='atualizarDados' method='post'>\n");
        sb.append("\t\t<h4>Informacoes do Produto</h4>"
                + "<div class='form-group'>"
                + "<label>Codigo</label>"
                + "<input class='form-control' required value='" + p.getId()+ "' name='codigoProduto' type='text' readonly='true'  />"
                + "</div>"
                + "<div class='form-group'>"
                + "<label>Nome </label>"
                + "<input class='form-control' required value='" + p.getNome() + "' name='nome' type='text'/>"
                + "</div>"
                + "<div class='form-group'>"
                + "<label>Descricao</label>"
                + "<input class='form-control' required value='" + p.getDescricao() + "' name='descricao' type='text'/>"
                + "</div>"
                + "<div class='form-group'>"
                + "<label>Preco</label>"
                + "<input class='form-control' required value='" + p.getPreco() + "' name='preco' type='text'/>"
                + "</div>"
                + "<div class='form-group'>"
                + "<label>Peso</label>"
                + "<input class='form-control' required value='" + p.getPeso() + "' name='peso' type='text'/>"
                + "</div>"
                + "<hr>"
                + "<input type='submit' class='btn btn-primary' value='Salvar'>");
        sb.append("\t</form>\r\n");
        return sb.toString();
    }
    
    public String getFormAtualizarVenda(Vendas  v) {
        StringBuffer sb = new StringBuffer();

        sb.append("<form action='actions/atualizarVenda.jsp' name='atualizarDados' method='post'>\n");
        sb.append("\t\t<label>Codigo Venda</label>"
        		+ "<input class='form-control' required value='" + v.getId()+"' name='codigoVenda' type='text' readonly='true'  />"
        		+ "<h4>Informacoes do Produto</h4>"
                + "<div class='form-group'>"
                + "<label>Codigo Produto</label>"
                + "<select name=\"idProduto\" class=\"form-control\"><option value=\"\">SELECIONE</option>"
	               
                + "<%\n"
	                +"Class.forName(\"org.postgresql.Driver\").newInstance();\n" 
	                +"String connectionURL = \"jdbc:postgresql://localhost:5432/GerVendas\";\n" 
	                +"Connection connection= DriverManager.getConnection(connectionURL, \"postgres\", \"123456\");\n"
	                +"PreparedStatement psmnt = connection.prepareStatement(\"select * from produto \");\n"
	                +"ResultSet results = psmnt.executeQuery();\n"
	                +"while(results.next()){\n"
	                +"String nomeProduto = results.getString(2);\n"
	                +"String idProduto = results.getString(1);\n"
	                +"%>"

                + "</div>"
                + "<div class='form-group'>"
                + "<label>Valor Unitario</label>"
                + "<input class='form-control' required value='" + v.getValorUnitario() + "' name='valorUnitario' type='text'/>"
                + "</div>"
                + "<div class='form-group'>"
                + "<label>Quantidade Produtos</label>"
                + "<input class='form-control' required value='" + v.getQuantidade() + "' name='quantidadeProduto' type='text'/>"
                + "</div>"
                + "<h4>Informacoes Financeiras</h4>"
                + "<div class='form-group'>"
                + "<label>Desconto</label>"
                + "<input class='form-control' required value='"+ v.getValorDesconto() + "' name='valorDesconto' type='text'/>"
                + "</div>"
                + "<div class='form-group'>"
                + "<label>Quantidade de Parcelas</label>"
                + "<input class='form-control' required value='"+ v.getQtdeParcelas()+ "' name='qtdeParcelas' type='text'/>"
                + "</div>"
                
                + "<h4>Informacoes Cliente</h4>"
                + "<div class='form-group'>"
                + "<label>Nome</label>"
                + "<select name=\"idCliente\" class=\"form-control\"><option value=\"\">SELECIONE</option>"
	               
	                + "<%\n"
		                +"Class.forName(\"org.postgresql.Driver\").newInstance();\n" 
		                +"String conexaoURL = \"jdbc:postgresql://localhost:5432/GerVendas\";\n" 
		                +"Connection conexao= DriverManager.getConnection(conexaoURL, \"postgres\", \"123456\");\n"
		                +"PreparedStatement prd = conexao.prepareStatement(\"select * from cliente \");\n"
		                +"ResultSet rs = prd.executeQuery();\n"
		                +"while(rs.next()){\n"
		                +"String nomeCliente = rs.getString(2);\n"
		                +"String idCliente = rs.getString(1);\n"
		                +"%>"
                + "</div>"
               
                + "<h4>Valores Finais</h4>"
                + "<div class='form-group'>"
                + "<label>Total sem Desconto</label>" 
                + "<input class='form-control' required value='"+v.getTotalSemDesconto() + "' name='totalsDesconto' type='text'>"        
                + "</div>"
                + "<div class='form-group'>"
                + "<label>Valor Desconto</label>" 
                + "<input class='form-control' required value='"+v.getValorDesconto()+ "' name='valorDesconto' type='text'>"        
                + "</div>"
                + "<div class='form-group'>"
                + "<label>Total Com Desconto</label>" 
                + "<input class='form-control' required value='"+v.getTotalComDesconto()+ "' name='totalcDesconto' type='text'>"        
                + "</div>"
                + "<div class='form-group'>"
                + "<label>Valor Parcela Com Desconto</label>" 
                + "<input class='form-control' required value='"+v.getParcelaComDesconto()+ "' name='parcelacDesconto' type='text'>"        
                + "</div>"
                + "<hr>"
                + "<input type='submit' class='btn btn-primary' value='Salvar'>");
        sb.append("\t</form>\r\n");
        return sb.toString();
    }
        
    public String getListCliente(List lista) {
        StringBuffer sb = new StringBuffer();
        
        for (Iterator it = lista.iterator(); it.hasNext();) {
            String strDate;
            Cliente c = (Cliente) it.next();
            strDate = "Null Value";
            if (c.getDataNascimento()!= null) {
                strDate = new SimpleDateFormat("dd/MM/yyyy").format(c.getDataNascimento());
            }
            sb.append("<li>"
                    + "<span class='booking-item'>"
                    + "<div class='row'>"
                    + "<div class='col-md-3'>"
                    + "<h4>Nome:"+ c.getNomeCompleto() +"</h4>"
                    + "<p class='booking-item-car-title'>CPF:" + c.getCpf() + "</p>"
                    + "<p class='booking-item-car-title'>Data Nascimento: '" + strDate + "'</p><br>" 
                    + "</div>"
                    + "<div class='col-md-3'><br>"
                    + "<a href='formAtualizarCliente.jsp?codigoCliente="+c.getId()+"' class='btn btn-primary'>Editar</a>"
                    + "<a href='actions/excluirCliente.jsp?codigoCliente="+c.getId()+"' class='btn btn-primary'>Excluir</a>"   
                    + "</div></div></span>"
                    + "</li>");
        }
        return sb.toString();
    }
    
    
    public String getListProduto(List lista) {
        StringBuffer sb = new StringBuffer();
        
        for (Iterator it = lista.iterator(); it.hasNext();) {
            Produto p =(Produto) it.next();
            
        
            sb.append("<li>"
                    + "<span class='booking-item'>"
                    + "<div class='row'>"
                    + "<div class='col-md-3'>"
                    + "<h4>Nome:"+ p.getNome() +"</h4>"
                    + "<p class='booking-item-car-title'>Descricao:" + p.getDescricao() + "</p>"
                    + "<p class='booking-item-car-title'>Peso:" + p.getPeso()+ "</p>"
                    + "<p class='booking-item-car-title'>Preco:" + p.getPreco() + "</p>"
                    + "</div>"
                    + "<div class='col-md-3'><br>"
                    + "<a href='formAtualizarProduto.jsp?codigoProduto="+p.getId()+"' class='btn btn-primary'>Editar</a>"
                    + "<a href='actions/excluirProduto.jsp?codigoProduto="+p.getId()+"' class='btn btn-primary'>Excluir</a>"   
                    + "</div></div></span>"
                    + "</li>");
        }
        return sb.toString();
    }
    
    public String getListVendas(List lista) {
        StringBuffer sb = new StringBuffer();
        
        for (Iterator it = lista.iterator(); it.hasNext();) {
            Vendas v = (Vendas) it.next();
            
        
            sb.append("<li>"
                    + "<span class='booking-item'>"
                    + "<div class='row'>"
                    + "<div class='col-md-3'>"
                    + "<h4>ID Venda:"+ v.getId()+"</h4>"
                    + "<p class='booking-item-car-title'>Codigo do Produto:" + v.getIdProduto() + "</p>"
                    + "<p class='booking-item-car-title'>Codigo do Cliente:" + v.getIdCliente() + "</p>"
                    + "<p class='booking-item-car-title'>Quantidade Produtos :" + v.getQuantidade()+ "</p>"
                    + "<p class='booking-item-car-title'>Preco Produto:" + v.getValorUnitario() + "</p>"
                    + "<p class='booking-item-car-title'>Total sem Desconto:" + v.getTotalSemDesconto() + "</p>"
                    + "<p class='booking-item-car-title'>Valor do Desconto:" + v.getValorDesconto() + "</p>"
                    + "<p class='booking-item-car-title'>Total com Desconto:" + v.getTotalComDesconto()+ "</p>"
                    + "<p class='booking-item-car-title'>Valor da Parcela com Desconto:" + v.getParcelaComDesconto() + "</p>"
                    + "</div>"
                    + "<div class='col-md-3'><br>"
                    + "<a href='formAtualizarVenda.jsp?codigoVenda="+v.getId()+"' class='btn btn-primary'>Editar</a>"
                    + "<a href='actions/excluirVenda.jsp?codigoVenda="+v.getId()+"' class='btn btn-primary'>Excluir</a>"   
                    + "</div></div></span>"
                    + "</li>");
        }
        return sb.toString();
    }
}
