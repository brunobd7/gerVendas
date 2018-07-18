<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controller" class="br.com.bruno.controller.VendasController"/>
<!DOCTYPE html>

 <script type="text/JavaScript">
      setTimeout("location.href = '/GerVendas/listVendas.jsp';",1000);
 </script>
 
<html>
     
    <body>
        <h1>Cadastro efetuado com sucesso !</h1>
        <hr>
        <h2 hidden><%=controller.adicionarVenda(request)%></h2>
        
    </body>
</html>
