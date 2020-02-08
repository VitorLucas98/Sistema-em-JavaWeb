/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class MenuDAO extends DataBaseDAO{

    public MenuDAO() throws Exception {
    }
    
    
    public ArrayList<Menu> getLista() throws Exception{
        
        this.conectar();
        ArrayList<Menu> lista = new ArrayList<Menu>();
        String sql = "SELECT * FROM menu";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        while(rs.next()){
            Menu m = new Menu();
            m.setIdMenu(rs.getInt("idMenu"));
            m.setMenu(rs.getString("menu"));
            m.setIcone(rs.getString("icone"));
            m.setLink(rs.getString("link"));
            m.setExibir(rs.getInt("exibir"));
            lista.add(m);
        }
        this.desconectar();
        return lista;
    }
    
    public boolean gravar(Menu m){
        try{
            String sql;
            this.conectar();
            if(m.getIdMenu()==0){
                sql = "INSERT INTO menu (menu, icone, link, exibir) VALUES (?,?,?,?)";
            }else{
                sql = "UPDATE menu set menu = ?, icone = ? ,link = ?, exibir = ? WHERE idMenu = ?";
            }
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1,m.getMenu());
            pstm.setString(2, m.getIcone());
            pstm.setString(3, m.getLink());
            pstm.setInt(4, m.getExibir());
            if(m.getIdMenu()>0){
                pstm.setInt(5, m.getIdMenu());
            }
            pstm.execute();
            this.desconectar();
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    
    }
    
    public boolean deletar(Menu m){
        try{
            this.conectar();
            String sql = "DELETE FROM menu WHERE idMenu = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, m.getIdMenu());
            pstm.execute();
            this.desconectar();
            return true;
         }catch(Exception e){
            System.out.println(e);
            return false;
        }
    
    }
    
    public Menu getCarregaPorId(int id) throws Exception{
        Menu m = new Menu();
        String sql = "SELECT * FROM menu WHERE idMenu = ?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
            m.setIdMenu(id);
            m.setMenu(rs.getString("menu"));
            m.setIcone(rs.getString("icone"));
            m.setLink(rs.getString("link"));
            m.setExibir(rs.getInt("exibir"));
        }
        this.desconectar();
        return m;
    }
    
    
    
}
