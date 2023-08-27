package Presentacion;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import Logica.DTAgrupa;
import Logica.DTPaquete;
import Logica.DTTipoPublicacion;
import Logica.ITipos;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Map;
import java.util.Set;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTable;

public class ConsultaPaquete extends JInternalFrame{

	private ITipos ctrlTipos;
	private JTextField textFieldValidez;
	private JTextField textFieldDescuento;
	private JComboBox<String> comboBoxPaquete;
	private JTable tableTipos;
	private JTextArea textAreaDescripcion;
	private JDateChooser dateChooserAlta;
	private boolean dataCargada;
	private JScrollPane scrollPane_1;
	
	public ConsultaPaquete(ITipos ctrlTipos) {
		this.ctrlTipos = ctrlTipos;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Consulta de Paquete de Tipos de Publicacion de Ofertas Laborales");
        dataCargada = false;
        setBounds(10, 40, 606, 571);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 257, 0, 0};
        gridBagLayout.rowHeights = new int[]{68, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);
        
        addInternalFrameListener(new InternalFrameAdapter() {
        	public void internalFrameClosing(InternalFrameEvent e) {
        		dataCargada = false;
        		System.out.println(dataCargada);	
        	}
        });
        
        Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
        GridBagConstraints gbc_rigidArea = new GridBagConstraints();
        gbc_rigidArea.insets = new Insets(0, 0, 5, 5);
        gbc_rigidArea.gridx = 0;
        gbc_rigidArea.gridy = 0;
        getContentPane().add(rigidArea, gbc_rigidArea);
        
        JLabel lblPaquete = new JLabel("Paquete:");
        GridBagConstraints gbc_lblPaquete = new GridBagConstraints();
        gbc_lblPaquete.anchor = GridBagConstraints.EAST;
        gbc_lblPaquete.insets = new Insets(0, 0, 5, 5);
        gbc_lblPaquete.gridx = 0;
        gbc_lblPaquete.gridy = 1;
        getContentPane().add(lblPaquete, gbc_lblPaquete);
        
        JPanel panel = new JPanel();
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.gridwidth = 2;
        gbc_panel.insets = new Insets(0, 0, 5, 5);
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridx = 1;
        gbc_panel.gridy = 1;
        getContentPane().add(panel, gbc_panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        
        comboBoxPaquete = new JComboBox<String>();
        panel.add(comboBoxPaquete);
        comboBoxPaquete.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		if (e.getStateChange() == ItemEvent.SELECTED && dataCargada == true) {
        			cargarInfoPaquete((String) comboBoxPaquete.getSelectedItem());
        		}
        	}
        });
        
        JLabel lblDescripcion = new JLabel("Descripcion:");
        GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
        gbc_lblDescripcion.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
        gbc_lblDescripcion.gridx = 0;
        gbc_lblDescripcion.gridy = 2;
        getContentPane().add(lblDescripcion, gbc_lblDescripcion);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setMinimumSize(new Dimension(2, 60));
        scrollPane.setPreferredSize(new Dimension(2, 60));
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.gridheight = 2;
        gbc_scrollPane.gridwidth = 2;
        gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 1;
        gbc_scrollPane.gridy = 2;
        getContentPane().add(scrollPane, gbc_scrollPane);
        
        textAreaDescripcion = new JTextArea();
        textAreaDescripcion.setEditable(false);
        scrollPane.setViewportView(textAreaDescripcion);
        
        JLabel lblValidez = new JLabel("Validez:");
        GridBagConstraints gbc_lblValidez = new GridBagConstraints();
        gbc_lblValidez.anchor = GridBagConstraints.EAST;
        gbc_lblValidez.insets = new Insets(0, 0, 5, 5);
        gbc_lblValidez.gridx = 0;
        gbc_lblValidez.gridy = 4;
        getContentPane().add(lblValidez, gbc_lblValidez);
        
        textFieldValidez = new JTextField();
        textFieldValidez.setEditable(false);
        GridBagConstraints gbc_textFieldValidez = new GridBagConstraints();
        gbc_textFieldValidez.gridwidth = 2;
        gbc_textFieldValidez.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldValidez.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldValidez.gridx = 1;
        gbc_textFieldValidez.gridy = 4;
        getContentPane().add(textFieldValidez, gbc_textFieldValidez);
        textFieldValidez.setColumns(10);
        
        JLabel lblDescuento = new JLabel("Descuento:");
        GridBagConstraints gbc_lblDescuento = new GridBagConstraints();
        gbc_lblDescuento.anchor = GridBagConstraints.EAST;
        gbc_lblDescuento.insets = new Insets(0, 0, 5, 5);
        gbc_lblDescuento.gridx = 0;
        gbc_lblDescuento.gridy = 5;
        getContentPane().add(lblDescuento, gbc_lblDescuento);
        
        textFieldDescuento = new JTextField();
        textFieldDescuento.setEditable(false);
        GridBagConstraints gbc_textFieldDescuento = new GridBagConstraints();
        gbc_textFieldDescuento.gridwidth = 2;
        gbc_textFieldDescuento.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldDescuento.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldDescuento.gridx = 1;
        gbc_textFieldDescuento.gridy = 5;
        getContentPane().add(textFieldDescuento, gbc_textFieldDescuento);
        textFieldDescuento.setColumns(10);
        
        JLabel lblFecha = new JLabel("Fecha Alta:");
        GridBagConstraints gbc_lblFecha = new GridBagConstraints();
        gbc_lblFecha.anchor = GridBagConstraints.EAST;
        gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
        gbc_lblFecha.gridx = 0;
        gbc_lblFecha.gridy = 6;
        getContentPane().add(lblFecha, gbc_lblFecha);
        
        dateChooserAlta = new JDateChooser();
        dateChooserAlta.setEnabled(false);
        GridBagConstraints gbc_dateChooserAlta = new GridBagConstraints();
        gbc_dateChooserAlta.gridwidth = 2;
        gbc_dateChooserAlta.insets = new Insets(0, 0, 5, 5);
        gbc_dateChooserAlta.fill = GridBagConstraints.BOTH;
        gbc_dateChooserAlta.gridx = 1;
        gbc_dateChooserAlta.gridy = 6;
        getContentPane().add(dateChooserAlta, gbc_dateChooserAlta);
        
        JLabel lblNewLabel = new JLabel("Tipos de Publicacion:");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 7;
        getContentPane().add(lblNewLabel, gbc_lblNewLabel);
        
        scrollPane_1 = new JScrollPane();
        scrollPane_1.setPreferredSize(new Dimension(2, 23));
        GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
        gbc_scrollPane_1.gridwidth = 2;
        gbc_scrollPane_1.gridheight = 4;
        gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
        gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
        gbc_scrollPane_1.gridx = 1;
        gbc_scrollPane_1.gridy = 7;
        getContentPane().add(scrollPane_1, gbc_scrollPane_1);
     
        
        Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
        GridBagConstraints gbc_rigidArea_1 = new GridBagConstraints();
        gbc_rigidArea_1.gridheight = 3;
        gbc_rigidArea_1.gridx = 3;
        gbc_rigidArea_1.gridy = 10;
        getContentPane().add(rigidArea_1, gbc_rigidArea_1);
        
	}
	
	public void cargarInfoPaquete(String nombreP) {
		Map<String, DTPaquete> dataPaquetes = ctrlTipos.obtenerDataPaquetes();
		if (!dataPaquetes.isEmpty()) {
			DTPaquete dataPaquete = dataPaquetes.get(nombreP);
			textFieldDescuento.setText(Double.toString(dataPaquete.getDescuento()));
			textFieldValidez.setText(Integer.toString(dataPaquete.getPeriodoValidez()));
			textAreaDescripcion.setText(dataPaquete.getDescripcion());
			dateChooserAlta.setDate(dataPaquete.getFecha());
			Object[][] tableData = new Object[dataPaquete.getTipos().keySet().size()][2];
			int index = 0;
			System.out.println(dataPaquete.getTipos().keySet().size());
			for (String key : dataPaquete.getTipos().keySet()) {
				DTAgrupa dataTipoKey = dataPaquete.getTipos().get(key);
				tableData[index][0] = dataTipoKey.getNombreTipo();
				System.out.println(dataTipoKey.getNombreTipo());
				tableData[index][1] = dataTipoKey.getCant();
			}
			String[] cabezales = {"Nombre", "Cantidad"}; 
	        tableTipos = new JTable(tableData, cabezales);
	        scrollPane_1.setViewportView(tableTipos);
		}
	}
	
    public void cargarPaquetes() {
    	comboBoxPaquete.removeAllItems();
    	comboBoxPaquete.addItem("Seleccionar");
    	Set<String> paquetesTipo = ctrlTipos.listarPaquetes();
    	for (String paquete : paquetesTipo) {
    		comboBoxPaquete.addItem(paquete);
    	}
    	dataCargada = true;
    }
}