package LocacaoDeEquipamentos.controller;

import LocacaoDeEquipamentos.Horarios;
import LocacaoDeEquipamentos.dao.Conexao;
import LocacaoDeEquipamentos.model.Horario;
import LocacaoDeEquipamentos.dao.HorarioDAO;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;import com.mysql.jdbc.PreparedStatement;
import java.net.URL;

import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class FXMLHorEditarController implements Initializable {
    
   
    @FXML
    private ComboBox<Horario> comboBoxHorario;
    private List<Horario> listHorario = new ArrayList<>();
    private ObservableList<Horario> observableListHorario;
    
    @FXML
    private ComboBox<String> comboBoxDia;
    private List<String> listDia = new ArrayList<>();
    private ObservableList<String> observableListDia;
    
    @FXML
    private ComboBox<String> comboBoxHorario2;
    private List<String> listHorario2 = new ArrayList<>();
    private ObservableList<String> observableListHorario2;

    @FXML
    private TextField tfDuracao;

    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        try {
            carregarComboBoxReserva();
            carregarComboBoxDH();
        } catch (Exception ex) {
            Logger.getLogger(FXMLEquiExcluirController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void fechar(){
        LocacaoDeEquipamentos.HorEditar.getStage().close();
    }
    
    public void carregarComboBoxReserva() throws Exception {    
        HorarioDAO dao = new HorarioDAO();
        List<Horario> ee = new ArrayList<Horario>();;
        ee = dao.ListarHorario();
        for(Horario pro: ee){
             listHorario.add(pro);
        }
        
        observableListHorario = FXCollections.observableArrayList(listHorario);
        comboBoxHorario.setItems(observableListHorario);
    }
    
    public void carregarComboBoxDH() throws Exception {    
      
       listDia.add("Segunda-feira");
       listDia.add("Terca-feira");
       listDia.add("Quarta-feira");
       listDia.add("Quinta-feira");
       listDia.add("Sexta-feira");
        
        observableListDia = FXCollections.observableArrayList(listDia);
        comboBoxDia.setItems(observableListDia);
        
       listHorario2.add("Aula 1");
       listHorario2.add("Aula 2");
       listHorario2.add("Aula 3");
       listHorario2.add("Aula $");
       listHorario2.add("Aula 5");
       listHorario2.add("Aula 6");
       listHorario2.add("Aula 7");
       listHorario2.add("Aula 8");
       listHorario2.add("Aula 9");
        
        observableListHorario2 = FXCollections.observableArrayList(listHorario2);
        comboBoxHorario2.setItems(observableListHorario2);
    }
    
    public void editar() throws Exception{

        
        if(comboBoxHorario.getSelectionModel().getSelectedItem() == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro ao inserir o professor");
            alert.setHeaderText("Selecione o horário que será editado");
            alert.show();
        }else if(comboBoxHorario2.getSelectionModel().getSelectedItem() == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro ao inserir o professor");
            alert.setHeaderText("Não deixe o campo 'Horário' em branco");
            alert.show();
        }else if(comboBoxDia.getSelectionModel().getSelectedItem() == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro ao inserir o professor");
            alert.setHeaderText("Não deixe o campo 'Dia' em branco");
            alert.show();
        }else if(tfDuracao.getText().equalsIgnoreCase("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro ao inserir o professor");
            alert.setHeaderText("Não deixe o campo 'Duração' em branco");
            alert.show();
        }else{
            Connection con = (Connection) Conexao.getConexao();
            String sql = "select * from horario where dia=?";
            PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
            stm.setString(1, comboBoxDia.getSelectionModel().getSelectedItem());
            ResultSet rs = stm.executeQuery();

            boolean existe = false;
            while (rs.next()) {
                if(rs.getString("horario").equalsIgnoreCase(comboBoxHorario2.getSelectionModel().getSelectedItem())){
                    existe = true;
                }
            }
            if(!existe){
                Horario e = comboBoxHorario.getSelectionModel().getSelectedItem();
                e.setDia(comboBoxDia.getSelectionModel().getSelectedItem());
                e.setDucacao(tfDuracao.getText());
                e.setHorario(comboBoxHorario2.getSelectionModel().getSelectedItem());
                HorarioDAO dao = new HorarioDAO();
                dao.atualizarHorario(e);

                LocacaoDeEquipamentos.Horarios.getStage().close();
                LocacaoDeEquipamentos.HorEditar.getStage().close();
                Horarios t = new Horarios();
                t.start(new Stage());
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro ao inserir horário");
                alert.setHeaderText("Horário indisponível. Selecione um horário não registrado");
                alert.show();
            }
        }    
       
    } 
    
    @FXML
    public void selecionarItemComboBoxHorario() {
        Horario eq = comboBoxHorario.getSelectionModel().getSelectedItem();
        if (eq != null) {
            tfDuracao.setText(eq.getDucacao());
        }
    }
    
    
   
}
