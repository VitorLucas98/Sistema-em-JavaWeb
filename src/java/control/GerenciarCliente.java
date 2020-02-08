/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;

/**
 *
 * @author Vítor Lucas
 */
public class GerenciarCliente extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                PrintWriter out = response.getWriter();
        String mensagem = "";
        String idCliente = request.getParameter("idCliente");
        String acao = request.getParameter("acao");
        Cliente c = new Cliente();
        try{
            if(acao.equals("deletar")){
                if(idCliente.equals("")||idCliente.isEmpty()){
                    mensagem = "O campo idCliente não foi selecionado";
                }else{
                    c.setIdCliente(Integer.parseInt(idCliente));
                    if(c.deletar()){
                        mensagem ="Cliente deletado!";
                    }else{
                        mensagem = "Erro ao deletar!";
                    }
                }
            }
            if(acao.equals("alterar")){
                Cliente novo = new Cliente();
                novo = c.getCarregaPorID(Integer.parseInt(idCliente));
                if(novo.getIdCliente()>0){
                    RequestDispatcher disp = getServletContext().getRequestDispatcher("/form_cliente.jsp");
                    request.setAttribute("c", novo);
                    disp.forward(request, response);
                }else{
                    mensagem ="Cliente não encontrado";
                }
            
            }
        }catch(Exception e){
            out.println(e);
            mensagem = "Erro ao acessar o banco";
        }
        out.println("<script type='text/javascript'>");
        out.println("alert('"+mensagem+"');");
        out.println("location.href='listar_cliente.jsp';");
        out.println("</script>");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String cpf_cnpj = request.getParameter("cpf_cnpj");
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String endereco = request.getParameter("endereco");
        String nomeReferencia = request.getParameter("nomeReferencia");
        String telefoneReferencia = request.getParameter("telefoneReferencia");
        String idCliente = request.getParameter("idCliente");
        String mensagem ="";
        Cliente c = new Cliente();
        try{
            if(!idCliente.isEmpty())
                c.setIdCliente(Integer.parseInt(idCliente));
           if((cpf_cnpj.equals(""))||(nome.equals(""))||
              (telefone.equals(""))||(endereco.equals(""))||
              (nomeReferencia.equals(""))||(telefoneReferencia.equals(""))){
            mensagem = "Campos obrigatórios deverão ser preenchidos!";
            }else{
               c.setCpf_cnpj(cpf_cnpj);
               c.setNome(nome);
               c.setTelefone(telefone);
               c.setEndereco(endereco);
               c.setNomeReferencia(nomeReferencia);
               c.setTelefoneReferencia(telefoneReferencia);
                if(c.gravar()){
                    mensagem = "Gravado com sucesso";
                }else{
                    mensagem = "Erro ao gravar no banco";
                }
            }
        }catch(Exception e){
            out.print(e);
            mensagem = "Erro ao acessar o banco";
        }
        out.println("<script type='text/javascript'>");
        out.println("alert('"+mensagem+"');");
        out.println("location.href='listar_cliente.jsp';");
        out.println("</script>");
    }
}
