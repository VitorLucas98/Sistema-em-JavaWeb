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
import model.Menu;

/**
 *
 * @author Administrador
 */
public class GerenciarMenu extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               PrintWriter out = response.getWriter();
            String mensagem = "";
            try{
                int idMenu = Integer.parseInt(request.getParameter("idMenu"));
                Menu m = new Menu();
                if(request.getParameter("acao").equals("deletar")){
                        if(idMenu>0){
                            m.setIdMenu(idMenu);
                            if(m.deletar()){
                                mensagem = "Excluido com sucesso!";
                            }else{
                                mensagem = "Erro ao excluir!";
                            }
                        }
                    
                }
                if(request.getParameter("acao").equals("alterar")){
                       Menu novo = new Menu();
                       novo = m.getCarregaPorId(idMenu);
                       if(novo.getIdMenu()>0){
                           RequestDispatcher disp = getServletContext().getRequestDispatcher("/form_menu.jsp");
                           request.setAttribute("m", novo);
                           disp.forward(request, response);
                       }else{
                           mensagem = "Menu não encontrado!";
                       }
                   
                   
                }
                    
            }catch(Exception e){
                out.print(e);
                mensagem = "Erro ao acessar o banco "+e;
            }
            out.println("<script type='text/javascript'>");
            out.println("alert('"+mensagem+"')");
            out.println("location.href='listar_menu.jsp';");
            out.println("</script>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String idMenu = request.getParameter("idMenu");
        String menu = request.getParameter("menu");
        String link = request.getParameter("link");
        String icone = request.getParameter("icone");
        String exibir = request.getParameter("exibir");
        String mensagem = "";
        Menu m = new Menu();
        if(!idMenu.isEmpty()){
            m.setIdMenu(Integer.parseInt(idMenu));
        }
        m.setMenu(menu);
        m.setLink(link);
        m.setIcone(icone);
        m.setExibir(Integer.parseInt(exibir));
        try{
            if((menu.equals("")) || (menu.isEmpty()) 
               ||(link.equals("")|| (link.isEmpty())
               ||(exibir.equals("")|| (exibir.isEmpty())))){
                    mensagem = "Campo obrigatório deverá ser preecnhido!";
            }else{
                  if(m.gravar()){
                    mensagem = "Gravado com sucesso!";
                  }else{
                    mensagem = "Erro ao gravar no banco";  
                  }
            }
        
        }catch(Exception e){
            out.print(e);
            mensagem = "Erro ao gravar no banco!";
        }
        out.println("<script type='text/javascript'>");
        out.println("alert('"+mensagem+"')");
        out.println("location.href='listar_menu.jsp';");
        out.println("</script>");
        
    }
}
