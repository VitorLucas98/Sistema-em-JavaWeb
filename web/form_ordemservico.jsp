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
<title>Formulário de Ordem de Serviço - Capital Notebooks</title>
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
                            <h3 class="mb-0 my-2">Formulário de Ordem de Serviço</h3>
                        </div>
                        <div class="card-body">
        
        <form class="form" role="form" autocomplete="off" action="gerenciar_ordemservico.do" method="POST">
        
            <input type="hidden" class="form-control" name="idNumero" id="idNumero" value="${os.idNumero}"/>
           
           <div class="row">
                <div class="form-group col-sm-6">
                    <label for="dataAbertura" class="control-label">Data de Abertura:</label>    
                    <input type="date" class="form-control" required="" name="dataAbertura" id="dataAbertura" value="${os.dataAbertura}"/>
                   
                </div> <div class="form-group col-sm-6">
                    <label for="equipamento" class="control-label">Equipamento:</label>    
                    <input type="text" class="form-control" required="" name="equipamento" id="equipamento" value="${os.equipamento}"/>
                </div>
                            </div>
         
                 <div class="row">
               
                 <div class="form-group col-sm-6">
                    <label for="numeroSerie" class="control-label">Número de série:</label>    
                    <input type="text" class="form-control" required="" name="numeroSerie" id="numeroSerie" value="${os.numeroSerie}"/>
                </div>
                 <div class="form-group col-sm-6">
                  
                    <label for="defeito">Defeito Apresentado:</label>

                                               <input type="text" class="form-control" required="" name="defeito" id="defeito" value="${os.defeito}"/>

                    
                </div>
            </div>
                
                  <div class="row">
                <div class="form-group col-sm-6">                   
                     <label for="observacao">Observação:</label>
                                           <input type="text" class="form-control" required="" name="observacao" id="observacao" value="${os.observacao}"/>
                                        
  
                                        
                </div>
                
                <div class="form-group col-sm-6">
                    <label for="carregador" class="control-label"> Possui Carregador ?</label>   
                    <%-- <input type="text" name="carregador" id="carregador" value="${os.carregador}"  /> --%>
                     <select name="carregador">
  <option value="SIM">SIM</option>
  <option value="NÃO">NÃO</option>
  </select>
                    
                <label for="bateria" class="control-label"> Possui Bateria ?</label>    
                   <%--   <input type="text" name="bateria" id="bateria" value="${os.bateria}" "/> --%>
                             <select name="bateria">
  <option value="SIM">SIM</option>
  <option value="NÃO">NÃO</option>
                             </select>
                </div>
            </div>
                
                <div class="row">
                <div class="form-group col-sm-6">
                    <label for="nome" class="control-label">Cliente</label>    
                    <select id="idCliente" name="idCliente">
                        <option value="">Selecione o Cliente</option>
                        <jsp:useBean class="model.Cliente" id="nome"/>
                        <c:forEach var="c" items="${nome.lista}">
                          <option value="${c.idCliente}" 
                           <c:if test="${c.idCliente==os.cliente.idCliente}">
                               selected=""</c:if>>
                              ${c.nome}
                          </option>    
                        </c:forEach>
                    </select>    
                </div>
            </div>
                        
                      <div class="row">
                <div class="form-group col-sm-6">
                    <label for="usuario" class="control-label">Usuário</label>    
                    <select id="idUsuario" name="idUsuario">
                        <option value="">Selecione o Usuário:</option>
                        <jsp:useBean class="model.Usuario" id="login"/>
                        <c:forEach var="u" items="${login.lista}">
                          <option value="${u.idUsuario}" 
                           <c:if test="${u.idUsuario==os.usuario.idUsuario}">
                               selected=""</c:if>>
                              ${u.login}
                          </option>    
                        </c:forEach>
                    </select>    
                </div>
            </div> 
    
            <div class="row">
                <button class="btn btn-success">
                    Gravar
                </button>
                <a href="listar_ordemservico.jsp" class="btn btn-warning">Voltar</a>
            </div>
        </form>
                        </div></div></div></div></div></div></div></div>
                  <%@include file="script.jsp" %>
                  <script>
                      $(document).ready(function(){
$("input").click(function(){
        $(this).next().show();
        $(this).next().hide();
    });

});
                      
                  </script>
        
    </body>
</html>

