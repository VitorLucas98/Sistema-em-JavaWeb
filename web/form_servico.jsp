<%-- 
    Document   : index
    Created on : 14/08/2018, 09:06:51
    Author     : Administrador
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
      
        <title>Formulário de Serviço - Capital Notebooks</title>
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
                            <h3 class="mb-0 my-2">Cadastro de Serviço</h3>
                        </div>
                        <div class="card-body">
        <form class="form" role="form" autocomplete="off" action="gerenciar_servico.do" method="POST">
            <input type="hidden" class="form-control" name="idServico" id="idServico" value="${s.idServico}"/>
           
                <div class="row">
                <div class="form-group col-sm-6">
                    <label for="nome" class="control-label">Serviço:</label>    
                    <input type="text" class="form-control" required="" name="nome" id="nome" value="${s.nome}"/>
                </div>
                <div class="form-group col-sm-6">
                    <label for="descricao" class="control-label">Descrição:</label>    
                    <input type="text" class="form-control" name="descricao" id="descricao" value="${s.descricao}"/>
                </div>
            </div>
            
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="valor" class="control-label">Valor R$:</label>    
                    <input type="text" class="valor form-control" style="display:inline-block"  name="valor" id="valor" value="${s.valor}"/>
                </div>
            </div>

            <div class="row">
                <button class="btn btn-success">
                    Gravar
                </button>
                <a href="listar_servico.jsp" class="btn btn-warning">Voltar</a>
            </div>
                               
        </form>
        </div>     <%@include file="script.jsp" %> <%@include file="mascaraForm.jsp" %>
    </body>

</html>
