/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LocacaoDeEquipamentos.controller;

import LocacaoDeEquipamentos.Central;
import LocacaoDeEquipamentos.ProEditar;
import LocacaoDeEquipamentos.ProExcluir;
import LocacaoDeEquipamentos.ProInserir;
import LocacaoDeEquipamentos.dao.EquipamentoDAO;
import LocacaoDeEquipamentos.model.Professor;
import LocacaoDeEquipamentos.dao.ProfessorDAO;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author suporte
 */
public class FXMLProfessoresController implements Initializable {

    @FXML
    private TableView<Professor> tableViewProfessores;

    @FXML
    private TableColumn<Professor, String> tableColumnNome;

    @FXML
    private TableColumn<Professor, String> tableColumnMateria;
    
    private List<Professor> listProfessores = new ArrayList();

    private ObservableList<Professor> observableListProfessores;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            carregarTableViewProfessores();
        } catch (Exception ex) {
            Logger.getLogger(FXMLProfessoresController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    public void carregarTableViewProfessores() throws Exception {

        tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnMateria.setCellValueFactory(new PropertyValueFactory<>("materia"));

        ProfessorDAO dao = new ProfessorDAO();
        List<Professor> ee = new ArrayList<Professor>();;
        ee = dao.ListarProfessores();
        for(Professor pro: ee){
             listProfessores.add(pro);
        }

        observableListProfessores = FXCollections.observableArrayList(listProfessores);

        tableViewProfessores.setItems(observableListProfessores);
    }
    
    
    @FXML
    void voltar(ActionEvent event) throws Exception {
        LocacaoDeEquipamentos.Professores.getStage().close();
        Central t = new Central();
        t.start(new Stage());
    } 
    @FXML
    void sair(ActionEvent event) throws Exception {
        LocacaoDeEquipamentos.Professores.getStage().close();
    }
    
    @FXML
    void inserirPro() throws Exception{
        ProInserir t = new ProInserir();
        t.start(new Stage());
    }
    
    @FXML
    void ExcluirPro() throws Exception{
        ProExcluir t = new ProExcluir();
        t.start(new Stage());
    }
    
    @FXML
    void EditarPro() throws Exception{
        ProEditar t = new ProEditar();
        t.start(new Stage());
    }
    
}
