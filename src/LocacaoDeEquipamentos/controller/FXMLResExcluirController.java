package LocacaoDeEquipamentos.controller;

import LocacaoDeEquipamentos.Reservas;
import LocacaoDeEquipamentos.model.Reserva;
import LocacaoDeEquipamentos.dao.ReservaDAO;
import LocacaoDeEquipamentos.dao.ReservaJoin;
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

public class FXMLResExcluirController implements Initializable {
    
    


    @FXML
    private ComboBox<ReservaJoin> comboBoxClientes;
    private List<ReservaJoin> listClientes = new ArrayList<>();
    private ObservableList<ReservaJoin> observableListClientes;



    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        try {
            carregarComboBoxReserva();
        } catch (Exception ex) {
            Logger.getLogger(FXMLResExcluirController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void fechar(){
        LocacaoDeEquipamentos.ResExcluir.getStage().close();
    }
    
    public void carregarComboBoxReserva() throws Exception {    
        ReservaDAO dao = new ReservaDAO();
        List<ReservaJoin> ee = new ArrayList<ReservaJoin>();;
        ee = dao.listarJOIN();
        for(ReservaJoin pro: ee){
             listClientes.add(pro);
        }
        
        observableListClientes = FXCollections.observableArrayList(listClientes);
        comboBoxClientes.setItems(observableListClientes);
    }
    
    public void excluir() throws Exception{
        
        LocacaoDeEquipamentos.Reservas.getStage().close();
        LocacaoDeEquipamentos.ResExcluir.getStage().close();
        
        
        ReservaJoin rJoin = comboBoxClientes.getSelectionModel().getSelectedItem();
        ReservaDAO dao = new ReservaDAO();
        dao.excluirReserva(rJoin.getCdreservas());
        
        
        Reservas t = new Reservas();
        t.start(new Stage());
    }
   
}
