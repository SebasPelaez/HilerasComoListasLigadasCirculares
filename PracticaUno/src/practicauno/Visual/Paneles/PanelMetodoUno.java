/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicauno.Visual.Paneles;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import practicauno.Lista.Hilera;
import practicauno.Visual.PanelLista;

/**
 *
 * @author Sebas
 */
public class PanelMetodoUno extends JPanel implements ActionListener, KeyListener {

    JButton btnEjecutar;
    JLabel lblNuevaCadena;
    JLabel lblPosicion;
    JTextArea txtNuevaCadena;
    JScrollPane scrCadena;
    JTextField txtPosicion;
    private Hilera hilera;
    private PanelLista panelLista;

    public PanelMetodoUno(Hilera hilera, PanelLista panelLista) {
        this.hilera = hilera;
        this.panelLista = panelLista;
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setSize(200, 200);
        setLayout(null);

        lblNuevaCadena = new JLabel("Nueva Cadena");
        lblNuevaCadena.setBounds(20, 20, 80, 20);
        add(lblNuevaCadena);
        
        txtNuevaCadena = new JTextArea();
        scrCadena = new JScrollPane(txtNuevaCadena);
        scrCadena.setBounds(100, 20, 220, 50);
        txtNuevaCadena.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        txtNuevaCadena.setLineWrap(true);
        txtNuevaCadena.setToolTipText("Ingrese la cadena");
        txtNuevaCadena.setWrapStyleWord(true);
        txtNuevaCadena.addKeyListener(this);
        add(scrCadena);

        lblPosicion = new JLabel("Posicion");
        lblPosicion.setBounds(20, 80, 80, 20);
        add(lblPosicion);        

        txtPosicion = new JTextField();
        txtPosicion.setBounds(100, 80, 80, 20);
        txtPosicion.addKeyListener(this);
        add(txtPosicion);

        btnEjecutar = new JButton("Ejecutar Metodo");
        btnEjecutar.setBounds(20, 110, 160, 30);
        btnEjecutar.addActionListener(this);
        add(btnEjecutar);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnEjecutar) {
            if (hilera.isVoid()) {
                JOptionPane.showMessageDialog(null, "Debes crear una hilera");
            } else {
                Hilera b = new Hilera();
                b.construirEnLista(txtNuevaCadena.getText());
                int pos = Integer.parseInt(txtPosicion.getText());
                String a = hilera.insert(pos, b);
                if(a != "0"){
                    JOptionPane.showMessageDialog(null,a);
                }
                hilera.pintarLista(panelLista.getTxtCadena());
                hilera.guardarEnArchivo();
                hilera.generarImagen();
            }
        }
    }

    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (e.getSource() == txtNuevaCadena) {
            if (!Character.isDigit(c) && !Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
                e.consume();
            }
        }
        if(e.getSource()==txtPosicion){
            if (!Character.isDigit(c)) {
                e.consume();
            }
        }

    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

}
