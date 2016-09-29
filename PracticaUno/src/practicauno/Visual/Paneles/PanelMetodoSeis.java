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
public class PanelMetodoSeis extends JPanel implements ActionListener{

    JButton btnEjecutar;
    JLabel lblNuevaCadena;
    JTextField txtNuevaCadena;
    private Hilera hilera;
    private PanelLista panelLista;
    
    public PanelMetodoSeis(Hilera hilera,PanelLista panelLista){
        this.hilera=hilera;
        this.panelLista=panelLista;
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setSize(200, 200);
        setLayout(null);
        
        lblNuevaCadena = new JLabel("Cadena");
        lblNuevaCadena.setBounds(20, 20, 80, 20);
        add(lblNuevaCadena);
        
        txtNuevaCadena = new JTextField();
        txtNuevaCadena.setBounds(100, 20, 80, 20);
        add(txtNuevaCadena);
        
        btnEjecutar = new JButton("Ejecutar Metodo");
        btnEjecutar.setBounds(20, 75, 160, 30);
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
                b.construirEnLista(txtNuevaCadena.getText());
                if (hilera.isSubString(b)) {
                    JOptionPane.showMessageDialog(null, "Es SubString");
                } else {
                    JOptionPane.showMessageDialog(null, "No Es SubString");
                }
            }
        }
    }
    
}
