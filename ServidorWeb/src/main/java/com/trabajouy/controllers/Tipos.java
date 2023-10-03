package com.trabajouy.controllers;

import java.io.IOException;
import java.net.URLDecoder;

import com.trabajouy.model.DTTipoPublicacion;
import com.trabajouy.model.Fabrica;
import com.trabajouy.model.ITipos;
import com.trabajouy.model.IUsuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Tipos
 */
@WebServlet("/Tipos")
public class Tipos extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Tipos() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Fabrica fab = Fabrica.getInstance();
		IUsuario ctrlUsuario = fab.getIUsuario();
		ITipos ctrlTipos = fab.getITipos();
		request.setAttribute("listaKeywords", ctrlUsuario.listarKeywords());
		String nombreTipo = (String)request.getParameter("t");
		if (nombreTipo!=null) {
			nombreTipo = URLDecoder.decode(nombreTipo,"UTF-8");
			DTTipoPublicacion dataTipo=ctrlTipos.obtenerDataTipos().get(nombreTipo);
			if(dataTipo!=null) {
			request.setAttribute("tipoPublicacion", dataTipo);
			request.getRequestDispatcher("/WEB-INF/consultaTipos/consultaTipoDetalle.jsp").forward(request, response);
			}
			else {
				response.sendError(404);
				request.getRequestDispatcher("/WEB-INF/errorPages/404.jsp").include(request, response);
				return;
			}
			
		}
		else {
			request.setAttribute("tiposPublicacion", ctrlTipos.obtenerDataTipos().keySet());
			request.getRequestDispatcher("/WEB-INF/consultaTipos/consultaTipo.jsp").forward(request, response);
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
