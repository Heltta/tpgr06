package com.trabajouy.controllers;

import java.io.IOException;
import java.util.Date;

import com.trabajouy.exceptions.PostulanteRepetido;
import com.trabajouy.model.DTUsuario;
import com.trabajouy.model.Fabrica;
import com.trabajouy.model.IUsuario;
import com.trabajouy.model.Usuario;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class AdminUsuarios
 */
@WebServlet({"/AltaUsuario","/ModificarUsuario"})
public class AdminUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AdminUsuarios() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/WEB-INF/altaUsuario/altaUsuario.jsp").
		forward(req, res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String servletPath = request.getServletPath();
		if ("/AltaUsuario".equals(servletPath)) {
			String nickname = request.getParameter("nickname");
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String contraseña = request.getParameter("contraseña");
			String confirmacion = request.getParameter("confirmacion");
			String email = request.getParameter("email");
			String fecha = request.getParameter("fecha");
			String nacionalidad = request.getParameter("nacionalidad");
			String descripcion = request.getParameter("descripcion");
			String link = request.getParameter("link");
			String tipouser = request.getParameter("tipoUsuario");
			Fabrica fab = Fabrica.getInstance();
			IUsuario ctrUser = fab.getIUsuario();
			if ("postulante".equals(tipouser)) {
				try {	
					ctrUser.ingresarPostulante(nickname, nombre, apellido, email, new Date(fecha.replace("-", "/")) ,nacionalidad);
					request.setAttribute("exito", true);
					request.setAttribute("mensaje", "Usuario creado con exito");
				} catch (Exception e) {
					request.setAttribute("exito", false);
					request.setAttribute("mensaje", e.getMessage());
					request.getRequestDispatcher("/WEB-INF/altaUsuario/altaUsuario.jsp").forward(request, response);
					return;
				}	
			} else if ("empresa".equals(tipouser)) {
				try {
					ctrUser.ingresarEmpresa(nickname, nombre, apellido, email, nickname, descripcion, link);
					request.setAttribute("exito", true);
					request.setAttribute("mensaje", "Usuario creado con exito");
				}catch (Exception e) {
					request.setAttribute("exito", false);
					request.setAttribute("mensaje", e.getMessage());
					request.getRequestDispatcher("/WEB-INF/altaUsuario/altaUsuario.jsp").forward(request, response);
					return;
				}
			}
			response.sendRedirect("AltaUsuario?mensaje=Usuario creado con exito");
		} else if ("/ModificarUsuario".equals(servletPath)) {
			
		}
	}
}
