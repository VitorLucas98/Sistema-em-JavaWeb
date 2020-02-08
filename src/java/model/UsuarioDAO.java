/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Administrador
 */
public class UsuarioDAO extends DataBaseDAO {
    
    public UsuarioDAO() throws Exception{}
    
    public List<Usuario> getLista() throws Exception{
        List<Usuario> lista = new ArrayList<Usuario>();
        String sql = "SELECT u.* FROM usuario u";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while(rs.next()){
            Usuario u = new Usuario();
            u.setIdUsuario(rs.getInt("u.idUsuario"));
            u.setLogin(rs.getString("u.login"));
            u.setSenha(rs.getString("u.senha"));
           
            Perfil p = new Perfil();
            u.setPerfil(p.getCarregaPorID(rs.getInt("u.idPerfil")));
            
            Funcionario f = new Funcionario();
            u.setFuncionario(f.getCarregaPorID(rs.getInt("u.idFuncionario")));
            lista.add(u);
        }
        this.desconectar();
        return lista;
    }
    
    public Usuario getCarregaPorID(int idUsuario) throws Exception{
        String sql = "SELECT * FROM usuario WHERE idUsuario=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1,idUsuario);
        ResultSet rs = pstm.executeQuery();
        Usuario u = new Usuario();
        if(rs.next()){
            u.setIdUsuario(rs.getInt("idUsuario"));
            u.setLogin(rs.getString("login"));
            u.setSenha(rs.getString("senha"));
           
            Perfil p = new Perfil();
            u.setPerfil(p.getCarregaPorID(rs.getInt("idPerfil")));
            
            Funcionario f = new Funcionario();
            u.setFuncionario(f.getCarregaPorID(rs.getInt("idFuncionario")));
        }
        this.desconectar();
        return u;
    }
    
    public boolean deletar(Usuario u){
        try{
            this.conectar();
            String sql = "DELETE FROM usuario WHERE idUsuario=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, u.getIdUsuario());
            pstm.execute();
            this.desconectar();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
   public boolean gravar(Usuario u){
        try{
            this.conectar();
            String sql;
            if(u.getIdUsuario()==0)
                sql = "INSERT INTO usuario (login, senha, idPerfil, idFuncionario) VALUES (?,?,?,?)";
            else
                sql = "UPDATE usuario SET login=?, senha=?, idPerfil=?, idFuncionario=? WHERE idUsuario=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, u.getLogin());
            pstm.setString(2, u.getSenha());
            pstm.setInt(3, u.getPerfil().getIdPerfil());
            pstm.setInt(4, u.getFuncionario().getIdFuncionario());
            if(u.getIdUsuario()>0)
                pstm.setInt(5,u.getIdUsuario());
            pstm.execute();
            this.desconectar();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
        public Usuario getRecuperarUsuario(String login){
        Usuario u = new Usuario();
        String sql = "SELECT u.*, p.perfil FROM usuario u "
                    + "INNER JOIN perfil p ON p.idPerfil = u.idPerfil "
                    + "WHERE u.login=?";
        
        try{
            this.conectar();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1,login);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                u.setIdUsuario(rs.getInt("u.idUsuario"));
                u.setLogin(rs.getString("u.login"));
                u.setSenha(rs.getString("u.senha"));
                Perfil p = new Perfil();
                u.setPerfil(p.getCarregaPorID(rs.getInt("u.idPerfil")));
                 Funcionario f = new Funcionario();
                 u.setFuncionario(f.getCarregaPorID(rs.getInt("u.idFuncionario")));
            }
            this.desconectar();
            return u;
        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    
    
    }
    
    
}
