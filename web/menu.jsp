<%@page import="model.Usuario"%>
<%@page import="control.GerenciarLogin"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
             <link rel="stylesheet" type="text/css" href="css/menu.css"/>
<%
    Usuario ulogado = GerenciarLogin.verificarAcesso(request, response);
    request.setAttribute("ulogado", ulogado);
%>

<div class="menu">
    
    <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #d1d1c7;">
     
    <ul>
        <c:if test="${ulogado!=null && ulogado.perfil!=null}">
            <c:forEach var="menu" items="${ulogado.perfil.menus}"> 
                <c:if test="${menu.exibir==1}">  
                    <li class="nav-item"><a href="${menu.link}">${menu.menu}</a></li>
                </c:if>
            </c:forEach>
        </c:if>            
        
    </ul>
    
    <div class="pull-right">Bem Vindo, <c:if test="${ulogado!=null}">
    ${ulogado.login}</c:if>
    <a href="gerenciar_login.do">Sair</a>
</div>
</nav>  


</div>
<%--<nav class="navbar navbar-expand-lg navbar-light bg-light">
 
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
       <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Ordem de Serviço
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="form_ordemservico.jsp">Novo</a>
          <a class="dropdown-item" href="listar_ordemservico.jsp">Consultar</a>
                 </div>
      </li>
       <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Garantia
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
           <a class="dropdown-item" href="form_garantiaservico.jsp">Novo</a>
          <a class="dropdown-item" href="listar_garantiaservico.jsp">Consultar</a>
          
        </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Cliente
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
      <a class="dropdown-item" href="form_cliente.jsp">Novo</a>
          <a class="dropdown-item" href="listar_cliente.jsp">Consultar</a>
                </div>
                </li>
                
       <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Funcionário
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
         <a class="dropdown-item" href="form_funcionario.jsp">Novo</a>
          <a class="dropdown-item" href="listar_funcionario.jsp">Consultar</a>
         
        </div>
      </li>
      
       <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Perfil
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
         <a class="dropdown-item" href="form_perfil.jsp">Novo</a>
          <a class="dropdown-item" href="listar_perfil.jsp">Consultar</a>
         
        </div>
      </li>
       <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Usuário
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
         <a class="dropdown-item" href="form_usuario.jsp">Novo</a>
          <a class="dropdown-item" href="listar_usuario.jsp">Consultar</a>
             </div>
       </li>
                <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Serviço
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
         <a class="dropdown-item" href="form_servico.jsp">Novo</a>
          <a class="dropdown-item" href="listar_servico.jsp">Consultar</a>
             </div>
      </li>
             
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Menu
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
         <a class="dropdown-item" href="form_menu.jsp">Novo</a>
          <a class="dropdown-item" href="listar_menu.jsp">Consultar</a>
             </div>
      </li>
    </ul>
          
  </div>



 
</nav>
--%>