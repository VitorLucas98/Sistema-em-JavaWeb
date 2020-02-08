
<%@page import="model.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : index
    Created on : 14/08/2018, 09:06:51
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta content="width=device-width, initial-scale=1, 
              maximum-scale=1, user-scalable=no" name="viewport"/>
        <%@include file="bootstrap.jsp" %>

        <title>Listagem de Usuários - Capital Notebooks</title>
        <script type="text/javascript">
            function confirmarExclusao(idUsuario, login){
                if(confirm('Deseja realmente excluir o usuario: '+login+'?')){
                    location.href="gerenciar_usuario.do?acao=deletar&idUsuario="+idUsuario;
                }
            }
        </script>    
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
                            <h3 class="mb-0 my-2 text-center">Usuários</h3>
                        <div class="mb-0 my-2">
                <div class="col-sm-12 mx-auto text-center">
             <a href="form_usuario.jsp" class="btn btn-info">
            Novo Cadastro
        </a>
                                           </div></div>
                        </div>
                        
                        <div class="card-body">
        <div class="table-responsive">
        <table class="table table-striped table-bordered table-hover" id="tabelaPesquisar">
             <thead>
            <tr>
                <th>ID</th>
                <th>Login</th>
                <th>Senha</th>
                <th>Perfil</th>
                <th>Funcionario</th>
                <th>Opções</th>
            </tr>
            </thead>
             <tfoot>
            <tr>
                 <th>ID</th>
                <th>Login</th>
                <th>Senha</th>
                <th>Perfil</th>
                <th>Funcionario</th>
                <th>Opções</th>
            </tr>
        </tfoot>
            <jsp:useBean class="model.Usuario" id="usuario"/>
            <c:forEach var="u" items="${usuario.lista}">
                <tr>
                    <td>${u.idUsuario}</td>
                    <td>${u.login}</td>
                    <td>${u.senha}</td>
                    <td>${u.perfil.perfil}</td>
                    <td>${u.funcionario.nome}</td>
                    <td> <div class="btn-group-vertical">
                         <a href="gerenciar_usuario.do?acao=alterar&idUsuario=${u.idUsuario}" class="btn btn-primary">
                             <i class="glyphicon glyphicon-pencil">Alterar</i>
                         </a>
                         <button class="btn btn-danger" 
                                 onclick="confirmarExclusao(${u.idUsuario},'${u.login}')">
                             <i class="glyphicon glyphicon-trash">Excluir</i>
                         </button>
                        </div>
                     </td>    
              </tr>
            </c:forEach>
             </tbody>
         </table>   
            
        </div></div></div></div></div></div></div></div></div>
               
      <%@include file="script.jsp" %> <%@include file="datatables.jsp" %>
    </body>
</html>
