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

import javax.swing.JInternalFrame;


public class main {

    private JFrame frmTrabajoUy;
    private AltaTipoPublicacion frmAltaTipoPublicacion;
    private PostulacionOferta frmPostulacionOferta;
    private IUsuario ctrlUsuario;
    private ITipos ctrlTipos;
    private AltaOferta frmAltaOferta;
    private ConsultaUsuario frmConsultaUsuario;
    private AgregarTipoPublicacionAPaquete frmAgregarTipoPublicacionAPaquete;
    private ConsultaOferta frmConsultaOferta;
    private CrearPaqueteTiposPublicacion frmCrearPaqueteTiposPublicacion;


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
        frmAgregarTipoPublicacionAPaquete = new AgregarTipoPublicacionAPaquete(ctrlTipos);
        frmAgregarTipoPublicacionAPaquete.setBounds(0, 0, 423, 266);
        frmTrabajoUy.getContentPane().add(frmAgregarTipoPublicacionAPaquete);
        frmTrabajoUy.getContentPane().add(frmAltaTipoPublicacion);
        frmTrabajoUy.getContentPane().add(frmAltaOferta);
        frmTrabajoUy.getContentPane().add(frmPostulacionOferta);
        frmTrabajoUy.getContentPane().add(frmConsultaOferta);
        frmConsultaUsuario = new ConsultaUsuario(ctrlUsuario, frmConsultaOferta);
        frmConsultaUsuario.setBounds(0,0, 500, 500);
        frmTrabajoUy.getContentPane().add(frmConsultaUsuario); 
        
        frmTrabajoUy.getContentPane().setLayout(null);
        
        CargarDatosDePrueba();
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
        menuUsuarios.add(menuItemAltaUser);

        JMenuItem menuItemConsultaUser = new JMenuItem("Consulta de Usuario");
        menuItemConsultaUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String [] nicknames= ctrlUsuario.listarUsuarios().toArray(new String[0]);
                frmConsultaUsuario.update(nicknames);
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
        menuTipos.add(menuItemConsultaPaquete);
        
        JMenuItem menuItemAltaKeyword = new JMenuItem("Alta de Keyword");
        menuTipos.add(menuItemAltaKeyword);
    };
    
    @SuppressWarnings("deprecation")
    public void CargarDatosDePrueba() {
    	ManejadorOferta mo = ManejadorOferta.getInstancia();
		ManejadorUsuario mu = ManejadorUsuario.getInstance();
		//Postulantes
		Postulante post = new Postulante("Juan123", "j123@mail.com", "Juan", "Perez", "Uruguayo", LocalDate.of(1996, 3, 4));
		Postulante post1 = new Postulante("Gonzalo123", "g123@mail.com", "Gonzalo", "Diaz", "Argentino", LocalDate.of(1997, 6, 14));
		Postulante post2 = new Postulante("Marcos123", "m123@mail.com", "Marcos", "Lopez", "Chileno", LocalDate.of(1998, 9, 25));
		mu.agregarUsuario(post);
		mu.agregarUsuario(post1);
		mu.agregarUsuario(post2);
		//Empresa
		Empresa emp = new Empresa("Artech123", "artech@mail.com", "Rodrigo", "Rodriguez", "Artech SA", "Empresa de tecnologia", "asd");
		Empresa emp1 = new Empresa("Tecni123", "tecni@mail.com", "Alvaro", "Rios", "Tecni SA", "Empresa de tecnicos", "asd");
		Empresa emp2 = new Empresa("Simba123", "simba@mail.com", "Julieta", "Pio", "Simba SA", "Empresa de sabana", "asd");
		mu.agregarUsuario(emp);
		mu.agregarUsuario(emp1);
		mu.agregarUsuario(emp2);
		
		DTHorario horario = new DTHorario("09:00", "18:00");
		DTHorario horario1 = new DTHorario("08:00", "16:00");
		DTHorario horario2 = new DTHorario("08:00", "14:00");
		Date fecha = new Date(2023,3,4);
		Date fecha1 = new Date(2022,12,3);
		Date fecha2 = new Date(2023,4,14);
		TipoPublicacion tipo = new TipoPublicacion("Oro", "descrip", 1, new Date(2023,5,1), 5000, 9);
		TipoPublicacion tipo1 = new TipoPublicacion("Plata", "descrip", 2, new Date(2023,7,2), 3000, 8);
		TipoPublicacion tipo2 = new TipoPublicacion("Bronce", "descrip", 3, new Date(2023,4,25), 2000, 6);
		OfertaLaboral oferta = new OfertaLaboral("Desarrollador", "trabajo junior", "Ciudad", "Mdeo", horario, 3000, fecha, tipo, null);
		OfertaLaboral oferta1 = new OfertaLaboral("Tecnico", "trabajo pc", "Ciudad1", "Mdeo1", horario1, 2000, fecha1, tipo1, null);
		OfertaLaboral oferta2 = new OfertaLaboral("Animalista", "trabajo animales", "Ciudad2", "Mdeo2", horario2, 5000, fecha2, tipo2, null);
		oferta.agregarPostulante(post);
		oferta.agregarPostulante(post1);
		oferta1.agregarPostulante(post);
		post.postularAOferta(oferta, fecha, "cv asd", "Descr");
		post1.postularAOferta(oferta, fecha1, "cv 2", "Descr2");
		post.postularAOferta(oferta1, fecha, "cv asd", "Descr");
		emp.agregarOferta(oferta);
		emp1.agregarOferta(oferta1);
		emp2.agregarOferta(oferta2);
		mo.agregarOferta(oferta);
		mo.agregarOferta(oferta1);
		mo.agregarOferta(oferta2);
    }
}
