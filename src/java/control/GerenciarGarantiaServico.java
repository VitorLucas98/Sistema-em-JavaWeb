/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.GarantiaServico;
import model.Servico;

/**
 *
 * @author Vítor Lucas
 */
public class GerenciarGarantiaServico extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String mensagem = "";
        String idGarantiaServico = request.getParameter("idGarantiaServico");
        String acao = request.getParameter("acao");
        GarantiaServico gs = new GarantiaServico();
        try{
            if(acao.equals("deletar")){
                if(idGarantiaServico.equals("")||idGarantiaServico.isEmpty()){
                    mensagem = "O campo idGarantiaServico não foi selecionado";
                }else{
                    gs.setIdGarantiaServico(Integer.parseInt(idGarantiaServico));
                    if(gs.deletar()){
                        mensagem ="Garantia de Serviço deletado!";
                    }else{
                        mensagem = "Erro ao deletar!";
                    }
                }
            }
            if(acao.equals("alterar")){
                GarantiaServico novo = new GarantiaServico();
                novo = gs.getCarregaPorID(Integer.parseInt(idGarantiaServico));
                if(novo.getIdGarantiaServico()>0){
                    RequestDispatcher disp = getServletContext().getRequestDispatcher("/form_garantiaservico.jsp");
                    request.setAttribute("gs", novo);
                    disp.forward(request, response);
                }else{
                    mensagem ="Garantia de Servico não encontrada";
                }
            
            }
        }catch(Exception e){
            out.println(e);
            mensagem = "Erro ao acessar o banco";
        }
        out.println("<script type='text/javascript'>");
        out.println("alert('"+mensagem+"');");
        out.println("location.href='listar_garantiaservico.jsp';");
        out.println("</script>");
        
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String idGarantiaServico = request.getParameter("idGarantiaServico");
        String dataAbertura = request.getParameter("dataAbertura");
        String observacao = request.getParameter("observacao");
        String diasGarantia = request.getParameter("diasGarantia");
        
        String idServico = request.getParameter("idServico");

        String mensagem = "";
        
        GarantiaServico gs = new GarantiaServico();
        
        if(!idGarantiaServico.isEmpty())
            gs.setIdGarantiaServico(Integer.parseInt(idGarantiaServico));
        if((dataAbertura.equals(""))||(observacao.equals(""))||
                (diasGarantia.equals(""))||(idServico.equals(""))){
            mensagem = "Campos obrigatórios deverão ser preenchidos!";
        }else{
            try {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                
                gs.setDataAbertura(df.parse(dataAbertura));
                gs.setObservacao(observacao);
                gs.setDiasGarantia(Integer.parseInt(diasGarantia));
                
                Servico s = new Servico();
                s.setIdServico(Integer.parseInt(idServico));
                gs.setServico(s);
                
                if(gs.gravar()){
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
        out.println("location.href='listar_garantiaservico.jsp';");
        out.println("</script>"); 
        
        
        
    }

}
