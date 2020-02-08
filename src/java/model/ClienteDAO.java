
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;

public class ClienteDAO extends DataBaseDAO {
    
     public ClienteDAO() throws Exception {
    }
    public List<Cliente> getLista() throws Exception{
        List<Cliente> lista = new ArrayList<Cliente>();
        String sql = "SELECT * FROM cliente";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while(rs.next()){
            Cliente c = new Cliente();
            c.setIdCliente(rs.getInt("idCliente"));
            c.setCpf_cnpj(rs.getString("cpf_cnpj"));
            c.setNome(rs.getString("nome"));
            c.setTelefone(rs.getString("telefone"));
            c.setEndereco(rs.getString("endereco"));
            c.setNomeReferencia(rs.getString("nomeReferencia"));
            c.setTelefoneReferencia(rs.getString("telefoneReferencia"));
            lista.add(c);
        }
        this.desconectar();
        return lista;
    }
        public Cliente getCarregaPorID(int idcliente) throws Exception{
        String sql = "SELECT * FROM cliente WHERE idcliente=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1,idcliente);
        ResultSet rs = pstm.executeQuery();
        Cliente c= new Cliente();
        if(rs.next()){
            c.setIdCliente(rs.getInt("idcliente"));
            c.setCpf_cnpj(rs.getString("cpf_cnpj"));
            c.setNome(rs.getString("nome"));
            c.setTelefone(rs.getString("telefone"));
            c.setEndereco(rs.getString("endereco"));
            c.setNomeReferencia(rs.getString("nomeReferencia"));
            c.setTelefoneReferencia(rs.getString("telefoneReferencia"));
        }
        this.desconectar();
        return c;
    }
        public boolean deletar(Cliente c){
        try{
            this.conectar();
            String sql = "DELETE FROM cliente WHERE idCliente=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, c.getIdCliente());
            pstm.execute();
            this.desconectar();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
        public boolean gravar(Cliente c){
        try{
            this.conectar();
            String sql;
            if(c.getIdCliente()==0) 
                sql = "INSERT INTO cliente (cpf_cnpj,nome,telefone,endereco,nomeReferencia,telefoneReferencia) VALUES (?,?,?,?,?,?)";    
            else
                sql = "UPDATE cliente SET cpf_cnpj=?,nome=?,telefone=?,endereco=?,nomeReferencia=?,telefoneReferencia=? WHERE idCliente=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
           
            pstm.setString(1, c.getCpf_cnpj());
            pstm.setString(2, c.getNome());
            pstm.setString(3, c.getTelefone());
            pstm.setString(4, c.getEndereco());
            pstm.setString(5, c.getNomeReferencia());
            pstm.setString(6, c.getTelefoneReferencia());          
            
            if(c.getIdCliente()>0)
                pstm.setInt(7, c.getIdCliente()); 
            
            pstm.execute();
            this.desconectar();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
