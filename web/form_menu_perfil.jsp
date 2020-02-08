

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta content="width=device-width, initial-scale=1, 
              maximum-scale=1, user-scalable=no" name="viewport"/>
         <%@include file="bootstrap.jsp" %>
        <title>Formulário de Menus Vinculados - Capital Notebooks</title>
        <script type="text/javascript">
            function confirmarExclusao(idMenu, nome, idPerfil){
                if(confirm('Deseja desvincular o menu' +nome+ '?')){
                    location.href="gerenciar_menu_perfil.do?acao=desvincular&idMenu="+idMenu+"&idPerfil="+idPerfil;
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
                            <h3 class="mb-0 my-2 text-center">Vincular e Desvicular Menus</h3>
                        </div>
                        <div class="card-body">
            <form class="form" role="form" autocomplete="off" action="gerenciar_menu_perfil.do" method="POST">
                <input type="hidden" class="form-control" name="idPerfil" id="idPerfil" value="${perfilv.idPerfil}"/>  
                <div class="row">
                    <div class="form-group col-sm-6">
                        <label for="perfil" class="control-label">Perfil: ${perfilv.perfil}</label>    
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-sm-6">
                    <label for="idMenu" class="control-label">Menu: </label>
                        <select name="idMenu" id="idMenu" class="form-control" required>
                            <option value="">Selecione o menu</option>
                            <c:forEach var="m" items="${perfilv.naoMenus}">
                            <option value="${m.idMenu}">${m.menu}</option>
                            </c:forEach>
                    </select>    
                    </div>
                </div>
              <div class="btn-group">
                    <button class="btn btn-success">
                        Vincular
                    </button>
                    <a href="listar_perfil.jsp" class="btn btn-warning">Voltar</a>
                </div>
            </form>
                    
                    
            <h2>Menus Vinculados</h2>
                <div class="table-responsive">
        <table class="table table-striped table-bordered table-hover" id="tabelaPesquisar">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Menu</th>
                    <th>Link</th>
                    <th>Desvincular</th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>ID</th>
                    <th>Menu</th>
                    <th>Link</th>
                    <th>Desvincular</th>
                </tr>
                </tfoot>
                <tbody>
                        <c:forEach var="m" items="${perfilv.menus}">
                            <tr>
                                <td>${m.idMenu}</td>
                                <td>${m.menu}</td>
                                <td>${m.link}</td>
                            <td>
                               
                                <button class="btn btn-danger" onclick="confirmarExclusao(${m.idMenu},'${m.menu}',${perfilv.idPerfil})">
                                    <i class="glyphicon glyphicon-trash">Desvincular</i>
                                </button>                                
                            </td>
                            </tr>
                     </c:forEach> 
                </tbody>
            </table>
                        </div></div></div></div></div></div></div></div>
                        <%@include file="script.jsp" %>  <%@include file="datatables.jsp" %>
    </body>
</html>
