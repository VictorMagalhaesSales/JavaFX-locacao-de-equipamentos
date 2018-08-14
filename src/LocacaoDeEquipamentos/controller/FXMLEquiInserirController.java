package LocacaoDeEquipamentos.controller;

import LocacaoDeEquipamentos.Equipamentos;
import LocacaoDeEquipamentos.model.Equipamento;
import LocacaoDeEquipamentos.dao.EquipamentoDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
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

public class FXMLEquiInserirController implements Initializable {
    
   @FXML
    private TextField tfNome;

    @FXML
    private TextArea taDesc;

    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
     
    }
    
    public void fechar(){
        LocacaoDeEquipamentos.EquiInserir.getStage().close();
    }
    
    public void inserir() throws Exception{
        String nome = tfNome.getText();
        String desc = taDesc.getText();
        
        
         if(nome.equalsIgnoreCase("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro ao inserir o professor");
            alert.setHeaderText("Não deixe o campo 'Nome' em branco");
            alert.show();
        }else if(desc.equalsIgnoreCase("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro ao inserir o professor");
            alert.setHeaderText("Não deixe o campo 'Descrição' em branco");
            alert.show();
        }else{
            Equipamento e = new Equipamento();
            e.setNome(nome);
            e.setDescricao(desc);
            EquipamentoDAO dao = new EquipamentoDAO();
            dao.inserirEquipamento(e);

            LocacaoDeEquipamentos.Equipamentos.getStage().close();
            LocacaoDeEquipamentos.EquiInserir.getStage().close();
            Equipamentos t = new Equipamentos();
            t.start(new Stage());
        }
    }
    
    
   
}
