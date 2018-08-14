package LocacaoDeEquipamentos.controller;

import LocacaoDeEquipamentos.Professores;
import LocacaoDeEquipamentos.model.Professor;
import LocacaoDeEquipamentos.dao.ProfessorDAO;
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

public class FXMLProExcluirController implements Initializable {
    
   @FXML
    private ComboBox<Professor> comboBoxProfessor;
    private List<Professor> listProfessor = new ArrayList<>();
    private ObservableList<Professor> observableListProfessor;

    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
       try {
           carregarComboBoxProfessor();
       } catch (Exception ex) {
           Logger.getLogger(FXMLProExcluirController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    public void fechar(){
        LocacaoDeEquipamentos.ProExcluir.getStage().close();
    }
    
    
    public void carregarComboBoxProfessor() throws Exception {    
        ProfessorDAO dao = new ProfessorDAO();
        List<Professor> ee = new ArrayList<Professor>();;
        ee = dao.ListarProfessores();
        for(Professor pro: ee){
             listProfessor.add(pro);
        }
        
        observableListProfessor = FXCollections.observableArrayList(listProfessor);
        comboBoxProfessor.setItems(observableListProfessor);
    }
    
    
    public void excluir() throws Exception{
        
        LocacaoDeEquipamentos.Professores.getStage().close();
        LocacaoDeEquipamentos.ProExcluir.getStage().close();
        
        Professor e = comboBoxProfessor.getSelectionModel().getSelectedItem();
        ProfessorDAO dao = new ProfessorDAO();
        dao.excluirProfessores(e.getCdprofessor());
        
        
        Professores t = new Professores();
        t.start(new Stage());
    }
    
    
   
}
