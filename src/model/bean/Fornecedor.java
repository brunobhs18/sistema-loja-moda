/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;

/**
 *
 * @author Brunobhs18
 */
public class Fornecedor {
    private int codfor;
    private String nomefor;
    private String enderecofor;
    private String contatofor;

    public int getCodfor() {
        return codfor;
    }

    public void setCodfor(int codfor) {
        this.codfor = codfor;
    }

        
    public String getNomefor() {
        return nomefor;
    }

    public void setNomefor(String nomefor) {
        this.nomefor = nomefor;
    }

    public String getEnderecofor() {
        return enderecofor;
    }

    public void setEnderecofor(String enderecofor) {
        this.enderecofor = enderecofor;
    }

    public String getContatofor() {
        return contatofor;
    }

    public void setContatofor(String contatofor) {
        this.contatofor = contatofor;
    }
    
    @Override
    public String toString(){
        return getNomefor();
    }
}
