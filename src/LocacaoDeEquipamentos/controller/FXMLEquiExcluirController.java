package LocacaoDeEquipamentos.controller;

import LocacaoDeEquipamentos.Equipamentos;
import LocacaoDeEquipamentos.model.Equipamento;
import LocacaoDeEquipamentos.dao.EquipamentoDAO;
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

public class FXMLEquiExcluirController implements Initializable {
    
    @FXML
    private ComboBox<Equipamento> comboBoxEquipamento;
    private List<Equipamento> listEquipamento = new ArrayList<>();
    private ObservableList<Equipamento> observableListEquipamento;
   

    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        try {
            carregarComboBoxReserva();
        } catch (Exception ex) {
            Logger.getLogger(FXMLEquiExcluirController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void fechar(){
        LocacaoDeEquipamentos.EquiExcluir.getStage().close();
    }
    
    public void carregarComboBoxReserva() throws Exception {    
        EquipamentoDAO dao = new EquipamentoDAO();
        List<Equipamento> ee = new ArrayList<Equipamento>();;
        ee = dao.ListarEquipamento();
        for(Equipamento pro: ee){
             listEquipamento.add(pro);
        }
        
        observableListEquipamento = FXCollections.observableArrayList(listEquipamento);
        comboBoxEquipamento.setItems(observableListEquipamento);
    }
     
    public void excluir() throws Exception{
        
        LocacaoDeEquipamentos.Equipamentos.getStage().close();
        LocacaoDeEquipamentos.EquiExcluir.getStage().close();
        
        Equipamento e = comboBoxEquipamento.getSelectionModel().getSelectedItem();
        EquipamentoDAO dao = new EquipamentoDAO();
        dao.excluirEquipamento(e.getCdequipamentos());
        
        
        Equipamentos t = new Equipamentos();
        t.start(new Stage());
    }
   
}
