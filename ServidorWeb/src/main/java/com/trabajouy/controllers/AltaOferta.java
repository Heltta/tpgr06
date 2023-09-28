package com.trabajouy.controllers;

import java.io.IOException;

import com.trabajouy.model.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class AltaOferta
 */
@WebServlet("/AltaOferta")
public class AltaOferta extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AltaOferta() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Usuario usr = (Usuario) session.getAttribute("usuario_logueado");
		request.getRequestDispatcher("/WEB-INF/altaOferta/altaOferta.jsp").
		forward(request, response);
//		if (usr!=null && usr.getClass()==Empresa.class) {
//			request.getRequestDispatcher("/WEB-INF/altaOferta/altaOferta.jsp").
//			forward(request, response);
//		}
//		else {
//			request.getRequestDispatcher("/WEB-INF/errorPages/404.jsp").
//			forward(request, response);
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
