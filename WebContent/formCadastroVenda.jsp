<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<jsp:useBean id="controller" class="br.com.bruno.controller.VendasController"/>
<jsp:useBean id="controllerCliente" class="br.com.bruno.controller.ClienteController"/>
<jsp:useBean id="controllerProoduto" class="br.com.bruno.controller.ProdutoController"/>

<%@include file="/commons/head.jsp" %>
<body>
   <div class="global-wrap">
      <%@include file="/commons/header.jsp" %>
      <div class="container">
         <h1 class="page-title">Cadastro de Vendas</h1>
      </div>
      <div class="container">
         <div class="row">
            <div class="col-md-14">
               <div class="row">
                  <div class="col-md-10">
                    <form action="actions/cadastrarVenda.jsp" name="cadastrarVenda" method="post">
                    	<h4>Informações do Produto</h4>
                        
                        <div class="form-group">
                           <label>Nome</label>
                           <select name="codigoProduto" class="form-control">
                           <option value="">SELECIONE</option>
                           <%
	                        Class.forName("org.postgresql.Driver").newInstance();
	                        String conexaoUrl = "jdbc:postgresql://localhost:5432/GerVendas";
	                        Connection conexao= DriverManager.getConnection(conexaoUrl,"postgres" ,"123456" );
	                        PreparedStatement prd = conexao.prepareStatement("select * from produto");
	                        ResultSet rs = prd.executeQuery();
	                        while(rs.next()){
	                        
	                        String nomeProduto = rs.getString(2);
	                        String idProduto = rs.getString(1);
                       		 %>
                       		<option value="<%=idProduto%>"><%=nomeProduto%></option>
                       		<%} 
	                        rs.close();
                       		prd.close();
                       		%>
                           </select>
                        </div>
                        <div class="form-group">
                        	<label>Valor Unitario</label>
                        	<input class="form-control" required type="text" name="valorUnitario" >
                        </div>
                        <div class="form-group">
                        	<label>Quantidade</label>
                        	<input class="form-control" required type="text" name="quantidadeProduto">
                        </div>
                        
                        <h4>Informações Financeiras</h4>
                        
                        <div class="form-group">
                           <label>Desconto</label>
                           <input class="form-control" required type="text" name="valorDesconto">
                        </div>
                        <div class="form-group">
                           <label>Quantidade de Parcelas</label>
                           <input class="form-control" required type="text" name="qtdeParcelas">
                        </div>
                        
                        <h4>Informações do Cliente</h4>
                        <div class="form-group">
                           <label>Nome</label>
                           <select name="codigoCliente" class="form-control">
                           <option value="">SELECIONE</option>
                           <%
	                        Class.forName("org.postgresql.Driver").newInstance();
	                        String connectionURL = "jdbc:postgresql://localhost:5432/GerVendas";
	                        Connection connection= DriverManager.getConnection(connectionURL,"postgres" ,"123456" );
	                        PreparedStatement psmnt = connection.prepareStatement("select * from cliente");
	                        ResultSet results = psmnt.executeQuery();
	                        while(results.next()){
	                        	
	                        String clienteNomeCompleto = results.getString(2);
	                        String idcliente = results.getString(1);
                       		 %>
                       		<option value="<%=idcliente%>"><%=clienteNomeCompleto%></option>
                       		<%} 
	                        results.close();
                       		psmnt.close();
                       		%>
                           </select>
                        </div>
                        <%-- <div class="form-group">
                           <label>CPF</label>
                           <select name="codigoCliente" class="form-control">
                           <option value="">SELECIONE</option>
                           <%
	                        Class.forName("org.postgresql.Driver").newInstance();
	                        String connectionURLL = "jdbc:postgresql://localhost:5432/GerVendas";
	                        Connection connectionn= DriverManager.getConnection(connectionURL,"postgres" ,"123456" );
	                        PreparedStatement psmntt = connection.prepareStatement("select * from cliente");
	                        ResultSet resultss = psmntt.executeQuery();
	                        while(resultss.next()){
	                        	
	                        String cpfCliente = resultss.getString(3);
	                        String idcliente = resultss.getString(1);
                       		 %>
                       		<option value="<%=idcliente%>"><%=cpfCliente%></option>
                       		<%} 
	                        results.close();
                       		psmnt.close();
                       		%>
                           </select> 
                        </div> 
                        --%>
                        
                         <h4>Valores Finais</h4>
                        
                        <div class="form-group">
                           <label>Total sem Desconto</label>
                           <input class="form-control" required type="text" name="totalsDesconto">
                        </div>
                        <div class="form-group">
                           <label>Valor Desconto</label>
                           <input class="form-control" required type="text" name="valorDesconto">
                        </div>
                        <div class="form-group">
                           <label>Total Com Desconto</label>
                           <input class="form-control" required type="text" name="totalcDesconto">
                        </div>
                        <div class="form-group">
                           <label>Valor Parcela com Desconto</label>
                           <input class="form-control" required type="text" name="parcelacDesconto">
                        </div>
                        <div>
                           <hr>
                           <input type="submit" class="btn btn-primary" value="Salvar">
                        </div>
                    </form>
                  </div>
                 
               </div>
            </div>
         </div>
      </div>
   </div>
</body>
</html>