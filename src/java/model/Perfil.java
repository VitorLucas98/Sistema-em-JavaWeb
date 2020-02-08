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
public class Perfil {
    private int idPerfil;
    private String perfil;
    private List<Menu> menus;
    private List<Menu> naoMenus;

    public Perfil() {
    }

    public Perfil(int idPerfil, String perfil, List<Menu> menus, List<Menu> naoMenus) {
        this.idPerfil = idPerfil;
        this.perfil = perfil;
        this.menus = menus;
        this.naoMenus = naoMenus;
    }
    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
        public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public List<Menu> getNaoMenus() {
        return naoMenus;
    }

    public void setNaoMenus(List<Menu> naoMenus) {
        this.naoMenus = naoMenus;
    }
    public String toString() {
        return getPerfil();
    }
    
    public List<Perfil> getLista() throws Exception{
        PerfilDAO pDAO = new PerfilDAO();
        return pDAO.getLista();
    }
    
    public boolean deletar() throws Exception{
        PerfilDAO pDAO = new PerfilDAO();
        return pDAO.deletar(this);
    }
    
    public boolean gravar() throws Exception{
        PerfilDAO pDAO = new PerfilDAO();
        return pDAO.gravar(this);
    }
    
    public Perfil getCarregaPorID(int id)throws Exception{
        PerfilDAO pDAO = new PerfilDAO();
        return pDAO.getCarregaPorID(id);
    }
        public boolean vincular(int idPerfil, int idMenu)throws Exception{
        PerfilDAO pDAO = new PerfilDAO();
        return pDAO.vincular(idPerfil,idMenu);
    }
    
    public boolean desvincular(int idPerfil, int idMenu)throws Exception{
        PerfilDAO pDAO = new PerfilDAO();
        return pDAO.desvincular(idPerfil,idMenu);
    }
    
}
