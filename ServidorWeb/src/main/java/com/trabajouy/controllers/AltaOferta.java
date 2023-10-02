package com.trabajouy.controllers;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.trabajouy.exceptions.nombreOfertaRepetido;
import com.trabajouy.model.DTEmpresa;
import com.trabajouy.model.DTHorario;
import com.trabajouy.model.DTUsuario;
import com.trabajouy.model.Fabrica;
import com.trabajouy.model.ITipos;
import com.trabajouy.model.IUsuario;

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
		DTUsuario usr = (DTUsuario) session.getAttribute("usuarioLogueado");
		
		Fabrica fabrica= Fabrica.getInstance();
		IUsuario ctrlUsuario= fabrica.getIUsuario();
		ITipos ctrlTipos= fabrica.getITipos();
		
		Set<String> listaTipos= ctrlUsuario.listarTiposDePublicacion();
		Set<String> listaKeywords= ctrlUsuario.listarKeywords();

		request.setAttribute("listaKeywords", listaKeywords);
		request.setAttribute("listaTipos", listaTipos);
		
		if (usr!=null && usr.getClass()==DTEmpresa.class) {
			Map<String,Set<String>> listaPaquetesPorTipo= ctrlUsuario.listarPaquetesCompradosParaTipoPublicacionDeEmpresa(usr.getNickname());
			request.setAttribute("listaPaquetes", listaPaquetesPorTipo);
			request.getRequestDispatcher("/WEB-INF/altaOferta/altaOferta.jsp").
			forward(request, response);
		}
		else {
			request.getRequestDispatcher("/WEB-INF/errorPages/404.jsp").
			forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		DTUsuario usr = (DTUsuario) session.getAttribute("usuarioLogueado");
		if (usr!=null && usr.getClass()==DTEmpresa.class) {
			
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
	
			List<String> keywordsList= Arrays.asList(request.getParameterValues("keywords"));
			Set<String> keywords = new HashSet<String>(keywordsList);
			
			String paquete =request.getParameter("paquete");
			
			
			Date fechaLocal = null;
			Fabrica fab= Fabrica.getInstance();
			IUsuario ctrlUsuario= fab.getIUsuario();
			
			String nickname= usr.getNickname();
					
			boolean result=false;
			try {
				result = ctrlUsuario.ingresarOferta(nickname,nombreTipo,nombre, descripcion, horario,remuneracion,fechaLocal,ciudad, departamento,keywords);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if(result) {
				
			}
		}
		else {
			request.getRequestDispatcher("/WEB-INF/errorPages/404.jsp").
			forward(request, response);
		}

	}
}
