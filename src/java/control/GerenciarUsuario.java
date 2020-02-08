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
import model.Perfil;
import model.Usuario;

/**
 *
 * @author Vítor Lucas
 */
public class GerenciarUsuario extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            PrintWriter out = response.getWriter();
            String mensagem = "";
            String idUsuario = request.getParameter("idUsuario");
            String acao = request.getParameter("acao");
            Usuario u = new Usuario();
            try{
            if(acao.equals("deletar")){
                if(idUsuario.equals("")||idUsuario.isEmpty()){
                    mensagem = "O campo idUsuario não foi selecionado";
                }else{
                    u.setIdUsuario(Integer.parseInt(idUsuario));
                    if(u.deletar()){
                        mensagem ="Usuário deletado!";
                    }else{
                        mensagem = "Erro ao deletar!";
                    }
                }
            }
            if(acao.equals("alterar")){
                Usuario novo = new Usuario();
                novo = u.getCarregaPorID(Integer.parseInt(idUsuario));
                if(novo.getIdUsuario()>0){
                    RequestDispatcher disp = getServletContext().getRequestDispatcher("/form_usuario.jsp");
                    request.setAttribute("u", novo);
                    disp.forward(request, response);
                }else{
                    mensagem ="Usuário não encontrado";
                }
            
            }
        }catch(Exception e){
            out.println(e);
            mensagem = "Erro ao acessar o banco";
        }
        out.println("<script type='text/javascript'>");
        out.println("alert('"+mensagem+"');");
        out.println("location.href='listar_usuario.jsp';");
        out.println("</script>");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String idUsuario = request.getParameter("idUsuario");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String idPerfil = request.getParameter("idPerfil");
        String idFuncionario = request.getParameter("idFuncionario");

        String mensagem = "";
        
        Usuario u = new Usuario();
        if(!idUsuario.isEmpty())
            u.setIdUsuario(Integer.parseInt(idUsuario));
        if((login.equals(""))||(senha.equals(""))||
                (idPerfil.equals(""))||(idFuncionario.equals(""))){
            mensagem = "Campos obrigatórios deverão ser preenchidos!";
        }else{
            try {
                u.setLogin(login);
                u.setSenha(senha);
                Perfil p = new Perfil();
                p.setIdPerfil(Integer.parseInt(idPerfil));
                u.setPerfil(p);
                Funcionario f = new Funcionario();
                f.setIdFuncionario(Integer.parseInt(idFuncionario));
                u.setFuncionario(f);
                if(u.gravar()){
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
        out.println("location.href='listar_usuario.jsp';");
        out.println("</script>"); 
        
        
    }
}
