package Presentacion;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import Logica.ITipos;

import java.awt.Insets;
import java.util.Date;

import javax.swing.JSpinner;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.SpinnerNumberModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearPaqueteTiposPublicacion extends JInternalFrame{
	private ITipos ctrlTipos;
	private JTextField textFieldNombre;
	private JSpinner spinnerValidez;
	private JSpinner spinnerDescuento;
	private JTextArea textAreaDescripcion;
	private JDateChooser dateChooserAlta;
	public CrearPaqueteTiposPublicacion(ITipos ctrlTipos) {
		this.ctrlTipos = ctrlTipos;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Crear Paquete de Tipos de Publicacion");
        setBounds(10, 40, 578, 444);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{90, 105, 206, 158, 0};
        gridBagLayout.rowHeights = new int[]{62, 0, 0, 0, 0, 0, 0, 26, 38, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);
        
        Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
        GridBagConstraints gbc_rigidArea_1 = new GridBagConstraints();
        gbc_rigidArea_1.insets = new Insets(0, 0, 5, 5);
        gbc_rigidArea_1.gridx = 0;
        gbc_rigidArea_1.gridy = 0;
        getContentPane().add(rigidArea_1, gbc_rigidArea_1);
        
        JLabel lblNombre = new JLabel("Nombre:");
        GridBagConstraints gbc_lblNombre = new GridBagConstraints();
        gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
        gbc_lblNombre.anchor = GridBagConstraints.EAST;
        gbc_lblNombre.gridx = 1;
        gbc_lblNombre.gridy = 1;
        getContentPane().add(lblNombre, gbc_lblNombre);
        
        textFieldNombre = new JTextField();
        GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
        gbc_textFieldNombre.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldNombre.gridx = 2;
        gbc_textFieldNombre.gridy = 1;
        getContentPane().add(textFieldNombre, gbc_textFieldNombre);
        textFieldNombre.setColumns(10);
        
        JLabel lblDescripcion = new JLabel("Descripcion:");
        GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
        gbc_lblDescripcion.gridheight = 3;
        gbc_lblDescripcion.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
        gbc_lblDescripcion.gridx = 1;
        gbc_lblDescripcion.gridy = 2;
        getContentPane().add(lblDescripcion, gbc_lblDescripcion);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(5, 60));
        scrollPane.setMinimumSize(new Dimension(5, 60));
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.gridheight = 3;
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
        gbc_scrollPane.gridx = 2;
        gbc_scrollPane.gridy = 2;
        getContentPane().add(scrollPane, gbc_scrollPane);
        
        JTextArea textAreaDescripcion = new JTextArea();
        textAreaDescripcion.setLineWrap(true);
        scrollPane.setViewportView(textAreaDescripcion);
        
        JLabel lblValidez = new JLabel("Validez:");
        GridBagConstraints gbc_lblValidez = new GridBagConstraints();
        gbc_lblValidez.anchor = GridBagConstraints.EAST;
        gbc_lblValidez.insets = new Insets(0, 0, 5, 5);
        gbc_lblValidez.gridx = 1;
        gbc_lblValidez.gridy = 5;
        getContentPane().add(lblValidez, gbc_lblValidez);
        
        JPanel panel_1 = new JPanel();
        GridBagConstraints gbc_panel_1 = new GridBagConstraints();
        gbc_panel_1.insets = new Insets(0, 0, 5, 5);
        gbc_panel_1.fill = GridBagConstraints.BOTH;
        gbc_panel_1.gridx = 2;
        gbc_panel_1.gridy = 5;
        getContentPane().add(panel_1, gbc_panel_1);
        panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
        
        spinnerValidez = new JSpinner();
        spinnerValidez.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        panel_1.add(spinnerValidez);
        
        JLabel lblDescuento = new JLabel("Descuento:");
        lblDescuento.setAlignmentX(Component.RIGHT_ALIGNMENT);
        GridBagConstraints gbc_lblDescuento = new GridBagConstraints();
        gbc_lblDescuento.anchor = GridBagConstraints.EAST;
        gbc_lblDescuento.insets = new Insets(0, 0, 5, 5);
        gbc_lblDescuento.gridx = 1;
        gbc_lblDescuento.gridy = 6;
        getContentPane().add(lblDescuento, gbc_lblDescuento);
        
        JPanel panel = new JPanel();
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.insets = new Insets(0, 0, 5, 5);
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridx = 2;
        gbc_panel.gridy = 6;
        getContentPane().add(panel, gbc_panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        
        spinnerDescuento = new JSpinner();
        panel.add(spinnerDescuento);
        
        JLabel lblFecha = new JLabel("Fecha:");
        GridBagConstraints gbc_lblFecha = new GridBagConstraints();
        gbc_lblFecha.anchor = GridBagConstraints.EAST;
        gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
        gbc_lblFecha.gridx = 1;
        gbc_lblFecha.gridy = 7;
        getContentPane().add(lblFecha, gbc_lblFecha);
        
        dateChooserAlta = new JDateChooser();
        GridBagConstraints gbc_dateChooserAlta = new GridBagConstraints();
        gbc_dateChooserAlta.insets = new Insets(0, 0, 5, 5);
        gbc_dateChooserAlta.fill = GridBagConstraints.BOTH;
        gbc_dateChooserAlta.gridx = 2;
        gbc_dateChooserAlta.gridy = 7;
        getContentPane().add(dateChooserAlta, gbc_dateChooserAlta);
        
        JPanel panel_2 = new JPanel();
        GridBagConstraints gbc_panel_2 = new GridBagConstraints();
        gbc_panel_2.insets = new Insets(0, 0, 5, 5);
        gbc_panel_2.fill = GridBagConstraints.VERTICAL;
        gbc_panel_2.gridx = 2;
        gbc_panel_2.gridy = 8;
        getContentPane().add(panel_2, gbc_panel_2);
        panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
        
        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        panel_2.add(btnAceptar);
        
        Component horizontalStrut = Box.createHorizontalStrut(20);
        panel_2.add(horizontalStrut);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        panel_2.add(btnCancelar);
        
        Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
        GridBagConstraints gbc_rigidArea = new GridBagConstraints();
        gbc_rigidArea.gridx = 3;
        gbc_rigidArea.gridy = 10;
        getContentPane().add(rigidArea, gbc_rigidArea);
	}

	private boolean checkFormulario() {
		String descripcion = textAreaDescripcion.getText();
		String nombre = textFieldNombre.getText();
		Date fecha = dateChooserAlta.getDate();
    	if (descripcion.isEmpty() || nombre.isEmpty() || fecha == null) {
			JOptionPane.showMessageDialog(this, "Debe llenar todos los campos", "Crear Paquete de Tipos de Publicacion", JOptionPane.ERROR_MESSAGE);
			return false;
    	} else {
			try {
				Integer.parseInt((String)spinnerValidez.getValue());
				Integer.parseInt((String)spinnerDescuento.getValue());
			}catch (NumberFormatException ev) {
				JOptionPane.showMessageDialog(this, "Debe ingresar un valor entero", "Agregar Tipo de Publicacion a Paquete", JOptionPane.ERROR_MESSAGE);
				return false;
			}
    	return true;
    	}
	}
	private void limpiarCrearPaquete() {
		textFieldNombre.setText("");
		textAreaDescripcion.selectAll();
		textAreaDescripcion.replaceSelection("");
		spinnerValidez.setValue(Integer.parseInt("0"));
		spinnerDescuento.setValue(Integer.parseInt("0"));
		dateChooserAlta.setDate(null);
	};
}