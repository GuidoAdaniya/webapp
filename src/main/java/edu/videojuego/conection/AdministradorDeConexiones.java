package edu.videojuego.conection;

import java.sql.Connection;
import java.sql.DriverManager;

public class AdministradorDeConexiones {

	public static Connection getConnection() {
		String url = "jdbc:mysql://127.0.0.1:3306/dbapex2";
		String username = "root";
		String password = "masaharu2015";
		
		String driverName = "com.mysql.cj.jdbc.Driver";
		/*
		String url = System.getenv("DATASOURCE_URL");
		String user = System.getenv("DATASOURCE_USERNAME");
		String password = System.getenv("DATASOURCE_PASSWORD");
		String driverName = System.getenv("DATASOURCE_DRIVER");
		*/
		//control errores
		Connection con = null;
		try {
			Class.forName(driverName);//carga en memoria el Driver
			con = DriverManager.getConnection(url,username,password);
		}catch(Exception e) {
			e.printStackTrace();//muestra la excepciÃ³n y el error
		}
		return con;
	}
	
	public static void main(String[] args) {
		Connection con = AdministradorDeConexiones.getConnection();//f5
		if(con != null) {
			System.out.println("Conexion ok");
		}else {
			System.err.println("Conexion fail");
		}
	}
}