
package model;


import java.util.Date;
import java.util.List;

public class GarantiaServico {
    private int idGarantiaServico;
    private Date dataAbertura;
    private String observacao;
    private int diasGarantia;
    private Servico servico;


    public GarantiaServico() {
    }

    public GarantiaServico(int idGarantiaServico, Date dataAbertura, String observacao, int diasGarantia, Servico servico) {
        this.idGarantiaServico = idGarantiaServico;
        this.dataAbertura = dataAbertura;
        this.observacao = observacao;
        this.diasGarantia = diasGarantia;
        this.servico = servico;
    }

    public int getIdGarantiaServico() {
        return idGarantiaServico;
    }

    public void setIdGarantiaServico(int idGarantiaServico) {
        this.idGarantiaServico = idGarantiaServico;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getDiasGarantia() {
        return diasGarantia;
    }

    public void setDiasGarantia(int diasGarantia) {
        this.diasGarantia = diasGarantia;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }
    

    public String toString() {
        return "Garantia de Servico: " + 
                "\nidGarantiaServico:" + getIdGarantiaServico() + 
                "\nData de Abertura: " + getDataAbertura() + 
                "\nDias de Garantia:" + getDiasGarantia()+
                "\nObservação: "+getObservacao()+
                "\n SERVIÇO: "+getServico();
    }   
    public List<GarantiaServico> getLista() throws Exception{
        GarantiaServicoDAO gsDAO = new GarantiaServicoDAO();
        return gsDAO.getLista();
    }
    
    public boolean deletar() throws Exception{
        GarantiaServicoDAO gsDAO = new GarantiaServicoDAO();
        return gsDAO.deletar(this);
    }
    
    public boolean gravar() throws Exception{
        GarantiaServicoDAO gsDAO = new GarantiaServicoDAO();
        return gsDAO.gravar(this);
    }
    
    public GarantiaServico getCarregaPorID(int id)throws Exception{
        GarantiaServicoDAO gsDAO = new GarantiaServicoDAO();
        return gsDAO.getCarregaPorID(id);
    }
}
