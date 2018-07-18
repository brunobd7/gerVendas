<jsp:useBean id="controller" class="br.com.bruno.controller.ClienteController"/>
<%@include file="/commons/head.jsp" %>
<body>
   <div class="global-wrap">
      <%@include file="/commons/header.jsp" %>
      <div class="container">
         <h1 class="page-title">Cadastro de Cliente</h1>
      </div>
      <div class="container">
         <div class="row">
            <div class="col-md-14">
               <div class="row">
                  <div class="col-md-10">
                    <form action="actions/cadastrarCliente.jsp" name="cadastrarCliente" method="post">
                        <h4>Informações do Cliente</h4>
                        <div class="form-group">
                           <label>Nome</label>
                           <input class="form-control" required type="text" name="nome" />
                        </div>
                        <div class="form-group">
                           <label>CPF</label>
                           <input class="form-control" required type="text" name="cpf" />
                        </div> 
                        <div class="form-group">
                           <label>Data de Nascimento</label>
                           <input class="form-control" required type="date" name="dataNascimento" />
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