/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LocacaoDeEquipamentos.controller;

import LocacaoDeEquipamentos.Central;
import LocacaoDeEquipamentos.Equipamentos;
import LocacaoDeEquipamentos.Horarios;
import LocacaoDeEquipamentos.Login;
import LocacaoDeEquipamentos.Professores;
import LocacaoDeEquipamentos.ResInserir;
import LocacaoDeEquipamentos.Reservas;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Victor
 */
public class FXMLCentralController implements Initializable {
    
      @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button professores;

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert professores != null : "fx:id=\"professores\" was not injected: check your FXML file 'FXMLCentral.fxml'.";

    }
    
     @FXML
    void professores(ActionEvent event) throws Exception {
        LocacaoDeEquipamentos.Central.getStage().close();
        Professores t = new Professores();
        t.start(new Stage());
    }
     @FXML
    void reservas(ActionEvent event) throws Exception {
        LocacaoDeEquipamentos.Central.getStage().close();
        Reservas t = new Reservas();
        t.start(new Stage());
    }
     @FXML
    void horarios(ActionEvent event) throws Exception {
        LocacaoDeEquipamentos.Central.getStage().close();
        Horarios t = new Horarios();
        t.start(new Stage());
    }
     @FXML
    void equipamentos(ActionEvent event) throws Exception {
        LocacaoDeEquipamentos.Central.getStage().close();
        Equipamentos t = new Equipamentos();
        t.start(new Stage());
    }
     @FXML
    void sair(ActionEvent event) throws Exception {
        LocacaoDeEquipamentos.Central.getStage().close();
        Login t = new Login();
        t.start(new Stage());
    }
     @FXML
    public void fechar(){
        LocacaoDeEquipamentos.Central.getStage().close();
    } 
    
}
