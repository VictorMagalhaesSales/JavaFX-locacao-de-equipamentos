package LocacaoDeEquipamentos.controller;

import LocacaoDeEquipamentos.Horarios;
import LocacaoDeEquipamentos.model.Horario;
import LocacaoDeEquipamentos.dao.HorarioDAO;
import java.net.URL;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class FXMLHorExcluirController implements Initializable {
    
    @FXML
    private ComboBox<Horario> comboBoxHorario;
    private List<Horario> listHorario = new ArrayList<>();
    private ObservableList<Horario> observableListHorario;

    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        try {
            carregarComboBoxReserva();
        } catch (Exception ex) {
            Logger.getLogger(FXMLEquiExcluirController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void fechar(){
        LocacaoDeEquipamentos.HorExcluir.getStage().close();
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
    
    public void excluir() throws Exception{
        
        LocacaoDeEquipamentos.Horarios.getStage().close();
        LocacaoDeEquipamentos.HorExcluir.getStage().close();
        
        Horario e = comboBoxHorario.getSelectionModel().getSelectedItem();
        HorarioDAO dao = new HorarioDAO();
        dao.excluirHorario(e.getCdhorario());
       
        
        
        Horarios t = new Horarios();
        t.start(new Stage());
    }
    
    
   
}
