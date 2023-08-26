package Presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class AltaUsuario extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nicknameField;
	private JTextField emailField;
	private JTextField nombreField;
	private JTextField apellidoField;
	private JTextField nacionalidadField;
	private JTextField descripcionField;
	private JTextField linkField;
	private String[] listaTiposDeUsuarios = { "Postulante", "Empresa" };

	/**
	 * Create the frame.
	 */
	public AltaUsuario() {
		setClosable(true);
		setTitle("Crear Usuario");
		setBounds(100, 100, 450, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 120, 169, 30};
		gridBagLayout.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0};
		getContentPane().setLayout(gridBagLayout);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea = new GridBagConstraints();
		gbc_rigidArea.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea.gridx = 0;
		gbc_rigidArea.gridy = 0;
		getContentPane().add(rigidArea, gbc_rigidArea);
		
		JLabel nickname = new JLabel("Nickname");
		GridBagConstraints gbc_nickname = new GridBagConstraints();
		gbc_nickname.anchor = GridBagConstraints.EAST;
		gbc_nickname.insets = new Insets(0, 0, 5, 5);
		gbc_nickname.gridx = 1;
		gbc_nickname.gridy = 1;
		getContentPane().add(nickname, gbc_nickname);
		
		nicknameField = new JTextField();
		GridBagConstraints gbc_nicknameField = new GridBagConstraints();
		gbc_nicknameField.insets = new Insets(0, 0, 5, 5);
		gbc_nicknameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nicknameField.gridx = 2;
		gbc_nicknameField.gridy = 1;
		getContentPane().add(nicknameField, gbc_nicknameField);
		nicknameField.setColumns(10);
		
		JLabel email = new JLabel("E-mail");
		GridBagConstraints gbc_email = new GridBagConstraints();
		gbc_email.anchor = GridBagConstraints.EAST;
		gbc_email.insets = new Insets(0, 0, 5, 5);
		gbc_email.gridx = 1;
		gbc_email.gridy = 2;
		getContentPane().add(email, gbc_email);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		GridBagConstraints gbc_emailField = new GridBagConstraints();
		gbc_emailField.insets = new Insets(0, 0, 5, 5);
		gbc_emailField.fill = GridBagConstraints.HORIZONTAL;
		gbc_emailField.gridx = 2;
		gbc_emailField.gridy = 2;
		getContentPane().add(emailField, gbc_emailField);
		
		JLabel nombre = new JLabel("Nombre");
		GridBagConstraints gbc_nombre = new GridBagConstraints();
		gbc_nombre.anchor = GridBagConstraints.EAST;
		gbc_nombre.insets = new Insets(0, 0, 5, 5);
		gbc_nombre.gridx = 1;
		gbc_nombre.gridy = 3;
		getContentPane().add(nombre, gbc_nombre);
		
		nombreField = new JTextField();
		GridBagConstraints gbc_nombreField = new GridBagConstraints();
		gbc_nombreField.insets = new Insets(0, 0, 5, 5);
		gbc_nombreField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nombreField.gridx = 2;
		gbc_nombreField.gridy = 3;
		getContentPane().add(nombreField, gbc_nombreField);
		nombreField.setColumns(10);
		
		JLabel apellido = new JLabel("Apellido");
		GridBagConstraints gbc_apellido = new GridBagConstraints();
		gbc_apellido.anchor = GridBagConstraints.EAST;
		gbc_apellido.insets = new Insets(0, 0, 5, 5);
		gbc_apellido.gridx = 1;
		gbc_apellido.gridy = 4;
		getContentPane().add(apellido, gbc_apellido);
		
		apellidoField = new JTextField();
		GridBagConstraints gbc_apellidoField = new GridBagConstraints();
		gbc_apellidoField.insets = new Insets(0, 0, 5, 5);
		gbc_apellidoField.fill = GridBagConstraints.HORIZONTAL;
		gbc_apellidoField.gridx = 2;
		gbc_apellidoField.gridy = 4;
		getContentPane().add(apellidoField, gbc_apellidoField);
		apellidoField.setColumns(10);
		
		JLabel tipoUsuario = new JLabel("Tipo de usuario");
		GridBagConstraints gbc_tipoUsuario = new GridBagConstraints();
		gbc_tipoUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_tipoUsuario.anchor = GridBagConstraints.EAST;
		gbc_tipoUsuario.gridx = 1;
		gbc_tipoUsuario.gridy = 5;
		getContentPane().add(tipoUsuario, gbc_tipoUsuario);
		JComboBox tiposDeUsuarioCombo = new JComboBox(listaTiposDeUsuarios);
		tiposDeUsuarioCombo.setSelectedIndex(-1);
		GridBagConstraints gbc_tiposDeUsuarioCombo = new GridBagConstraints();
		gbc_tiposDeUsuarioCombo.insets = new Insets(0, 0, 5, 5);
		gbc_tiposDeUsuarioCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_tiposDeUsuarioCombo.gridx = 2;
		gbc_tiposDeUsuarioCombo.gridy = 5;
		getContentPane().add(tiposDeUsuarioCombo, gbc_tiposDeUsuarioCombo);
		
		JLabel nacionalidad = new JLabel("Nacionalidad");
		nacionalidad.setEnabled(false);
		GridBagConstraints gbc_nacionalidad = new GridBagConstraints();
		gbc_nacionalidad.anchor = GridBagConstraints.EAST;
		gbc_nacionalidad.insets = new Insets(0, 0, 5, 5);
		gbc_nacionalidad.gridx = 1;
		gbc_nacionalidad.gridy = 6;
		getContentPane().add(nacionalidad, gbc_nacionalidad);
		
		nacionalidadField = new JTextField();
		nacionalidadField.setEnabled(false);
		GridBagConstraints gbc_nacionalidadField = new GridBagConstraints();
		gbc_nacionalidadField.insets = new Insets(0, 0, 5, 5);
		gbc_nacionalidadField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nacionalidadField.gridx = 2;
		gbc_nacionalidadField.gridy = 6;
		getContentPane().add(nacionalidadField, gbc_nacionalidadField);
		nacionalidadField.setColumns(10);
		
		JLabel fechaNacimiento = new JLabel("Fecha de nacimiento");
		fechaNacimiento.setEnabled(false);
		GridBagConstraints gbc_fechaNacimiento = new GridBagConstraints();
		gbc_fechaNacimiento.anchor = GridBagConstraints.EAST;
		gbc_fechaNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_fechaNacimiento.gridx = 1;
		gbc_fechaNacimiento.gridy = 7;
		getContentPane().add(fechaNacimiento, gbc_fechaNacimiento);
		
		JDateChooser fechaDeNacimientoChooser = new JDateChooser();
		GridBagConstraints gbc_fechaDeNacimientoChooser = new GridBagConstraints();
		fechaDeNacimientoChooser.setEnabled(false);
		gbc_fechaDeNacimientoChooser.insets = new Insets(0, 0, 5, 5);
		gbc_fechaDeNacimientoChooser.fill = GridBagConstraints.BOTH;
		gbc_fechaDeNacimientoChooser.gridx = 2;
		gbc_fechaDeNacimientoChooser.gridy = 7;
		getContentPane().add(fechaDeNacimientoChooser, gbc_fechaDeNacimientoChooser);
		
		JLabel descripcion = new JLabel("Descripcion");
		descripcion.setEnabled(false);
		GridBagConstraints gbc_descripcion = new GridBagConstraints();
		gbc_descripcion.anchor = GridBagConstraints.EAST;
		gbc_descripcion.insets = new Insets(0, 0, 5, 5);
		gbc_descripcion.gridx = 1;
		gbc_descripcion.gridy = 8;
		getContentPane().add(descripcion, gbc_descripcion);
		
		descripcionField = new JTextField();
		descripcionField.setEnabled(false);
		GridBagConstraints gbc_descripcionField = new GridBagConstraints();
		gbc_descripcionField.insets = new Insets(0, 0, 5, 5);
		gbc_descripcionField.fill = GridBagConstraints.HORIZONTAL;
		gbc_descripcionField.gridx = 2;
		gbc_descripcionField.gridy = 8;
		getContentPane().add(descripcionField, gbc_descripcionField);
		descripcionField.setColumns(10);
		
		JLabel link = new JLabel("Link");
		link.setEnabled(false);
		GridBagConstraints gbc_link = new GridBagConstraints();
		gbc_link.anchor = GridBagConstraints.EAST;
		gbc_link.insets = new Insets(0, 0, 5, 5);
		gbc_link.gridx = 1;
		gbc_link.gridy = 9;
		getContentPane().add(link, gbc_link);
		
		linkField = new JTextField();
		linkField.setEnabled(false);
		GridBagConstraints gbc_linkField = new GridBagConstraints();
		gbc_linkField.insets = new Insets(0, 0, 5, 5);
		gbc_linkField.fill = GridBagConstraints.HORIZONTAL;
		gbc_linkField.gridx = 2;
		gbc_linkField.gridy = 9;
		getContentPane().add(linkField, gbc_linkField);
		linkField.setColumns(10);
		
		JButton submit = new JButton("Crear Usuario");
		GridBagConstraints gbc_submit = new GridBagConstraints();
		gbc_submit.anchor = GridBagConstraints.EAST;
		gbc_submit.insets = new Insets(0, 0, 0, 5);
		gbc_submit.gridx = 2;
		gbc_submit.gridy = 10;
		getContentPane().add(submit, gbc_submit);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_1 = new GridBagConstraints();
		gbc_rigidArea_1.gridx = 3;
		gbc_rigidArea_1.gridy = 10;
		getContentPane().add(rigidArea_1, gbc_rigidArea_1);

	}

}
