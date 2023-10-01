package com.trabajouy.controllers;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;

import com.trabajouy.exceptions.PostulanteRepetido;
import com.trabajouy.model.DTOfertaLaboral;
import com.trabajouy.model.DTUsuario;
import com.trabajouy.model.Fabrica;
import com.trabajouy.model.IUsuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Postulaciones
 */
@WebServlet({"/Postularse"}) 
public class Postulaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Postulaciones() {

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("usuario-loggeado", "lgarcia");
		String oferta = URLDecoder.decode(request.getParameter("n"), "UTF-8");
		System.out.print(oferta);
		Fabrica fab = Fabrica.getInstance();
		IUsuario ctrlUsuario = fab.getIUsuario();
		request.setAttribute("listaKeywords", ctrlUsuario.listarKeywords());
		try {
			DTOfertaLaboral dataOferta = ctrlUsuario.seleccionarOfertaLaboral(oferta);
			request.setAttribute("oferta", dataOferta);
			request.getRequestDispatcher("/WEB-INF/postulacionOferta/postulacionOferta.jsp").forward(request, response);
		} catch (Exception e) {
			response.sendError(404);
			request.getRequestDispatcher("/WEB-INF/errorPages/404.jsp").include(request, response);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String servletPath = request.getServletPath();
		System.out.print(servletPath);
		if ("/Postularse".equals(servletPath)) {
			DTUsuario user = (DTUsuario) request.getSession().getAttribute("usuario-loggeado");
			Fabrica fab = Fabrica.getInstance();
			IUsuario ctrlUsuario = fab.getIUsuario();
			DTOfertaLaboral dataOferta = (DTOfertaLaboral) request.getAttribute("oferta");
			String cv = (String) request.getAttribute("cv");
			String motivacion = (String) request.getAttribute("motivacion");
			try {
				ctrlUsuario.ingresarDatosPostulacion(user.getNickname(), cv, motivacion, dataOferta.getNombre(), new Date());
			} catch (Exception e) {
				request.getRequestDispatcher("/WEB-INF/postulacionOferta/postulacionOferta.jsp").forward(request, response);
				return;
			}
			response.sendRedirect("Oferta");
		}
	}
}
