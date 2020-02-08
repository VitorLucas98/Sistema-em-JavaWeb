<%-- 
    Document   : index
    Created on : 14/08/2018, 09:06:51
    Author     : Administrador


  <form action="gerenciar_perfil.do" method="POST">
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta content="width=device-width, initial-scale=1, 
              maximum-scale=1, user-scalable=no" name="viewport"/>
      
        <%@include file="bootstrap.jsp" %>
        <title>Formulário de Perfil - Capital Notebooks</title>
    </head>
    <body><div class="container-fluid">
             
             <div class="header"><div id="logo"></div></div>
            <%@include file="menu.jsp" %>
            
             <div class="container py-5 shadow p-4 mb-5 bg-gradient-warning">
    <div class="row">
        <div class="col-md-12">
                     <div class="row">
                <div class="col-sm-12 mx-auto">
                    <div class="card border-secondary">
                        <div class="card-header">
                            <h3 class="mb-0 my-2">Cadastro de Perfil</h3>
                        </div>
                        <div class="card-body">
                            <form class="form" role="form" autocomplete="off" action="gerenciar_perfil.do" method="POST">
            
                     
      
            <input type="hidden" class="form-control" name="idPerfil" id="idPerfil" value="${p.idPerfil}"/>
            
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="perfil" class="control-label">Perfil</label>    
                    <input type="text" class="form-control" required="" name="perfil" id="perfil" value="${p.perfil}"/>
                </div>
            </div>
            <div class="row">
                <button class="btn btn-success">
                    Gravar
                </button>
                <a href="listar_perfil.jsp" class="btn btn-warning">Voltar</a>
            </div>
                
        </form>
                        </div></div></div></div></div></div></div></div>
                    <%@include file="script.jsp" %>
    </body>
</html>
