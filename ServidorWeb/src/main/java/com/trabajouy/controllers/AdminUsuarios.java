package com.trabajouy.controllers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Set;

import org.apache.tomcat.jakartaee.commons.compress.utils.FileNameUtils;

import com.trabajouy.exceptions.PostulanteRepetido;
import com.trabajouy.model.DTUsuario;
import com.trabajouy.model.Fabrica;
import com.trabajouy.model.IUsuario;
import com.trabajouy.model.Usuario;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;


/**
 * Servlet implementation class AdminUsuarios
 */
@WebServlet({"/AltaUsuario","/ModificarUsuario"})
@MultipartConfig
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Fabrica fab = Fabrica.getInstance();
		IUsuario ctrlUser = fab.getIUsuario();
		Set<String> listaKeywords= ctrlUser.listarKeywords();
		request.setAttribute("listaKeywords", listaKeywords);
		request.getRequestDispatcher("/WEB-INF/altaUsuario/altaUsuario.jsp").
		forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String servletPath = request.getServletPath();
		
		if ("/AltaUsuario".equals(servletPath)) {
			Fabrica fab = Fabrica.getInstance();
			IUsuario ctrUser = fab.getIUsuario();
			Set<String> listaKeywords= ctrUser.listarKeywords();
			request.setAttribute("listaKeywords", listaKeywords);
			String nickname = request.getParameter("nickname");
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String contraseña = request.getParameter("contrasenia");
			String confirmacion = request.getParameter("confirmacion");
			System.out.print(contraseña);
			System.out.print(confirmacion);
			if (!contraseña.equals(confirmacion)) {
				request.setAttribute("exito", false);
				request.setAttribute("mensaje", "La contraseña y la confirmación deben coincidir");
				request.getRequestDispatcher("/WEB-INF/altaUsuario/altaUsuario.jsp").forward(request, response);
				return;
			}
			String email = request.getParameter("email");
			String fecha = request.getParameter("fecha");
			String nacionalidad = request.getParameter("nacionalidad");
			String descripcion = request.getParameter("descripcion");
			String link = request.getParameter("link");
			String tipouser = request.getParameter("tipoUsuario");
			Part imagen = request.getPart("imagen");
			String nombreImagen = imagen.getSubmittedFileName();
			String separador = FileSystems.getDefault().getSeparator();
			String mediaPath = System.getProperty("catalina.base") + separador + "wtpwebapps" + separador + "ServidorWeb" + separador + "media" + separador;
			if (imagen == null) {
				//imagen = /imagen/por/defecto
			}
			if ("postulante".equals(tipouser)) {
				try {
					ctrUser.ingresarPostulante(nickname, nombre, apellido, email, new Date(fecha.replace("-", "/")) ,nacionalidad, mediaPath, contraseña);
					request.setAttribute("exito", true);
					request.setAttribute("mensaje", "Usuario creado con exito");
					if (imagen != null) imagen.write(mediaPath + nickname + nombreImagen);
				} catch (Exception e) {
					request.setAttribute("exito", false);
					request.setAttribute("mensaje", e.getMessage());
					request.getRequestDispatcher("/WEB-INF/altaUsuario/altaUsuario.jsp").forward(request, response);
					return;
				}	
			} else if ("empresa".equals(tipouser)) {
				try {
					ctrUser.ingresarEmpresa(nickname, nombre, apellido, email, nickname, descripcion, link, mediaPath, contraseña);
					request.setAttribute("exito", true);
					request.setAttribute("mensaje", "Usuario creado con exito");
				    if (imagen != null) imagen.write(mediaPath + nickname + nombreImagen);
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
