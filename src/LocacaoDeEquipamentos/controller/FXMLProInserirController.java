package LocacaoDeEquipamentos.controller;

import LocacaoDeEquipamentos.Professores;
import LocacaoDeEquipamentos.model.Professor;
import LocacaoDeEquipamentos.dao.ProfessorDAO;
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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class FXMLProInserirController implements Initializable {
    
    
    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfMateria;
   

    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
     
    }
    
    public void fechar(){
        LocacaoDeEquipamentos.ProInserir.getStage().close();
    }
    
    public void inserir() throws Exception{
        String nome = tfNome.getText();
        String materia = tfMateria.getText();
        
        
        if(nome.equalsIgnoreCase("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro ao inserir o professor");
            alert.setHeaderText("Não deixe o campo 'Nome' em branco");
            alert.show();
        }else if(materia.equalsIgnoreCase("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro ao inserir o professor");
            alert.setHeaderText("Não deixe o campo 'Materia' em branco");
            alert.show();
        }else{
            Professor e = new Professor();
            e.setNome(nome);
            e.setMateria(materia);
            ProfessorDAO dao = new ProfessorDAO();
            dao.inserirProfessor(e);
            LocacaoDeEquipamentos.Professores.getStage().close();
            LocacaoDeEquipamentos.ProInserir.getStage().close();
            Professores t = new Professores();
            t.start(new Stage());
        }
    }
}
