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
public class Funcionario {
    private int idFuncionario; private String nome; 
    private String telefone; private String endereco;
private String cpf;


    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Funcionario() {
    }

    public Funcionario(int idFuncionario, String nome, String telefone, String endereco, String cpf) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
    public String toString() {
        return getNome();
    }
    public List<Funcionario> getLista() throws Exception{
        FuncionarioDAO fDAO = new FuncionarioDAO();
        return fDAO.getLista();
    }
    
    public boolean deletar() throws Exception{
        FuncionarioDAO fDAO = new FuncionarioDAO();
        return fDAO.deletar(this);
    }
    
    public boolean gravar() throws Exception{
        FuncionarioDAO fDAO = new FuncionarioDAO();
        return fDAO.gravar(this);
    }
    
    public Funcionario getCarregaPorID(int idFuncionario)throws Exception{
        FuncionarioDAO fDAO = new FuncionarioDAO();
        return fDAO.getCarregaPorID(idFuncionario);
    }
    
}
