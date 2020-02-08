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
public class GarantiaServicoDAO extends DataBaseDAO {
    
    public GarantiaServicoDAO() throws Exception {
    }
    
    public List<GarantiaServico> getLista() throws Exception{
        List<GarantiaServico> lista = new ArrayList<GarantiaServico>();
        String sql = "SELECT gs.* FROM garantiaservico gs ";
                   
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while(rs.next()){
            GarantiaServico gs = new GarantiaServico();
            gs.setIdGarantiaServico(rs.getInt("gs.idGarantiaServico"));
            gs.setDataAbertura(rs.getDate("gs.dataAbertura"));
            gs.setObservacao(rs.getString("gs.observacao"));
            gs.setDiasGarantia(rs.getInt("gs.diasGarantia"));
            
            Servico s = new Servico();
            gs.setServico(s.getCarregaPorID(rs.getInt("gs.idServico")));

            lista.add(gs);
        }
        this.desconectar();
        return lista;
    }
    
    public GarantiaServico getCarregaPorID(int id) throws Exception{
        String sql = "SELECT * FROM garantiaservico WHERE idGarantiaServico=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1,id);
        ResultSet rs = pstm.executeQuery();
        GarantiaServico gs = new GarantiaServico();
        if(rs.next()){
            gs.setIdGarantiaServico(rs.getInt("idGarantiaServico"));
            gs.setDataAbertura(rs.getDate("dataAbertura"));
            gs.setObservacao(rs.getString("observacao"));
            gs.setDiasGarantia(rs.getInt("diasGarantia"));

            Servico s = new Servico();
            gs.setServico(s.getCarregaPorID(rs.getInt("idServico")));
        }
        this.desconectar();
        return gs;
    }
    
    public boolean deletar(GarantiaServico gs){
        try{
            this.conectar();
            String sql = "DELETE FROM garantiaservico WHERE idGarantiaServico=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, gs.getIdGarantiaServico());
            pstm.execute();
            this.desconectar();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean gravar(GarantiaServico gs){
        try{
            this.conectar();
            String sql;
            if(gs.getIdGarantiaServico()==0)
                sql = "INSERT INTO garantiaservico (dataAbertura, observacao, diasGarantia, idServico) VALUES (?,?,?,?)";
            else
                sql = "UPDATE garantiaservico SET dataAbertura=?, observacao=?, diasGarantia=?, idServico=? WHERE idGarantiaServico=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setDate(1, new Date (gs.getDataAbertura().getTime()));
            pstm.setString(2, gs.getObservacao());
            pstm.setInt(3, gs.getDiasGarantia());   
            pstm.setInt(4, gs.getServico().getIdServico());         
            if(gs.getIdGarantiaServico()>0)
                pstm.setInt(5,gs.getIdGarantiaServico());
            pstm.execute();
            this.desconectar();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
