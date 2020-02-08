<%-- 
    Document   : index
    Created on : 14/08/2018, 09:06:51
    Author     : Administrador
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta content="width=device-width, initial-scale=1, 
              maximum-scale=1, user-scalable=no" name="viewport"/>
         <%@include file="bootstrap.jsp" %>
        <title>Formulário de Garantia - Capital Notebooks</title>
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
                            <h3 class="mb-0 my-2">Cadastro de Garantia de Serviço</h3>
                        </div>
                        <div class="card-body">
        <form class="form" role="form" autocomplete="off" action="gerenciar_garantiaservico.do" method="POST">
            <input type="hidden" class="form-control" name="idGarantiaServico" id="idGarantiaServico" value="${gs.idGarantiaServico}"/>
            
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="dataAbertura" class="control-label">Data de Abertura:</label>   
                    <input type="date" class="form-control" required="" name="dataAbertura" id="dataAbertura" value="${gs.dataAbertura}"/>
                </div>
                <div class="form-group col-sm-6">
                    <label for="observacao" class="control-label">Observação:</label>    
                    <input type="text" class="form-control" required="" name="observacao" id="observacao" value="${gs.observacao}"/>
                </div>
            </div>
           
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="diasGarantia" class="control-label">Dias de Garantia:</label>    
                    <input type="text" class="form-control" required="" name="diasGarantia" id="diasGarantia" value="${gs.diasGarantia}"/>
                </div>
                <div class="form-group col-sm-3">
                    <label for="descricao" class="control-label">Serviço</label>    
                    <select id="idServico" name="idServico">
                        <option value="">Selecione o Serviço</option>
                        <jsp:useBean class="model.Servico" id="descricao"/>
                        <c:forEach var="s" items="${descricao.lista}">
                          <option value="${s.idServico}" 
                            <c:if test="${s.idServico==gs.servico.idServico}">
                             selected=""</c:if>>
                              ${s.nome}
                          </option>    
                        </c:forEach>
                    </select>    
                </div>
                                       </div>
                        
                        <div class="row">
                <button class="btn btn-success">
                    Gravar
                </button>
                <a href="listar_garantiaservico.jsp" class="btn btn-warning">Voltar</a>
            </div>
                         </form>
            </div></div></div></div></div></div></div></div>
                        <%@include file="script.jsp" %>
                  
    </body>
</html>

