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
import model.Funcionario;
import model.Servico;

/**
 *
 * @author Vítor Lucas
 */
public class GerenciarServico extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String mensagem = "";
        String idServico = request.getParameter("idServico");
        String acao = request.getParameter("acao");
        Servico s = new Servico();
        try{
            if(acao.equals("deletar")){
                if(idServico.equals("")||idServico.isEmpty()){
                    mensagem = "O campo idServico não foi selecionado";
                }else{
                    s.setIdServico(Integer.parseInt(idServico));
                    if(s.deletar()){
                        mensagem ="Serviço deletado!";
                    }else{
                        mensagem = "Erro ao deletar!";
                    }
                }
            }
            if(acao.equals("alterar")){
                Servico novo = new Servico();
                novo = s.getCarregaPorID(Integer.parseInt(idServico));
                if(novo.getIdServico()>0){
                    RequestDispatcher disp = getServletContext().getRequestDispatcher("/form_servico.jsp");
                    request.setAttribute("s", novo);
                    disp.forward(request, response);
                }else{
                    mensagem ="Serviço não encontrado";
                }
            
            }
        }catch(Exception e){
            out.println(e);
            mensagem = "Erro ao acessar o banco";
        }
       out.println("<script type='text/javascript'>");
        out.println("alert('"+mensagem+"');");
        out.println("location.href='listar_servico.jsp';");
        out.println("</script>");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String idServico = request.getParameter("idServico");
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String valor = request.getParameter("valor");
             
        String mensagem = "";
        
        Servico s = new Servico();
        if(!idServico.isEmpty())
            s.setIdServico(Integer.parseInt(idServico));
        if((nome.equals(""))||(descricao.equals(""))||
                (valor.equals(""))){
            mensagem = "Campos obrigatórios deverão ser preenchidos!";
        }else{
            try {
                s.setNome(nome);
                s.setDescricao(descricao);
                
                double novoValor = 0;
                if(!valor.isEmpty())
                novoValor = Double.parseDouble(valor.replace(".","").replace(",","."));
            s.setValor(novoValor);
             
              
                if(s.gravar()){
                    mensagem = "Gravado com sucesso!";
                }else{
                    mensagem = "Erro ao gravar no banco";
                }
            } catch (Exception ex) {
                out.print(ex);
                mensagem = "Erro ao gravar no banco";
            }
        }
        out.println("<script type='text/javascript'>");
        out.println("alert('"+mensagem+"');");
        out.println("location.href='listar_servico.jsp';");
        out.println("</script>"); 
    }

}
