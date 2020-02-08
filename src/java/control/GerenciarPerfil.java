/*
 * To change this template, choose Tools | Templates
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
 * @author Administrador
 */
public class GerenciarPerfil extends HttpServlet {

    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String mensagem = "";
        String idPerfil = request.getParameter("idPerfil");
        String acao = request.getParameter("acao");
        Perfil p = new Perfil();
        try{
            if(acao.equals("deletar")){
                if(idPerfil.equals("")||idPerfil.isEmpty()){
                    mensagem = "O campo idperfil não foi selecionado";
                }else{
                    p.setIdPerfil(Integer.parseInt(idPerfil));
                    if(p.deletar()){
                        mensagem ="Perfil deletado!";
                    }else{
                        mensagem = "Erro ao deletar!";
                    }
                }
            }
            if(acao.equals("alterar")){
                Perfil novo = new Perfil();
                novo = p.getCarregaPorID(Integer.parseInt(idPerfil));
                if(novo.getIdPerfil()>0){
                    RequestDispatcher disp = getServletContext().getRequestDispatcher("/form_perfil.jsp");
                    request.setAttribute("p", novo);
                    disp.forward(request, response);
                }else{
                    mensagem ="Perfil não encontrado";
                }
            
            }
        }catch(Exception e){
            out.println(e);
            mensagem = "Erro ao acessar o banco";
        }
        out.println("<script type='text/javascript'>");
        out.println("alert('"+mensagem+"');");
        out.println("location.href='listar_perfil.jsp';");
        out.println("</script>");
    }
        
  
      protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
         String idPerfil = request.getParameter("idPerfil");
        String perfil = request.getParameter("perfil");
       
        String mensagem ="";
        Perfil p = new Perfil();
        try{
            if(!idPerfil.isEmpty())
                p.setIdPerfil(Integer.parseInt(idPerfil));
            if(perfil.equals("")||perfil.isEmpty()){
                mensagem = "O campo perfil deve ser preenchido";
            }else{
                p.setPerfil(perfil);
                if(p.gravar()){
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
        out.println("location.href='listar_perfil.jsp';");
        out.println("</script>");
    }
  
}
