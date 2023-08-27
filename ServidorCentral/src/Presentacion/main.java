package Presentacion;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Logica.DTHorario;
import Logica.Empresa;
import Logica.Fabrica;
import Logica.ITipos;
import Logica.IUsuario;
import Logica.ManejadorOferta;
import Logica.ManejadorUsuario;
import Logica.OfertaLaboral;
import Logica.Postulante;
import Logica.TipoPublicacion;

import javax.swing.JMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;

import javax.swing.JInternalFrame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class main {

    private JFrame frmTrabajoUy;
    private AltaTipoPublicacion frmAltaTipoPublicacion;
    private PostulacionOferta frmPostulacionOferta;
    private AltaUsuario frmAltaUsuario;
    private IUsuario ctrlUsuario;
    private ITipos ctrlTipos;
    private AltaOferta frmAltaOferta;
    private ConsultaUsuario frmConsultaUsuario;
    private AgregarTipoPublicacionAPaquete frmAgregarTipoPublicacionAPaquete;
    private ConsultaOferta frmConsultaOferta;
    private CrearPaqueteTiposPublicacion frmCrearPaqueteTiposPublicacion;
    private ConsultaPaquete frmConsultaPaquete;
    
    private String csvDirectory;
    private ArrayList<String> keywords;
    private ArrayList<String> usuarios;
    private ArrayList<String> ofertas;
    private ArrayList<String> paquetes;
    private ArrayList<String> tipos;
    private ArrayList<Double> costoTipos;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    main window = new main();
                    window.frmTrabajoUy.setBounds(0,0,900,700);
                    window.frmTrabajoUy.setMinimumSize(new Dimension(870,620));
                    window.frmTrabajoUy.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public main() {
        initialize();

        frmTrabajoUy.getContentPane().setLayout(null);
        frmAltaTipoPublicacion = new AltaTipoPublicacion(ctrlTipos);
        frmAltaOferta = new AltaOferta(ctrlUsuario);
        frmConsultaOferta = new ConsultaOferta(ctrlUsuario);
        frmPostulacionOferta = new PostulacionOferta(ctrlUsuario, frmConsultaOferta);
        frmAltaUsuario = new AltaUsuario(ctrlUsuario);
        frmCrearPaqueteTiposPublicacion = new CrearPaqueteTiposPublicacion(ctrlTipos);
        frmAgregarTipoPublicacionAPaquete = new AgregarTipoPublicacionAPaquete(ctrlTipos);
        frmAgregarTipoPublicacionAPaquete.setBounds(0, 0, 423, 266);
        frmTrabajoUy.getContentPane().add(frmAgregarTipoPublicacionAPaquete);
        frmTrabajoUy.getContentPane().add(frmAltaTipoPublicacion);
        frmTrabajoUy.getContentPane().add(frmAltaOferta);
        frmTrabajoUy.getContentPane().add(frmPostulacionOferta);
        frmTrabajoUy.getContentPane().add(frmConsultaOferta);
        frmTrabajoUy.getContentPane().add(frmAltaUsuario);
        frmTrabajoUy.getContentPane().add(frmCrearPaqueteTiposPublicacion);
        frmConsultaUsuario = new ConsultaUsuario(ctrlUsuario, frmConsultaOferta);
        frmConsultaUsuario.setBounds(0,0, 500, 500);
        frmTrabajoUy.getContentPane().add(frmConsultaUsuario); 
        frmConsultaPaquete = new ConsultaPaquete(ctrlTipos);
        frmTrabajoUy.getContentPane().add(frmConsultaPaquete);
        
        frmTrabajoUy.getContentPane().setLayout(null);
        csvDirectory= System.getProperty("user.dir") + "\\src\\TProg_DatosPruebaTarea1_2023-CSVs-v1_0\\";

        cargarDatosUsuarios();
        cargarTipoPublicacion();
        cargarKeywords();
        cargarOfertasLaborales();
        cargarPostulaciones();
        cargarPaquetes();
        cargarTipoPaquetes();
    }

    private void initialize() {
    	Fabrica fab = Fabrica.getInstance();
    	ctrlUsuario = fab.getIUsuario();
    	ctrlTipos = fab.getITipos();
    			
        frmTrabajoUy = new JFrame();
        frmTrabajoUy.setTitle("Trabajo.UY");
        frmTrabajoUy.setBounds(100, 100, 960, 599);
        frmTrabajoUy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JMenuBar menuBar = new JMenuBar();
        frmTrabajoUy.setJMenuBar(menuBar);

        JMenu menuUsuarios = new JMenu("Usuario");
        menuBar.add(menuUsuarios);
        
        JMenu menuOferta = new JMenu("Oferta");
        menuBar.add(menuOferta);
        
        JMenu menuTipos = new JMenu("Tipo de Publicacion");
        menuBar.add(menuTipos);
        
        JMenuItem menuItemAltaUser = new JMenuItem("Alta Usuario");
        menuItemAltaUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmAltaUsuario.setVisible(true);
            }
        });
        menuUsuarios.add(menuItemAltaUser);

        JMenuItem menuItemConsultaUser = new JMenuItem("Consulta de Usuario");
        menuItemConsultaUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmConsultaUsuario.update();
                frmConsultaUsuario.setVisible(true);
            }
        });
        menuUsuarios.add(menuItemConsultaUser);
        
        JMenuItem menuItemModDatosUser = new JMenuItem("Modificar Datos de Usuario");
        menuUsuarios.add(menuItemModDatosUser);
        
        JMenuItem menuItemAltaOferta = new JMenuItem("Alta de Oferta Laboral");
        menuItemAltaOferta.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String[] empresas = new String[ctrlUsuario.listarEmpresas().size()];
        		empresas =ctrlUsuario.listarEmpresas().toArray(empresas);
        		String[] tipos = new String[ctrlUsuario.listarTiposDePublicacion().size()];
        		tipos =ctrlUsuario.listarTiposDePublicacion().toArray(tipos);
        		String[] key = new String[ctrlUsuario.listarKeywords().size()];
        		key=ctrlUsuario.listarKeywords().toArray(key);
        		frmAltaOferta.actualizar(empresas,tipos,key);
        		frmAltaOferta.setVisible(true);
        	}
        });
        menuOferta.add(menuItemAltaOferta);
        
        JMenuItem menuItemConsultaOferta = new JMenuItem("Consulta de Oferta Laboral");
        menuItemConsultaOferta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmConsultaOferta.ListarEmpresas();
            	frmConsultaOferta.setVisible(true);
            }
        });
        menuOferta.add(menuItemConsultaOferta);
        
        JMenuItem menuItemPostulacion = new JMenuItem("Postulacion a Oferta Laboral");
        menuOferta.add(menuItemPostulacion);
        menuItemPostulacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmPostulacionOferta.ListarEmpresas();
            	frmPostulacionOferta.setVisible(true);
            }
        });
        JMenuItem menuItemAltaTipo = new JMenuItem("Alta de Tipo de Publicacion de Oferta Laboral");
        menuItemAltaTipo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmAltaTipoPublicacion.setVisible(true);
            }
        });
        menuTipos.add(menuItemAltaTipo);
        
        JMenuItem menuItemCrearPaquete = new JMenuItem("Crear Paquete de Tipos de Publicacion");
        menuItemCrearPaquete.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frmCrearPaqueteTiposPublicacion.setVisible(true);
        	}
        });
        menuTipos.add(menuItemCrearPaquete);
        
        JMenuItem menuItemAgregarTipo = new JMenuItem("Agregar Tipo de Publicacion a Paquete");
        menuItemAgregarTipo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frmAgregarTipoPublicacionAPaquete.cargarPaquetes();
        		frmAgregarTipoPublicacionAPaquete.cargarTiposPaquete();
        		frmAgregarTipoPublicacionAPaquete.setVisible(true);
        	}
        });
        menuTipos.add(menuItemAgregarTipo);
        
        JMenuItem menuItemConsultaPaquete = new JMenuItem("Consulta de Paquete de Tipos de Publicacion");
        menuItemConsultaPaquete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmConsultaPaquete.cargarPaquetes();
            	frmConsultaPaquete.setVisible(true);
            }
        });
        menuTipos.add(menuItemConsultaPaquete);
        
        JMenuItem menuItemAltaKeyword = new JMenuItem("Alta de Keyword");
        menuTipos.add(menuItemAltaKeyword);
    };
    

    public void cargarDatosPrueba2() {

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
                	Date fecha =new Date(Integer.parseInt(numerosFecha[2]),Integer.parseInt(numerosFecha[1]),Integer.parseInt(numerosFecha[0]));
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
                Date fecha =new Date(Integer.parseInt(numerosFecha[2]),Integer.parseInt(numerosFecha[1]),Integer.parseInt(numerosFecha[0]));
                ctrlTipos.ingresarDatosTipoPublicacion(nombre, desc, Integer.parseInt(exp),fecha,(costo), Double.parseDouble(dur));
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
                Date fecha =new Date(Integer.parseInt(numerosFecha[2]),Integer.parseInt(numerosFecha[1]),Integer.parseInt(numerosFecha[0]));
                Set<String> lkeywords= new HashSet<String>();
                
                BufferedReader br2 = new BufferedReader(new FileReader(OfertasKeysCSV));
                String line2;
                int j=0;
                while ((line2 = br2.readLine()) != null) {
                	if(j>0) {
                		String[] data2 = line2.split(";");
                		String [] data3= data2[1].replaceAll(" ", "").split(",");
                		for (int l=0; l<data3.length; l++) {
                			lkeywords.add(keywords.get(Integer.parseInt(data3[l].substring(1))-1));
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
                Date fecha =new Date(Integer.parseInt(numerosFecha[2]),Integer.parseInt(numerosFecha[1]),Integer.parseInt(numerosFecha[0]));
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
                Date fecha =new Date(Integer.parseInt(numerosFecha[2]),Integer.parseInt(numerosFecha[1]),Integer.parseInt(numerosFecha[0]));
                BufferedReader br2 = new BufferedReader(new FileReader(tipoPubliPaq));
                String line2;
                int j=0;
                double costo=0;
                while ((line2 = br2.readLine()) != null) {
        			if(j>0) { //Ref; Paquete; Tipos; Cantidad
                    String[] data2 = line2.split(";");
                    int paq= Integer.parseInt(data2[1].trim().substring(3));
                    int tip= Integer.parseInt(data2[2].trim().substring(2));
                    int cant= Integer.parseInt(data2[3].trim());
                    if(paq==i) {
                    	costo=costo+costoTipos.get(tip-1);
                    }                    
        			}
                    j++;
                }
                ctrlTipos.ingresarDatosPaquete(nombre, descr, duracion, descuento, costo, fecha);
                costo=0;
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
