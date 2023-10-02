package com.trabajouy.controllers;

import java.io.IOException;
import java.util.Set;

import com.trabajouy.model.DTOfertaLaboral;
import com.trabajouy.model.Fabrica;
import com.trabajouy.model.IUsuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/**
 * Servlet implementation class Oferta
 */
@WebServlet("/Oferta")
public class Oferta extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Oferta() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Fabrica fab= Fabrica.getInstance();
		IUsuario ctrlUsuario= fab.getIUsuario();
		
		String nombreOferta=request.getParameter("n");
		
		String keyword= request.getParameter("k");
		Set<String> listaKeywords= ctrlUsuario.listarKeywords();
		request.setAttribute("listaKeywords", listaKeywords);
		
		if(nombreOferta!=null) {
			nombreOferta= URLDecoder.decode(nombreOferta,StandardCharsets.UTF_8.toString());
			//si no existe la oferta segun su nombre tirar 404
			try {
				DTOfertaLaboral oferta = ctrlUsuario.seleccionarOfertaLaboral(nombreOferta);
				request.setAttribute("oferta", oferta);
				request.getRequestDispatcher("/WEB-INF/consultaOferta/consultaOfertaDetalles.jsp").
				
				forward(request, response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.getRequestDispatcher("/WEB-INF/errorPages/404.jsp").
				forward(request, response);
			}
		}
		else {
			Set<DTOfertaLaboral> ofertas = (keyword!=null && listaKeywords.contains(keyword)) ?  ctrlUsuario.listarOfertasPorKeyword(keyword): ctrlUsuario.listarOfertasLaborales();
			request.setAttribute("ofertas", ofertas);
			request.getRequestDispatcher("/WEB-INF/consultaOferta/consultaOferta.jsp").
			forward(request, response);
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
