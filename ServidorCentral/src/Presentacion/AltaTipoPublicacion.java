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
import javax.swing.JScrollPane;

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
        setBounds(10, 40, 410, 427);


        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] {30, 30, 0, 0, 0, 30, 0, 30, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 2;
		gbc_lblNombre.gridy = 2;
		getContentPane().add(lblNombre, gbc_lblNombre);
		
		textFieldNombre = new JTextField();
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.gridwidth = 2;
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNombre.gridx = 3;
		gbc_textFieldNombre.gridy = 2;
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
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 2;
		gbc_scrollPane_1.gridheight = 2;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 3;
		gbc_scrollPane_1.gridy = 3;
		getContentPane().add(scrollPane_1, gbc_scrollPane_1);
		
		textAreaDescripcion = new JTextArea();
		scrollPane_1.setViewportView(textAreaDescripcion);
		textAreaDescripcion.setLineWrap(true);
		
		JLabel lblExposicion = new JLabel("Exposicion:");
		lblExposicion.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblExposicion = new GridBagConstraints();
		gbc_lblExposicion.anchor = GridBagConstraints.EAST;
		gbc_lblExposicion.insets = new Insets(0, 0, 5, 5);
		gbc_lblExposicion.gridx = 2;
		gbc_lblExposicion.gridy = 6;
		getContentPane().add(lblExposicion, gbc_lblExposicion);
		
		textFieldExposicion = new JTextField();
		GridBagConstraints gbc_textFieldExposicion = new GridBagConstraints();
		gbc_textFieldExposicion.gridwidth = 2;
		gbc_textFieldExposicion.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldExposicion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldExposicion.gridx = 3;
		gbc_textFieldExposicion.gridy = 6;
		getContentPane().add(textFieldExposicion, gbc_textFieldExposicion);
		textFieldExposicion.setColumns(10);
		
		JLabel lblDuracion = new JLabel("Duracion:");
		lblDuracion.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblDuracion = new GridBagConstraints();
		gbc_lblDuracion.anchor = GridBagConstraints.EAST;
		gbc_lblDuracion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDuracion.gridx = 2;
		gbc_lblDuracion.gridy = 8;
		getContentPane().add(lblDuracion, gbc_lblDuracion);
		
		textFieldDuracion = new JTextField();
		GridBagConstraints gbc_textFieldDuracion = new GridBagConstraints();
		gbc_textFieldDuracion.gridwidth = 2;
		gbc_textFieldDuracion.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDuracion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDuracion.gridx = 3;
		gbc_textFieldDuracion.gridy = 8;
		getContentPane().add(textFieldDuracion, gbc_textFieldDuracion);
		textFieldDuracion.setColumns(10);
		
		JLabel lblCosto = new JLabel("Costo:");
		lblCosto.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblCosto = new GridBagConstraints();
		gbc_lblCosto.anchor = GridBagConstraints.EAST;
		gbc_lblCosto.insets = new Insets(0, 0, 5, 5);
		gbc_lblCosto.gridx = 2;
		gbc_lblCosto.gridy = 10;
		getContentPane().add(lblCosto, gbc_lblCosto);
		
		textFieldCosto = new JTextField();
		textFieldCosto.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_textFieldCosto = new GridBagConstraints();
		gbc_textFieldCosto.gridwidth = 2;
		gbc_textFieldCosto.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCosto.fill = GridBagConstraints.BOTH;
		gbc_textFieldCosto.gridx = 3;
		gbc_textFieldCosto.gridy = 10;
		getContentPane().add(textFieldCosto, gbc_textFieldCosto);
		textFieldCosto.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.anchor = GridBagConstraints.EAST;
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.gridx = 2;
		gbc_lblFecha.gridy = 12;
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
		gbc_chooserFechaAlta.gridy = 12;
		getContentPane().add(chooserFechaAlta, gbc_chooserFechaAlta);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmdAltaTipoPublicacion(e);
			}
		});
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAceptar.gridx = 3;
		gbc_btnAceptar.gridy = 15;
		getContentPane().add(btnAceptar, gbc_btnAceptar);		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				limpiarAltaTipo();
			}
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 4;
		gbc_btnCancelar.gridy = 15;
		getContentPane().add(btnCancelar, gbc_btnCancelar);
		
	}
			
	private void cmdAltaTipoPublicacion(ActionEvent e) {
		if (checkFormulario()) {
			String nombreT = this.textFieldNombre.getText();
			String descripcionT = this.textAreaDescripcion.getText();
			int exposicionT = Integer.parseInt(textFieldExposicion.getText());
			Date fechaT = this.chooserFechaAlta.getDate();
			double costoT = Integer.parseInt(textFieldCosto.getText());
			double duracionT = Double.parseDouble(textFieldDuracion.getText());
		
			try {
				ctrlTipos.ingresarDatosTipoPublicacion(nombreT, descripcionT, exposicionT, fechaT, costoT, duracionT);
				JOptionPane.showMessageDialog(this, "El Tipo de Publicacion se ha creado con éxito", "Agregar Tipo de Publicacion",
	                    JOptionPane.INFORMATION_MESSAGE);
			} catch (nombreTipoPublicacionRepetido exc) {
				JOptionPane.showMessageDialog(this, exc.getMessage(), "Agregar Tipo de Publicacion",
	                    JOptionPane.INFORMATION_MESSAGE);
			}
		}		
	}
	
	private boolean checkFormulario() {
		String nombreT = textFieldNombre.getText();
		String descripcionT = textAreaDescripcion.getText();
		String exposicionT = textFieldExposicion.getText();
		String duracionT = textFieldDuracion.getText();
		String costoT = textFieldCosto.getText();
		Date fechaT = this.chooserFechaAlta.getDate();
		
		if (nombreT.isEmpty() || descripcionT.isEmpty() || fechaT == null || exposicionT.isEmpty() ||
				duracionT.isEmpty() || costoT.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Debe llenar todos los campos", "Alta Tipo de Publicacion", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		try {
			Double.parseDouble(costoT);
			Double.parseDouble(duracionT);
			Integer.parseInt(exposicionT);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Debe ingresar un numero", "Alta Tipo de Publicacion", JOptionPane.ERROR_MESSAGE);
			return false;
		}
			
		return true;
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
