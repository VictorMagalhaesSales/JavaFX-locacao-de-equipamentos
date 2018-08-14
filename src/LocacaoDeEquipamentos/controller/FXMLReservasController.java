package LocacaoDeEquipamentos.controller;

import LocacaoDeEquipamentos.Central;
import LocacaoDeEquipamentos.ResExcluir;
import LocacaoDeEquipamentos.ResInserir;
import LocacaoDeEquipamentos.dao.Conexao;
import LocacaoDeEquipamentos.model.Horario;
import LocacaoDeEquipamentos.model.Reserva;
import LocacaoDeEquipamentos.dao.ReservaDAO;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class FXMLReservasController implements Initializable {
    @FXML
    private ResourceBundle resources;
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
        seg1.setText("Nenhuma reserva");
        seg2.setText("Nenhuma reserva");
        seg3.setText("Nenhuma reserva");
        seg4.setText("Nenhuma reserva");
        seg5.setText("Nenhuma reserva");
        seg6.setText("Nenhuma reserva");
        seg7.setText("Nenhuma reserva");
        seg8.setText("Nenhuma reserva");
        seg9.setText("Nenhuma reserva");
        ter1.setText("Nenhuma reserva");
        ter2.setText("Nenhuma reserva");
        ter3.setText("Nenhuma reserva");
        ter4.setText("Nenhuma reserva");
        ter5.setText("Nenhuma reserva");
        ter6.setText("Nenhuma reserva");
        ter7.setText("Nenhuma reserva");
        ter8.setText("Nenhuma reserva");
        ter9.setText("Nenhuma reserva");
        qua1.setText("Nenhuma reserva");
        qua2.setText("Nenhuma reserva");
        qua3.setText("Nenhuma reserva");
        qua4.setText("Nenhuma reserva");
        qua5.setText("Nenhuma reserva");
        qua6.setText("Nenhuma reserva");
        qua7.setText("Nenhuma reserva");
        qua8.setText("Nenhuma reserva");
        qua9.setText("Nenhuma reserva");
        qui1.setText("Nenhuma reserva");
        qui2.setText("Nenhuma reserva");
        qui3.setText("Nenhuma reserva");
        qui4.setText("Nenhuma reserva");
        qui5.setText("Nenhuma reserva");
        qui6.setText("Nenhuma reserva");
        qui7.setText("Nenhuma reserva");
        qui8.setText("Nenhuma reserva");
        qui9.setText("Nenhuma reserva");
        sex1.setText("Nenhuma reserva");
        sex2.setText("Nenhuma reserva");
        sex3.setText("Nenhuma reserva");
        sex4.setText("Nenhuma reserva");
        sex5.setText("Nenhuma reserva");
        sex6.setText("Nenhuma reserva");
        sex7.setText("Nenhuma reserva");
        sex8.setText("Nenhuma reserva");
        sex9.setText("Nenhuma reserva");
        seg1.setStyle("-fx-text-inner-color: red;");
        seg2.setStyle("-fx-text-inner-color: red;");
        seg3.setStyle("-fx-text-inner-color: red;");
        seg4.setStyle("-fx-text-inner-color: red;");
        seg5.setStyle("-fx-text-inner-color: red;");
        seg6.setStyle("-fx-text-inner-color: red;");
        seg7.setStyle("-fx-text-inner-color: red;");
        seg8.setStyle("-fx-text-inner-color: red;");
        seg9.setStyle("-fx-text-inner-color: red;");
        ter1.setStyle("-fx-text-inner-color: red;");
        ter2.setStyle("-fx-text-inner-color: red;");
        ter3.setStyle("-fx-text-inner-color: red;");
        ter4.setStyle("-fx-text-inner-color: red;");
        ter5.setStyle("-fx-text-inner-color: red;");
        ter6.setStyle("-fx-text-inner-color: red;");
        ter7.setStyle("-fx-text-inner-color: red;");
        ter8.setStyle("-fx-text-inner-color: red;");
        ter9.setStyle("-fx-text-inner-color: red;");
        qua1.setStyle("-fx-text-inner-color: red;");
        qua2.setStyle("-fx-text-inner-color: red;");
        qua3.setStyle("-fx-text-inner-color: red;");
        qua4.setStyle("-fx-text-inner-color: red;");
        qua5.setStyle("-fx-text-inner-color: red;");
        qua6.setStyle("-fx-text-inner-color: red;");
        qua7.setStyle("-fx-text-inner-color: red;");
        qua8.setStyle("-fx-text-inner-color: red;");
        qua9.setStyle("-fx-text-inner-color: red;");
        qui1.setStyle("-fx-text-inner-color: red;");
        qui2.setStyle("-fx-text-inner-color: red;");
        qui3.setStyle("-fx-text-inner-color: red;");
        qui4.setStyle("-fx-text-inner-color: red;");
        qui5.setStyle("-fx-text-inner-color: red;");
        qui6.setStyle("-fx-text-inner-color: red;");
        qui7.setStyle("-fx-text-inner-color: red;");
        qui8.setStyle("-fx-text-inner-color: red;");
        qui9.setStyle("-fx-text-inner-color: red;");
        sex1.setStyle("-fx-text-inner-color: red;");
        sex2.setStyle("-fx-text-inner-color: red;");
        sex3.setStyle("-fx-text-inner-color: red;");
        sex4.setStyle("-fx-text-inner-color: red;");
        sex5.setStyle("-fx-text-inner-color: red;");
        sex6.setStyle("-fx-text-inner-color: red;");
        sex7.setStyle("-fx-text-inner-color: red;");
        sex8.setStyle("-fx-text-inner-color: red;");
        sex9.setStyle("-fx-text-inner-color: red;");
        try {
            carregarHorariosSeg();
            carregarHorariosTer();
            carregarHorariosQua();
            carregarHorariosQui();
            carregarHorariosSex();
            resetarNoDomingo();
        } catch (Exception ex) {
            Logger.getLogger(FXMLReservasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    @FXML
    void carregarHorariosSeg() throws Exception{
        Connection con = (Connection) Conexao.getConexao();
        String sql = "select equipamentos.nome as 'enome', professor.nome as 'pnome', horario.dia, horario.horario from reservas join professor on professor=cdprofessor join equipamentos on cdequipamentos=equipamentos join horario on cdhorario=reservas.horario where dia='segunda-feira';";
        PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        
        while (rs.next()){  
            String b = rs.getString("horario");
            if(b.equalsIgnoreCase("Aula 1")){
                if(seg1.getText().equalsIgnoreCase("Nenhuma reserva")){
                    seg1.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = seg1.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    seg1.setText(res);
                }
                seg1.setStyle("-fx-text-inner-color: green;");
            }else if(b.equalsIgnoreCase("Aula 2")){
                if(seg2.getText().equalsIgnoreCase("Nenhuma reserva")){
                    seg2.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = seg2.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    seg2.setText(res);
                }
                seg2.setStyle("-fx-text-inner-color: green;"); 
            }else if(b.equalsIgnoreCase("Aula 3")){
                if(seg3.getText().equalsIgnoreCase("Nenhuma reserva")){
                    seg3.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = seg3.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    seg3.setText(res);
                }
                seg3.setStyle("-fx-text-inner-color: green;"); 
            }else if(b.equalsIgnoreCase("Aula 4")){
                if(seg4.getText().equalsIgnoreCase("Nenhuma reserva")){
                    seg4.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = seg4.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    seg4.setText(res);
                } 
                seg4.setStyle("-fx-text-inner-color: green;"); 
            }else if(b.equalsIgnoreCase("Aula 5")){
                if(seg5.getText().equalsIgnoreCase("Nenhuma reserva")){
                    seg5.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = seg5.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    seg5.setText(res);
                }  
                seg5.setStyle("-fx-text-inner-color: green;");
            }else if(b.equalsIgnoreCase("Aula 6")){
                if(seg6.getText().equalsIgnoreCase("Nenhuma reserva")){
                    seg6.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = seg6.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    seg6.setText(res);
                }
                seg6.setStyle("-fx-text-inner-color: green;"); 
            }else if(b.equalsIgnoreCase("Aula 7")){
                if(seg7.getText().equalsIgnoreCase("Nenhuma reserva")){
                    seg7.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = seg7.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    seg7.setText(res);
                } 
                seg7.setStyle("-fx-text-inner-color: green;");
            }else if(b.equalsIgnoreCase("Aula 8")){
                if(seg8.getText().equalsIgnoreCase("Nenhuma reserva")){
                    seg8.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = seg8.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    seg8.setText(res);
                } 
                seg8.setStyle("-fx-text-inner-color: green;");
            }else if(b.equalsIgnoreCase("Aula 9")){
                if(seg9.getText().equalsIgnoreCase("Nenhuma reserva")){
                    seg9.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = seg9.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    seg9.setText(res);
                }  
                seg9.setStyle("-fx-text-inner-color: green;");
            }
        }
    }  
    @FXML
    void carregarHorariosTer() throws Exception{
        Connection con = (Connection) Conexao.getConexao();
        String sql = "select equipamentos.nome as 'enome', professor.nome as 'pnome', horario.dia, horario.horario from reservas join professor on professor=cdprofessor join equipamentos on cdequipamentos=equipamentos join horario on cdhorario=reservas.horario where dia='terca-feira';";
        PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        
        while (rs.next()){  
            String b = rs.getString("horario");
            if(b.equalsIgnoreCase("Aula 1")){
                if(ter1.getText().equalsIgnoreCase("Nenhuma reserva")){
                    ter1.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = ter1.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    ter1.setText(res);
                }
                ter1.setStyle("-fx-text-inner-color: green;");
            }else if(b.equalsIgnoreCase("Aula 2")){
                if(ter2.getText().equalsIgnoreCase("Nenhuma reserva")){
                    ter2.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = ter2.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    ter2.setText(res);
                }
                ter2.setStyle("-fx-text-inner-color: green;"); 
            }else if(b.equalsIgnoreCase("Aula 3")){
                if(ter3.getText().equalsIgnoreCase("Nenhuma reserva")){
                    ter3.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = ter3.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    ter3.setText(res);
                }
                ter3.setStyle("-fx-text-inner-color: green;"); 
            }else if(b.equalsIgnoreCase("Aula 4")){
                if(ter4.getText().equalsIgnoreCase("Nenhuma reserva")){
                    ter4.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = ter4.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    ter4.setText(res);
                } 
                ter4.setStyle("-fx-text-inner-color: green;"); 
            }else if(b.equalsIgnoreCase("Aula 5")){
                if(ter5.getText().equalsIgnoreCase("Nenhuma reserva")){
                    ter5.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = ter5.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    ter5.setText(res);
                }  
                ter5.setStyle("-fx-text-inner-color: green;");
            }else if(b.equalsIgnoreCase("Aula 6")){
                if(ter6.getText().equalsIgnoreCase("Nenhuma reserva")){
                    ter6.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = ter6.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    ter6.setText(res);
                }
                ter6.setStyle("-fx-text-inner-color: green;"); 
            }else if(b.equalsIgnoreCase("Aula 7")){
                if(ter7.getText().equalsIgnoreCase("Nenhuma reserva")){
                    ter7.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = ter7.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    ter7.setText(res);
                } 
                ter7.setStyle("-fx-text-inner-color: green;");
            }else if(b.equalsIgnoreCase("Aula 8")){
                if(ter8.getText().equalsIgnoreCase("Nenhuma reserva")){
                    ter8.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = ter8.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    ter8.setText(res);
                } 
                ter8.setStyle("-fx-text-inner-color: green;");
            }else if(b.equalsIgnoreCase("Aula 9")){
                if(ter9.getText().equalsIgnoreCase("Nenhuma reserva")){
                    ter9.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = ter9.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    ter9.setText(res);
                }  
                ter9.setStyle("-fx-text-inner-color: green;");
            }
        }
    } 
     @FXML
    void carregarHorariosQua() throws Exception{
        Connection con = (Connection) Conexao.getConexao();
        String sql = "select equipamentos.nome as 'enome', professor.nome as 'pnome', horario.dia, horario.horario from reservas join professor on professor=cdprofessor join equipamentos on cdequipamentos=equipamentos join horario on cdhorario=reservas.horario where dia='quarta-feira';";
        PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        
        while (rs.next()){  
            String b = rs.getString("horario");
            if(b.equalsIgnoreCase("Aula 1")){
                if(qua1.getText().equalsIgnoreCase("Nenhuma reserva")){
                    qua1.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = qua1.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    qua1.setText(res);
                }
                qua1.setStyle("-fx-text-inner-color: green;");
            }else if(b.equalsIgnoreCase("Aula 2")){
                if(qua2.getText().equalsIgnoreCase("Nenhuma reserva")){
                    qua2.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = qua2.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    qua2.setText(res);
                }
                qua2.setStyle("-fx-text-inner-color: green;"); 
            }else if(b.equalsIgnoreCase("Aula 3")){
                if(qua3.getText().equalsIgnoreCase("Nenhuma reserva")){
                    qua3.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = qua3.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    qua3.setText(res);
                }
                qua3.setStyle("-fx-text-inner-color: green;"); 
            }else if(b.equalsIgnoreCase("Aula 4")){
                if(qua4.getText().equalsIgnoreCase("Nenhuma reserva")){
                    qua4.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = qua4.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    qua4.setText(res);
                } 
                qua4.setStyle("-fx-text-inner-color: green;"); 
            }else if(b.equalsIgnoreCase("Aula 5")){
                if(qua5.getText().equalsIgnoreCase("Nenhuma reserva")){
                    qua5.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = qua5.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    qua5.setText(res);
                }  
                qua5.setStyle("-fx-text-inner-color: green;");
            }else if(b.equalsIgnoreCase("Aula 6")){
                if(qua6.getText().equalsIgnoreCase("Nenhuma reserva")){
                    qua6.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = qua6.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    qua6.setText(res);
                }
                qua6.setStyle("-fx-text-inner-color: green;"); 
            }else if(b.equalsIgnoreCase("Aula 7")){
                if(qua7.getText().equalsIgnoreCase("Nenhuma reserva")){
                    qua7.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = qua7.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    qua7.setText(res);
                } 
                qua7.setStyle("-fx-text-inner-color: green;");
            }else if(b.equalsIgnoreCase("Aula 8")){
                if(qua8.getText().equalsIgnoreCase("Nenhuma reserva")){
                    qua8.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = qua8.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    qua8.setText(res);
                } 
                qua8.setStyle("-fx-text-inner-color: green;");
            }else if(b.equalsIgnoreCase("Aula 9")){
                if(qua9.getText().equalsIgnoreCase("Nenhuma reserva")){
                    qua9.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = qua9.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    qua9.setText(res);
                }  
                qua9.setStyle("-fx-text-inner-color: green;");
            }
        }
    } 
     @FXML
    void carregarHorariosQui() throws Exception{
        Connection con = (Connection) Conexao.getConexao();
        String sql = "select equipamentos.nome as 'enome', professor.nome as 'pnome', horario.dia, horario.horario from reservas join professor on professor=cdprofessor join equipamentos on cdequipamentos=equipamentos join horario on cdhorario=reservas.horario where dia='quinta-feira';";
        PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        
        while (rs.next()){  
            String b = rs.getString("horario");
            if(b.equalsIgnoreCase("Aula 1")){
                if(qui1.getText().equalsIgnoreCase("Nenhuma reserva")){
                    qui1.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = qui1.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    qui1.setText(res);
                }
                qui1.setStyle("-fx-text-inner-color: green;");
            }else if(b.equalsIgnoreCase("Aula 2")){
                if(qui2.getText().equalsIgnoreCase("Nenhuma reserva")){
                    qui2.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = qui2.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    qui2.setText(res);
                }
                qui2.setStyle("-fx-text-inner-color: green;"); 
            }else if(b.equalsIgnoreCase("Aula 3")){
                if(qui3.getText().equalsIgnoreCase("Nenhuma reserva")){
                    qui3.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = qui3.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    qui3.setText(res);
                }
                qui3.setStyle("-fx-text-inner-color: green;"); 
            }else if(b.equalsIgnoreCase("Aula 4")){
                if(qui4.getText().equalsIgnoreCase("Nenhuma reserva")){
                    qui4.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = qui4.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    qui4.setText(res);
                } 
                qui4.setStyle("-fx-text-inner-color: green;"); 
            }else if(b.equalsIgnoreCase("Aula 5")){
                if(qui5.getText().equalsIgnoreCase("Nenhuma reserva")){
                    qui5.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = qui5.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    qui5.setText(res);
                }  
                qui5.setStyle("-fx-text-inner-color: green;");
            }else if(b.equalsIgnoreCase("Aula 6")){
                if(qui6.getText().equalsIgnoreCase("Nenhuma reserva")){
                    qui6.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = qui6.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    qui6.setText(res);
                }
                qui6.setStyle("-fx-text-inner-color: green;"); 
            }else if(b.equalsIgnoreCase("Aula 7")){
                if(qui7.getText().equalsIgnoreCase("Nenhuma reserva")){
                    qui7.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = qui7.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    qui7.setText(res);
                } 
                qui7.setStyle("-fx-text-inner-color: green;");
            }else if(b.equalsIgnoreCase("Aula 8")){
                if(qui8.getText().equalsIgnoreCase("Nenhuma reserva")){
                    qui8.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = qui8.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    qui8.setText(res);
                } 
                qui8.setStyle("-fx-text-inner-color: green;");
            }else if(b.equalsIgnoreCase("Aula 9")){
                if(qui9.getText().equalsIgnoreCase("Nenhuma reserva")){
                    qui9.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = qui9.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    qui9.setText(res);
                }  
                qui9.setStyle("-fx-text-inner-color: green;");
            }
        }
    } 
    @FXML
    void carregarHorariosSex() throws Exception{
        Connection con = (Connection) Conexao.getConexao();
        String sql = "select equipamentos.nome as 'enome', professor.nome as 'pnome', horario.dia, horario.horario from reservas join professor on professor=cdprofessor join equipamentos on cdequipamentos=equipamentos join horario on cdhorario=reservas.horario where dia='sexta-feira';";
        PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        
        while (rs.next()){  
            String b = rs.getString("horario");
            if(b.equalsIgnoreCase("Aula 1")){
                if(sex1.getText().equalsIgnoreCase("Nenhuma reserva")){
                    sex1.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = sex1.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    sex1.setText(res);
                }
                sex1.setStyle("-fx-text-inner-color: green;");
            }else if(b.equalsIgnoreCase("Aula 2")){
                if(sex2.getText().equalsIgnoreCase("Nenhuma reserva")){
                    sex2.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = sex2.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    sex2.setText(res);
                }
                sex2.setStyle("-fx-text-inner-color: green;"); 
            }else if(b.equalsIgnoreCase("Aula 3")){
                if(sex3.getText().equalsIgnoreCase("Nenhuma reserva")){
                    sex3.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = sex3.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    sex3.setText(res);
                }
                sex3.setStyle("-fx-text-inner-color: green;"); 
            }else if(b.equalsIgnoreCase("Aula 4")){
                if(sex4.getText().equalsIgnoreCase("Nenhuma reserva")){
                    sex4.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = sex4.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    sex4.setText(res);
                } 
                sex4.setStyle("-fx-text-inner-color: green;"); 
            }else if(b.equalsIgnoreCase("Aula 5")){
                if(sex5.getText().equalsIgnoreCase("Nenhuma reserva")){
                    sex5.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = sex5.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    sex5.setText(res);
                }  
                sex5.setStyle("-fx-text-inner-color: green;");
            }else if(b.equalsIgnoreCase("Aula 6")){
                if(sex6.getText().equalsIgnoreCase("Nenhuma reserva")){
                    sex6.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = sex6.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    sex6.setText(res);
                }
                sex6.setStyle("-fx-text-inner-color: green;"); 
            }else if(b.equalsIgnoreCase("Aula 7")){
                if(sex7.getText().equalsIgnoreCase("Nenhuma reserva")){
                    sex7.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = sex7.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    sex7.setText(res);
                } 
                sex7.setStyle("-fx-text-inner-color: green;");
            }else if(b.equalsIgnoreCase("Aula 8")){
                if(sex8.getText().equalsIgnoreCase("Nenhuma reserva")){
                    sex8.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = sex8.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    sex8.setText(res);
                } 
                sex8.setStyle("-fx-text-inner-color: green;");
            }else if(b.equalsIgnoreCase("Aula 9")){
                if(sex9.getText().equalsIgnoreCase("Nenhuma reserva")){
                    sex9.setText(rs.getString("pnome") + ": " + rs.getString("enome"));
                }else{
                    String res = sex9.getText() + "; " + rs.getString("pnome") + ": " + rs.getString("enome");
                    sex9.setText(res);
                }  
                sex9.setStyle("-fx-text-inner-color: green;");
            }
        }
    }  
    @FXML
    void voltar(ActionEvent event) throws Exception {
        LocacaoDeEquipamentos.Reservas.getStage().close();
        Central t = new Central();
        t.start(new Stage());
    }    
    @FXML
    void sair(ActionEvent event) throws Exception {
        LocacaoDeEquipamentos.Reservas.getStage().close();
    }   
     @FXML
    public void inserir() throws Exception{
        ResInserir t = new ResInserir();
        t.start(new Stage());
    } 
     @FXML
    public void excluir() throws Exception{
        ResExcluir t = new ResExcluir();
        t.start(new Stage());
    }
    
    public void resetarNoDomingo() throws Exception{
        Date d = new Date();
        Calendar c = new GregorianCalendar();
        c.setTime(d);
        String nome = "";
        int dia = c.get(c.DAY_OF_WEEK);
        switch(dia){
          case Calendar.SUNDAY: nome = "Domingo";break;
          case Calendar.MONDAY: nome = "Segunda";break;
          case Calendar.TUESDAY: nome = "Terça";break;
          case Calendar.WEDNESDAY: nome = "Quarta";break;
          case Calendar.THURSDAY: nome = "Quinta";break;
          case Calendar.FRIDAY: nome = "Sexta";break;
          case Calendar.SATURDAY: nome = "Sábado";break;
        }
        
        if(nome.equalsIgnoreCase("Domingo")){
            Connection con = (Connection) Conexao.getConexao();
            String sql = "delete from reservas where cdreservas != 0";
            PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
            stm.executeUpdate();
            System.out.println("Reservas resetadas!");
        }
        
    }
}
