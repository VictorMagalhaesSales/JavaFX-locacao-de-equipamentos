package LocacaoDeEquipamentos.dao;
import LocacaoDeEquipamentos.model.Horario;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;


public class Exec {
    public static void main(String args[]) throws Exception{
        
 /*     Professor p1 = new Professor();
        p1.setMateria("matemática2");
        p1.setNome("Geo2");
        p1.setCdprofessor(2);   
       ProfessorDAO rDao = new ProfessorDAO();
        
       
       List<Professor> pp = new ArrayList<Professor>();;
       pp = rDao.ListarProfessores();
       for(Professor pro: pp){
           String a = pro.toString();
           System.out.println(a);
        }
*/

 /*
        Equipamento eq = new Equipamento();
        eq.setCdequipamentos(1);
        eq.setDescricao("aasdasd");
        eq.setNome("ada");
        
        
        EquipamentoDAO eDao = new EquipamentoDAO();
        eDao.atualizarEquipamentos(eq);
        
        List<Equipamento> ee = new ArrayList<Equipamento>();;
        ee = eDao.ListarEquipamento();
        for(Equipamento pro: ee){
            String a = pro.toString();
            System.out.println(a);
        }
*/
 
       
        HorarioDAO hDao = new HorarioDAO();
        
        Horario h = new Horario();
        h.setCdhorario(0);
        h.setDia("sexta-feira");
        h.setDucacao("asdasd");
        h.setHorario("a");
        hDao.inserirHorario(h);
}
}
