package com.trabajouy.controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.trabajouy.model.*;
/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String separador = FileSystems.getDefault().getSeparator();
    private String csvDirectory= System.getProperty("catalina.base") + separador + "wtpwebapps" + separador + "ServidorWeb" + separador + "TProg_DatosPruebaTarea1_2023-CSVs-v1_0" + separador;
    private Fabrica fab = Fabrica.getInstance();
    private IUsuario ctrlUsuario = fab.getIUsuario();
    private ITipos ctrlTipos = fab.getITipos();
    
    private ArrayList<String> keywords;
    private ArrayList<String> usuarios;
    private ArrayList<String> ofertas;
    private ArrayList<String> paquetes;
    private ArrayList<String> tipos;
    private ArrayList<Double> costoTipos;

    /**
     * Default constructor. 
     */
    public Home() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.print(System.getProperty("catalina.base"));
		if(req.getSession().getAttribute("cantPaginas") == null) {
			req.getSession().setAttribute("cantPaginas", 1);
			//Codigo temporal para cargar datos de prueba
			cargarDatosPrueba();
		}
		Fabrica fabrica= Fabrica.getInstance();
		IUsuario ctrlUsuario= fabrica.getIUsuario();
		Set<String> listaKeywords= ctrlUsuario.listarKeywords();
		req.setAttribute("listaKeywords", listaKeywords);
		req.getRequestDispatcher("/WEB-INF/home/Home.jsp").forward(req, res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


public void cargarDatosPrueba() {
	cargarDatosUsuarios();
    cargarTipoPublicacion();
    cargarKeywords();
    cargarOfertasLaborales();
    cargarPostulaciones();
    cargarPaquetes();
    cargarTipoPaquetes();
}
public void cargarDatosUsuarios() {
	String usuariosCSV=csvDirectory+"Usuarios.csv";
	String postulantesCSV=csvDirectory+"Usuarios-Postulantes.csv";
	String empresasCSV=csvDirectory+"Usuarios-Empresas.csv";
	String line;
	ArrayList<String> systemTagUsuarios= new ArrayList<String>();
	usuarios= new ArrayList<String>();
	
	ArrayList<String> systemTagPostulantes= new ArrayList<String>();
	ArrayList<String> fechaP= new ArrayList<String>();
	ArrayList<String> nacionalidadP= new ArrayList<String>();
	
	ArrayList<String> systemTagE= new ArrayList<String>();
	ArrayList<String> descE= new ArrayList<String>();
	ArrayList<String> linkE= new ArrayList<String>();
	int i=0;
	try (BufferedReader br = new BufferedReader(new FileReader(postulantesCSV))) {
		while ((line = br.readLine()) != null) {
			if(i>0) {
            String[] data = line.split(";");
            String sysName = data[0].trim();
            String fecha = data[1].trim();
            String nacionalidad= data[2].trim();
            systemTagPostulantes.add(sysName);
            fechaP.add(fecha);
            nacionalidadP.add(nacionalidad);
			}
            i++;
        }
	}
	catch(IOException e){
		e.printStackTrace();
	}
	i=0;
	try (BufferedReader br = new BufferedReader(new FileReader(empresasCSV))) {
		while ((line = br.readLine()) != null) {
			if(i>0) {
            String[] data = line.split(";");
            String sysName = data[0].trim();
            String desc = data[1].trim();
            String link= data[2].trim();
            systemTagE.add(sysName);
            descE.add(desc);
            linkE.add(link);
			}
            i++;
        }
	}
	catch(IOException e){
		e.printStackTrace();
	}
	i=0;
	try (BufferedReader br = new BufferedReader(new FileReader(usuariosCSV))) {
		while ((line = br.readLine()) != null) {
			if(i>0) {
            String[] data = line.split(";");
            String sysName = data[0].trim();
            String nickname = data[2].trim();
            String nombre= data[3].trim();
            String apellido= data[4].trim();
            String mail= data[5].trim();
            usuarios.add(nickname);
            if(systemTagPostulantes.contains(sysName)) {
            	String[] numerosFecha = fechaP.get(i-1).split("/");
            	LocalDate localfecha = LocalDate.of(Integer.parseInt(numerosFecha[2]),Integer.parseInt(numerosFecha[1]),Integer.parseInt(numerosFecha[0]));
            	//Date fecha =new Date(Integer.parseInt(numerosFecha[2]),Integer.parseInt(numerosFecha[1]),Integer.parseInt(numerosFecha[0]));
            	Date fecha = Date.from(localfecha.atStartOfDay(ZoneId.systemDefault()).toInstant());
            	ctrlUsuario.ingresarPostulante(nickname, nombre, apellido, mail, fecha, nacionalidadP.get(systemTagPostulantes.indexOf(sysName)));
            }else {
            	ctrlUsuario.ingresarEmpresa(nickname, nombre, apellido, mail, nickname ,descE.get(systemTagE.indexOf(sysName)), linkE.get(systemTagE.indexOf(sysName)));
            }
			}
            i++;
        }
	}
	catch (Exception e) {
		e.printStackTrace();
	}
}
public void cargarKeywords() {
	String keywordsCSV = csvDirectory+"Keywords.csv";
	keywords= new ArrayList<String>();
	String line;
	int i=0;
	try (BufferedReader br = new BufferedReader(new FileReader(keywordsCSV))) {
		while ((line = br.readLine()) != null) {
			if(i>0) {
            String[] data = line.split(";");
            String nombre = data[1].trim();
            keywords.add(nombre);
            ctrlTipos.ingresarKeyword(nombre);
			}
            i++;
        }
	}
	catch (Exception e) {
		e.printStackTrace();
	}
}
public void cargarTipoPublicacion() {
	String tipoCSV = csvDirectory+"TipoPublicacion.csv";
	String line;
	tipos= new ArrayList<String>();
	costoTipos = new ArrayList<Double>();
	int i=0;
	try (BufferedReader br = new BufferedReader(new FileReader(tipoCSV))) {
		while ((line = br.readLine()) != null) {
			if(i>0) {
            String[] data = line.split(";");
            String nombre= data[1].trim();
            tipos.add(nombre);
            String desc= data[2].trim();
            String exp= data[3].trim();
            String dur= data[4].trim();
            Double costo= Double.parseDouble(data[5].trim());
            costoTipos.add(costo);
            String fechaAlta= data[6].trim();
            String[] numerosFecha = fechaAlta.split("/");

            //LocalDate localfecha = LocalDate.of(Integer.parseInt(numerosFecha[2]),Integer.parseInt(numerosFecha[1]),Integer.parseInt(numerosFecha[0]));
           // Instant instante = localfecha.atStartOfDay(ZoneId.systemDefault()).toInstant();
        	//Date fecha = Date.from(instante);
            Date fecha =new Date(Integer.parseInt(numerosFecha[2]),Integer.parseInt(numerosFecha[1]),Integer.parseInt(numerosFecha[0]));
            ctrlTipos.ingresarDatosTipoPublicacion(nombre, desc, Integer.parseInt(exp),fecha,(costo), Integer.parseInt(dur));
			}
            i++;
        }
	}
	catch (Exception e) {
		e.printStackTrace();
	}
}
public void cargarOfertasLaborales() {
	String ofertasCSV = csvDirectory+"OfertasLaborales.csv";
	String OfertasKeysCSV= csvDirectory+"OfertasLaboralesKeywords.csv";
	ofertas= new ArrayList<String>();
	String line;
	int i=0;
	try (BufferedReader br = new BufferedReader(new FileReader(ofertasCSV))) {
		while ((line = br.readLine()) != null) {
			if(i>0) {
				//Ref;Nombre;Descripcion;Departamento;Ciudad;Horario;Remuneracion;Usuario;TipoPublicacion;FechaAlta
            String[] data = line.split(";");
            String nombre= data[1].trim();
            ofertas.add(nombre);
            String desc= data[2].trim();
            String dep= data[3].trim();
            String ciudad= data[4].trim();
            String horarioString= data[5].trim();
            String [] horarios = horarioString.split("-"); 
            DTHorario horario= new DTHorario(horarios[0].replaceAll(" ", ""), horarios[1].replaceAll(" ", ""));
            int remuneracion= Integer.parseInt(data[6].trim());
            int usuario= Integer.parseInt(data[7].trim().substring(1));
            int ixPubli= Integer.parseInt(data[8].trim().substring(2));
            String fechaAlta= data[9].trim();
            String[] numerosFecha = fechaAlta.split("/");
            LocalDate localfecha = LocalDate.of(Integer.parseInt(numerosFecha[2]),Integer.parseInt(numerosFecha[1]),Integer.parseInt(numerosFecha[0])-2);
        	Date fecha = Date.from(localfecha.atStartOfDay(ZoneId.systemDefault()).toInstant());
            //Date fecha =new Date(Integer.parseInt(numerosFecha[2]),Integer.parseInt(numerosFecha[1]),Integer.parseInt(numerosFecha[0]));
            Set<String> lkeywords= new HashSet<String>();
            
            BufferedReader br2 = new BufferedReader(new FileReader(OfertasKeysCSV));
            String line2;
            int j=0;
            while ((line2 = br2.readLine()) != null) {
            	if(j>0) {
            		
            		String[] data2 = line2.split(";");
            		if(data[0].equals(data2[0])) {
            			String [] data3= data2[1].replaceAll(" ", "").split(",");
            			for (int l=0; l<data3.length; l++) {
            				lkeywords.add(keywords.get(Integer.parseInt(data3[l].substring(1))-1));
            			}
            			break;
            		}
            	}
            	j++;
            }
            ctrlUsuario.ingresarOferta(usuarios.get(usuario-1), tipos.get(ixPubli-1), nombre, desc, horario, remuneracion, fecha, ciudad, dep, lkeywords);
            lkeywords.clear();
			}
            i++;
        }
	}
	catch (Exception e) {
		e.printStackTrace();
	}
}
public void cargarPostulaciones() {
	String postuCSV = csvDirectory+"Postulaciones.csv";
	String line;
	int i=0;
	try (BufferedReader br = new BufferedReader(new FileReader(postuCSV))) {
		while ((line = br.readLine()) != null) {
			if(i>0) { //Ref;Usuario;CV;Motivación;Fecha;Oferta
            String[] data = line.split(";");
            int uID= Integer.parseInt(data[1].trim().substring(1));
            String cv= data[2].trim();
            String mot= data[3].trim();
            String fechaAlta= data[4].trim();
            int oID= Integer.parseInt(data[5].trim().substring(1));
            String[] numerosFecha = fechaAlta.split("/");
            LocalDate localfecha = LocalDate.of(Integer.parseInt(numerosFecha[2]),Integer.parseInt(numerosFecha[1]),Integer.parseInt(numerosFecha[0])-2);
        	Date fecha = Date.from(localfecha.atStartOfDay(ZoneId.systemDefault()).toInstant());
            //Date fecha = new Date(Integer.parseInt(numerosFecha[2]),Integer.parseInt(numerosFecha[1]),Integer.parseInt(numerosFecha[0]));
            ctrlUsuario.ingresarDatosPostulacion(usuarios.get(uID-1), cv, mot, ofertas.get(oID-1) , fecha);
			}
            i++;
        }
	}
	catch (Exception e) {
		e.printStackTrace();
	}
}
public void cargarPaquetes() {
	String paqueCSV = csvDirectory+"Paquetes.csv";
	String tipoPubliPaq = csvDirectory+"TiposPublicacionPaquetes.csv";
	String line;
	paquetes= new ArrayList<String>();
	int i=0;
	try (BufferedReader br = new BufferedReader(new FileReader(paqueCSV))) {
		while ((line = br.readLine()) != null) {
			if(i>0) { //Ref;Nombre;Descripcion;Período;Descuento;Fecha
            String[] data = line.split(";");
            String nombre= data[1].trim();
            paquetes.add(nombre);
            String descr= data[2].trim();
            String periodo= data[3].trim();
            int duracion = Integer.parseInt(data[3].trim().replaceAll("[^0-9]", ""));
            double descuento= Double.parseDouble(data[4].trim());
            String fechaAlta= data[5].trim();
            String[] numerosFecha = fechaAlta.split("/");
            LocalDate localfecha = LocalDate.of(Integer.parseInt(numerosFecha[2]),Integer.parseInt(numerosFecha[1]),Integer.parseInt(numerosFecha[0])-2);
        	Date fecha = Date.from(localfecha.atStartOfDay(ZoneId.systemDefault()).toInstant());
            //Date fecha =new Date(Integer.parseInt(numerosFecha[2]),Integer.parseInt(numerosFecha[1]),Integer.parseInt(numerosFecha[0]));
            BufferedReader br2 = new BufferedReader(new FileReader(tipoPubliPaq));
            String line2;
            int j=0;
            ctrlTipos.ingresarDatosPaquete(nombre, descr, duracion, descuento, fecha);
			}
            i++;
        }
	}
	catch (Exception e) {
		e.printStackTrace();
	}
}
public void cargarTipoPaquetes() {
	String tipoPubliPaq = csvDirectory+"TiposPublicacionPaquetes.csv";
	String line;
	int i=0;
	try (BufferedReader br = new BufferedReader(new FileReader(tipoPubliPaq))) {
		while ((line = br.readLine()) != null) {
			if(i>0) { //Ref; Paquete; Tipos; Cantidad
            String[] data = line.split(";");
            int paq= Integer.parseInt(data[1].trim().substring(3));
            int tip= Integer.parseInt(data[2].trim().substring(2));
            int cant= Integer.parseInt(data[3].trim());
            
            ctrlTipos.agregarTipoPublicacion(paquetes.get(paq-1), tipos.get(tip-1), cant);
            
			}
            i++;
        }
	}
	catch (Exception e) {
		e.printStackTrace();
	}
}
public void cargarCompras() {
	
}
}

