
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="controller" class="br.com.bruno.controller.ProdutoController"/>
<%@include file="/commons/head.jsp" %>
<body>
  <div class="global-wrap">
    <%@include file="/commons/header.jsp" %>
        <div class="container">
            <h1 class="page-title">Atualização de Dados do Produto</h1>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-14">
                    <div class="row">
                        <div class="col-md-10">
                            <%=controller.getProdutoSingle(request)%>
                        </div>
                    </div>

                </div>
            </div>
        </div>
</body>

</html>