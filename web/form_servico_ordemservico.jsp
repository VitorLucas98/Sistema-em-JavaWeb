<%-- 
    Document   : form_servico_ordemservico
    Created on : 28/10/2018, 17:32:10
    Author     : Vítor Lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta content="width=device-width, initial-scale=1, 
              maximum-scale=1, user-scalable=no" name="viewport"/>
       <%@include file="bootstrap.jsp" %>
        <title>Formulário de Serviços Vinculados - Capital Notebooks</title>
        <script type="text/javascript">
            function confirmarExclusao(idServico, nome, idNumero){
                if(confirm('Deseja desvincular o Servico' +nome+ '?')){
                    location.href="gerenciarservico_ordemservico.do?acao=desvincular&idServico="+idServico+"&idNumero="+idNumero;
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
                            <h3 class="mb-0 my-2">Vincular e Desvicular Serviços</h3>
                        </div>
                        <div class="card-body">
        <form class="form" role="form" autocomplete="off" action="gerenciarservico_ordemservico.do" method="POST">
            <input type="hidden" class="form-control" name="idNumero" id="idNumero" value="${ordemservicov.idNumero}"/>
            
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="dataAbertura" class="control-label">Data de Abertura: <fmt:formatDate pattern="dd/MM/YYYY" value="${ordemservicov.dataAbertura}"/> </label> 
                    
                </div>
               
            </div>
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="idServico" class="control-label">Serviços: </label>
                    <select name="idServico" id="idServico" class="form-control" required>
                        <option value="">Selecione o Serviço</option>
                        <c:forEach var="s" items="${ordemservicov.naoServicos}">
                            <option value="${s.idServico}">${s.nome}</option>
                        </c:forEach>
                    </select>    
                </div>
            </div>
            <div class="row">
                <button class="btn btn-success">
                    Vincular
                </button>
                <a href="listar_ordemservico.jsp" class="btn btn-warning">Voltar</a>
            </div>
        </form>
                <h2>Serviços Vinculados</h2>
                <div class="table-responsive">
                     <table class="table table-striped table-bordered table-hover" id="tabelaPesquisar">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Descrição</th>
                    <th>Valor</th>                                        
                   
                    <th>Desvincular</th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Descrição</th>
                    <th>Valor</th>                                        
                                        <th>Desvincular</th>
                </tr>
                </tfoot>
                <tbody>
                 <c:forEach var="s" items="${ordemservicov.servicos}">
                     <c:set var="Amount" value="${s.valor}" />  
                            <tr>
                                <td>${s.idServico}</td>
                                <td>${s.nome}</td>
                                <td>${s.descricao}</td>
                                <td><fmt:formatNumber value="${Amount}" type="currency" /></td>
                                                            <td>
                               
                                <button class="btn btn-danger" onclick="confirmarExclusao(${s.idServico},'${s.nome}',${ordemservicov.idNumero})">Desvincular
                                    <i class="glyphicon glyphicon-trash"></i>
                                </button>                                
                            </td>
                            </tr>
                 </c:forEach> 
                 </tbody>            
             </table>   
                </div></div></div></div></div></div></div></div></div>
                <%@include file="script.jsp" %> <%@include file="datatables.jsp" %>
    </body>
</html>
