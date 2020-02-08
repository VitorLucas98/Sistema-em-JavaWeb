/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vítor Lucas
 */
public class OrdemServicoDAO extends DataBaseDAO {
    public OrdemServicoDAO() throws Exception{}
    
    public List<OrdemServico> getLista() throws Exception{
        List<OrdemServico> lista = new ArrayList<OrdemServico>();
        String sql = "SELECT os.* FROM  ordemservico os ";                 
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while(rs.next()){
            OrdemServico os = new OrdemServico();
            os.setIdNumero(rs.getInt("os.IdNumero"));
            os.setDataAbertura(rs.getDate("os.dataAbertura"));
            os.setDataFechamento(rs.getDate("os.dataFechamento"));
            os.setObservacao(rs.getString("os.observacao"));
            os.setEquipamento(rs.getString("os.equipamento"));
            os.setCarregador(rs.getString("os.carregador"));
            os.setBateria(rs.getString("os.bateria"));
            os.setStatus(rs.getString("os.status"));
            os.setDefeito(rs.getString("os.defeito"));
            os.setNumeroSerie(rs.getString("os.numeroSerie"));

            
            Cliente c = new Cliente();
            os.setCliente(c.getCarregaPorID(rs.getInt("os.idCliente")));
            
            Usuario u = new Usuario();
            os.setUsuario(u.getCarregaPorID(rs.getInt("os.idUsuario")));
            
            lista.add(os);
        }
        this.desconectar();
        return lista;
    }
    
    public OrdemServico getCarregaPorID(int id) throws Exception{
        String sql = "SELECT * FROM  ordemservico WHERE IdNumero=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1,id);
        ResultSet rs = pstm.executeQuery();
        OrdemServico os = new OrdemServico();
        if(rs.next()){            
            os.setIdNumero(rs.getInt("IdNumero"));
            os.setDataAbertura(rs.getDate("dataAbertura"));
            os.setDataFechamento(rs.getDate("dataFechamento"));
            os.setObservacao(rs.getString("observacao"));
            os.setEquipamento(rs.getString("equipamento"));
            os.setCarregador(rs.getString("carregador"));
            os.setBateria(rs.getString("bateria"));
            os.setStatus(rs.getString("status"));
            os.setDefeito(rs.getString("defeito"));
            os.setNumeroSerie(rs.getString("numeroSerie"));

            
            Cliente c = new Cliente();
            os.setCliente(c.getCarregaPorID(rs.getInt("idCliente")));
            
            Usuario u = new Usuario();
            os.setUsuario(u.getCarregaPorID(rs.getInt("idUsuario")));
            
            os.setServicos(servicosVinculadosPorOrdemServico(id));
            os.setNaoServicos(servicosNaoVinculadosPorOrdemServico(id));
        }
        this.desconectar();
        return os;
    }
    
    public boolean deletar(OrdemServico u){
        try{
            this.conectar();
            String sql = "DELETE FROM ordemservico WHERE idNumero=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, u.getIdNumero());
            pstm.execute();
            this.desconectar();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean gravar(OrdemServico os){
        try{
            this.conectar();
            String sql;
            if(os.getIdNumero()==0)
                sql = "INSERT INTO ordemservico (dataAbertura, dataFechamento, observacao, "
                        + "equipamento, carregador, bateria, status, defeito, numeroSerie,"
                        + " idCliente, idUsuario) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            else
                sql = "UPDATE ordemservico SET dataAbertura=?, dataFechamento=?, observacao=?,"
                        + "equipamento=?, carregador=?, bateria=?, status=?, defeito=?,numeroSerie=?, idCliente=?, idUsuario=? WHERE IdNumero=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setDate(1, new Date (os.getDataAbertura().getTime()));
            pstm.setDate(2, new Date (os.getDataFechamento().getTime()));
            pstm.setString(3, os.getObservacao());
            pstm.setString(4, os.getEquipamento());
            pstm.setString(5, os.getCarregador());
            pstm.setString(6, os.getBateria());
            pstm.setString(7, os.getStatus());
            pstm.setString(8, os.getDefeito());
            pstm.setString(9, os.getNumeroSerie());            
            pstm.setInt(10, os.getCliente().getIdCliente());
            pstm.setInt(11, os.getUsuario().getIdUsuario());
            if(os.getIdNumero()>0)
                pstm.setInt(12,os.getIdNumero());            
            pstm.execute();
            this.desconectar();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
      public boolean encerrar(OrdemServico os){
        try{
            this.conectar();
            String sql;
              sql = "UPDATE ordemservico SET dataFechamento=?, status=? WHERE IdNumero=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setDate(1, new Date (os.getDataFechamento().getTime()));
            pstm.setString(2, os.getStatus());
            pstm.setInt(3, os.getIdNumero());
                                   
            pstm.execute();
            this.desconectar();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean vincular(int idNumero, int idServico){
        try{
            String sql = "INSERT INTO ordemservico_servico(idNumero, idServico)"
                    + " VALUES(?,?)";
            this.conectar();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1,idNumero);
            pstm.setInt(2, idServico);
            pstm.execute();
            this.desconectar();
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    } 
        public boolean desvincular(int idNumero, int idServico){
        try{
            String sql = "DELETE FROM ordemservico_servico WHERE idNumero=? AND idServico=?";
            this.conectar();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1,idNumero);
            pstm.setInt(2,idServico);
            pstm.execute();
            this.desconectar();
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    
    }
    
    public List<Servico> servicosVinculadosPorOrdemServico(int id) throws Exception{
        List<Servico> lista = new ArrayList<Servico>();
        String sql = "SELECT s.* FROM ordemservico_servico as oss, servico as s "
                + "WHERE oss.idServico = s.idServico AND oss.idNumero=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1,id);
        ResultSet rs = pstm.executeQuery();
        while(rs.next()){
            Servico s = new Servico();
            s.setIdServico(rs.getInt("s.idServico"));
            s.setNome(rs.getString("s.nome"));
            s.setDescricao(rs.getString("s.descricao"));
            s.setValor(rs.getDouble("s.valor"));
           
            lista.add(s);
        }
        this.desconectar();
        return lista;
        
    }
    public List<Servico> servicosNaoVinculadosPorOrdemServico(int id) throws Exception{
        List<Servico> lista = new ArrayList<Servico>();
        String sql = "SELECT * FROM servico "
                + "WHERE idServico "
                + "NOT IN(SELECT idServico FROM ordemservico_servico WHERE idNumero=?) ";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1,id);
        ResultSet rs = pstm.executeQuery();
        while(rs.next()){
            Servico s = new Servico();
            s.setIdServico(rs.getInt("idServico"));
            s.setNome(rs.getString("nome"));
            s.setDescricao(rs.getString("descricao"));
            s.setValor(rs.getDouble("valor"));
            
          
            lista.add(s);
        }
        this.desconectar();
        return lista;
        
    }
}
