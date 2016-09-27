/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicauno.Visual;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import practicauno.Lista.Hilera;

/**
 *
 * @author jsebastian.pelaez
 */
public class VentanaPrincipal extends JFrame implements ActionListener, KeyListener {

    private JTextArea txtCadena;

    private JButton btnCrearHilera;
    private JButton btnMetodoUno;
    private JButton btnMetodoDos;
    private JButton btnMetodoTres;
    private JButton btnMetodoCuatro;
    private JButton btnMetodoCinco;
    private JButton btnMetodoSeis;
    private JButton btnMetodoSiete;
    private JButton btnMetodoOcho;

    private JScrollPane scrCadena;

    private PanelLista panelLista;

    private Hilera hilera;

    public VentanaPrincipal() {
        hilera = new Hilera();

        setTitle("Practica Uno Logica III");
        setSize(760, 450);
        getContentPane().setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        panelLista = new PanelLista();
        panelLista.setLocation(390, 18);
        getContentPane().add(panelLista);

        txtCadena = new JTextArea();
        scrCadena = new JScrollPane(txtCadena);
        scrCadena.setBounds(20, 20, 360, 75);
        txtCadena.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        txtCadena.setLineWrap(true);
        txtCadena.setToolTipText("Ingrese la cadena");
        txtCadena.setWrapStyleWord(true);
        txtCadena.addKeyListener(this);
        getContentPane().add(scrCadena);

        btnCrearHilera = new JButton("Crear Hilera");
        btnCrearHilera.setBounds(20, 110, 360, 30);
        getContentPane().add(btnCrearHilera);
        setVisible(true);

        btnMetodoUno = new JButton("Agregar una Hilera");
        btnMetodoUno.setBounds(20, 175, 170, 30);
        getContentPane().add(btnMetodoUno);

        btnMetodoDos = new JButton("Eliminar Hilera");
        btnMetodoDos.setBounds(210, 175, 170, 30);
        getContentPane().add(btnMetodoDos);

        btnMetodoTres = new JButton("Modificar Hilera");
        btnMetodoTres.setBounds(20, 240, 170, 30);
        getContentPane().add(btnMetodoTres);

        btnMetodoCuatro = new JButton("Invertir Hilera");
        btnMetodoCuatro.setBounds(210, 240, 170, 30);
        getContentPane().add(btnMetodoCuatro);
        setVisible(true);

        btnMetodoCinco = new JButton("Ordenar Hilera");
        btnMetodoCinco.setBounds(20, 305, 170, 30);
        getContentPane().add(btnMetodoCinco);

        btnMetodoSeis = new JButton("Determinar SubString");
        btnMetodoSeis.setBounds(210, 305, 170, 30);
        getContentPane().add(btnMetodoSeis);

        btnMetodoSiete = new JButton("Determinar Palindromo");
        btnMetodoSiete.setBounds(20, 370, 170, 30);
        getContentPane().add(btnMetodoSiete);

        btnMetodoOcho = new JButton("Determinar Anagrama");
        btnMetodoOcho.setBounds(210, 370, 170, 30);
        getContentPane().add(btnMetodoOcho);
        setVisible(true);

        btnCrearHilera.addActionListener(this);
        btnMetodoUno.addActionListener(this);
        btnMetodoDos.addActionListener(this);
        btnMetodoTres.addActionListener(this);
        btnMetodoCuatro.addActionListener(this);
        btnMetodoCinco.addActionListener(this);
        btnMetodoSeis.addActionListener(this);
        btnMetodoSiete.addActionListener(this);
        btnMetodoOcho.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCrearHilera) {
            if (txtCadena.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Ingrese una cadena");
            } else {
                hilera.construirEnLista(txtCadena.getText());
                hilera.pintarLista(panelLista.getTxtCadena());
                hilera.guardarEnArchivo();
                hilera.generarImagen();
            }
        }
        if (e.getSource() == btnMetodoUno) {
            if (hilera.isVoid()) {
                JOptionPane.showMessageDialog(null, "Debes crear una hilera");
            } else {
                Hilera b = new Hilera();
                b.construirEnLista(JOptionPane.showInputDialog(null, "Ingrese la nueva hilera"));
                int pos = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Desde que posición deseas insetar?"));
                hilera.insert(pos, b);
                hilera.pintarLista(panelLista.getTxtCadena());
            }
        }

        if (e.getSource() == btnMetodoDos) {
            if (hilera.isVoid()) {
                JOptionPane.showMessageDialog(null, "Debes crear una hilera");
            } else {
                if (JOptionPane.showConfirmDialog(null, "¿Deseas Borrar Toda la Hilera?", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    hilera.eliminarHilera(0, 0, true);
                } else {
                    int i = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Desde que posición deseas eliminar?"));
                    int j = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Cuantos caracteres deseas eliminar?"));
                    hilera.eliminarHilera(i, j, false);
                }
                hilera.pintarLista(panelLista.getTxtCadena());
            }
        }

        if (e.getSource() == btnMetodoTres) {
            if (hilera.isVoid()) {
                JOptionPane.showMessageDialog(null, "Debes crear una hilera");
            } else {
                Hilera b = new Hilera();
                int i = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Desde que posición deseas reemplazar?"));
                int j = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Cuantos caracteres deseas reemplazar?"));
                b.construirEnLista(JOptionPane.showInputDialog(null, "Ingrese la nueva por la cual desea reemplazar"));
                hilera.replace(i, j, b);
                hilera.pintarLista(panelLista.getTxtCadena());
            }
        }

        if (e.getSource() == btnMetodoCuatro) {
            if (hilera.isVoid()) {
                JOptionPane.showMessageDialog(null, "Debes crear una hilera");
            } else {
                hilera.invertirHilera();
                hilera.pintarLista(panelLista.getTxtCadena());
            }
        }

        if (e.getSource() == btnMetodoCinco) {
            if (hilera.isVoid()) {
                JOptionPane.showMessageDialog(null, "Debes crear una hilera");
            } else {
                hilera.ordenar();
                hilera.pintarLista(panelLista.getTxtCadena());
            }
        }

        if (e.getSource() == btnMetodoSeis) {
            if (hilera.isVoid()) {
                JOptionPane.showMessageDialog(null, "Debes crear una hilera");
            } else {
                Hilera b = new Hilera();
                b.construirEnLista(JOptionPane.showInputDialog(null, "Ingrese la hilera que desea verificar"));
                if (hilera.isSubString(b)) {
                    JOptionPane.showMessageDialog(null, "Es SubString");
                } else {
                    JOptionPane.showMessageDialog(null, "No Es SubString");
                }
            }
        }

        if (e.getSource() == btnMetodoSiete) {
            if (hilera.isVoid()) {
                JOptionPane.showMessageDialog(null, "Debes crear una hilera");
            } else if (hilera.esPalindrome()) {
                JOptionPane.showMessageDialog(null, "Es Palindrome");
            } else {
                JOptionPane.showMessageDialog(null, "No Es Palindrome");
            }

        }

        if (e.getSource() == btnMetodoOcho) {
            if (hilera.isVoid()) {
                JOptionPane.showMessageDialog(null, "Debes crear una hilera");
            } else {
                Hilera b = new Hilera();
                b.construirEnLista(JOptionPane.showInputDialog(null, "Ingrese la hilera que desea verificar"));
                if (hilera.isAnagrama(b)) {
                    JOptionPane.showMessageDialog(null, "Es un Anagrama");
                } else {
                    JOptionPane.showMessageDialog(null, "No Es Anagrama");
                }
            }

        }

    }

    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (!Character.isDigit(c) && !Character.isLetter(c)&& c!=KeyEvent.VK_SPACE) {
            e.consume();
        }
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

}
