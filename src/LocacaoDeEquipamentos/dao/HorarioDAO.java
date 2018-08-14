
package LocacaoDeEquipamentos.dao;

import LocacaoDeEquipamentos.model.Horario;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HorarioDAO {
  
    private static HorarioDAO horario = null;

    public static HorarioDAO getHorario() {
        if (horario == null) {
            horario = new HorarioDAO();

        }
        return horario;
    }

    public boolean inserirHorario(Horario h) throws Exception {
        Connection con = (Connection) Conexao.getConexao();
        String sql = "insert into horario values(0,?,?,?)";
        PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
        stm.setString(1, h.getHorario());
        stm.setString(2, h.getDia());
        stm.setString(3, h.getDucacao());

        if (stm.executeUpdate() == 1) {
            return true;
        } else {
            return false;
        }
    }

    public List<Horario> ListarHorario() throws Exception {
        List<Horario> horario = new ArrayList<Horario>();
        Connection con = (Connection) Conexao.getConexao();
        String sql = "select * from horario";
        PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();

        while (rs.next()) {
           Horario h = new Horario();
            h.setCdhorario(rs.getInt("cdhorario"));
            h.setHorario(rs.getString("horario"));
            h.setDia(rs.getString("dia"));
            h.setDucacao(rs.getString("duracao"));
            horario.add(h);

        } 
        return horario;
    }

    public boolean excluirHorario(int cdhorario) throws Exception {
        Connection con = (Connection) Conexao.getConexao();
        String sql = "delete from horario where cdhorario = ?";
        PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
        stm.setInt(1, cdhorario);

        if (stm.executeUpdate() == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean atualizarHorario(Horario h) throws Exception {
        java.sql.Connection con = Conexao.getConexao();
        String sql = "update horario set  horario=?, dia=?, duracao=? where cdhorario=?";
        com.mysql.jdbc.PreparedStatement stm = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(sql);
        stm.setString(1,h.getHorario());
        stm.setString(2, h.getDia());
        stm.setString(3, h.getDucacao());
        stm.setInt(4, h.getCdhorario());
       
        

        if (stm.executeUpdate() != 1) {
            return false;
        } else {
            return true;
        }

    }

}


  

