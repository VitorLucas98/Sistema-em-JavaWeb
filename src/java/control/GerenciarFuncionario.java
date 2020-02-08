
package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Funcionario;


/**
 *
 * @author Vítor Lucas
 */
public class GerenciarFuncionario extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String mensagem = "";
        String idFuncionario=request.getParameter("idFuncionario");
        String acao = request.getParameter("acao");
        Funcionario f = new Funcionario();
        try{
          //  acao.equals("deletar")
           
            
            if("deletar".equals(acao)){
                if(idFuncionario.equals("")||idFuncionario.isEmpty()){
                    mensagem = "O campo idFuncionario não foi selecionada";
                }else{
                    f.setIdFuncionario(Integer.parseInt(idFuncionario));
                    if(f.deletar()){
                        mensagem ="Funcionario deletado!";
                    }else{
                        mensagem = "Erro ao deletar!";
                    }
                }
            }
            //acao.equals("alterar")
            if("alterar".equals(acao)){
                Funcionario novo = new Funcionario();
                novo = f.getCarregaPorID(Integer.parseInt(idFuncionario));
                if(novo.getIdFuncionario()>0){
                    RequestDispatcher disp = getServletContext().getRequestDispatcher("/form_funcionario.jsp");
                    request.setAttribute("f", novo);
                    disp.forward(request, response);
                }else{
                    mensagem ="Funcionario não encontrado";
                }
            
            }
                          
        }catch(Exception e){
            out.println(e);
            mensagem = "Erro ao acessar o banco";
        }
        out.println("<script type='text/javascript'>");
        out.println("alert('"+mensagem+"');");
        out.println("location.href='listar_funcionario.jsp';");
        out.println("</script>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String idFuncionario = request.getParameter("idFuncionario");
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String endereco = request.getParameter("endereco");
         String cpf = request.getParameter("cpf");

        String mensagem ="";
        Funcionario f = new Funcionario();
        try{
            if(!idFuncionario.isEmpty())
                f.setIdFuncionario(Integer.parseInt(idFuncionario));
//            nome.equals("")
            if("".equals(nome)||nome.isEmpty()){
                mensagem = "O campo nome deve ser preenchido";
            }
            //telefone.equals("")
             if("".equals(telefone)||telefone.isEmpty()){
                mensagem = "O campo telefone deve ser preenchido";
            } 
             //endereco.equals("")
             if("".equals(endereco) ||endereco.isEmpty()){
                mensagem = "O campo endereço deve ser preenchido";
            }
             //cpf.equals("")
              if("".equals(cpf)||cpf.isEmpty()){
                mensagem = "O campo cpf deve ser preenchido";
             
              }else{
                f.setNome(nome);
                f.setTelefone(telefone);
                f.setEndereco(endereco);
                f.setCpf(cpf);

                if(f.gravar()){
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
        out.println("location.href='listar_funcionario.jsp';");
        out.println("</script>");
    }

}
