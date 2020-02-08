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
        <title>Formulário de Menu - Capital Notebooks</title>
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
                            <h3 class="mb-0 my-2">Cadastro de Menu</h3>
                        </div>
                        <div class="card-body">
        <form class="form" role="form" autocomplete="off"  action="gerenciar_menu.do" method="POST">
            <input type="hidden" class="form-control" name="idMenu" id="idMenu" value="${m.idMenu}"/>
            
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="menu" class="control-label">Menu</label>    
                    <input type="text" class="form-control" required="" name="menu" id="menu" value="${m.menu}"/>
                </div>
                <div class="form-group col-sm-6">
                    <label for="icone" class="control-label">Icone</label>    
                    <input type="text" class="form-control" name="icone" id="icone" value="${m.icone}"/>
                </div>
            </div>
          
                <div class="row">
                <div class="form-group col-sm-6">
                    <label for="link" class="control-label">Link</label>    
                    <input type="text" class="form-control" required="" name="link" id="link" value="${m.link}"/>
                </div>
                <div class="form-group col-sm-6">
                    <label for="exibir" class="control-label">Exibir</label>    
                    <select id="exibir" name="exibir">
                        <c:if test="${m.exibir==null}">
                            <option value="1">Sim</option>
                            <option value="2">Não</option>
                        </c:if>
                        <c:if test="${m.exibir==1}">
                            <option value="${m.exibir}" selected="">Sim</option>
                            <option value="2">Não</option>
                        </c:if>
                        <c:if test="${m.exibir==2}">
                            <option value="1">Sim</option>
                            <option value="${m.exibir}" selected="">Não</option>
                        </c:if>
                    </select>    
                </div>
            </div>

            
            <div class="row">
                <button class="btn btn-success">
                    Gravar
                </button>
                <a href="listar_menu.jsp" class="btn btn-warning">Voltar</a>
            </div>
        </form>
        </div><%@include file="script.jsp" %>
    </body>
</html>
