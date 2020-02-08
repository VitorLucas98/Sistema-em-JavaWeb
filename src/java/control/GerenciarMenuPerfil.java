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
import model.Perfil;

/**
 *
 * @author Vítor Lucas
 */
public class GerenciarMenuPerfil extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String mensagem = "";
        String idPerfil = request.getParameter("idPerfil");
        String acao = request.getParameter("acao");
        try{
            if(acao.equals("gerenciar")){
                Perfil p = new Perfil();
                Perfil novo = new Perfil();
                novo = p.getCarregaPorID(Integer.parseInt(idPerfil));
                if(novo.getIdPerfil()>0){
                    RequestDispatcher disp = getServletContext().getRequestDispatcher("/form_menu_perfil.jsp");
                    request.setAttribute("perfilv", novo);
                    disp.forward(request, response);
                }else{
                    mensagem = "Perfil não encontrado";
                }
            }
            if(acao.equals("desvincular")){
                String idMenu= request.getParameter("idMenu");
                if(idMenu.equals("")||idMenu.isEmpty()){
                    mensagem = "Selecione o menu";
                }else{
                    Perfil p = new Perfil();
                    if(p.desvincular(Integer.parseInt(idPerfil), 
                        Integer.parseInt(idMenu))){
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
        out.println("location.href='gerenciar_menu_perfil.do?acao=gerenciar&idPerfil="+idPerfil+"';");
        out.println("</script>");
       
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String mensagem = "";
        String idPerfil = request.getParameter("idPerfil");
        String idMenu = request.getParameter("idMenu");
        try{
            if(idPerfil.equals("")||idMenu.equals("")){
                mensagem = "Campos obrigatórios devem ser preenchidos";
            }else{
                Perfil p = new Perfil();
                if(p.vincular(Integer.parseInt(idPerfil), 
                        Integer.parseInt(idMenu))){
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
        out.println("location.href='gerenciar_menu_perfil.do?acao=gerenciar&idPerfil="+idPerfil+"';");
        out.println("</script>");
    }
    }


