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
       
    
               
              
   <title>Listagem de OS - Capital Notebooks</title>
        <script type="text/javascript">
            function confirmarExclusao(idNumero, servico){
                if(confirm('Deseja realmente excluir o Ordem de Serviço, cujo o serviço é: '+servico+'?')){
                    location.href="gerenciar_ordemservico.do?acao=deletar&idNumero="+idNumero;
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
                <div class="col-sm-12 mx-auto text-center">
                    <div class="card border-secondary">
                        <div class="card-header">
                            <h3 class="mb-0 my-2">Ordens de Serviço</h3>
                             <div class="mb-0 my-2">
                <div class="col-sm-12 mx-auto text-center">
             <a href="form_ordemservico.jsp" class="btn btn-info">
            Novo Cadastro
        </a>
                            <a href="reports/ordemservico/relatorioOS.jsp" class="btn btn-info" target="_blank">
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
                
                <th>Status</th>
                <th>Data de Abertura</th>
                <th>Data de Fechamento</th>
                <th>Equipamento</th>
              
                <th>Defeito</th>
                <th>Cliente</th>
                <th>Opções</th>
            </tr>
               </thead>
               <tfoot>
            <tr>
                <th>ID</th><th>Status</th>
                <th>Data de Abertura</th>
                <th>Data de Fechamento</th>
                <th>Equipamento</th>
                
                <th>Defeito</th>
                <th>Cliente</th>
                <th>Opções</th>
            </tr>
        </tfoot>
            
            <jsp:useBean class="model.OrdemServico" id="OrdemServico"/>
            <c:forEach var="os" items="${OrdemServico.lista}">
                                  
                     <c:set var = "fechamento" scope = "session" value = "${os.dataFechamento}"/>
                    <fmt:formatDate pattern="dd/MM/YYYY" var="fechamentoFormatado" value="${os.dataFechamento}"/>   
                    
                              <tr>
                    <td>${os.idNumero}</td>
                    <td>${os.status}</td>
                    <td><fmt:formatDate pattern="dd/MM/YYYY" value="${os.dataAbertura}"/></td>
                    
                    <td><c:out value="${fechamento == '0002-11-30' ? '': fechamentoFormatado }" /></td>
                   
                    <td>${os.equipamento}</td>
                    <td>${os.defeito}</td>
                    <td>${os.cliente.nome}</td>
                   
                    <td> <div class="btn-group-vertical">
                         
                              <a href="gerenciar_ordemservico.do?acao=visualizar&idNumero=${os.idNumero}"  target="_blank" class="btn btn-primary">
                             <i class="glyphicon glyphicon-pencil">Visualizar</i>
                         </a>
                             <a href="gerenciarservico_ordemservico.do?acao=gerenciar&idNumero=${os.idNumero}" class="btn btn-primary">
                             <i class="glyphicon">Serviços</i>
                         </a>
                         <button class="btn btn-danger" 
                                 onclick="confirmarExclusao(${os.idNumero},'${os.equipamento}')">
                             <i class="glyphicon glyphicon-trash">Excluir</i>
                         </button>
                          
                             </div>
                     </td>    
              </tr>
            </c:forEach>
                       </table> 
           
                
        </div></div></div></div></div></div></div></div></div></div>
               
  <%@include file="script.jsp" %>
    <%@include file="datatables.jsp" %>
    
    </body>
</html>
