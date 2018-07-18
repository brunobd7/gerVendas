<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controller" class="br.com.bruno.controller.VendasController"/>
<!DOCTYPE html>

 <script type="text/JavaScript">
      setTimeout("location.href = '/GerVendas/listVendas.jsp';",1000);
 </script>
 
<html>
     
    <body>
        <h1>Exclusao efetuada com sucesso !</h1>
        <hr>
        <h2 hidden><%=controller.removerVenda(request)%></h2>
        
    </body>
</html>
