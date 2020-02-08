
package model;

import java.util.List;


public class Cliente {
    private int idCliente;
    private String cpf_cnpj;
    private String nome ;
    private String telefone;
    private String endereco;
    private String nomeReferencia ;
    private String telefoneReferencia;
    
      public Cliente() {     
   }
      
    public Cliente(int idCliente, String cpf_cnpj, String nome, String telefone, String endereco, String nomeReferencia, String telefoneReferencia) {
        this.idCliente = idCliente;
        this.cpf_cnpj = cpf_cnpj;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.nomeReferencia = nomeReferencia;
        this.telefoneReferencia = telefoneReferencia;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
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

    public String getNomeReferencia() {
        return nomeReferencia;
    }

    public void setNomeReferencia(String nomeReferencia) {
        this.nomeReferencia = nomeReferencia;
    }

    public String getTelefoneReferencia() {
        return telefoneReferencia;
    }

    public void setTelefoneReferencia(String telefoneReferencia) {
        this.telefoneReferencia = telefoneReferencia;
    } 
    public String toString(){
        return  getNome();
               
    }
    
public List<Cliente> getLista() throws Exception{
        ClienteDAO cDAO = new ClienteDAO();
        return cDAO.getLista();
    }
    
    public boolean deletar() throws Exception{
        ClienteDAO cDAO = new ClienteDAO();
        return cDAO.deletar(this);
    }
    
    public boolean gravar() throws Exception{
        ClienteDAO cDAO = new ClienteDAO();
        return cDAO.gravar(this);
    }
    
    public Cliente getCarregaPorID(int idCliente)throws Exception{
        ClienteDAO cDAO = new ClienteDAO();
        return cDAO.getCarregaPorID(idCliente);
    }


}