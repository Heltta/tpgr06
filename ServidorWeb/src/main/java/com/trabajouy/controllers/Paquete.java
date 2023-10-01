package com.trabajouy.controllers;

import java.io.IOException;

import com.trabajouy.model.Fabrica;
import com.trabajouy.model.ITipos;
import com.trabajouy.model.IUsuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Paquete
 */
@WebServlet({"/ConsultaPaquetes","/CompraPaquete"})
public class Paquete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Paquete() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String servletPath = request.getServletPath();
		if("/ConsultaPaquetes".equals(servletPath)) {
			Fabrica fab = Fabrica.getInstance();
			IUsuario ctrlUsuario = fab.getIUsuario();
			request.setAttribute("listaKeywords", ctrlUsuario.listarKeywords());
			ITipos ctrlTipos = fab.getITipos();
			request.setAttribute("listaPaquetes", ctrlTipos.obtenerDataPaquetes());
			request.getRequestDispatcher("/WEB-INF/consultaPaquetes/consultapaquetes.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
