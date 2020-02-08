/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Funcionario;


/**
 *
 * @author Vítor Lucas
 */
public class ServicoDAO extends DataBaseDAO{

    public ServicoDAO() throws Exception {
    }
   public List<Servico> getLista() throws Exception{
        List<Servico> lista = new ArrayList<Servico>();
        String sql = "SELECT s.* FROM servico s ";  
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
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
    
    public Servico getCarregaPorID(int id) throws Exception{
        String sql = "SELECT * FROM servico WHERE idServico=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1,id);
        ResultSet rs = pstm.executeQuery();
        Servico s = new Servico();
        if(rs.next()){
            s.setIdServico(rs.getInt("idServico"));
            s.setNome(rs.getString("nome"));
            s.setDescricao(rs.getString("descricao"));
            s.setValor(rs.getDouble("valor"));
    
        }
        this.desconectar();
        return s;
    }
    
    public boolean deletar(Servico s){
        try{
            this.conectar();
            String sql = "DELETE FROM servico WHERE idServico=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, s.getIdServico());
            pstm.execute();
            this.desconectar();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean gravar(Servico s){
        try{
            this.conectar();
            String sql;
            if(s.getIdServico()==0)
                sql = "INSERT INTO servico (nome, descricao, valor) VALUES (?,?,?)";
            else
                sql = "UPDATE servico SET nome=?, descricao=?, valor=? WHERE idServico=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, s.getNome());
            pstm.setString(2, s.getDescricao());
            pstm.setDouble(3, s.getValor());
        
           
            if(s.getIdServico()>0)
                pstm.setInt(4,s.getIdServico());
            pstm.execute();
            this.desconectar();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}