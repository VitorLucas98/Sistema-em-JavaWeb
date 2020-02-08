<%@page import="model.Menu"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta content="width=device-width,initial-scale=1,
              maximum-scale=1,user-scalable=no" name="viewport"/>
   <%@include file="bootstrap.jsp" %>
        <link rel="stylesheet" href="datatables/jquery.dataTables.min.css"/>
        <title>Listagem de Menus - Capital Notebooks</title>
        <script type="text/javascript">
            function confirmarExclusao(id, nome){
                if(confirm('Deseja excluir o menu' +nome+ '?')){
                    location.href="gerenciar_menu.do?acao=deletar&idMenu="+id;
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
                            <h3 class="mb-0 my-2 text-center">Menus</h3>
                        <div class="mb-0 my-2">
                <div class="col-sm-12 mx-auto text-center">
             <a href="form_menu.jsp" class="btn btn-info">
            Novo Cadastro
        </a>
                                        </div></div>
                        </div>
                        
                        <div class="card-body">
                             <div class="table-responsive">
            <table class="table table-striped table-bordered table-hover" id="tabelaPesquisar">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Menu</th>
                    <th>Link</th>
                    <th>Icone</th>
                    <th>Exibir</th>
                    <th>Opções</th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>ID</th>
                    <th>Menu</th>
                    <th>Link</th>
                    <th>Icone</th>
                    <th>Exibir</th>
                    <th>Opções</th>
                </tr>
                </tfoot>
                 <jsp:useBean class="model.Menu" id="menu" />
                  <tbody>
                 <c:forEach var="m" items="${menu.lista}">
                            <tr>
                                <td>${m.idMenu}</td>
                                <td>${m.menu}</td>
                                <td>${m.link}</td>
                                <td>${m.icone}</td>
                                

                                <td>
                                    <c:if test="${m.exibir==1}">Exibir</c:if>
                                    <c:if test="${m.exibir==2}">Não Exibir</c:if>
                                </td>
                            <td> <div class="btn-group-vertical">
                                <a href="gerenciar_menu.do?acao=alterar&idMenu=${m.idMenu}" class="btn btn-primary">
                                    <i class="glyphicon glyphicon-pencil">Alterar</i>
                                </a>
                                <button class="btn btn-danger" onclick="confirmarExclusao(${m.idMenu},'${m.menu}')">
                                    <i class="glyphicon glyphicon-trash">Excluir</i>
                                </button>                                
                            </div></td>
                            </tr>
                 </c:forEach> 
                 </tbody>            
             </table>    
                             </div></div></div></div></div></div></div></div></div>   <%@include file="script.jsp" %>   <%@include file="datatables.jsp" %>  
    </body>

    
</html>
</html>


