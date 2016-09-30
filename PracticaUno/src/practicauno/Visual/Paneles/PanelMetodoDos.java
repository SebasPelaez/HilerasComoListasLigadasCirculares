/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicauno.Visual.Paneles;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
public class PanelMetodoDos extends JPanel implements ActionListener, KeyListener {

    JButton btnEjecutar;
    JLabel lblCantidad;
    JLabel lblPosicion;
    JTextField txtCantidad;
    JTextField txtPosicion;
    private Hilera hilera;
    private PanelLista panelLista;

    public PanelMetodoDos(Hilera hilera, PanelLista panelLista) {
        this.hilera = hilera;
        this.panelLista = panelLista;
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setSize(200, 200);
        setLayout(null);

        lblPosicion = new JLabel("Posicion Inicial");
        lblPosicion.setBounds(20, 20, 80, 20);
        add(lblPosicion);

        lblCantidad = new JLabel("Cantidad Caracteres");
        lblCantidad.setBounds(20, 45, 80, 20);
        add(lblCantidad);

        txtPosicion = new JTextField();
        txtPosicion.setBounds(100, 20, 80, 20);
        txtPosicion.addKeyListener(this);
        add(txtPosicion);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(100, 45, 80, 20);
        txtCantidad.addKeyListener(this);
        add(txtCantidad);

        btnEjecutar = new JButton("Ejecutar Metodo");
        btnEjecutar.setBounds(20, 75, 160, 30);
        btnEjecutar.addActionListener(this);
        add(btnEjecutar);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnEjecutar) {
            if (hilera.isVoid()) {
                JOptionPane.showMessageDialog(null, "Debes crear una hilera");
            } else {
                if (JOptionPane.showConfirmDialog(null, "¿Deseas Borrar Toda la Hilera?", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    hilera.eliminarHilera(0, 0, true);
                } else {
                    int i = Integer.parseInt(txtPosicion.getText());
                    int j = Integer.parseInt(txtCantidad.getText());
                    hilera.eliminarHilera(i, j, false);
                }
                hilera.pintarLista(panelLista.getTxtCadena());
                hilera.guardarEnArchivo();
                hilera.generarImagen();
            }
        }
    }

    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (!Character.isDigit(c)) {
            e.consume();
        }
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

}
