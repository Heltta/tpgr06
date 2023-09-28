package com.trabajouy.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import com.trabajouy.model.DTHorario;
import com.trabajouy.model.Empresa;
import com.trabajouy.model.Fabrica;
import com.trabajouy.model.IUsuario;
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
		HttpSession session = request.getSession();
		Usuario usr = (Usuario) session.getAttribute("usuario_logueado");
		if (usr!=null && usr.getClass()==Empresa.class) {
			
			String nombreTipo= request.getParameter("tipoOferta");
			String nombre= request.getParameter("nombre");
			String descripcion= request.getParameter("descripcion");
			int remuneracion= Integer.parseInt( request.getParameter("remuneracion"));
			String departamento= request.getParameter("departamento");
			String ciudad= request.getParameter("ciudad");
			String imagen= request.getParameter("imagen");
			String horarioInicio= request.getParameter("horarioInicio");
			String horarioFin= request.getParameter("horarioFin");
			DTHorario horario= new DTHorario(horarioInicio, horarioFin);
			
			//keywords????
			Set<String> keywords = null;
			
			String paquete =request.getParameter("paquete");
			
			Date fechaLocal = null;
			Fabrica fab= Fabrica.getInstance();
			IUsuario ctrlUsuario= fab.getIUsuario();
			
			String nickname= usr.getNickname();
					
			boolean result= ctrlUsuario.ingresarOferta(nickname,nombreTipo,nombre, descripcion, horario,remuneracion,fechaLocal,ciudad, departamento,keywords);


			if(result) {
				
			}
		}
		else {
			request.getRequestDispatcher("/WEB-INF/errorPages/404.jsp").
			forward(request, response);
		}

	}
}
