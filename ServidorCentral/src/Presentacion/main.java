package Presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class main {

    private JFrame frmTrabajoUy;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    main window = new main();
                    window.frmTrabajoUy.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public main() {
        initialize();
    }

    private void initialize() {
        frmTrabajoUy = new JFrame();
        frmTrabajoUy.setTitle("Trabajo.UY");
        frmTrabajoUy.setBounds(100, 100, 450, 400);
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
        menuUsuarios.add(menuItemConsultaUser);
        
        JMenuItem menuItemModDatosUser = new JMenuItem("Modificar Datos de Usuario");
        menuUsuarios.add(menuItemModDatosUser);
        
        JMenuItem menuItemAltaOferta = new JMenuItem("Alta de Oferta Laboral");
        menuOferta.add(menuItemAltaOferta);
        
        JMenuItem menuItemConsultaOferta = new JMenuItem("Consulta de Oferta Laboral");
        menuOferta.add(menuItemConsultaOferta);
        
        JMenuItem menuItemPostulacion = new JMenuItem("Postulacion a Oferta Laboral");
        menuOferta.add(menuItemPostulacion);
        
        JMenuItem menuItemAltaTipo = new JMenuItem("Alta de Tipo de Publicacion de Oferta Laboral");
        menuTipos.add(menuItemAltaTipo);
        
        JMenuItem menuItemCrearPaquete = new JMenuItem("Crear Paquete de Tipos de Publicacion");
        menuTipos.add(menuItemCrearPaquete);
        
        JMenuItem menuItemAgregarTipo = new JMenuItem("Agregar Tipo de Publicacion a Paquete");
        menuTipos.add(menuItemAgregarTipo);
        
        JMenuItem menuItemConsultaPaquete = new JMenuItem("Consulta de Paquete de Tipos de Publicacion");
        menuTipos.add(menuItemConsultaPaquete);
        
        JMenuItem menuItemAltaKeyword = new JMenuItem("Alta de Keyword");
        menuTipos.add(menuItemAltaKeyword);
    }
}
