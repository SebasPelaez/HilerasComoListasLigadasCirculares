/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicauno.Visual.Paneles;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import practicauno.Lista.Hilera;
import practicauno.Visual.PanelLista;

/**
 *
 * @author Sebas
 */
public class PanelMetodoTres extends JPanel implements ActionListener{

    JButton btnEjecutar;
    JLabel lblNuevaCadena;
    JLabel lblPosicion;
    JLabel lblCantidad;
    JTextField txtNuevaCadena;
    JTextField txtPosicion;
    JTextField txtCantidad;
    private Hilera hilera;
    private PanelLista panelLista;
    
    public PanelMetodoTres(Hilera hilera,PanelLista panelLista){
        this.hilera=hilera;
        this.panelLista=panelLista;
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setSize(200, 200);
        setLayout(null);
        
        lblNuevaCadena = new JLabel("Nueva Cadena");
        lblNuevaCadena.setBounds(20, 20, 80, 20);
        add(lblNuevaCadena);
        
        lblPosicion = new JLabel("Posicion");
        lblPosicion.setBounds(20, 45, 80, 20);
        add(lblPosicion);
        
        lblCantidad = new JLabel("#Caracteres");
        lblCantidad.setBounds(20, 75, 80, 20);
        add(lblCantidad);
        
        txtNuevaCadena = new JTextField();
        txtNuevaCadena.setBounds(100, 20, 80, 20);
        add(txtNuevaCadena);
        
        txtPosicion = new JTextField();
        txtPosicion.setBounds(100, 45, 80, 20);
        add(txtPosicion);
        
        txtCantidad = new JTextField();
        txtCantidad.setBounds(100, 75, 80, 20);
        add(txtCantidad);
        
        btnEjecutar = new JButton("Ejecutar Metodo");
        btnEjecutar.setBounds(20, 105, 160, 30);
        btnEjecutar.addActionListener(this);
        add(btnEjecutar);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnEjecutar){
             if (hilera.isVoid()) {
                JOptionPane.showMessageDialog(null, "Debes crear una hilera");
            } else {
                Hilera b = new Hilera();
                int i = Integer.parseInt(txtPosicion.getText());
                int j = Integer.parseInt(txtCantidad.getText());
                b.construirEnLista(txtNuevaCadena.getText());
                hilera.replace(i, j, b);
                hilera.pintarLista(panelLista.getTxtCadena());
                hilera.guardarEnArchivo();
                hilera.generarImagen();
            }
        }
    }
    
}
