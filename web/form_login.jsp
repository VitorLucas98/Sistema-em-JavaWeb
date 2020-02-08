<%-- 
    Document   : form_login
    Created on : 31/10/2018, 18:07:17
    Author     : Vítor Lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta content="width=device-width, initial-scale=1, 
              maximum-scale=1, user-scalable=no" name="viewport"/>
        <%@include file="bootstrap.jsp" %>
              <title>Formulário de Login - Capital Notebooks</title>
    </head>
    <body>  <%
              String mensagem = (String)request.getSession().getAttribute("mensagem");
              if(mensagem!=null){
                  request.getSession().removeAttribute("mensagem");
                
            %>
            <img src="../../../../AppData/Local/Temp/c.png" alt=""/>
                  <div class="alert alert-info"><%=mensagem%></div>
            <%
               } 
            %>
       <div id="main" class="container-fluid">
            
               <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-6 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body text-center">
               
              <img src="imagens/c.png" width="40%">
          <h4 class="text-center">Capital Notebook</h4>
           <h4 class="text-center">SGOS -Gerenciador de Ordem de Serviço</h4>
            <form class="form-signin" action="gerenciar_login.do" method="POST">
                   
              <div class="form-label-group">
                <input type="text" id="login" name="login" class="form-control" placeholder="Usuário" required autofocus>
                         </div>
                <p>
              <div class="form-label-group">
                <input type="password" id="senha" name="senha"  class="form-control" placeholder="Senha" required> <p>
                           </div>
             
              <button class="btn btn-lg btn-primary btn-block text-uppercase" >Entrar</button>
                   </form>
          
          </div>
        </div>
      </div>
    </div>
  </div>
 
                  
     
</html>

  