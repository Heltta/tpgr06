package Presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.JList;

public class ConsultaUsuario extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaUsuario frame = new ConsultaUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConsultaUsuario() {
		setResizable(true);
		setTitle("Consulta de Usuario");
		setBounds(100, 100, 497, 431);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Nombre del Usuario:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 0;
		getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 5, 0);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 3;
		gbc_textArea.gridy = 2;
		getContentPane().add(textArea, gbc_textArea);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JTextArea textArea_1 = new JTextArea();
		GridBagConstraints gbc_textArea_1 = new GridBagConstraints();
		gbc_textArea_1.insets = new Insets(0, 0, 5, 0);
		gbc_textArea_1.fill = GridBagConstraints.BOTH;
		gbc_textArea_1.gridx = 3;
		gbc_textArea_1.gridy = 3;
		getContentPane().add(textArea_1, gbc_textArea_1);
		
		JLabel lblNewLabel_3 = new JLabel("Correo electronico:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JTextArea textArea_1_1 = new JTextArea();
		GridBagConstraints gbc_textArea_1_1 = new GridBagConstraints();
		gbc_textArea_1_1.insets = new Insets(0, 0, 5, 0);
		gbc_textArea_1_1.fill = GridBagConstraints.BOTH;
		gbc_textArea_1_1.gridx = 3;
		gbc_textArea_1_1.gridy = 4;
		getContentPane().add(textArea_1_1, gbc_textArea_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("Nacionalidad:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JTextArea textArea_1_2 = new JTextArea();
		GridBagConstraints gbc_textArea_1_2 = new GridBagConstraints();
		gbc_textArea_1_2.insets = new Insets(0, 0, 5, 0);
		gbc_textArea_1_2.fill = GridBagConstraints.BOTH;
		gbc_textArea_1_2.gridx = 3;
		gbc_textArea_1_2.gridy = 5;
		getContentPane().add(textArea_1_2, gbc_textArea_1_2);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha de nacimiento:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 6;
		getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JTextArea textArea_1_3 = new JTextArea();
		GridBagConstraints gbc_textArea_1_3 = new GridBagConstraints();
		gbc_textArea_1_3.insets = new Insets(0, 0, 5, 0);
		gbc_textArea_1_3.fill = GridBagConstraints.BOTH;
		gbc_textArea_1_3.gridx = 3;
		gbc_textArea_1_3.gridy = 6;
		getContentPane().add(textArea_1_3, gbc_textArea_1_3);
		
		JLabel lblNewLabel_6 = new JLabel("Nombre de la empresa:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 7;
		getContentPane().add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JTextArea textArea_1_4 = new JTextArea();
		GridBagConstraints gbc_textArea_1_4 = new GridBagConstraints();
		gbc_textArea_1_4.insets = new Insets(0, 0, 5, 0);
		gbc_textArea_1_4.fill = GridBagConstraints.BOTH;
		gbc_textArea_1_4.gridx = 3;
		gbc_textArea_1_4.gridy = 7;
		getContentPane().add(textArea_1_4, gbc_textArea_1_4);
		
		JLabel lblNewLabel_7 = new JLabel("Descripcion");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 8;
		getContentPane().add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		JTextArea textArea_1_5 = new JTextArea();
		GridBagConstraints gbc_textArea_1_5 = new GridBagConstraints();
		gbc_textArea_1_5.insets = new Insets(0, 0, 5, 0);
		gbc_textArea_1_5.fill = GridBagConstraints.BOTH;
		gbc_textArea_1_5.gridx = 3;
		gbc_textArea_1_5.gridy = 8;
		getContentPane().add(textArea_1_5, gbc_textArea_1_5);
		
		JLabel lblNewLabel_8 = new JLabel("Link:");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 9;
		getContentPane().add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		JTextArea textArea_1_6 = new JTextArea();
		GridBagConstraints gbc_textArea_1_6 = new GridBagConstraints();
		gbc_textArea_1_6.insets = new Insets(0, 0, 5, 0);
		gbc_textArea_1_6.fill = GridBagConstraints.BOTH;
		gbc_textArea_1_6.gridx = 3;
		gbc_textArea_1_6.gridy = 9;
		getContentPane().add(textArea_1_6, gbc_textArea_1_6);
		
		JLabel lblNewLabel_9 = new JLabel("Postulaciones");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 10;
		getContentPane().add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		JList list = new JList();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 3;
		gbc_list.gridy = 10;
		getContentPane().add(list, gbc_list);
		

	}
}
