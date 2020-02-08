<%-- 
    Document   : form_funcionario
    Created on : 06/10/2018, 22:55:04
    Author     : Vítor Lucas
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
        <title>Formulário de Funcionário - Capital Notebooks</title>
        
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
                            <h3 class="mb-0 my-2">Cadastro de Funcionário</h3>
                        </div>
                        <div class="card-body">
       
        <form class="form" role="form" autocomplete="off" action="gerenciar_funcionario.do" method="POST">
           
            
             <input type="hidden" class="form-control" name="idFuncionario" id="idFuncionario" value="${f.idFuncionario}"/>
            
             <div class="row">
                <div class="form-group col-sm-6">
                    <label for="nome" class="control-label">Nome:</label>    
                    <input type="text" class="form-control" placeholder="Digite o nome do funcionário"  required="" name="nome" id="nome" value="${f.nome}"/>
                </div>
                <div class="form-group col-sm-6">
                    <label for="cpf" class="control-label">CPF</label>    
                    <input type="text" class="cpf form-control" style="display:inline-block" placeholder="Digite o CPF ou CNPJ" required="" name="cpf" id="cpf" value="${f.cpf}"/>
                </div>
            </div>
               
                         
                           
            <div class="row">
                <div class="form-group col-sm-6">
                   <label for="telefone" class="control-label">Telefone</label>    
                    <input type="text" class="telefone form-control" style="display:inline-block" placeholder="Telefone para contato Ex.: (000) 00000-0000" name="telefone" id="telefone" value="${f.telefone}"/>
                </div>
                <div class="form-group col-sm-6">
                    <label for="endereco" class="control-label">Endereço:</label>    
                    <input type="text" class="form-control" required="" placeholder="Ex.: Quadra - Numero - Bairro - Cidade - Estado"  name="endereco" id="endereco" value="${f.endereco}"/>
                </div>
            </div>
                
                                    
            <div class="row">
                <button class="btn btn-success">
                    Gravar
                </button>
                <a href="listar_funcionario.jsp" class="btn btn-warning">Voltar</a>
            </div>
        </form>
                        </div></div></div></div></div></div></div></div>
                  <%@include file="script.jsp" %>
                        <%@include file="mascaraForm.jsp" %>
                  
    </body>
</html>
