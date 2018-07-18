<%@include file="/commons/head.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controller" class="br.com.bruno.controller.ProdutoController"/>

<body>
  <div class="global-wrap">
    <%@include file="/commons/header.jsp" %>
    <div class="container">
      <h1 class="page-title">Lista De Produtos</h1>
    </div>
    <div class="container">
      <div class="row">
        <div class="col-md-9">
          <ul class="booking-list">
             <%=controller.getProdutoAll()%>
          </ul>
        </div>
      </div>
    </div>
</body>
</html>