<%-- 
    Document   : index
    Created on : 14/08/2018, 09:06:51
    Author     : Administrador
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

   <title>Formulário de Usuários - Capital Notebooks</title>
    </head>
    <body>
        <div class="container-fluid">
            
                     <div class="header">
                <div id="logo"></div>
            </div>
             <%@include file="menu.jsp" %>
               <div class="container py-5 shadow p-4 mb-5 bg-gradient-warning">
    <div class="row">
        <div class="col-md-12">
                       <div class="row">
                <div class="col-sm-12 mx-auto">
                    <div class="card border-secondary">
                        <div class="card-header">
                            <h3 class="mb-0 my-2">Cadastro de Usuário</h3>
                        </div>
                        <div class="card-body">
                            <form class="form" role="form" autocomplete="off" action="gerenciar_usuario.do" method="POST">
        
            <input type="hidden" class="form-control" name="idUsuario" id="idUsuario" value="${u.idUsuario}"/>
           
                <div class="row">
                <div class="form-group col-sm-6">
                    <label for="login" class="control-label">Login</label>    
                    <input type="text" class="form-control" required="" name="login" id="login" value="${u.login}"/>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="senha" class="control-label">Senha</label>    
                    <input type="password" class="form-control" name="senha" id="senha" value="${u.senha}"/>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="perfil" class="control-label">Perfil</label>    
                    <select id="idPerfil" name="idPerfil">
                        <option value="">Selecione o Perfil</option>
                        <jsp:useBean class="model.Perfil" id="perfil"/>
                        <c:forEach var="p" items="${perfil.lista}">
                          <option value="${p.idPerfil}" 
                           <c:if test="${p.idPerfil==u.perfil.idPerfil}">
                               selected=""</c:if>>
                              ${p.perfil}
                          </option>    
                        </c:forEach>
                    </select>    
                </div>
            </div>
             <div class="row">
                <div class="form-group col-sm-6">
                    <label for="nome" class="control-label">Funcionário</label>    
                    <select id="idFuncionario" name="idFuncionario">
                        <option value="">Selecione o Funcionário</option>
                        <jsp:useBean class="model.Funcionario" id="nome"/>
                        <c:forEach var="f" items="${nome.lista}">
                          <option value="${f.idFuncionario}" 
                           <c:if test="${f.idFuncionario==u.funcionario.idFuncionario}">
                               selected=""</c:if>>
                              ${f.nome}
                          </option>    
                        </c:forEach>
                    </select>    
                </div>
            </div>
            <div class="row">
                <button class="btn btn-success">
                    Gravar
                </button>
                <a href="listar_usuario.jsp" class="btn btn-warning">Voltar</a>
            </div>
        </form>
               </div></div></div></div></div></div></div></div>
                  <%@include file="script.jsp" %>
                  
    </body>
</html>
