package com.mihuella;

import java.sql.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
  public static void main(String[] args) {

	  SpringApplication.run(App.class,args);
	  System.out.println("Executed Main Application");
	  
	  
	  final String url = "jdbc:mysql://sql10.freesqldatabase.com:3306/sql10699337";
	  final String user = "sql10699337";
	  final String pass = "MLeR2Lz8Ii";
	  
	  try {
		System.out.println("Intentando conectar con la BBDD");
		//Crear conexion  
		
		/*Connection conexion = */ DriverManager.getConnection(url, user, pass);
		System.out.println("Conexion exitosa!!!");
		
	} catch (Exception e) {
		System.out.println("CONEXION FALLIDA");
		e.printStackTrace();					//esto hace que nos muestre que error hubo. Sino no muestra nada. Es muy util
	}
	  
	  
	 SessionFactory sessionFactory =  new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Parametro.class).buildSessionFactory();
	 Session session = sessionFactory.openSession();
	 
	 try {
		Parametro parametro = new Parametro("nafta",3.0);
		session.beginTransaction();
		session.persist(parametro);
		session.getTransaction().commit();
		session.close();
		
	} finally {
		session.close();
	}
	 
	//CalculoHUFacade.mostrarCalculoHuella(args);
  }

}

