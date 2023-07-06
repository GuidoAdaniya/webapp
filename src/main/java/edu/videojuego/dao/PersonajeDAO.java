package edu.videojuego.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.videojuego.conection.AdministradorDeConexiones;
import edu.videojuego.pojo.Personaje;

public class PersonajeDAO {

  /*metodos del crud*/
	public List<Personaje> listarPersonajes() {
		//Connection
    Connection con = AdministradorDeConexiones.getConnection();
		List<Personaje> list = new ArrayList<>();

		if(con != null) {
			String sql = "select * from personaje";
			try{
			// Se crea un Statement, para realizar la consulta
			Statement s = con.createStatement();
			
			// Se realiza la consulta. Los resultados se guardan en el 
			// ResultSet rs
			ResultSet rs = s.executeQuery (sql);
			while(rs.next()) {
				// rs > sacando los datos
				int id = rs.getInt(1);//toma la primer columna
				String nombre = rs.getString(2);
				int edad = rs.getInt(3);
				String clase = rs.getString(4);
				String pickrate = rs.getString(5);
				
				//campos crear un objeto????
				Personaje p = new Personaje();
				p.setId(id);
				p.setNombre(nombre);
				p.setEdad(edad);
				p.setClase(clase);
				p.setPickrate(pickrate);
				
				//agrego a la lista 
				list.add(p);
			}
			//cierro la conexion
			con.close();
		 } catch(SQLException e){
			e.printStackTrace();
		 }
		 }
			return list;
	}
  
}