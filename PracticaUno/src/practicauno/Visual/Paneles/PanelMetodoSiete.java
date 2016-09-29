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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import practicauno.Lista.Hilera;
import practicauno.Visual.PanelLista;

/**
 *
 * @author Sebas
 */
public class PanelMetodoSiete extends JPanel implements ActionListener{

    JButton btnEjecutar;
    private Hilera hilera;
    private PanelLista panelLista;
    
    public PanelMetodoSiete(Hilera hilera,PanelLista panelLista){
        this.hilera=hilera;
        this.panelLista=panelLista;
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setSize(200, 200);
        setLayout(null);
              
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
            } else if (hilera.esPalindrome()) {
                JOptionPane.showMessageDialog(null, "Es Palindrome");
            } else {
                JOptionPane.showMessageDialog(null, "No Es Palindrome");
            }
        }
    }
    
}
