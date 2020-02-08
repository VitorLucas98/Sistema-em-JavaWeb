    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.OrdemServico;
import model.Servico;
import model.Usuario;
import java.util.Date;
/**
 *
 * @author Vítor Lucas
 */
public class GerenciarOrdemServico extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       PrintWriter out = response.getWriter();
        String mensagem = "";
        String idNumero = request.getParameter("idNumero");
        String acao = request.getParameter("acao");
        OrdemServico os = new OrdemServico();
        Date date = new Date();
        try{
            
            //acao.equals("deletar")
            if("deletar".equals(acao)){
                if(idNumero.equals("")||idNumero.isEmpty()){
                    mensagem = "O campo idNumero não foi selecionado";
                }else{
                    os.setIdNumero(Integer.parseInt(idNumero));
                    if(os.deletar()){
                        mensagem ="Ordem de Serviço deletado!";
                    }else{
                        mensagem = "Erro ao deletar!";
                    }
                }
            }
            //acao.equals("alterar")
            if("alterar".equals(acao)){
               OrdemServico novo = new OrdemServico();
                novo = os.getCarregaPorID(Integer.parseInt(idNumero));
                if(novo.getIdNumero()>0){
                    
                    RequestDispatcher disp = getServletContext().getRequestDispatcher("/form_ordemservico.jsp");
                    request.setAttribute("os", novo);
                    disp.forward(request, response);
                }else{
                    mensagem ="Ordem de Serviço não encontrada";
                }
            
            }
            
              if("visualizar".equals(acao)){
                   
                  
               OrdemServico novoOS = new OrdemServico();
                novoOS = os.getCarregaPorID(Integer.parseInt(idNumero));
                                OrdemServico novo = new OrdemServico();
                                novo = os.getCarregaPorID(Integer.parseInt(idNumero));
                if(novoOS.getIdNumero()>0){
                    RequestDispatcher disp = getServletContext().getRequestDispatcher("/visualizarOS.jsp");
                    request.setAttribute("os", novoOS);
                    request.setAttribute("ordemservicov", novo);
                    disp.forward(request, response);
                    
                }else{
                    mensagem ="Ordem de Serviço não encontrada";
                }
            
            }        
              
           
              
              if("encerrar".equals(acao))
               if(idNumero.equals("")||idNumero.isEmpty()){
                    mensagem = "O campo idNumero não foi selecionado";
                }else{
           Date diaHoje = new Date();
                     os.setIdNumero(Integer.parseInt(idNumero));
                     os.setDataFechamento(diaHoje);
                    os.setStatus("Encerrado");
                    if(os.encerrar()){
                        mensagem ="Ordem de Serviço Encerrada!";
                    }else{
                        mensagem = "Erro ao Encerrar!";
                    }
                }
              
        }catch(Exception e){
            out.println(e);
            mensagem = "Erro ao acessar o banco";
        }
        out.println("<script type='text/javascript'>");
        out.println("alert('"+mensagem+"');");
        out.println("location.href='listar_ordemservico.jsp';");
        out.println("</script>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String idNumero = request.getParameter("idNumero");
        String dataAbertura = request.getParameter("dataAbertura");
        String dataFechamento = request.getParameter("dataFechamento");
        String observacao = request.getParameter("observacao");
        String equipamento = request.getParameter("equipamento");
        String carregador = request.getParameter("carregador");
        String bateria = request.getParameter("bateria");
        String status = request.getParameter("status");
        String defeito = request.getParameter("defeito");
        String numeroSerie = request.getParameter("numeroSerie");
        String idCliente = request.getParameter("idCliente");
        String idUsuario = request.getParameter("idUsuario");
        String acao = request.getParameter("acao");
        String mensagem = "";
        
        OrdemServico os = new OrdemServico();
        if(!idNumero.isEmpty()){
            os.setIdNumero(Integer.parseInt(idNumero));}
        if((dataAbertura.equals(""))||(observacao.equals(""))||(equipamento.equals(""))||
                (carregador.equals(""))||(bateria.equals(""))||(defeito.equals(""))||(numeroSerie.equals(""))||
                (idCliente.equals(""))||(idUsuario.equals(""))){
            mensagem = "Campos obrigatórios deverão ser preenchidos!";
        }else{
            
            
            
            try {
                
                  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
      SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
      String data = "0000-00-00";
      Date date = ft.parse(data);
                os.setDataAbertura(df.parse(dataAbertura));
                os.setDataFechamento(date);
                os.setObservacao(observacao);
                os.setEquipamento(equipamento);
                os.setCarregador(carregador);
                os.setBateria(bateria);
                os.setStatus("Aberto");
                os.setDefeito(defeito);
                os.setNumeroSerie(numeroSerie);

                
                Cliente c = new Cliente();
                c.setIdCliente(Integer.parseInt(idCliente));
                os.setCliente(c);
                
                Usuario u = new Usuario();
                u.setIdUsuario(Integer.parseInt(idUsuario));
                os.setUsuario(u);
          
                if(os.gravar()){
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
        out.println("location.href='listar_ordemservico.jsp';");
        out.println("</script>");
    }
}
