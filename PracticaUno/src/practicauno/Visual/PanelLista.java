/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicauno.Visual;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import practicauno.Lista.Hilera;
import practicauno.Nodo.Nodo;

/**
 *
 * @author jsebastian.pelaez
 */
public class PanelLista extends JPanel{
    
    private JTextArea txtCadena;
    private JScrollPane scrCadena;
    
    public PanelLista(){
        setBorder(BorderFactory.createTitledBorder("Representación de la Hilera"));
        setSize(350,385);
        setLayout(null);
        
        txtCadena = new JTextArea();
	scrCadena = new JScrollPane(txtCadena);
	scrCadena.setBounds(20, 20, 315, 355);
	txtCadena.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	txtCadena.setLineWrap(true);
	txtCadena.setToolTipText("Cadena en forma de Lista");
	txtCadena.setWrapStyleWord(true);
	add(scrCadena);      
        
        setVisible(true);
        
    }

    public JTextArea getTxtCadena() {
        return txtCadena;
    }

    public void setTxtCadena(JTextArea txtCadena) {
        this.txtCadena = txtCadena;
    }
   
}
