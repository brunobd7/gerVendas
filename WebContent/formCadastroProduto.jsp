<jsp:useBean id="controller" class="br.com.bruno.controller.ProdutoController"/>
<%@include file="/commons/head.jsp" %>
<body>
   <div class="global-wrap">
      <%@include file="/commons/header.jsp" %>
      <div class="container">
         <h1 class="page-title">Cadastro de Produtos</h1>
      </div>
      <div class="container">
         <div class="row">
            <div class="col-md-14">
               <div class="row">
                  <div class="col-md-10">
                    <form action="actions/cadastrarProduto.jsp" name="cadastrarProduto" method="post">
                        <h4>Informações do Produto</h4>
                        <div class="form-group">
                           <label>Nome</label>
                           <input class="form-control" required type="text" name="nome" />
                        </div>
                        <div class="form-group">
                           <label>Descricao</label>
                           <input class="form-control" required type="text" name="descricao" />
                        </div> 
                        <div class="form-group">
                           <label>Peso</label>
                           <input class="form-control" required type="text" name="peso" />
                        </div> 
                         <div class="form-group">
                           <label>Preco</label>
                           <input class="form-control" required type="text" name="preco" />
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