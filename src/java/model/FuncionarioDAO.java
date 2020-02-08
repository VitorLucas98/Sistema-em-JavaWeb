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


/**
 *
 * @author Vítor Lucas
 */
public class FuncionarioDAO extends DataBaseDAO{
     public FuncionarioDAO() throws Exception {
    }
    
    public List<Funcionario> getLista() throws Exception{
        List<Funcionario> lista = new ArrayList<Funcionario>();
        String sql = "SELECT * FROM funcionario";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while(rs.next()){
            Funcionario f = new Funcionario();
            f.setIdFuncionario(rs.getInt("idFuncionario"));
            f.setNome(rs.getString("nome"));
            f.setTelefone(rs.getString("telefone"));
            f.setCpf(rs.getString("cpf"));
            f.setEndereco(rs.getString("endereco"));
            lista.add(f);
        }
        this.desconectar();
        return lista;
    }
    
    
    public Funcionario getCarregaPorID(int idFuncionario) throws Exception{
        String sql = "SELECT * FROM funcionario WHERE idFuncionario=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1,idFuncionario);
        ResultSet rs = pstm.executeQuery();
        Funcionario f = new Funcionario();
        if(rs.next()){
            f.setIdFuncionario(rs.getInt("idFuncionario"));
            f.setNome(rs.getString("nome"));
            f.setTelefone(rs.getString("telefone"));
            f.setEndereco(rs.getString("endereco"));
            f.setCpf(rs.getString("cpf"));
        }
        this.desconectar();
        return f;
    }
    
    public boolean deletar(Funcionario f){
        try{
            this.conectar();
            String sql = "DELETE FROM funcionario WHERE idFuncionario=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, f.getIdFuncionario());
            pstm.execute();
            this.desconectar();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
        public boolean gravar(Funcionario f){
        try{
            this.conectar();
            String sql;
            if(f.getIdFuncionario()==0)
                sql = "INSERT INTO funcionario (nome,telefone,endereco,cpf) VALUES (?,?,?,?)";
            else
                sql = "UPDATE funcionario SET nome=?,telefone=?,endereco=?,cpf=? WHERE idFuncionario=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, f.getNome());
            pstm.setString(2, f.getTelefone());
            pstm.setString(3, f.getEndereco());
            pstm.setString(4, f.getCpf());
            if(f.getIdFuncionario()>0)
                pstm.setInt(5,f.getIdFuncionario());           
            pstm.execute();
            this.desconectar();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
        

        
}
