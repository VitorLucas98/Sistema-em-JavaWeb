
<%@page import="model.Perfil"%>
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
        <title>Listagem de Perfis - Capital Notebooks</title>
        <script type="text/javascript">
            function confirmarExclusao(idPerfil, nome){
                if(confirm('Deseja realmente excluir o perfil'+nome+'?')){
                    location.href="gerenciar_perfil.do?acao=deletar&idPerfil="+idPerfil;
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
                            <h3 class="mb-0 my-2 text-center">Perfis</h3>
                        <div class="mb-0 my-2">
                <div class="col-sm-12 mx-auto text-center">
             <a href="form_perfil.jsp" class="btn btn-info">
            Novo Cadastro
        </a>
                                           </div></div>
                        </div>
                        
                        <div class="card-body">
        
          <div class="table-responsive">
        <table class="table table-striped table-bordered table-hover" id="tabelaPesquisar">
          <thead>  <tr>
                <th>ID</th>
                <th>Perfil</th>
                <th>Opções</th>
            </tr>   </thead>    
          <tfoot>
            <tr>
               <th>ID</th>
                <th>Perfil</th>
                <th>Opções</th>
            </tr>
        </tfoot>
             <jsp:useBean class="model.Perfil" id="perfil"/>
            <c:forEach var="p" items="${perfil.lista}">
                <tr>
                    <td>${p.idPerfil}</td>
                    <td>${p.perfil}</td>
                    <td><div class="btn-group">
                         <a href="gerenciar_perfil.do?acao=alterar&idPerfil=${p.idPerfil}" class="btn btn-primary">
                             <i class="glyphicon glyphicon-pencil">Alterar</i>
                         </a>
                         <button class="btn btn-danger" 
                                 onclick="confirmarExclusao(${p.idPerfil},'${p.perfil}')">
                             <i class="glyphicon glyphicon-trash">Excluir</i>
                         </button>
                         <a href="gerenciar_menu_perfil.do?acao=gerenciar&idPerfil=${p.idPerfil}" class="btn btn-primary">
                             <i class="glyphicon">Menus</i>
                         </a></div>
                     </td>    
              </tr>
            </c:forEach></tbody>
         </table>    
        
          </div></div></div></div></div></div></div></div></div>
             <%@include file="script.jsp" %>   <%@include file="datatables.jsp" %>
    </body>
</html>
