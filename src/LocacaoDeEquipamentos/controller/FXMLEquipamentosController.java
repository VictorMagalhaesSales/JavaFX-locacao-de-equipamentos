/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LocacaoDeEquipamentos.controller;

import LocacaoDeEquipamentos.Central;
import LocacaoDeEquipamentos.EquiEditar;
import LocacaoDeEquipamentos.EquiExcluir;
import LocacaoDeEquipamentos.EquiInserir;
import LocacaoDeEquipamentos.Equipamentos;
import LocacaoDeEquipamentos.Horarios;
import LocacaoDeEquipamentos.Login;
import LocacaoDeEquipamentos.Professores;
import LocacaoDeEquipamentos.ResInserir;
import LocacaoDeEquipamentos.Reservas;
import LocacaoDeEquipamentos.model.Equipamento;
import LocacaoDeEquipamentos.dao.EquipamentoDAO;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Victor
 */
public class FXMLEquipamentosController implements Initializable {
    

    @FXML
    private TableView<Equipamento> tableViewEquipamentos;

    @FXML
    private TableColumn<Equipamento, String> tableColumnNome;

    @FXML
    private TableColumn<Equipamento, String> tableColumnDesc;

    @FXML
    private TableColumn<Equipamento, String> tableColumnReservado;
    
    private List<Equipamento> listEquipamentos = new ArrayList();

    private ObservableList<Equipamento> observableListEquipamentos;

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources){
        try {
            carregarTableViewClientes();
        } catch (Exception ex) {
            Logger.getLogger(FXMLEquipamentosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void carregarTableViewClientes() throws Exception {

        tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnDesc.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tableColumnReservado.setCellValueFactory(new PropertyValueFactory<>("reservado"));

        EquipamentoDAO dao = new EquipamentoDAO();
        List<Equipamento> ee = new ArrayList<Equipamento>();;
        ee = dao.ListarEquipamento();
        for(Equipamento pro: ee){
             listEquipamentos.add(pro);
        }

        observableListEquipamentos = FXCollections.observableArrayList(listEquipamentos);

        tableViewEquipamentos.setItems(observableListEquipamentos);
    }
    
    @FXML
    void voltar(ActionEvent event) throws Exception {
        LocacaoDeEquipamentos.Equipamentos.getStage().close();
        Central t = new Central();
        t.start(new Stage());
    } 
     @FXML
    public void fechar(){
        LocacaoDeEquipamentos.Equipamentos.getStage().close();
    }  
     @FXML
    public void InserirEqui() throws Exception{
        EquiInserir t = new EquiInserir();
        t.start(new Stage());
    }   
     @FXML
    public void EditarEqui() throws Exception{
        EquiEditar t = new EquiEditar();
        t.start(new Stage());
    }   
     @FXML
    public void ExcluirEqui() throws Exception{
        EquiExcluir t = new EquiExcluir();
        t.start(new Stage());
    } 
    
}
