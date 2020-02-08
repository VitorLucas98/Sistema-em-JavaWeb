
<%@page import="model.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <title>Listagem de Garantias - Capital Notebooks</title>
        <script type="text/javascript">
            function confirmarExclusao(id, dataAbertura){
                if(confirm('Deseja realmente excluir a Garantia de serviço cujo a data de abeturar seja : '+dataAbertura+'?')){
                    location.href="gerenciar_garantiaservico.do?acao=deletar&idGarantiaServico="+id;
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
                            <h3 class="mb-0 my-2 text-center">Garantias </h3>
                        <div class="mb-0 my-2">
                <div class="col-sm-12 mx-auto text-center">
             <a href="form_garantiaservico.jsp" class="btn btn-info">
            Novo Cadastro
        </a>
                            <a href="reports/garantia/relatorioGarantia.jsp" class="btn btn-info" target="_blank">
           Imprimir Relatório
        </a>
                </div></div>
                        </div>
                        
                        <div class="card-body">
       
            <div class="table-responsive">
        <table class="table table-striped table-bordered table-hover" id="tabelaPesquisar">
                <thead>
            <tr>
                <th>ID</th>
                <th>Data de Abertura</th>
                <th>Observação</th>
                <th>Dias de Garantia</th>
                              <th>Serviço</th>
                <th>Descrição</th>
                <th>Opções</th>
            </tr>
                </thead>
                  <tfoot>
            <tr>
                 <th>ID</th>
                <th>Data de Abertura</th>
                <th>Observação</th>
                <th>Dias de Garantia</th>
                                <th>Serviço</th>
                <th>Descrição</th>
                <th>Opções</th>
            </tr>
        </tfoot>
           
            <jsp:useBean class="model.GarantiaServico" id="garantiaservico"/>
             
            <c:forEach var="gs" items="${garantiaservico.lista}">
                 
                
                
                <tr>
                    <td>${gs.idGarantiaServico}</td>
                    <td><fmt:formatDate pattern="dd/MM/YYYY" value="${gs.dataAbertura}"/></td>
                    <td>${gs.observacao}</td>          
                    <td>${gs.diasGarantia}</td>
                                        <td>${gs.servico.nome}</td>
                    <td>${gs.servico.descricao}</td>
                    

                    <td>
                        
                        <div class="btn-group">
                        <form action="reports/garantia/imprimirGarantia.jsp" target="_blank" method="get">
  <input type="hidden" class="form-control-sm"  name="idGarantiaServico" id="idGarantiaServico" value="${gs.idGarantiaServico}">
  <input class="btn btn-info" type="submit"  value="Imprimir">
</form>
                         <a href="gerenciar_garantiaservico.do?acao=alterar&idGarantiaServico=${gs.idGarantiaServico}" class="btn btn-primary">
                             <i class="glyphicon glyphicon-pencil">Alterar</i>
                         </a>
                         <button class="btn btn-danger" 
                                 onclick="confirmarExclusao(${gs.idGarantiaServico},'${gs.dataAbertura}')">
                             <i class="glyphicon glyphicon-trash">Excluir</i>
                         </button>
                        </div>
                     </td>    
              </tr>
            </c:forEach>
           
         </table>    
        
     </div></div></div></div></div></div></div></div></div>
            <%@include file="script.jsp" %>    <%@include file="datatables.jsp" %>
    </body>
</html>
