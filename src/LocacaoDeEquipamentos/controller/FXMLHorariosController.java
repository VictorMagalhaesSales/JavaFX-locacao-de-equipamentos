package LocacaoDeEquipamentos.controller;

import LocacaoDeEquipamentos.Central;
import LocacaoDeEquipamentos.HorEditar;
import LocacaoDeEquipamentos.HorExcluir;
import LocacaoDeEquipamentos.HorInserir;
import LocacaoDeEquipamentos.Horarios;
import LocacaoDeEquipamentos.dao.Conexao;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLHorariosController implements Initializable {

    @FXML
    private URL location;
     @FXML
    private TextField seg1;
    @FXML
    private TextField seg2;
    @FXML
    private TextField seg3;
    @FXML
    private TextField seg4;
    @FXML
    private TextField seg5;
    @FXML
    private TextField seg6;
    @FXML
    private TextField seg7;
    @FXML
    private TextField seg8;
    @FXML
    private TextField seg9;
    @FXML
    private TextField ter1;
    @FXML
    private TextField qua1;
    @FXML
    private TextField qui1;
    @FXML
    private TextField sex1;
    @FXML
    private TextField ter2;
    @FXML
    private TextField qua2;
    @FXML
    private TextField qui2;
    @FXML
    private TextField sex2;
    @FXML
    private TextField ter3;
    @FXML
    private TextField qua3;
    @FXML
    private TextField qui3;
    @FXML
    private TextField sex3;
    @FXML
    private TextField ter4;
    @FXML
    private TextField qua4;
    @FXML
    private TextField qui4;
    @FXML
    private TextField sex4;
    @FXML
    private TextField ter5;
    @FXML
    private TextField qua5;
    @FXML
    private TextField qui5;
    @FXML
    private TextField sex5;
    @FXML
    private TextField ter6;
    @FXML
    private TextField qua6;
    @FXML
    private TextField qui6;
    @FXML
    private TextField sex6;
    @FXML
    private TextField ter7;
    @FXML
    private TextField qua7;
    @FXML
    private TextField qui7;
    @FXML
    private TextField sex7;
    @FXML
    private TextField ter8;
    @FXML
    private TextField qua8;
    @FXML
    private TextField qui8;
    @FXML
    private TextField sex8;
    @FXML
    private TextField ter9;
    @FXML
    private TextField qua9;
    @FXML
    private TextField qui9;
    @FXML
    private TextField sex9;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            carregarHorariosSeg();
            carregarHorariosTer();
            carregarHorariosQua();
            carregarHorariosQui();
            carregarHorariosSex();
        } catch (Exception ex) {
            Logger.getLogger(FXMLReservasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
     @FXML
    void voltar(ActionEvent event) throws Exception {
        LocacaoDeEquipamentos.Horarios.getStage().close();
        Central t = new Central();
        t.start(new Stage());
    } 
    @FXML
    void sair(ActionEvent event) throws Exception {
        LocacaoDeEquipamentos.Horarios.getStage().close();
    }
      
     @FXML
    public void InserirEHor() throws Exception{
        HorInserir t = new HorInserir();
        t.start(new Stage());
    }   
     @FXML
    public void EditarHor() throws Exception{
        HorEditar t = new HorEditar();
        t.start(new Stage());
    }   
     @FXML
    public void ExcluirHor() throws Exception{
        HorExcluir t = new HorExcluir();
        t.start(new Stage());
    } 
    
    @FXML
    void  carregarHorariosSeg() throws Exception{
        Connection con = (Connection) Conexao.getConexao();
        String sql = "select * from horario where dia='segunda-feira';";
        PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        
        while (rs.next()){  
            String b = rs.getString("horario");
            if(b.equalsIgnoreCase("Aula 1")){
                seg1.setText(rs.getString("duracao"));
                seg1.setStyle("-fx-text-inner-color: green;");
            }else if(b.equalsIgnoreCase("Aula 2")){
                seg2.setText(rs.getString("duracao"));
                seg2.setStyle("-fx-text-inner-color: green;"); 
            }else if(b.equalsIgnoreCase("Aula 3")){
                seg3.setText(rs.getString("duracao"));
                seg3.setStyle("-fx-text-inner-color: green;"); 
            }else if(b.equalsIgnoreCase("Aula 4")){
                seg4.setText(rs.getString("duracao"));
                seg4.setStyle("-fx-text-inner-color: green;"); 
            }else if(b.equalsIgnoreCase("Aula 5")){
                seg5.setText(rs.getString("duracao"));  
                seg5.setStyle("-fx-text-inner-color: green;");
            }else if(b.equalsIgnoreCase("Aula 6")){
                seg6.setText(rs.getString("duracao"));
                seg6.setStyle("-fx-text-inner-color: green;"); 
            }else if(b.equalsIgnoreCase("Aula 7")){
                seg7.setText(rs.getString("duracao"));
                seg7.setStyle("-fx-text-inner-color: green;");
            }else if(b.equalsIgnoreCase("Aula 8")){
                seg8.setText(rs.getString("duracao"));
                seg8.setStyle("-fx-text-inner-color: green;");
            }else if(b.equalsIgnoreCase("Aula 9")){
                seg9.setText(rs.getString("duracao")); 
                seg9.setStyle("-fx-text-inner-color: green;");
            }
        }
    }  
    
    @FXML
    void carregarHorariosTer() throws Exception{
        Connection con = (Connection) Conexao.getConexao();
        String sql = "select * from horario where dia='terca-feira';";
        PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        
        while (rs.next()){  
            String b = rs.getString("horario");
            if(b.equalsIgnoreCase("Aula 1")){
                ter1.setText(rs.getString("duracao"));
                ter1.setStyle("-fx-text-inner-color: green;");
            }else if(b.equalsIgnoreCase("Aula 2")){
                ter2.setText(rs.getString("duracao"));
                ter2.setStyle("-fx-text-inner-color: green;"); 
            }else if(b.equalsIgnoreCase("Aula 3")){
                ter3.setText(rs.getString("duracao"));
                ter3.setStyle("-fx-text-inner-color: green;"); 
            }else if(b.equalsIgnoreCase("Aula 4")){
                ter4.setText(rs.getString("duracao")); 
                ter4.setStyle("-fx-text-inner-color: green;"); 
            }else if(b.equalsIgnoreCase("Aula 5")){
                ter5.setText(rs.getString("duracao"));  
                ter5.setStyle("-fx-text-inner-color: green;");
            }else if(b.equalsIgnoreCase("Aula 6")){
                ter6.setText(rs.getString("duracao"));
                ter6.setStyle("-fx-text-inner-color: green;"); 
            }else if(b.equalsIgnoreCase("Aula 7")){
                ter7.setText(rs.getString("duracao"));
                ter7.setStyle("-fx-text-inner-color: green;");
            }else if(b.equalsIgnoreCase("Aula 8")){
                ter8.setText(rs.getString("duracao")); 
                ter8.setStyle("-fx-text-inner-color: green;");
            }else if(b.equalsIgnoreCase("Aula 9")){
                ter9.setText(rs.getString("duracao"));  
                ter9.setStyle("-fx-text-inner-color: green;");
            }
        }
    }  
    
    @FXML
    void carregarHorariosQua() throws Exception{
        Connection con = (Connection) Conexao.getConexao();
        String sql = "select * from horario where dia='quarta-feira';";
        PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        
        while (rs.next()){  
            String b = rs.getString("horario");
            if(b.equalsIgnoreCase("Aula 1")){
                qua1.setText(rs.getString("duracao"));
                qua1.setStyle("-fx-text-inner-color: green;");
            }else if(b.equalsIgnoreCase("Aula 2")){
                qua2.setText(rs.getString("duracao"));
                qua2.setStyle("-fx-text-inner-color: green;"); 
            }else if(b.equalsIgnoreCase("Aula 3")){
                qua3.setText(rs.getString("duracao"));
                qua3.setStyle("-fx-text-inner-color: green;"); 
            }else if(b.equalsIgnoreCase("Aula 4")){
                qua4.setText(rs.getString("duracao")); 
                qua4.setStyle("-fx-text-inner-color: green;"); 
            }else if(b.equalsIgnoreCase("Aula 5")){
                qua5.setText(rs.getString("duracao")); 
                qua5.setStyle("-fx-text-inner-color: green;");
            }else if(b.equalsIgnoreCase("Aula 6")){
                qua6.setText(rs.getString("duracao"));
                qua6.setStyle("-fx-text-inner-color: green;"); 
            }else if(b.equalsIgnoreCase("Aula 7")){
                qua7.setText(rs.getString("duracao"));
                qua7.setStyle("-fx-text-inner-color: green;");
            }else if(b.equalsIgnoreCase("Aula 8")){
                qua8.setText(rs.getString("duracao"));
                qua8.setStyle("-fx-text-inner-color: green;");
            }else if(b.equalsIgnoreCase("Aula 9")){
                qua9.setText(rs.getString("duracao"));  
                qua9.setStyle("-fx-text-inner-color: green;");
            }
        }
    }
    
     @FXML
    void carregarHorariosQui() throws Exception{
        Connection con = (Connection) Conexao.getConexao();
        String sql = "select * from horario where dia='quinta-feira';";
        PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        
        while (rs.next()){  
            String b = rs.getString("horario");
            if(b.equalsIgnoreCase("Aula 1")){
                qui1.setText(rs.getString("duracao"));
                qui1.setStyle("-fx-text-inner-color: green;");
            }else if(b.equalsIgnoreCase("Aula 2")){
                qui2.setText(rs.getString("duracao"));
                qui2.setStyle("-fx-text-inner-color: green;"); 
            }else if(b.equalsIgnoreCase("Aula 3")){
                qui3.setText(rs.getString("duracao"));
                qui3.setStyle("-fx-text-inner-color: green;"); 
            }else if(b.equalsIgnoreCase("Aula 4")){
                qui4.setText(rs.getString("duracao")); 
                qui4.setStyle("-fx-text-inner-color: green;"); 
            }else if(b.equalsIgnoreCase("Aula 5")){
                qui5.setText(rs.getString("duracao")); 
                qui5.setStyle("-fx-text-inner-color: green;");
            }else if(b.equalsIgnoreCase("Aula 6")){
                qui6.setText(rs.getString("duracao"));
                qui6.setStyle("-fx-text-inner-color: green;"); 
            }else if(b.equalsIgnoreCase("Aula 7")){
                qui7.setText(rs.getString("duracao"));
                qui7.setStyle("-fx-text-inner-color: green;");
            }else if(b.equalsIgnoreCase("Aula 8")){
                qui8.setText(rs.getString("duracao")); 
                qui8.setStyle("-fx-text-inner-color: green;");
            }else if(b.equalsIgnoreCase("Aula 9")){
                qui9.setText(rs.getString("duracao")); 
                qui9.setStyle("-fx-text-inner-color: green;");
            }
        }
    }
    
    @FXML
    void carregarHorariosSex() throws Exception{
        Connection con = (Connection) Conexao.getConexao();
        String sql = "select * from horario where dia='sexta-feira';";
        PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        
        while (rs.next()){  
            String b = rs.getString("horario");
            if(b.equalsIgnoreCase("Aula 1")){
                sex1.setText(rs.getString("duracao"));
                sex1.setStyle("-fx-text-inner-color: green;");
            }else if(b.equalsIgnoreCase("Aula 2")){
                sex2.setText(rs.getString("duracao"));
                sex2.setStyle("-fx-text-inner-color: green;"); 
            }else if(b.equalsIgnoreCase("Aula 3")){
                sex3.setText(rs.getString("duracao"));
                sex3.setStyle("-fx-text-inner-color: green;"); 
            }else if(b.equalsIgnoreCase("Aula 4")){
                sex4.setText(rs.getString("duracao"));
                sex4.setStyle("-fx-text-inner-color: green;"); 
            }else if(b.equalsIgnoreCase("Aula 5")){
                sex5.setText(rs.getString("duracao")); 
                sex5.setStyle("-fx-text-inner-color: green;");
            }else if(b.equalsIgnoreCase("Aula 6")){
                sex6.setText(rs.getString("duracao"));
                sex6.setStyle("-fx-text-inner-color: green;"); 
            }else if(b.equalsIgnoreCase("Aula 7")){
                sex7.setText(rs.getString("duracao")); 
                sex7.setStyle("-fx-text-inner-color: green;");
            }else if(b.equalsIgnoreCase("Aula 8")){
                sex8.setText(rs.getString("duracao")); 
                sex8.setStyle("-fx-text-inner-color: green;");
            }else if(b.equalsIgnoreCase("Aula 9")){
                sex9.setText(rs.getString("duracao"));  
                sex9.setStyle("-fx-text-inner-color: green;");
            }
        }
    } 


    
}
