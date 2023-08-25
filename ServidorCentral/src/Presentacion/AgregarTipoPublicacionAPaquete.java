package Presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import Logica.ITipos;
import Logica.PaqueteTipoPublicacion;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class AgregarTipoPublicacionAPaquete extends JInternalFrame {
	private ITipos ctrlTipos;
	private JTextField textFieldCantidad;
	private JComboBox<String> comboBoxPaquete;
	private JComboBox<String> comboBoxTipo;

	public AgregarTipoPublicacionAPaquete(ITipos ctrlTipos) {
		this.ctrlTipos = ctrlTipos;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Agregar Tipo de Publicacion a Paquete");
        setBounds(10, 40, 578, 444);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 31, 27, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);
        
        Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
        GridBagConstraints gbc_rigidArea = new GridBagConstraints();
        gbc_rigidArea.insets = new Insets(0, 0, 5, 5);
        gbc_rigidArea.gridx = 0;
        gbc_rigidArea.gridy = 0;
        getContentPane().add(rigidArea, gbc_rigidArea);
        
        JLabel lblSeleccionePaquete = new JLabel("Seleccione un paquete:");
        lblSeleccionePaquete.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_lblSeleccionePaquete = new GridBagConstraints();
        gbc_lblSeleccionePaquete.anchor = GridBagConstraints.EAST;
        gbc_lblSeleccionePaquete.insets = new Insets(0, 0, 5, 5);
        gbc_lblSeleccionePaquete.gridx = 1;
        gbc_lblSeleccionePaquete.gridy = 1;
        getContentPane().add(lblSeleccionePaquete, gbc_lblSeleccionePaquete);
        
        JPanel panel_1 = new JPanel();
        GridBagConstraints gbc_panel_1 = new GridBagConstraints();
        gbc_panel_1.gridwidth = 5;
        gbc_panel_1.insets = new Insets(0, 0, 5, 5);
        gbc_panel_1.fill = GridBagConstraints.BOTH;
        gbc_panel_1.gridx = 2;
        gbc_panel_1.gridy = 1;
        getContentPane().add(panel_1, gbc_panel_1);
        panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
        
        comboBoxPaquete = new JComboBox<String>();
        panel_1.add(comboBoxPaquete);

        
        JLabel lblSeleccioneTipo = new JLabel("Seleccione un tipo:");
        lblSeleccioneTipo.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_lblSeleccioneTipo = new GridBagConstraints();
        gbc_lblSeleccioneTipo.anchor = GridBagConstraints.EAST;
        gbc_lblSeleccioneTipo.insets = new Insets(0, 0, 5, 5);
        gbc_lblSeleccioneTipo.gridx = 1;
        gbc_lblSeleccioneTipo.gridy = 2;
        getContentPane().add(lblSeleccioneTipo, gbc_lblSeleccioneTipo);
        
        JPanel panel_2 = new JPanel();
        GridBagConstraints gbc_panel_2 = new GridBagConstraints();
        gbc_panel_2.gridwidth = 5;
        gbc_panel_2.insets = new Insets(0, 0, 5, 5);
        gbc_panel_2.fill = GridBagConstraints.BOTH;
        gbc_panel_2.gridx = 2;
        gbc_panel_2.gridy = 2;
        getContentPane().add(panel_2, gbc_panel_2);
        panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
        
        comboBoxTipo = new JComboBox<String>();
        panel_2.add(comboBoxTipo);
        
        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_lblCantidad = new GridBagConstraints();
        gbc_lblCantidad.anchor = GridBagConstraints.EAST;
        gbc_lblCantidad.insets = new Insets(0, 0, 5, 5);
        gbc_lblCantidad.gridx = 1;
        gbc_lblCantidad.gridy = 3;
        getContentPane().add(lblCantidad, gbc_lblCantidad);
        
        JPanel panel_3 = new JPanel();
        GridBagConstraints gbc_panel_3 = new GridBagConstraints();
        gbc_panel_3.gridwidth = 5;
        gbc_panel_3.insets = new Insets(0, 0, 5, 5);
        gbc_panel_3.fill = GridBagConstraints.BOTH;
        gbc_panel_3.gridx = 2;
        gbc_panel_3.gridy = 3;
        getContentPane().add(panel_3, gbc_panel_3);
        panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
        
        JButton btnMenos = new JButton("-");
        btnMenos.setHorizontalAlignment(SwingConstants.LEFT);
        btnMenos.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int cant = 1;
        		try {
        			cant = Integer.parseInt(textFieldCantidad.getText());
        		} catch (NumberFormatException ev) {
        			cant = 1;
        		}
        		cant--;
        		if (cant < 1) cant = 1;
        		textFieldCantidad.setText(Integer.toString(cant));
        	}
        });
        panel_3.add(btnMenos);
        
        textFieldCantidad = new JTextField();
        textFieldCantidad.setHorizontalAlignment(SwingConstants.RIGHT);
        textFieldCantidad.setText("1");
        panel_3.add(textFieldCantidad);
        textFieldCantidad.setColumns(10);
        
        JButton btnMas = new JButton("+");
        btnMas.setHorizontalAlignment(SwingConstants.RIGHT);
        btnMas.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int cant = 0;
        		try {
        			cant = Integer.parseInt(textFieldCantidad.getText());
        		} catch (NumberFormatException ev) {
        			cant = 0;
        		}
        		cant++;
        		if (cant < 1) cant = 1;
        		textFieldCantidad.setText(Integer.toString(cant));
        	}
        });
        panel_3.add(btnMas);
        
        JPanel panel = new JPanel();
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.gridwidth = 5;
        gbc_panel.anchor = GridBagConstraints.NORTH;
        gbc_panel.insets = new Insets(0, 0, 5, 5);
        gbc_panel.gridx = 2;
        gbc_panel.gridy = 4;
        getContentPane().add(panel, gbc_panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        
        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setHorizontalAlignment(SwingConstants.LEFT);
        btnAgregar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(checkFormulario()) {
        			ctrlTipos.agregarTipoPublicacion(comboBoxPaquete.getSelectedItem().toString(), 
            				comboBoxTipo.getSelectedItem().toString(), Integer.parseInt(textFieldCantidad.getText()));
            		setVisible(false);
            		limpiarAgregarTipoAPaquete();
        		}
        	}
        });
        panel.add(btnAgregar);
        
        Component horizontalStrut = Box.createHorizontalStrut(20);
        panel.add(horizontalStrut);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setHorizontalAlignment(SwingConstants.RIGHT);
        btnCancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
        		limpiarAgregarTipoAPaquete();
        	}
        });
        panel.add(btnCancelar);
        
        Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
        GridBagConstraints gbc_rigidArea_1 = new GridBagConstraints();
        gbc_rigidArea_1.gridx = 9;
        gbc_rigidArea_1.gridy = 5;
        getContentPane().add(rigidArea_1, gbc_rigidArea_1);

	}
	
    public void cargarPaquetes() {
    	Set<String> paquetesTipo = ctrlTipos.listarPaquetes();
    	for (String paquete : paquetesTipo) {
    		comboBoxPaquete.addItem(paquete);
    	}
    }

    public void cargarTiposPaquete() {
    	Set<String> tiposPublicacion = ctrlTipos.listarTiposPublicacion();
    	for (String tipo: tiposPublicacion) {
    		comboBoxTipo.addItem(tipo);
    	}
    }
    
    public void limpiarAgregarTipoAPaquete() {
    	comboBoxPaquete.removeAllItems();
    	comboBoxTipo.removeAllItems();
    	textFieldCantidad.setText("0");
    }
    
    public boolean checkFormulario() {
    	String cantT = textFieldCantidad.getText();
    	if (cantT.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Debe llenar todos los campos", "Alta Tipo de Publicacion", JOptionPane.ERROR_MESSAGE);
			return false;
    	} else if (comboBoxPaquete.getSelectedIndex() == -1 || comboBoxTipo.getSelectedIndex() == -1) {
    		JOptionPane.showMessageDialog(this, "Debe seleccionar un valor de la lista", "Alta Tipo de Publicacion", JOptionPane.ERROR_MESSAGE);
    		return false;
    	} else {
			try {
				Integer.parseInt(textFieldCantidad.getText());
			}catch (NumberFormatException ev) {
				JOptionPane.showMessageDialog(this, "Debe ingresar un valor entero", "Agregar Tipo de Publicacion a Paquete", JOptionPane.ERROR_MESSAGE);
				textFieldCantidad.setText("1");
				return false;
			}
    	return true;
    	}
    }
}