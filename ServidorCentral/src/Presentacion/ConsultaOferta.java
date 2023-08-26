package Presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import Logica.DTHorario;
import Logica.DTOfertaLaboral;
import Logica.DTPostulacion;
import Logica.IUsuario;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

@SuppressWarnings("serial")
public class ConsultaOferta extends JInternalFrame{
	private JComboBox<String> cbEmpresa;
	private JComboBox<String> cbOferta;
	private IUsuario ctrlUsuario;
	private JTextField tfNombre;
	private JTextField tfCiudad;
	private JTextField tfDepartamento;
	private JTextField tfHorario;
	private JTextField tfRemuneracion;
	private JTextField tfFecha;
	private JTextField tfCosto;
	private JTable table;

	public ConsultaOferta(IUsuario ctrlUsuario, String empresa, String oferta) {
		this.ctrlUsuario = ctrlUsuario;
		
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
		setTitle("Consulta de oferta laboral");
		setBounds(0, 0, 420, 550);
		setMinimumSize(new Dimension(420, 550));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 0, 0, 25};
		gridBagLayout.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 25};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 13;
		getContentPane().add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setEnabled(false);
		table.setRowSelectionAllowed(false);
		DefaultTableModel dtm = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Fecha", "CV", "Descripción"
				}) ;
		table.setModel(dtm);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("            ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblEmpresa = new JLabel("Empresa");
		GridBagConstraints gbc_lblEmpresa = new GridBagConstraints();
		gbc_lblEmpresa.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmpresa.anchor = GridBagConstraints.EAST;
		gbc_lblEmpresa.gridx = 1;
		gbc_lblEmpresa.gridy = 1;
		getContentPane().add(lblEmpresa, gbc_lblEmpresa);
		
		cbOferta = new JComboBox<String>();
		cbEmpresa = new JComboBox<String>();

		if(!empresa.isEmpty() && !oferta.isEmpty()) {
			cbEmpresa.setEnabled(false);
			cbOferta.setEnabled(false);
			cbOferta.addItem(empresa);
			cbEmpresa.addItem(oferta);
			mostrarDatos(ctrlUsuario.seleccionarOfertaLaboral(oferta),dtm);
		}else {
			cbOferta.addItem("Seleccionar");
			cbEmpresa.addItem("Seleccionar");
			for(String nomEmpresa : ctrlUsuario.listarEmpresas()) {
				cbEmpresa.addItem(nomEmpresa);
			}
			cbEmpresa.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent itemEvent) {
					if(cbEmpresa.getSelectedIndex() != 0) {
						cbOferta.removeAllItems();
						cbOferta.addItem("Seleccionar");
						for(String oferta : ctrlUsuario.obtenerOfertasDeEmpresa(cbEmpresa.getSelectedItem().toString())) {
						  cbOferta.addItem(oferta);
						}
					}else {
						cbOferta.removeAllItems();
						cbOferta.addItem("Seleccionar");
					}
				}
			});
			cbOferta.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent itemEvent) {
					mostrarDatos(ctrlUsuario.seleccionarOfertaLaboral(cbOferta.getSelectedItem().toString()),dtm);
				}
			});
		}
		
		GridBagConstraints gbc_cbEmpresa = new GridBagConstraints();
		gbc_cbEmpresa.insets = new Insets(0, 0, 5, 0);
		gbc_cbEmpresa.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbEmpresa.gridx = 2;
		gbc_cbEmpresa.gridy = 1;
		getContentPane().add(cbEmpresa, gbc_cbEmpresa);
		
		JLabel lblNewLabel_1 = new JLabel("               ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 2;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblOferta = new JLabel("Oferta");
		GridBagConstraints gbc_lblOferta = new GridBagConstraints();
		gbc_lblOferta.anchor = GridBagConstraints.EAST;
		gbc_lblOferta.insets = new Insets(0, 0, 5, 5);
		gbc_lblOferta.gridx = 1;
		gbc_lblOferta.gridy = 3;
		getContentPane().add(lblOferta, gbc_lblOferta);
		
		GridBagConstraints gbc_cbOferta = new GridBagConstraints();
		gbc_cbOferta.insets = new Insets(0, 0, 5, 0);
		gbc_cbOferta.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbOferta.gridx = 2;
		gbc_cbOferta.gridy = 3;
		getContentPane().add(cbOferta, gbc_cbOferta);
		
		JLabel lblNewLabel_2 = new JLabel("             ");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 4;
		getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 5;
		getContentPane().add(lblNombre, gbc_lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setEditable(false);
		GridBagConstraints gbc_tfNombre = new GridBagConstraints();
		gbc_tfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_tfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNombre.gridx = 2;
		gbc_tfNombre.gridy = 5;
		getContentPane().add(tfNombre, gbc_tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		GridBagConstraints gbc_lblCiudad = new GridBagConstraints();
		gbc_lblCiudad.anchor = GridBagConstraints.EAST;
		gbc_lblCiudad.insets = new Insets(0, 0, 5, 5);
		gbc_lblCiudad.gridx = 1;
		gbc_lblCiudad.gridy = 6;
		getContentPane().add(lblCiudad, gbc_lblCiudad);
		
		tfCiudad = new JTextField();
		tfCiudad.setEditable(false);
		GridBagConstraints gbc_tfCiudad = new GridBagConstraints();
		gbc_tfCiudad.insets = new Insets(0, 0, 5, 0);
		gbc_tfCiudad.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCiudad.gridx = 2;
		gbc_tfCiudad.gridy = 6;
		getContentPane().add(tfCiudad, gbc_tfCiudad);
		tfCiudad.setColumns(10);
		
		JLabel lblDepartamento = new JLabel("Departamento");
		GridBagConstraints gbc_lblDepartamento = new GridBagConstraints();
		gbc_lblDepartamento.anchor = GridBagConstraints.EAST;
		gbc_lblDepartamento.insets = new Insets(0, 0, 5, 5);
		gbc_lblDepartamento.gridx = 1;
		gbc_lblDepartamento.gridy = 7;
		getContentPane().add(lblDepartamento, gbc_lblDepartamento);
		
		tfDepartamento = new JTextField();
		tfDepartamento.setEditable(false);
		GridBagConstraints gbc_tfDepartamento = new GridBagConstraints();
		gbc_tfDepartamento.insets = new Insets(0, 0, 5, 0);
		gbc_tfDepartamento.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfDepartamento.gridx = 2;
		gbc_tfDepartamento.gridy = 7;
		getContentPane().add(tfDepartamento, gbc_tfDepartamento);
		tfDepartamento.setColumns(10);
		
		JLabel lblHorario = new JLabel("Horario");
		GridBagConstraints gbc_lblHorario = new GridBagConstraints();
		gbc_lblHorario.anchor = GridBagConstraints.EAST;
		gbc_lblHorario.insets = new Insets(0, 0, 5, 5);
		gbc_lblHorario.gridx = 1;
		gbc_lblHorario.gridy = 8;
		getContentPane().add(lblHorario, gbc_lblHorario);
		
		tfHorario = new JTextField();
		tfHorario.setEditable(false);
		GridBagConstraints gbc_tfHorario = new GridBagConstraints();
		gbc_tfHorario.insets = new Insets(0, 0, 5, 0);
		gbc_tfHorario.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfHorario.gridx = 2;
		gbc_tfHorario.gridy = 8;
		getContentPane().add(tfHorario, gbc_tfHorario);
		tfHorario.setColumns(10);
		
		JLabel lblRemuneracion = new JLabel("Remuneración");
		GridBagConstraints gbc_lblRemuneracion = new GridBagConstraints();
		gbc_lblRemuneracion.anchor = GridBagConstraints.EAST;
		gbc_lblRemuneracion.insets = new Insets(0, 0, 5, 5);
		gbc_lblRemuneracion.gridx = 1;
		gbc_lblRemuneracion.gridy = 9;
		getContentPane().add(lblRemuneracion, gbc_lblRemuneracion);
		
		tfRemuneracion = new JTextField();
		tfRemuneracion.setEditable(false);
		GridBagConstraints gbc_tfRemuneracion = new GridBagConstraints();
		gbc_tfRemuneracion.insets = new Insets(0, 0, 5, 0);
		gbc_tfRemuneracion.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfRemuneracion.gridx = 2;
		gbc_tfRemuneracion.gridy = 9;
		getContentPane().add(tfRemuneracion, gbc_tfRemuneracion);
		tfRemuneracion.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha");
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.anchor = GridBagConstraints.EAST;
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.gridx = 1;
		gbc_lblFecha.gridy = 10;
		getContentPane().add(lblFecha, gbc_lblFecha);
		
		tfFecha = new JTextField();
		tfFecha.setEditable(false);
		GridBagConstraints gbc_tfFecha = new GridBagConstraints();
		gbc_tfFecha.insets = new Insets(0, 0, 5, 0);
		gbc_tfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfFecha.gridx = 2;
		gbc_tfFecha.gridy = 10;
		getContentPane().add(tfFecha, gbc_tfFecha);
		tfFecha.setColumns(10);
		
		JLabel lblCosto = new JLabel("Costo");
		GridBagConstraints gbc_lblCosto = new GridBagConstraints();
		gbc_lblCosto.anchor = GridBagConstraints.EAST;
		gbc_lblCosto.insets = new Insets(0, 0, 5, 5);
		gbc_lblCosto.gridx = 1;
		gbc_lblCosto.gridy = 11;
		getContentPane().add(lblCosto, gbc_lblCosto);
		
		tfCosto = new JTextField();
		tfCosto.setEditable(false);
		GridBagConstraints gbc_tfCosto = new GridBagConstraints();
		gbc_tfCosto.insets = new Insets(0, 0, 5, 0);
		gbc_tfCosto.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCosto.gridx = 2;
		gbc_tfCosto.gridy = 11;
		getContentPane().add(tfCosto, gbc_tfCosto);
		tfCosto.setColumns(10);
		
		JLabel lblPostulaciones = new JLabel("Postulaciones");
		GridBagConstraints gbc_lblPostulaciones = new GridBagConstraints();
		gbc_lblPostulaciones.insets = new Insets(0, 0, 5, 0);
		gbc_lblPostulaciones.gridx = 2;
		gbc_lblPostulaciones.gridy = 12;
		getContentPane().add(lblPostulaciones, gbc_lblPostulaciones);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
				setVisible(false);
			}
		});
		
		
		GridBagConstraints gbc_btnCerrar = new GridBagConstraints();
		gbc_btnCerrar.anchor = GridBagConstraints.EAST;
		gbc_btnCerrar.gridx = 2;
		gbc_btnCerrar.gridy = 15;
		getContentPane().add(btnCerrar, gbc_btnCerrar);
		
	}
	private void mostrarDatos(DTOfertaLaboral datos, DefaultTableModel dtm) {
		if(datos != null) {
			tfNombre.setText(datos.getNombre());
			tfCiudad.setText(datos.getCiudad());
			tfDepartamento.setText(datos.getDepartamento());
			tfHorario.setText(datos.getHorario().getInicio().toString() + " - " + datos.getHorario().getFin().toString()); //Puede estar vacio el horario?
			tfRemuneracion.setText(Integer.toString(datos.getRemuneracion()));
			tfFecha.setText(datos.getFecha().toString());
			tfCosto.setText(Double.toString(datos.getCosto()));
			Set<DTPostulacion> postulaciones = datos.getPostulaciones();
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");
			String[] data = new String[postulaciones.size() + 1];
			for(DTPostulacion post : postulaciones) {
				data[0] = formato.format(post.getFechaPostulacion());
				data[1] = post.getResumenCV();
				data[2] = post.getDescripcion();
				dtm.addRow(data);
				table.setModel(dtm);
			}
		}
	}
	private void limpiarCampos() {
		cbEmpresa.setSelectedIndex(0);
		cbOferta.setSelectedIndex(0);
		tfNombre.setText("");
		tfCiudad.setText("");
		tfDepartamento.setText("");
		tfHorario.setText("");
		tfRemuneracion.setText("");
		tfFecha.setText("");
		tfCosto.setText("");
		table.removeAll();
	};
}
