
package LocacaoDeEquipamentos.model;

import javafx.scene.control.TextField;

public class Equipamento {
    private int cdequipamentos;
    private String nome;
    private String descricao;
    private boolean reservado;

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

    public int getCdequipamentos() {
        return cdequipamentos;
    }

    public void setCdequipamentos(int cdequipamentos) {
        this.cdequipamentos = cdequipamentos;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    

    
    
    @Override
    public String toString() {
        return nome+" - "+descricao;
    }

    
    
   
    

}
