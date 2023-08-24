package Presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import Logica.ITipos;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class AgregarTipoPublicacionAPaquete extends JInternalFrame {
	private ITipos ctrlTipos;

	public AgregarTipoPublicacionAPaquete(ITipos ctrlTipos) {
		this.ctrlTipos = ctrlTipos;
		setResizable(true);
		setVisible(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Agregar Tipo de Publicacion a Paquete");
        setBounds(10, 40, 578, 444);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);
        
        Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
        GridBagConstraints gbc_rigidArea = new GridBagConstraints();
        gbc_rigidArea.insets = new Insets(0, 0, 5, 5);
        gbc_rigidArea.gridx = 0;
        gbc_rigidArea.gridy = 0;
        getContentPane().add(rigidArea, gbc_rigidArea);
        
        JLabel lblSeleccionePaquete = new JLabel("Seleccione un paquete:");
        GridBagConstraints gbc_lblSeleccionePaquete = new GridBagConstraints();
        gbc_lblSeleccionePaquete.anchor = GridBagConstraints.EAST;
        gbc_lblSeleccionePaquete.insets = new Insets(0, 0, 5, 5);
        gbc_lblSeleccionePaquete.gridx = 1;
        gbc_lblSeleccionePaquete.gridy = 1;
        getContentPane().add(lblSeleccionePaquete, gbc_lblSeleccionePaquete);
        
        JPanel panel_1 = new JPanel();
        GridBagConstraints gbc_panel_1 = new GridBagConstraints();
        gbc_panel_1.insets = new Insets(0, 0, 5, 5);
        gbc_panel_1.fill = GridBagConstraints.BOTH;
        gbc_panel_1.gridx = 3;
        gbc_panel_1.gridy = 1;
        getContentPane().add(panel_1, gbc_panel_1);
        panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
        
        JComboBox comboBoxPaquete = new JComboBox();
        panel_1.add(comboBoxPaquete);
        
        JLabel lblSeleccioneTipo = new JLabel("Seleccione un tipo:");
        GridBagConstraints gbc_lblSeleccioneTipo = new GridBagConstraints();
        gbc_lblSeleccioneTipo.anchor = GridBagConstraints.EAST;
        gbc_lblSeleccioneTipo.insets = new Insets(0, 0, 5, 5);
        gbc_lblSeleccioneTipo.gridx = 1;
        gbc_lblSeleccioneTipo.gridy = 2;
        getContentPane().add(lblSeleccioneTipo, gbc_lblSeleccioneTipo);
        
        JPanel panel_2 = new JPanel();
        GridBagConstraints gbc_panel_2 = new GridBagConstraints();
        gbc_panel_2.insets = new Insets(0, 0, 5, 5);
        gbc_panel_2.fill = GridBagConstraints.BOTH;
        gbc_panel_2.gridx = 3;
        gbc_panel_2.gridy = 2;
        getContentPane().add(panel_2, gbc_panel_2);
        panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
        
        JComboBox comboBoxTipo = new JComboBox();
        panel_2.add(comboBoxTipo);
        
        JPanel panel = new JPanel();
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.anchor = GridBagConstraints.NORTH;
        gbc_panel.insets = new Insets(0, 0, 0, 5);
        gbc_panel.gridx = 3;
        gbc_panel.gridy = 3;
        getContentPane().add(panel, gbc_panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        
        JButton btnAgregar = new JButton("Agregar");
        panel.add(btnAgregar);
        
        Component horizontalStrut = Box.createHorizontalStrut(20);
        panel.add(horizontalStrut);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        panel.add(btnCancelar);
        
        Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
        GridBagConstraints gbc_rigidArea_1 = new GridBagConstraints();
        gbc_rigidArea_1.gridx = 4;
        gbc_rigidArea_1.gridy = 3;
        getContentPane().add(rigidArea_1, gbc_rigidArea_1);

	}

}
