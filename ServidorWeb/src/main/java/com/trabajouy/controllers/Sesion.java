package com.trabajouy.controllers;

import java.io.IOException;

import com.trabajouy.model.DTUsuario;
import com.trabajouy.model.Fabrica;
import com.trabajouy.model.IUsuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Sesion
 */
@WebServlet("/Sesion")
public class Sesion extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Sesion() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getSession().getAttribute("usuarioLogueado") == null) {
			Fabrica fab = Fabrica.getInstance();
			IUsuario ctrlUsuario = fab.getIUsuario();
			request.setAttribute("listaKeywords", ctrlUsuario.listarKeywords());
			request.getRequestDispatcher("/WEB-INF/inicioSesion/inicioSesion.jsp").
			forward(request, response);
		}else {
			response.sendRedirect("Home");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Fabrica fab = Fabrica.getInstance();
		IUsuario ctrlUsuario = fab.getIUsuario();
		String nickname = (String) request.getParameter("nickname");
		String pass = (String) request.getParameter("pass");
		DTUsuario usuario = ctrlUsuario.iniciarSesion(nickname, pass);
		if(usuario != null) {
			request.getSession().setAttribute("usuarioLogueado", usuario);
			response.sendRedirect("Home");
		}else {
			request.setAttribute("listaKeywords", ctrlUsuario.listarKeywords());
			request.getRequestDispatcher("/WEB-INF/inicioSesion/errorInicio.jsp").forward(request, response);
		}
	}

}
