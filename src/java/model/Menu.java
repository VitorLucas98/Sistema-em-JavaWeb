/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class Menu {
    private int idMenu;
    private String menu;
    private String link;
    private String icone;
    private int exibir;

    public Menu() {
    }

    public Menu(int idMenu, String menu, String link, String icone, int exibir) {
        this.idMenu = idMenu;
        this.menu = menu;
        this.link = link;
        this.icone = icone;
        this.exibir = exibir;
    }

    
    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public int getExibir() {
        return exibir;
    }

    public void setExibir(int exibir) {
        this.exibir = exibir;
    }

    @Override
    public String toString() {
        return getMenu();
    }
    
    public ArrayList<Menu> getLista()throws Exception{
    
        MenuDAO mDAO = new MenuDAO();
        return mDAO.getLista();
    }
    
    public boolean gravar() throws Exception{
        MenuDAO mDAO = new MenuDAO();
        return mDAO.gravar(this);
    }
    
    public boolean deletar() throws Exception{
        MenuDAO mDAO = new MenuDAO();
        return mDAO.deletar(this);
    }
    
    public Menu getCarregaPorId(int idmenu) throws Exception{
        MenuDAO mDAO = new MenuDAO();
        return mDAO.getCarregaPorId(idmenu);
    }
    
}
