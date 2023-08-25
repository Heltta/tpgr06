package Presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Logica.Fabrica;
import Logica.ITipos;
import Logica.IUsuario;

import javax.swing.JMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private CrearPaqueteTiposPublicacion frmCrearPaqueteTiposPublicacion;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    main window = new main();
                    window.frmTrabajoUy.setBounds(0,0,800,600);
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
        frmPostulacionOferta = new PostulacionOferta(ctrlUsuario);
        frmAgregarTipoPublicacionAPaquete = new AgregarTipoPublicacionAPaquete(ctrlTipos);
        frmCrearPaqueteTiposPublicacion = new CrearPaqueteTiposPublicacion(ctrlTipos);
        frmAgregarTipoPublicacionAPaquete.setBounds(491, 56, 423, 266);
        frmTrabajoUy.getContentPane().add(frmAgregarTipoPublicacionAPaquete);
        frmTrabajoUy.getContentPane().add(frmAltaTipoPublicacion);
        frmTrabajoUy.getContentPane().add(frmAltaOferta);
        frmTrabajoUy.getContentPane().add(frmPostulacionOferta);
        frmConsultaUsuario = new ConsultaUsuario(ctrlUsuario);
        frmConsultaUsuario.setBounds(0,0, 500, 500);
        frmTrabajoUy.getContentPane().add(frmConsultaUsuario); 
        frmTrabajoUy.getContentPane().add(frmCrearPaqueteTiposPublicacion);
        
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
        menuOferta.add(menuItemConsultaOferta);
        
        JMenuItem menuItemPostulacion = new JMenuItem("Postulacion a Oferta Laboral");
        menuOferta.add(menuItemPostulacion);
        menuItemPostulacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
        menuTipos.add(menuItemConsultaPaquete);
        
        JMenuItem menuItemAltaKeyword = new JMenuItem("Alta de Keyword");
        menuTipos.add(menuItemAltaKeyword);
    }
    
}
