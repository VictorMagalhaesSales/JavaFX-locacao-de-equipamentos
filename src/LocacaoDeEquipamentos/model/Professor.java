
package LocacaoDeEquipamentos.model;

public class Professor {

    private int Cdprofessor;
    private String Nome;
    private String Materia;

    public int getCdprofessor() {
        return Cdprofessor;
    }

    public void setCdprofessor(int Cdprofessor) {
        this.Cdprofessor = Cdprofessor;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getMateria() {
        return Materia;
    }

    public void setMateria(String Materia) {
        this.Materia = Materia;
    }

    @Override
    public String toString() {
        return Nome;
    }
    
    

    
}

