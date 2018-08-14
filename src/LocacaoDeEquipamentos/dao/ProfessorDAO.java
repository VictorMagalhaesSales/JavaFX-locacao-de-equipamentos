
package LocacaoDeEquipamentos.dao;

import LocacaoDeEquipamentos.model.Professor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProfessorDAO {
    private static EquipamentoDAO professor = null;


    public static ProfessorDAO getProfessor() {
        if (professor == null) {
            Professor Professor = new Professor();
        }
        ProfessorDAO professorDAO = null;
        return professorDAO;
    }

    public boolean inserirProfessor (Professor p) throws Exception {
        Connection con = Conexao.getConexao();
        String sql = "insert into professor values(0,?,?);";
        PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
        stm.setString(1, p.getNome());
        stm.setString(2, p.getMateria());
        

        if (stm.executeUpdate() == 1) {
            return true;
        } else {
            return false;
        }
    }

    public List<Professor> ListarProfessores() throws Exception {
        List<Professor> professores = new ArrayList<>();
        Connection con = Conexao.getConexao();
        String sql = "select * from professor";
        PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();

        while (rs.next()) {
            Professor p = new Professor();
            p.setCdprofessor(rs.getInt("Cdprofessor"));
            p.setNome(rs.getString("nome"));
            p.setMateria(rs.getString("materia"));
            professores.add(p);
            
        }
        return professores;
    }
    
    public boolean excluirProfessores(int cdprofessor) throws Exception {
        Connection con = Conexao.getConexao();
        String sql = "delete from professor where cdprofessor = ?";
        PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
        stm.setInt(1, cdprofessor);


                if (stm.executeUpdate() == 1) {
            return true;
        } else {
            return false;
        }
    }
    
  public boolean atualizarProfessores(Professor p) throws Exception {
        Connection con = Conexao.getConexao();
        String sql = "update professor set nome=?, materia=? where cdprofessor=?";
        PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
        stm.setString(1, p.getNome());
        stm.setString(2, p.getMateria());
        stm.setInt(3, p.getCdprofessor());
        

        if (stm.executeUpdate() != 1) {
            return false;
        } else {
            return true;
        }

    }


   
}




