/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicauno.Visual;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import practicauno.Lista.Hilera;

/**
 *
 * @author jsebastian.pelaez
 */
public class VentanaPrincipal extends JFrame implements ActionListener{
    
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
    
    public VentanaPrincipal(){
        hilera = new Hilera();
        
        setTitle("Practica Uno Logica III");
	setSize(730,625);
	getContentPane().setLayout(null);
	setResizable(false);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
        
        panelLista = new PanelLista();
        panelLista.setLocation(360,18);
        getContentPane().add(panelLista);
        
        txtCadena = new JTextArea();
	scrCadena = new JScrollPane(txtCadena);
	scrCadena.setBounds(20, 20, 300, 75);
	txtCadena.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	txtCadena.setLineWrap(true);
	txtCadena.setToolTipText("Ingrese la cadena");
	txtCadena.setWrapStyleWord(true);
	getContentPane().add(scrCadena);
        
        btnCrearHilera = new JButton("Crear Hilera");
        btnCrearHilera.setBounds(20, 110, 300, 45);
        getContentPane().add(btnCrearHilera);
        setVisible(true);
        
        btnMetodoUno = new JButton("Metodo Uno");
        btnMetodoUno.setBounds(20, 175, 140, 45);
        getContentPane().add(btnMetodoUno);
        
        btnMetodoDos = new JButton("Metodo Dos");
        btnMetodoDos.setBounds(180, 175, 140, 45);
        getContentPane().add(btnMetodoDos);   
        
        btnMetodoTres = new JButton("Metodo Tres");
        btnMetodoTres.setBounds(20, 240, 140, 45);
        getContentPane().add(btnMetodoTres);        
        
        btnMetodoCuatro = new JButton("Metodo Cuatro");
        btnMetodoCuatro.setBounds(180, 240, 140, 45);
        getContentPane().add(btnMetodoCuatro);
        setVisible(true);
        
        btnMetodoCinco = new JButton("Metodo Cinco");
        btnMetodoCinco.setBounds(20, 305, 140, 45);
        getContentPane().add(btnMetodoCinco);
        
        btnMetodoSeis = new JButton("Metodo Seis");
        btnMetodoSeis.setBounds(180, 305, 140, 45);
        getContentPane().add(btnMetodoSeis);   
        
        btnMetodoSiete = new JButton("Metodo Siete");
        btnMetodoSiete.setBounds(20, 370, 140, 45);
        getContentPane().add(btnMetodoSiete);        
        
        btnMetodoOcho = new JButton("Metodo Ocho");
        btnMetodoOcho.setBounds(180, 370, 140, 45);
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
        if(e.getSource()==btnMetodoUno){
            
        }
    }
    
}
