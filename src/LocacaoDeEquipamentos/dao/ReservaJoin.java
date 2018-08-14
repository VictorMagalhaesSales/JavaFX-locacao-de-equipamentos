
package LocacaoDeEquipamentos.dao;
public class ReservaJoin {
    private int cdreservas;
    private String horario;
    private String dia;
    private String professor;
    private String equipamento;

    public int getCdreservas() {
        return cdreservas;
    }

    public void setCdreservas(int cdreservas) {
        this.cdreservas = cdreservas;
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

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }

    @Override
    public String toString() {
        return dia + " , " + horario + " , " + professor + " , " + equipamento;
    }
    
    
    
}
