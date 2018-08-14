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
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class FXMLEquiEditarController implements Initializable {
    
    @FXML
    private ComboBox<Equipamento> comboBoxEquip;
    private List<Equipamento> listEquip = new ArrayList<>();
    private ObservableList<Equipamento> observableListEquip;
    
     @FXML
    private TextField tfNome;

    @FXML
    private TextArea taDesc;
   

    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        try {
            carregarComboBoxEquipamentos();
        } catch (Exception ex) {
            Logger.getLogger(FXMLEquiEditarController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void carregarComboBoxEquipamentos() throws Exception {    
        EquipamentoDAO dao = new EquipamentoDAO();
        List<Equipamento> ee = new ArrayList<Equipamento>();;
        ee = dao.ListarEquipamento();
        for(Equipamento pro: ee){
             listEquip.add(pro);
        }
        
        observableListEquip = FXCollections.observableArrayList(listEquip);
        comboBoxEquip.setItems(observableListEquip);
    }
     
     public void editar() throws Exception{
        
        if(tfNome.getText().equalsIgnoreCase("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro ao inserir o professor");
            alert.setHeaderText("Não deixe o campo 'Nome' em branco");
            alert.show();
        }else if(taDesc.getText().equalsIgnoreCase("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro ao inserir o professor");
            alert.setHeaderText("Não deixe o campo 'Descrição' em branco");
            alert.show();
        }else{
            Equipamento e = comboBoxEquip.getSelectionModel().getSelectedItem();
            e.setNome(tfNome.getText());
            e.setDescricao(taDesc.getText());
            EquipamentoDAO dao = new EquipamentoDAO();
            dao.atualizarEquipamentos(e);

            LocacaoDeEquipamentos.Equipamentos.getStage().close();
            LocacaoDeEquipamentos.EquiEditar.getStage().close();
            Equipamentos t = new Equipamentos();
            t.start(new Stage());
        }
    } 
    
    public void fechar(){
        LocacaoDeEquipamentos.EquiEditar.getStage().close();
    }
    
    
    @FXML
    public void selecionarItemComboBoxEquipamentos() {
        Equipamento eq = comboBoxEquip.getSelectionModel().getSelectedItem();
        if (eq != null) {
            tfNome.setText(eq.getNome());
            taDesc.setText(eq.getDescricao());
        }
    }
    
    
   
}
