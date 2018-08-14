
package LocacaoDeEquipamentos.model;

public class Horario {

    private int cdhorario;
    private String horario;
    private String dia;
    private String duracao;

    public String getDucacao() {
        return duracao;
    }

    public void setDucacao(String ducacao) {
        this.duracao = ducacao;
    }
    
    
    

    public int getCdhorario() {
        return cdhorario;
    }

    public void setCdhorario(int cdhorario) {
        this.cdhorario = cdhorario;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    @Override
    public String toString() {
        return  horario + " , " + dia + " , " + duracao;
    }

    
    
}
