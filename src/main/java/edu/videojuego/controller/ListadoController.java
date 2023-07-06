package edu.videojuego.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.videojuego.dao.PersonajeDAO;
import edu.videojuego.pojo.Personaje;


@WebServlet("/api/ListadoController")
public class ListadoController extends HttpServlet {

	@Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//crear la instancia de PersonajeDAO
		PersonajeDAO dao = new PersonajeDAO();
		
		//invocar al metodo listarProductos()
		List<Personaje> listado = dao.listarPersonajes();
		
		//grabar el listado en el request para que lo vea la siguiente pagina
		req.setAttribute("listado", listado);
		
		//ir a la siguiente pagina

		getServletContext().getRequestDispatcher("/listado.jsp").forward(req, resp);
	}
}