package com.trabajouy.controllers;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.trabajouy.model.DTUsuario;
import com.trabajouy.model.Fabrica;
import com.trabajouy.model.IUsuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConsultaUsuario
 */
@WebServlet({"/ConsultaUsuario","/PerfilUsuario"})
public class ConsultaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ConsultaUsuario() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Fabrica fab = Fabrica.getInstance();
		IUsuario ctrlUsuario = fab.getIUsuario();
		String servletPath = request.getServletPath();
		if(servletPath.equals("/ConsultaUsuario")) {
			ArrayList<String> nicknamesUsuarios = ctrlUsuario.listarUsuarios();
			Collections.sort(nicknamesUsuarios);
			Set<DTUsuario> usuarios = new HashSet<DTUsuario>();
			for(String nombre : nicknamesUsuarios){
				usuarios.add(ctrlUsuario.mostrarDatosUsuario(nombre));
			}
			request.setAttribute("usuarios", usuarios);
			request.setAttribute("listaKeywords", ctrlUsuario.listarKeywords());
			request.getRequestDispatcher("/WEB-INF/consultaUsuario/consultaUsuario.jsp").
			forward(request, response);
		}
		else if(servletPath.equals("/PerfilUsuario")){
			String nickname = URLDecoder.decode(request.getParameter("nickname"),StandardCharsets.UTF_8.toString());
			DTUsuario user = ctrlUsuario.mostrarDatosUsuario(nickname);
			request.setAttribute("detalleUsuario", user);
			request.getRequestDispatcher("/WEB-INF/consultaUsuario/perfilUsuario.jsp").forward(request, response);
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
