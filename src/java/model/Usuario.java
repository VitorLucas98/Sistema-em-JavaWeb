/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.List;
/**
 *
 * @author Administrador
 */
public class Usuario {
    private int idUsuario;
    private String login;
    private String senha;
    private Perfil perfil;
    private Funcionario funcionario;

    public Usuario() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
     public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    

    public String toString() {
        return getLogin();
    }
    
    public List<Usuario> getLista() throws Exception{
        UsuarioDAO uDAO = new UsuarioDAO();
        return uDAO.getLista();
    }
    
    public boolean deletar() throws Exception{
        UsuarioDAO uDAO = new UsuarioDAO();
        return uDAO.deletar(this);
    }
    
    public boolean gravar() throws Exception{
        UsuarioDAO uDAO = new UsuarioDAO();
        return uDAO.gravar(this);
    }
    
    public Usuario getCarregaPorID(int idUsuario)throws Exception{
        UsuarioDAO uDAO = new UsuarioDAO();
        return uDAO.getCarregaPorID(idUsuario);
    }
     public Usuario getRecuperarUsuario(String login) throws Exception{
        UsuarioDAO uDAO = new UsuarioDAO();
        return uDAO.getRecuperarUsuario(login);
    
    }
   
}
