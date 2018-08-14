package LocacaoDeEquipamentos.controller;

import LocacaoDeEquipamentos.Reservas;
import LocacaoDeEquipamentos.dao.Conexao;
import LocacaoDeEquipamentos.model.Equipamento;
import LocacaoDeEquipamentos.dao.EquipamentoDAO;
import LocacaoDeEquipamentos.model.Horario;
import LocacaoDeEquipamentos.dao.HorarioDAO;
import LocacaoDeEquipamentos.model.Professor;
import LocacaoDeEquipamentos.dao.ProfessorDAO;
import LocacaoDeEquipamentos.model.Reserva;
import LocacaoDeEquipamentos.dao.ReservaDAO;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class FXMLResInsertController implements Initializable {

    @FXML
    private ComboBox<Equipamento> comboBoxClientes;
    private List<Equipamento> listClientes = new ArrayList<>();
    private ObservableList<Equipamento> observableListClientes;
    
    @FXML
    private ComboBox<Professor> comboBoxProfessor;
    private List<Professor> listProfessor = new ArrayList<>();
    private ObservableList<Professor> observableListProfessor;
    
    @FXML
    private ComboBox<Horario> comboBoxHorario;
    private List<Horario> listHorario = new ArrayList<>();
    private ObservableList<Horario> observableListHorario;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            carregarComboBoxClientes();
            carregarComboBoxProfessor();
            carregarComboBoxHorario();
        } catch (Exception ex) {
            Logger.getLogger(FXMLResInsertController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void carregarComboBoxClientes() throws Exception {    
        EquipamentoDAO equipDAO = new EquipamentoDAO();
        List<Equipamento> ee = new ArrayList<Equipamento>();;
        ee = equipDAO.ListarEquipamento();
        for(Equipamento pro: ee){
             listClientes.add(pro);
        }
        
        observableListClientes = FXCollections.observableArrayList(listClientes);
        comboBoxClientes.setItems(observableListClientes);
    }

    public void carregarComboBoxProfessor() throws Exception {    
        ProfessorDAO pDAO = new ProfessorDAO();
        List<Professor> ee = new ArrayList<Professor>();;
        ee = pDAO.ListarProfessores();
        for(Professor pro: ee){
             listProfessor.add(pro);
        }
        
        observableListProfessor = FXCollections.observableArrayList(listProfessor);
        comboBoxProfessor.setItems(observableListProfessor);
    }

    public void carregarComboBoxHorario() throws Exception {    
        HorarioDAO pDAO = new HorarioDAO();
        List<Horario> ee = new ArrayList<Horario>();;
        ee = pDAO.ListarHorario();
        for(Horario pro: ee){
             listHorario.add(pro);
        }
        
        observableListHorario = FXCollections.observableArrayList(listHorario);
        comboBoxHorario.setItems(observableListHorario);
    }

    public void fechar(){
        LocacaoDeEquipamentos.ResInserir.getStage().close();
    }
    
    public void inserir() throws Exception{
        Equipamento equip = comboBoxClientes.getSelectionModel().getSelectedItem();
        Professor p = comboBoxProfessor.getSelectionModel().getSelectedItem();
        Horario h = comboBoxHorario.getSelectionModel().getSelectedItem();
        
        
         if(equip == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro ao inserir o professor");
            alert.setHeaderText("Não deixe o campo 'Equipamento' em branco");
            alert.show();
        }else if(h == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro ao inserir o professor");
            alert.setHeaderText("Não deixe o campo 'Horário' em branco");
            alert.show();
        }else if(p == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro ao inserir o professor");
            alert.setHeaderText("Não deixe o campo 'Professor' em branco");
            alert.show();
        }else{
            equip.setReservado(true);
            EquipamentoDAO eDao = new EquipamentoDAO();
            eDao.atualizarEquipamentos(equip);

            Connection con = (Connection) Conexao.getConexao();
            String sql = "select * from reservas";
            PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            boolean test = true;
            while (rs.next()){
                if(h.getCdhorario() == rs.getInt("horario") && equip.getCdequipamentos() == rs.getInt("equipamentos")){
                    test = false;
                }
            }

            if(test){
                LocacaoDeEquipamentos.Reservas.getStage().close();
                LocacaoDeEquipamentos.ResInserir.getStage().close();

                Reserva r = new Reserva();
                r.setEquipamento(equip.getCdequipamentos());
                r.setHorario(h.getCdhorario());
                r.setProfessor(p.getCdprofessor());

                ReservaDAO rDao = new ReservaDAO();
                rDao.EfetuarReserva(r);

                Reservas t = new Reservas();
                t.start(new Stage());
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro ao reservar equipamento");
                alert.setHeaderText("Equipamento já reservado nesse horario");
                alert.show();
            }
        }    
    }
}
