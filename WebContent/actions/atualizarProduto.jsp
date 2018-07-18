<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controller" class="br.com.bruno.controller.ProdutoController"/>
<!DOCTYPE html>

 <script type="text/JavaScript">
      setTimeout("location.href = '/GerVendas/listProduto.jsp';",1000);
 </script>
 
<html>
     
    <body>
        <h1>Produto Atualizado com sucesso !</h1>
        <hr>
        <h2 hidden><%=controller.atualizarProduto(request)%></h2>
        
    </body>
</html>
