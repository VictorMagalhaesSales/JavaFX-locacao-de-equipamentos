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
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class FXMLProEditarController implements Initializable {
    
    @FXML
    private ComboBox<Professor> comboBoxProfessor;
    private List<Professor> listProfessor = new ArrayList<>();
    private ObservableList<Professor> observableListProfessor;
    
    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfMateria;

   

    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        try {
           carregarComboBoxProfessor();
       } catch (Exception ex) {
           Logger.getLogger(FXMLProExcluirController.class.getName()).log(Level.SEVERE, null, ex);
       }
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
    
    public void fechar(){
        LocacaoDeEquipamentos.ProEditar.getStage().close();
    }
    
     public void editar() throws Exception{
        Professor e = comboBoxProfessor.getSelectionModel().getSelectedItem();
        e.setNome(tfNome.getText());
        e.setMateria(tfMateria.getText());
        
        if(e.getNome().equalsIgnoreCase("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro ao inserir o professor");
            alert.setHeaderText("Não deixe o campo 'Nome' em branco");
            alert.show();
        }else if(e.getMateria().equalsIgnoreCase("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro ao inserir o professor");
            alert.setHeaderText("Não deixe o campo 'Materia' em branco");
            alert.show();
        }else{
            ProfessorDAO dao = new ProfessorDAO();
            dao.atualizarProfessores(e);

            LocacaoDeEquipamentos.Professores.getStage().close();
            LocacaoDeEquipamentos.ProEditar.getStage().close();
            Professores t = new Professores();
            t.start(new Stage());
        }
    } 
     
     @FXML
    public void selecionarItemComboBoxProfessor() {
        Professor eq = comboBoxProfessor.getSelectionModel().getSelectedItem();
        if (eq != null) {
            tfNome.setText(eq.getNome());
            tfMateria.setText(eq.getMateria());
        }
    }
    
    
   
}
