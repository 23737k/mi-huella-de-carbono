package my_app.Mi_Huella;

import java.sql.*;

public class App {
  public static void main(String[] args) {
	  
	  try {
		//Crear conexion  
		Connection conexion = DriverManager.getConnection("jdbc:mysql://sql10.freesqldatabase.com:3306/sql10699337", "sql10699337", "MLeR2Lz8Ii");
		//Crear objeto Statement
		Statement statement = conexion.createStatement();
		//Crear objeto ResultSet --> para crear querys
		ResultSet resultset = statement.executeQuery("SELECT * FROM prueba");	//select a la tabla que creamos
		
		while(resultset.next()) {	//mientras haya un siguiente elemento
			System.out.println(resultset.getString("nombre") + " " + resultset.getString("apellido") + " " + resultset.getString("edad"));
		}
	} catch (Exception e) {
		System.out.println("CONEXION FALLIDA");
		e.printStackTrace();					//esto hace que nos muestre que error hubo. Sino no muestra nada. Es muy util
	}
	  
	//CalculoHUFacade.mostrarCalculoHuella(args);
  }

}

