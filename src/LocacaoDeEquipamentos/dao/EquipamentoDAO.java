package LocacaoDeEquipamentos.dao;

import LocacaoDeEquipamentos.model.Equipamento;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class EquipamentoDAO {
   
    public static EquipamentoDAO getEquipamento() {
        Object EquipamentoDAO = null;
       
        
        if (EquipamentoDAO== null) {
            Equipamento Equipamento = new Equipamento();
        }

        return (EquipamentoDAO) EquipamentoDAO;
    }

   
    public boolean inserirEquipamento(Equipamento e) throws Exception {
        Connection con = (Connection) Conexao.getConexao();
        String sql = "insert into equipamentos values(0,?,?,?)";
        PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
        stm.setString(1, e.getNome());
        stm.setString(2, e.getDescricao());
        stm.setBoolean(3, e.isReservado());

        if (stm.executeUpdate() == 1) {
            return true;
        } else {
            return false;
        }
    }

    public List<Equipamento> ListarEquipamento() throws Exception {
        List<Equipamento> equipamento = new ArrayList<>();
        Connection con = (Connection) Conexao.getConexao();
        String sql = "select * from equipamentos";
        PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();

        while (rs.next()) {
            Equipamento e = new Equipamento();
            e.setCdequipamentos(rs.getInt("cdequipamentos"));
            e.setNome(rs.getString("Nome"));
            e.setDescricao(rs.getString("Descricao"));
            e.setReservado(rs.getBoolean("reservado"));
            equipamento.add(e);

        }
        return equipamento ;
    }

    public boolean excluirEquipamento(int codigo) throws Exception {
        Connection con = (Connection) Conexao.getConexao();
        String sql = "delete from equipamentos where cdequipamentos = ?";
        PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
        stm.setInt(1, codigo);

        if (stm.executeUpdate() == 1) {
            return true;
        } else {
            return false;
        }

    
    }
    
    public boolean atualizarEquipamentos (Equipamento p) throws Exception {
        java.sql.Connection con = Conexao.getConexao();
        String sql = "update equipamentos set nome=?, descricao=?, reservado=? where cdequipamentos=?";
        java.sql.PreparedStatement stm = (java.sql.PreparedStatement) con.prepareStatement(sql);
        stm.setString(1, p.getNome());
        stm.setString(2, p.getDescricao());
        stm.setBoolean(3, p.isReservado());
        stm.setInt(4, p.getCdequipamentos());
        

        if (stm.executeUpdate() != 1) {
            return false;
        } else {
            return true;
        }

    }

}
               
    
   