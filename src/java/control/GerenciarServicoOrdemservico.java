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
import model.OrdemServico;

/**
 *
 * @author Vítor Lucas
 */
public class GerenciarServicoOrdemservico extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              PrintWriter out = response.getWriter();
        String mensagem = "";
        String idNumero = request.getParameter("idNumero");
        String acao = request.getParameter("acao");
        try{
            if(acao.equals("gerenciar")){
                OrdemServico os = new OrdemServico();
                OrdemServico novo = new OrdemServico();
                novo = os.getCarregaPorID(Integer.parseInt(idNumero));
                if(novo.getIdNumero()>0){
                    RequestDispatcher disp = getServletContext().getRequestDispatcher("/form_servico_ordemservico.jsp");
                    request.setAttribute("ordemservicov", novo);
                    disp.forward(request, response);
                }else{
                    mensagem = "Ordem de serviço não encontrada";
                }
            }
            if(acao.equals("desvincular")){
                String idServico= request.getParameter("idServico");
                if(idServico.equals("")||idServico.isEmpty()){
                    mensagem = "Selecione o Serviço";
                }else{
                    OrdemServico os = new OrdemServico();
                    if(os.desvincular(Integer.parseInt(idNumero), 
                        Integer.parseInt(idServico))){
                        mensagem = "Desvinculado com sucesso";    
                    }else{
                        mensagem = "Erro ao desvincular";
                    }  
                }
            }
        }catch(Exception e){
            out.print(e);
        }
        out.println("<script type='text/javascript'>");
        out.println("alert('"+mensagem+"');");
        out.println("location.href='gerenciarservico_ordemservico.do?acao=gerenciar&idNumero="+idNumero+"';");
        out.println("</script>");  
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             PrintWriter out = response.getWriter();
        String mensagem = "";
        String idNumero = request.getParameter("idNumero");
        String idServico = request.getParameter("idServico");
        try{
            if(idNumero.equals("")||idServico.equals("")){
                mensagem = "Campos obrigatórios devem ser preenchidos";
            }else{
                OrdemServico os = new OrdemServico();
                if(os.vincular(Integer.parseInt(idNumero), 
                        Integer.parseInt(idServico))){
                    mensagem = "Vinculado com sucesso";
                }else{
                    mensagem = "Erro ao vincular";
                }
            }
            
        }catch(Exception e){
            out.print(e);
        }
        out.println("<script type='text/javascript'>");
        out.println("alert('"+mensagem+"');");
        out.println("location.href='gerenciarservico_ordemservico.do?acao=gerenciar&idNumero="+idNumero+"';");
        out.println("</script>");
    }

}
