package Presentacion;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import Excepciones.nombreTipoPublicacionRepetido;
import Logica.ITipos;

import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class AltaTipoPublicacion extends JInternalFrame {
	private JTextField textFieldNombre;
	private JTextField textFieldExposicion;
	private JTextField textFieldDuracion;
	private JTextArea textAreaDescripcion;
	private JDateChooser chooserFechaAlta;
	private ITipos ctrlTipos;
	private JTextField textFieldCosto;
	
	
	public AltaTipoPublicacion(ITipos ctrlTipos) {
		this.ctrlTipos = ctrlTipos;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Alta de Tipo de Publicacion de Oferta Laboral");
        setBounds(10, 40, 523, 588);
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {30, 30, 0, 0, 0, 30, 0, 30, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 2;
		gbc_lblNombre.gridy = 1;
		getContentPane().add(lblNombre, gbc_lblNombre);
		
		textFieldNombre = new JTextField();
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.gridwidth = 2;
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNombre.gridx = 3;
		gbc_textFieldNombre.gridy = 1;
		getContentPane().add(textFieldNombre, gbc_textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 2;
		gbc_lblDescripcion.gridy = 3;
		getContentPane().add(lblDescripcion, gbc_lblDescripcion);
		
		textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setLineWrap(true);
		GridBagConstraints gbc_textAreaDescripcion = new GridBagConstraints();
		gbc_textAreaDescripcion.anchor = GridBagConstraints.SOUTH;
		gbc_textAreaDescripcion.gridwidth = 2;
		gbc_textAreaDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textAreaDescripcion.gridx = 3;
		gbc_textAreaDescripcion.gridy = 3;
		getContentPane().add(textAreaDescripcion, gbc_textAreaDescripcion);
		
		JLabel lblExposicion = new JLabel("Exposicion:");
		lblExposicion.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblExposicion = new GridBagConstraints();
		gbc_lblExposicion.anchor = GridBagConstraints.EAST;
		gbc_lblExposicion.insets = new Insets(0, 0, 5, 5);
		gbc_lblExposicion.gridx = 2;
		gbc_lblExposicion.gridy = 5;
		getContentPane().add(lblExposicion, gbc_lblExposicion);
		
		textFieldExposicion = new JTextField();
		GridBagConstraints gbc_textFieldExposicion = new GridBagConstraints();
		gbc_textFieldExposicion.gridwidth = 2;
		gbc_textFieldExposicion.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldExposicion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldExposicion.gridx = 3;
		gbc_textFieldExposicion.gridy = 5;
		getContentPane().add(textFieldExposicion, gbc_textFieldExposicion);
		textFieldExposicion.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmdAltaTipoPublicacion(e);
			}
		});
		
		JLabel lblDuracion = new JLabel("Duracion:");
		lblDuracion.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblDuracion = new GridBagConstraints();
		gbc_lblDuracion.anchor = GridBagConstraints.EAST;
		gbc_lblDuracion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDuracion.gridx = 2;
		gbc_lblDuracion.gridy = 7;
		getContentPane().add(lblDuracion, gbc_lblDuracion);
		
		textFieldDuracion = new JTextField();
		GridBagConstraints gbc_textFieldDuracion = new GridBagConstraints();
		gbc_textFieldDuracion.gridwidth = 2;
		gbc_textFieldDuracion.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDuracion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDuracion.gridx = 3;
		gbc_textFieldDuracion.gridy = 7;
		getContentPane().add(textFieldDuracion, gbc_textFieldDuracion);
		textFieldDuracion.setColumns(10);
		
		JLabel lblCosto = new JLabel("Costo:");
		lblCosto.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblCosto = new GridBagConstraints();
		gbc_lblCosto.anchor = GridBagConstraints.EAST;
		gbc_lblCosto.insets = new Insets(0, 0, 5, 5);
		gbc_lblCosto.gridx = 2;
		gbc_lblCosto.gridy = 9;
		getContentPane().add(lblCosto, gbc_lblCosto);
		
		textFieldCosto = new JTextField();
		textFieldCosto.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_textFieldCosto = new GridBagConstraints();
		gbc_textFieldCosto.gridwidth = 2;
		gbc_textFieldCosto.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCosto.fill = GridBagConstraints.BOTH;
		gbc_textFieldCosto.gridx = 3;
		gbc_textFieldCosto.gridy = 9;
		getContentPane().add(textFieldCosto, gbc_textFieldCosto);
		textFieldCosto.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.anchor = GridBagConstraints.EAST;
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.gridx = 2;
		gbc_lblFecha.gridy = 11;
		getContentPane().add(lblFecha, gbc_lblFecha);
		
		//Codigo para desactivar la edicion del campo de texto fecha en el JDateChooser
		chooserFechaAlta = new JDateChooser();
		JTextFieldDateEditor editorFechaAlta = (JTextFieldDateEditor) chooserFechaAlta.getDateEditor();
		editorFechaAlta.setEditable(false);
		
		GridBagConstraints gbc_chooserFechaAlta = new GridBagConstraints();
		gbc_chooserFechaAlta.gridwidth = 2;
		gbc_chooserFechaAlta.insets = new Insets(0, 0, 5, 5);
		gbc_chooserFechaAlta.fill = GridBagConstraints.BOTH;
		gbc_chooserFechaAlta.gridx = 3;
		gbc_chooserFechaAlta.gridy = 11;
		getContentPane().add(chooserFechaAlta, gbc_chooserFechaAlta);
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAceptar.gridx = 3;
		gbc_btnAceptar.gridy = 17;
		getContentPane().add(btnAceptar, gbc_btnAceptar);		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				limpiarAltaTipo();
			}
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 4;
		gbc_btnCancelar.gridy = 17;
		getContentPane().add(btnCancelar, gbc_btnCancelar);
		
		 
	}
			
	private void cmdAltaTipoPublicacion(ActionEvent e) {
		String nombreT = this.textFieldNombre.getText();
		String descripcionT = this.textAreaDescripcion.getText();
		int exposicionT = Integer.parseInt(textFieldExposicion.getText());
		Date fechaT = this.chooserFechaAlta.getDate();
		double costoT = Integer.parseInt(textFieldCosto.getText());
		double duracionT = Integer.parseInt(textFieldDuracion.getText());
	
		try {
			ctrlTipos.ingresarDatosTipoPublicacion(nombreT, descripcionT, exposicionT, fechaT, costoT, duracionT);
			JOptionPane.showMessageDialog(this, "El Tipo de Publicacion se ha creado con éxito", "Agregar Tipo de Publicacion",
                    JOptionPane.INFORMATION_MESSAGE);
		} catch (nombreTipoPublicacionRepetido exc) {
			JOptionPane.showMessageDialog(this, exc.getMessage(), "Agregar Tipo de Publicacion",
                    JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	private void limpiarAltaTipo() {
		textFieldNombre.setText("");
		textAreaDescripcion.selectAll();
		textAreaDescripcion.replaceSelection("");
		textFieldExposicion.setText("");
		textFieldDuracion.setText("");
		textFieldCosto.setText("");
		
	};
}
