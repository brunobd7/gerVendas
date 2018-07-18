
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="controller" class="br.com.bruno.controller.VendasController"/>
<%@include file="/commons/head.jsp" %>
<body>
  <div class="global-wrap">
    <%@include file="/commons/header.jsp" %>
        <div class="container">
            <h1 class="page-title">Atualização de Dados da Venda</h1>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-14">
                    <div class="row">
                        <div class="col-md-10">
                            <%=controller.getVendasSingle(request)%>
                        </div>
                    </div>

                </div>
            </div>
        </div>
</body>

</html>