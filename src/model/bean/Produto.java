
package model.bean;

/**
 *
 * @author Brunobhs18
 */

public class Produto {
    
    private int cod;
    private String fornecedorp;
    private int codfor;
    private String nomeprod;
    private int qtd;
    private String tamanho;
    private String cor;
    private double valorcp;
    private double valorvd;
    private String data;

    public int getCodfor() {
        return codfor;
    }

    public void setCodfor(int codfor) {
        this.codfor = codfor;
    }
    
    

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getFornecedorp() {
        return fornecedorp;
    }

    public void setFornecedorp(String fornecedorp) {
       this.fornecedorp = fornecedorp;
    }
   

    public String getNomeprod() {
        return nomeprod;
    }

    public void setNomeprod(String nomeprod) {
        this.nomeprod = nomeprod;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getValorcp() {
        return valorcp;
    }

    public void setValorcp(double valorcp) {
        this.valorcp = valorcp;
    }

    public double getValorvd() {
        return valorvd;
    }

    public void setValorvd(double valorvd) {
        this.valorvd = valorvd;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    
    
}
