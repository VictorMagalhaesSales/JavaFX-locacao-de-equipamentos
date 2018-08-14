package LocacaoDeEquipamentos.dao;


import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

public class Conexao {
	private static Connection con = null;
	private Conexao(){
		System.out.println("Conexão criada");
	}
	public static Connection getConexao() throws ClassNotFoundException, SQLException{
		if (con == null){
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/locacao?user=root&password=";
			con = (Connection) DriverManager.getConnection(url);
		}
		return con;
	}
	
	public void finalizar() throws Exception{
		con.close();
	}
 	
}

    
    
   
