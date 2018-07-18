<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controller" class="br.com.bruno.controller.ClienteController"/>
<!DOCTYPE html>

 <script type="text/JavaScript">
      setTimeout("location.href = '/GerVendas/listCliente.jsp';",1000);
 </script>
 
 
<html>
     
    <body>
        <h1>Alterado com sucesso !</h1>
        <hr>
        <h2 hidden><%=controller.atualizarCliente(request)%></h2>
        
    </body>
</html>
