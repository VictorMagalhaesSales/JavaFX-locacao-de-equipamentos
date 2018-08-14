package LocacaoDeEquipamentos.controller;

import LocacaoDeEquipamentos.Horarios;
import LocacaoDeEquipamentos.dao.Conexao;
import LocacaoDeEquipamentos.model.Horario;
import LocacaoDeEquipamentos.dao.HorarioDAO;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
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

public class FXMLHorInserirController implements Initializable {
    
    @FXML
    private ComboBox<String> comboBoxDia;
    private List<String> listDia = new ArrayList<>();
    private ObservableList<String> observableListDia;
    
    @FXML
    private ComboBox<String> comboBoxHorario;
    private List<String> listHorario = new ArrayList<>();
    private ObservableList<String> observableListHorario;
    
    @FXML
    private TextField tfDuracao;

    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        try {
            carregarComboBoxDH();
        } catch (Exception ex) {
            Logger.getLogger(FXMLEquiExcluirController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void fechar(){
        LocacaoDeEquipamentos.HorInserir.getStage().close();
    }
    
    public void inserir() throws Exception{
        String horario = comboBoxHorario.getSelectionModel().getSelectedItem();
        String dia = comboBoxDia.getSelectionModel().getSelectedItem();
        String duracao = tfDuracao.getText();
        
        
        
        
         if(horario == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro ao inserir o professor");
            alert.setHeaderText("Não deixe o campo 'Horário' em branco");
            alert.show();
        }else if(dia == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro ao inserir o professor");
            alert.setHeaderText("Não deixe o campo 'Dia' em branco");
            alert.show();
        }else if(duracao.equalsIgnoreCase("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro ao inserir o professor");
            alert.setHeaderText("Não deixe o campo 'Duração' em branco");
            alert.show();
        }else{
            Connection con = (Connection) Conexao.getConexao();
            String sql = "select * from horario where dia=?";
            PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
            stm.setString(1, dia);
            ResultSet rs = stm.executeQuery();
            boolean existe = false;
            while (rs.next()) {
                if(rs.getString("horario").equalsIgnoreCase(horario)){
                    existe = true;
                }
            }
            if(!existe){
                Horario e = new Horario();
                e.setDia(dia);
                e.setDucacao(duracao);
                e.setHorario(horario);
                HorarioDAO dao = new HorarioDAO();
                dao.inserirHorario(e);

                LocacaoDeEquipamentos.Horarios.getStage().close();
                LocacaoDeEquipamentos.HorInserir.getStage().close();
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
    
    public void carregarComboBoxDH() throws Exception {    
      
       listDia.add("Segunda-feira");
       listDia.add("Terca-feira");
       listDia.add("Quarta-feira");
       listDia.add("Quinta-feira");
       listDia.add("Sexta-feira");
        
       observableListDia = FXCollections.observableArrayList(listDia);
       comboBoxDia.setItems(observableListDia);
        
       listHorario.add("Aula 1");
       listHorario.add("Aula 2");
       listHorario.add("Aula 3");
       listHorario.add("Aula $");
       listHorario.add("Aula 5");
       listHorario.add("Aula 6");
       listHorario.add("Aula 7");
       listHorario.add("Aula 8");
       listHorario.add("Aula 9");
        
        observableListHorario = FXCollections.observableArrayList(listHorario);
        comboBoxHorario.setItems(observableListHorario);
    }
    
}
