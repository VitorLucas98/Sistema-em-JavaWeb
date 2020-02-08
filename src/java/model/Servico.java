/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author Vítor Lucas
 */
public class Servico {
    private int idServico;
    private String nome;
    private String descricao;
    private Double valor;
    
  
    

    public Servico() {
    }

    public Servico(int idServico, String nome, String descricao, Double valor) {
        this.idServico = idServico;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
       
    }
    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
      
    public String toString() {
        return "Serviço: " + 
                "\nidServiço:" + getIdServico() + 
                "\nNome:" + getNome() + 
                "\nDescricao:" + getDescricao() +
                "\nValor:" + getValor();
                
               }
    
        public List<Servico> getLista() throws Exception{
        ServicoDAO sDAO = new ServicoDAO();
        return sDAO.getLista();
    }
    
    public boolean deletar() throws Exception{
        ServicoDAO sDAO = new ServicoDAO();
        return sDAO.deletar(this);
    }
    
    public boolean gravar() throws Exception{
        ServicoDAO sDAO = new ServicoDAO();
        return sDAO.gravar(this);
    }
    
    public Servico getCarregaPorID(int id)throws Exception{
        ServicoDAO sDAO = new ServicoDAO();
        return sDAO.getCarregaPorID(id);
    }
}
