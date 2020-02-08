<%@page import="model.Funcionario"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta content="width=device-width, initial-scale=1, 
              maximum-scale=1, user-scalable=no" name="viewport"/>
              <%@include file="bootstrap.jsp" %>

        <title>Listagem de Funcionários - Capital Notebooks</title>
        <script type="text/javascript">
            function confirmarExclusao(idFuncionario, nome){
                if(confirm('Deseja realmente excluir o funcionário:'+nome+'?')){
                    location.href="gerenciar_funcionario.do?acao=deletar&idFuncionario="+idFuncionario;
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
                            <h3 class="mb-0 my-2 text-center">Funcionários</h3>
                        <div class="mb-0 my-2">
                <div class="col-sm-12 mx-auto text-center">
             <a href="form_funcionario.jsp" class="btn btn-info">
            Novo Cadastro
        </a>
                            <a href="reports/funcionario/relatorioFuncionarios.jsp" class="btn btn-info" target="_blank">
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
                <th>Nome</th>
                <th>CPF</th>
                <th>Telefone</th>
                <th>Endereço</th>
                <th>Opções</th>
            </tr>
              </thead>
                  <tfoot>
            <tr>
                  <th>ID</th>
                <th>Nome</th>
                <th>CPF</th>
                <th>Telefone</th>
                <th>Endereço</th>
                <th>Opções</th>
            </tr>
        </tfoot>
                     
            <jsp:useBean class="model.Funcionario" id="funcionario"/>
            <c:forEach var="f" items="${funcionario.lista}">
                 
                <tr>
                    <td>${f.idFuncionario}</td>
                    <td>${f.nome}</td>
                     <td>${f.cpf}</td>
                    <td>${f.telefone}</td>
                    <td>${f.endereco}</td>

                    <td>
                         <div class="btn-group-vertical">
                         <a href="gerenciar_funcionario.do?acao=alterar&idFuncionario=${f.idFuncionario}" class="btn btn-primary">
                             <i class="glyphicon glyphicon-pencil"></i>Alterar
                         </a>
                             <button class="btn btn-danger"
                                     onclick="confirmarExclusao(${f.idFuncionario},'${f.nome}')">
                                 <i class="glyphicon glyphicon-trash"></i>Excluir
                             </button>
                         </div>
                     </td>    
              </tr>   
              
            </c:forEach>
                          
         </table>   
            
        </div></div></div></div></div></div></div></div></div>
               
                 <%@include file="script.jsp" %><%@include file="datatables.jsp" %>
            
    </body>
</html>
