/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PerfilDAO extends DataBaseDAO{

    public PerfilDAO() throws Exception {
    }
    
    public List<Perfil> getLista() throws Exception{
        List<Perfil> lista = new ArrayList<Perfil>();
        String sql = "SELECT * FROM perfil";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while(rs.next()){
            Perfil p = new Perfil();
            p.setIdPerfil(rs.getInt("idPerfil"));
            p.setPerfil(rs.getString("perfil"));
            lista.add(p);
        }
        this.desconectar();
        return lista;
    }
    
    public Perfil getCarregaPorID(int id) throws Exception{
        String sql = "SELECT * FROM perfil WHERE idPerfil=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1,id);
        ResultSet rs = pstm.executeQuery();
        Perfil p = new Perfil();
        if(rs.next()){
            p.setIdPerfil(rs.getInt("idPerfil"));
            p.setPerfil(rs.getString("perfil"));
            p.setMenus(menusVinculadosPorPerfil(id));
            p.setNaoMenus(menusNaoVinculadosPorPerfil(id));
        }
        this.desconectar();
        return p;
    }
    
    public boolean deletar(Perfil p){
        try{
            this.conectar();
            String sql = "DELETE FROM perfil WHERE idPerfil=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, p.getIdPerfil());
            pstm.execute();
            this.desconectar();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean gravar(Perfil p){
        try{
            this.conectar();
            String sql;
            if(p.getIdPerfil()==0)
                sql = "INSERT INTO perfil (perfil) VALUES (?)";
            else
                sql = "UPDATE perfil SET perfil=? WHERE idPerfil=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, p.getPerfil());
            if(p.getIdPerfil()>0)
                pstm.setInt(2,p.getIdPerfil());
            
            pstm.execute();
            this.desconectar();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public boolean vincular(int idPerfil, int idMenu){
        try{
            String sql = "INSERT INTO menu_perfil(idPerfil, idMenu)"
                    + " VALUES(?,?)";
            this.conectar();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1,idPerfil);
            pstm.setInt(2, idMenu);
            pstm.execute();
            this.desconectar();
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    } 
        public boolean desvincular(int idPerfil, int idMenu){
        try{
            String sql = "DELETE FROM menu_perfil WHERE idPerfil=? AND idMenu=?";
            this.conectar();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1,idPerfil);
            pstm.setInt(2,idMenu);
            pstm.execute();
            this.desconectar();
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    
    }
    
    public List<Menu> menusVinculadosPorPerfil(int id) throws Exception{
        List<Menu> lista = new ArrayList<Menu>();
        String sql = "SELECT m.* FROM menu_perfil as mp, menu as m "
                + "WHERE mp.idMenu = m.idMenu AND mp.idPerfil=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1,id);
        ResultSet rs = pstm.executeQuery();
        while(rs.next()){
            Menu m = new Menu();
            m.setIdMenu(rs.getInt("m.idMenu"));
            m.setMenu(rs.getString("m.menu"));
            m.setIcone(rs.getString("m.icone"));
            m.setLink(rs.getString("m.link"));
            m.setExibir(rs.getInt("m.exibir"));
            lista.add(m);
        }
        this.desconectar();
        return lista;
        
    }
    public List<Menu> menusNaoVinculadosPorPerfil(int id) throws Exception{
        List<Menu> lista = new ArrayList<Menu>();
        String sql = "SELECT * FROM menu "
                + "WHERE idMenu "
                + "NOT IN(SELECT idMenu FROM menu_perfil WHERE idPerfil=?) ";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1,id);
        ResultSet rs = pstm.executeQuery();
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
}
