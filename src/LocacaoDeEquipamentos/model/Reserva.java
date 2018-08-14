package LocacaoDeEquipamentos.model;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class Reserva {
   private int cdreserva;
   private int professor;
   private int equipamento;
   private int horario;

    public int getCdreserva() {
        return cdreserva;
    }

    public void setCdreserva(int cdreserva) {
        this.cdreserva = cdreserva;
    }

    public int getProfessor() {
        return professor;
    }

    public void setProfessor(int professor) {
        this.professor = professor;
    }

    public int getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(int equipamento) {
        this.equipamento = equipamento;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    @Override
    public String toString(){
        
        return "horario";
    }
   
    
    
   


   
 
  
   
}