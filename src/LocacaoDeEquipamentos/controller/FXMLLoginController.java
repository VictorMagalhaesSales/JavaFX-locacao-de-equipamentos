/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LocacaoDeEquipamentos.controller;

import LocacaoDeEquipamentos.Central;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class FXMLLoginController implements Initializable {
    
      @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField tfLogin;

    @FXML
    private Button bLogar;

    @FXML
    private PasswordField pfSenha;
    

    @FXML
    void fazerLogin(ActionEvent event) throws Exception {
        if(tfLogin.getText().equals("administrador") && pfSenha.getText().equals("master450")){
            LocacaoDeEquipamentos.Login.getStage().close();
            Central t = new Central();
            t.start(new Stage());
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro no login");
            alert.setHeaderText("Login e/ou senha incorreto(s)");
            alert.show();
        }
        
        
    }
    
    public void fechar(){
        LocacaoDeEquipamentos.Login.getStage().close();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert tfLogin != null : "fx:id=\"tfLogin\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert bLogar != null : "fx:id=\"bLogar\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert pfSenha != null : "fx:id=\"pfSenha\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
    }

    

}
