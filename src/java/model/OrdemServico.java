/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Vítor Lucas
 */
public class OrdemServico {
    private int idNumero;
    private Date dataAbertura;
    private Date dataFechamento;
    private String observacao;
    private String equipamento;
    private String carregador;
    private String bateria;
    private String status;
    private String defeito;
    private String numeroSerie;
    private Cliente cliente;
    private Usuario usuario;
    private Funcionario funcionario;
    
    private List<Servico> servicos;
    private List<Servico> naoServicos;

    public OrdemServico() {
    }

    public OrdemServico(int idNumero, Date dataAbertura, Date dataFechamento, String observacao, String equipamento, String carregador, String bateria, String status, String defeito, String numeroSerie, Cliente cliente, Usuario usuario, Funcionario funcionario, List<Servico> servicos, List<Servico> naoServicos) {
        this.idNumero = idNumero;
        this.dataAbertura = dataAbertura;
        this.dataFechamento = dataFechamento;
        this.observacao = observacao;
        this.equipamento = equipamento;
        this.carregador = carregador;
        this.bateria = bateria;
        this.status = status;
        this.defeito = defeito;
        this.numeroSerie = numeroSerie;
        this.cliente = cliente;
        this.usuario = usuario;
        this.funcionario = funcionario;
        this.servicos = servicos;
        this.naoServicos = naoServicos;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

     
    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public List<Servico> getNaoServicos() {
        return naoServicos;
    }

    public void setNaoServicos(List<Servico> naoServicos) {
        this.naoServicos = naoServicos;
    }

    public int getIdNumero() {
        return idNumero;
    }

    public void setIdNumero(int idNumero) {
        this.idNumero = idNumero;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }



    public String getCarregador() {
        return carregador;
    }

    public void setCarregador(String carregador) {
        this.carregador = carregador;
    }

    public String getBateria() {
        return bateria;
    }

    public void setBateria(String bateria) {
        this.bateria = bateria;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDefeito() {
        return defeito;
    }

    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String toString() {
        return "OrdemServico:" + "\nidNumero: " + getIdNumero() +
                "\nData de Abertura: " + getDataAbertura() +
                "\nData de Fechamento: " + getDataFechamento() +
                "\nObservacao: " + getObservacao() +
                "\nEquipamento: "+getEquipamento()+
                "\nCarregador: " + getCarregador() +
                "\nBateria: " + getBateria() +
                "\nStatus: " + getStatus() +
                "\nDefeito: " + getDefeito() +
                "\nNúmero ce série: " + getNumeroSerie() +
                "\nDADOS DO CLIENTE: " + getCliente() +
                "\nDADOS DO USUÁRIO: " + getUsuario();
    }
    public List<OrdemServico> getLista() throws Exception{
        OrdemServicoDAO osDAO = new OrdemServicoDAO();
        return osDAO.getLista();
    }
    
    public boolean deletar() throws Exception{
        OrdemServicoDAO osDAO = new OrdemServicoDAO();
        return osDAO.deletar(this);
    }
    
    public boolean gravar() throws Exception{
        OrdemServicoDAO osDAO = new OrdemServicoDAO();
        return osDAO.gravar(this);
    }
    
    public boolean encerrar() throws Exception{
        OrdemServicoDAO osDAO = new OrdemServicoDAO();
        return osDAO.encerrar(this);
    }
    
    public OrdemServico getCarregaPorID(int id)throws Exception{
        OrdemServicoDAO osDAO = new OrdemServicoDAO();
        return osDAO.getCarregaPorID(id);
    }
    public boolean vincular(int idNumero, int idServico)throws Exception{
        OrdemServicoDAO osDAO = new OrdemServicoDAO();
        return osDAO.vincular(idNumero,idServico);
    }
    
    public boolean desvincular(int idNumero, int idServico)throws Exception{
        OrdemServicoDAO osDAO = new OrdemServicoDAO();
        return osDAO.desvincular(idNumero,idServico);
    }
    
}
