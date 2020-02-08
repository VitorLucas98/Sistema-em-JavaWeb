<%-- 
    Document   : index
    Created on : 14/08/2018, 09:06:51
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta content="width=device-width, initial-scale=1, 
              maximum-scale=1, user-scalable=no" name="viewport"/>
        <%@include file="bootstrap.jsp" %>
  <%@include file="mascaraForm.jsp" %>
        <title>Formulário de Cliente - Capital Notebooks</title>
    </head>
    <body>
       <div class="container-fluid">
            <div class="header"><div id="logo"></div></div>
        <%@include file="menu.jsp" %>
        
        
          <div class="container py-5 shadow p-4 mb-5 bg-gradient-warning">
    <div class="row">
        <div class="col-md-12">
                       <div class="row">
                <div class="col-sm-12 mx-auto">
                    <div class="card border-secondary">
                        <div class="card-header">
                            <h3 class="mb-0 my-2">Cadastro de Cliente</h3>
                        </div>
                        <div class="card-body">
       
         <form class="form" role="form" autocomplete="off" action="gerenciar_cliente.do" method="POST">
     
            <input type="hidden" class="form-control" name="idCliente" id="idCliente" value="${c.idCliente}"/>
            
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="cpf_cnpj" class="control-label">CPF/CNPJ</label>    
                    <input type="text" class="cpf_cnpj form-control" style="display:inline-block" placeholder="Digite o CPF ou CNPJ" name="cpf_cnpj" id="cpf_cnpj" value="${c.cpf_cnpj}"/>
                </div>
                 <div class="form-group col-sm-6">
                    <label for="nome" class="control-label">Nome</label>    
                    <input type="text" class="form-control" required="" placeholder="Digite o nome do cliente" name="nome" id="nome" value="${c.nome}"/>
                </div>
            </div>
            <div class="row">
               
            </div><div class="row">
                <div class="form-group col-sm-6">
                    <label for="telefone" class="control-label">Telefone</label>    
                    <input type="text" class="telefone form-control" style="display:inline-block" placeholder="Telefone para contato Ex.: (000) 00000-0000" name="telefone" id="telefone" value="${c.telefone}"/>
                </div>
                <div class="form-group col-sm-6">
                    <label for="endereco" class="control-label">Endereço</label>    
                    <input type="text" class="form-control" required="" placeholder="Ex.: Quadra - Numero - Bairro - Cidade - Estado" name="endereco" id="endereco" value="${c.endereco}"/>
                </div>
                
                  </div>
            
                <div class="row">
                <div class="form-group col-sm-6">
                    <label for="nomeReferencia" class="control-label">Nome de Referência</label>    
                    <input type="text" class="form-control" required="" placeholder="Nome de referência" name="nomeReferencia" id="nomeReferencia" value="${c.nomeReferencia}"/>
                </div>
                 <div class="form-group col-sm-6">
                    <label for="telefoneReferencia" class="control-label">Telefone de Referência</label>    
                    <input type="text" class="telefoneReferencia form-control" style="display:inline-block" placeholder="Telefone de Referêcia Ex.: (000) 00000-0000" name="telefoneReferencia" id="telefoneReferencia" value="${c.telefoneReferencia}"/>
                </div>
            </div>
            <div class="row">
                <button class="btn btn-success">
                    Gravar
                </button>
                <a href="listar_cliente.jsp" class="btn btn-warning">Voltar</a>
            </div>
        </form>
        </div></div></div></div></div></div></div></div>
                  <%@include file="script.jsp" %> <%@include file="mascaraForm.jsp" %>
    </body>
</html>
