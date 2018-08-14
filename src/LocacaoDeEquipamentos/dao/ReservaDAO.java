package LocacaoDeEquipamentos.dao;


import LocacaoDeEquipamentos.model.Reserva;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ReservaDAO {

   
    public boolean EfetuarReserva(Reserva r) throws Exception {
        Connection con = (Connection) Conexao.getConexao();
        String sql = "insert into reservas values(0,?,?,?)";
        PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
        stm.setInt(1, r.getEquipamento());
        stm.setInt(2, r.getHorario());
        stm.setInt(3,r.getProfessor());

        if (stm.executeUpdate() == 1) {
            return true;
        } else {
            return false;
        }
    }
        
    public List<Reserva> listarReservas() throws Exception {
        ArrayList<Reserva> reserva = new ArrayList<Reserva>();
        Connection con = (Connection) Conexao.getConexao();
        String sql = "select * from reservas ";
        PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();

        while (rs.next()) {
            Reserva r = new Reserva();
            r.setCdreserva(rs.getInt("cdreservas"));
            r.setProfessor(Integer.parseInt( rs.getString("professor") ) );
            r.setEquipamento(rs.getInt("equipamentos"));
            r.setHorario(rs.getInt("horario"));
            reserva.add(r);
        }
        return reserva;
    }

    public boolean excluirReserva(int codigo) throws Exception {
        Connection con = (Connection) Conexao.getConexao();
        String sql = "delete from reservas where cdreservas = ?";
        PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
        stm.setInt(1, codigo);

        if (stm.executeUpdate() == 1) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean atualizarReserva(Reserva p) throws Exception {
        Connection con = Conexao.getConexao();
        String sql = "update resrevas set equipamentos=?, horario=?, professor=? where cdreservas=?";
        java.sql.PreparedStatement stm = (java.sql.PreparedStatement) con.prepareStatement(sql);
        stm.setInt(1, p.getEquipamento());
        stm.setInt(2, p.getHorario());
        stm.setInt(3, p.getProfessor());
        stm.setInt(4, p.getCdreserva());
        

        if (stm.executeUpdate() != 1) {
            return false;
        } else {
            return true;
        }

    }
    
    public List<ReservaJoin> listarJOIN() throws Exception {
       ArrayList<ReservaJoin> reserva = new ArrayList<ReservaJoin>();
        Connection con = (Connection) Conexao.getConexao();
        String sql  = "select reservas.cdreservas ,horario.dia, horario.horario, professor.nome as 'professor', equipamentos.nome as 'equipamento' from professor join reservas on professor=cdprofessor join equipamentos on cdequipamentos=equipamentos join horario on cdhorario=reservas.horario;";
        PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();

        while (rs.next()) {
            ReservaJoin r = new ReservaJoin();
            r.setCdreservas(rs.getInt("cdreservas"));
            r.setDia(rs.getString("dia"));
            r.setHorario(rs.getString("horario"));
            r.setProfessor(rs.getString("professor"));
            r.setEquipamento(rs.getString("equipamento"));
            reserva.add(r);
        }
        return reserva;
    }
}
