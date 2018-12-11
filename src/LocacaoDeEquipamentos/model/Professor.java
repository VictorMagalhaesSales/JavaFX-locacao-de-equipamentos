
package LocacaoDeEquipamentos.model;

public class Professor {

    private int Cdprofessor;
    private String Nome;
    private String Materia;
    private String Login;
    private String Senha;

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

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    @Override
    public String toString() {
        return Nome;
    }
    
    

    
}

