<%@page import="model.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<title>Visualizar Ordem</title>

<%@include file="bootstrap.jsp" %>

 <script type="text/javascript">
            function confirmarExclusao(idNumero, servico){
                if(confirm('Deseja realmente excluir o Ordem de Serviço, cujo o serviço é: '+servico+'?')){
                    location.href="gerenciar_ordemservico.do?acao=deletar&idNumero="+idNumero;
                }
            }
        </script>    
</head>
<body>

 <div id="main" class="container-fluid">
<div class="container py-5 shadow p-4 mb-5 bg-gradient-warning">
    <div class="row">
        <div class="col-md-12">
                       <div class="row">
                <div class="col-sm-12 mx-auto">
                    <div class="card border-secondary">
                        <div class="card-header">
                            <h3 class="mb-0 my-2">Ordem de Serviço - Nº: ${os.idNumero} - Cliente: ${os.cliente.nome} </h3>
                        </div>
                        <div class="card-body">      
    
    
  <div class="row">
   
    <div class="col-md-2">
       <p><strong>ID</strong></p> 
      <p>${os.idNumero}</p>
    </div>
        <div class="col-md-2">
      <p><strong>Status</strong></p>
  	  <p>${os.status}</p>
    </div>
      
	
	<div class="col-md-4">
    <p><strong>Data de Abertura</strong></p
    
  	  <p><fmt:formatDate pattern="dd/MM/YYYY" value="${os.dataAbertura}"/></p>
    </div>
    <div class="col-md-4">
         <c:set var = "fechamento" scope = "session" value = "${os.dataFechamento}"/>
                    <fmt:formatDate pattern="dd/MM/YYYY" var="fechamentoFormatado" value="${os.dataFechamento}"/>  
      <p><strong>Data de Fechamento</strong></p>
      
  	  <p><c:out value="${fechamento == '0002-11-30' ? '': fechamentoFormatado }" /></p>
    </div>
  </div>
	<div class="row">
            <div class="col-md-4">
      <p><strong>Equipamento</strong></p>
  	  <p>${os.equipamento}</p>
    </div>
    
    <div class="col-md-4">
      <p><strong>Defeito Apresentado</strong></p>
  	  <p>${os.defeito}</p>
    </div>
 
    <div class="col-md-4">
      <p><strong>Numero de Série</strong></p>
  	  <p>${os.numeroSerie}</p>
    </div>
        </div>
    
    <div class="row">
    <div class="col-md-4">
      <p><strong>Observação</strong></p>
  	  <p>${os.observacao}</p>
    </div>
		
	<div class="col-md-4">
      <p><strong>Carregador</strong></p>
  	  <p>${os.carregador}</p>
    </div>
	
    <div class="col-md-4">
      <p><strong>Bateria</strong></p>
  	  <p>${os.bateria}</p>
    </div>
    
    
    
    </div>
	
	
	<div class="row">
      <div class="col-md-4">
      <p><strong>Cliente</strong></p>
    <p> ${os.cliente.nome}</p>
      </div>
    <div class="col-md-4">
         <p><strong>CPF/CNPJ</strong></p>
  	  <p>${os.cliente.cpf_cnpj}</p>
    </div> 
          <div class="col-md-2">
      <p><strong>Usuário do Sistema</strong></p>
  	  <p>${os.usuario.login}</p>
    </div>
        </div>
    <div class="row">
         <div class="col-md-12">
             
             <h2>Serviços Vinculados</h2>
                <div class="table-responsive">
                <table class="table table-striped table-bordered table-hover display" id="tabelaPesquisar">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Serviço</th>
                    <th>Descrição</th>
                    <th>Valor</th>                                        
                     
                     </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>ID</th>
                    <th>Serviço</th>
                    <th>Descrição</th>
                    <th>Valor  </th> 
                    
                          
                          
                </tr>
                </tfoot>
                
                 <c:forEach var="s" items="${ordemservicov.servicos}">
                     <c:set var="total" value="${total + s.valor}"></c:set>
                                   <c:set var="Amount" value="${s.valor}" />  
  

                            <tr>
                                <td>${s.idServico}</td>
                                <td>${s.nome}</td>
                                <td>${s.descricao}</td>
                                <td><fmt:formatNumber value="${Amount}" type="currency" /></td>
                         </tr> 
                                                                                     
                            

                           
                     
                 </c:forEach> 
                                  
                     
                 
                 
                
             </table>   
             
           
         </div>
       </div>

    
      <div class="table-responsive">
    <table class="table table-striped table-bordered table-hover">
        <thead>
                <tr>
                                                   
                    <td><th><center>Valor Total: <fmt:formatNumber value="${total}" type="currency" /></center></th></td>
                                <td></td>
                    
                                                            
                     
                     </tr>
                </thead>
      
    </table></div>
      
          <div class="btn-group">
             <form action="reports/ordemservico/imprimirOrdem.jsp" method="get">
  <input type="hidden" class="form-control-sm"  name="idNumero" id="idNumero" value="${os.idNumero}">
  <input class="btn btn-info" type="submit" value="Imprimir">
</form>
  
                 <a href="gerenciar_ordemservico.do?acao=alterar&idNumero=${os.idNumero}" class="btn btn-primary">Editar</a>
           <a href="gerenciar_ordemservico.do?acao=encerrar&idNumero=${os.idNumero}" class="btn btn-primary">Encerrar</a>
	<a href=""  onclick="window.close()" class="btn btn-primary">Fechar</a>
       
         <button class="btn btn-danger" 
                                 onclick="confirmarExclusao(${os.idNumero},'${os.equipamento}')">
                             <i class="glyphicon glyphicon-trash">Excluir</i>
                         </button> 
 
          </div></div></div></div></div></div></div></div></div></div>
     
  
 <%@include file="script.jsp" %> <%@include file="datatables.jsp" %>
      

    </body>
</html>
 