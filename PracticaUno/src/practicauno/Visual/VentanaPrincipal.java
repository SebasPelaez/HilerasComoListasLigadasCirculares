/**
 *
 * @author Juan Sebastian Pelaez, Juan Esteban Marin
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
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import practicauno.Lista.Hilera;
import practicauno.Visual.Paneles.PanelMetodoCinco;
import practicauno.Visual.Paneles.PanelMetodoCuatro;
import practicauno.Visual.Paneles.PanelMetodoDos;
import practicauno.Visual.Paneles.PanelMetodoOcho;
import practicauno.Visual.Paneles.PanelMetodoSeis;
import practicauno.Visual.Paneles.PanelMetodoSiete;
import practicauno.Visual.Paneles.PanelMetodoTres;
import practicauno.Visual.Paneles.PanelMetodoUno;

/**
 * Clase que Genera el frame donde se realiza la simulacion
 */
public class VentanaPrincipal extends JFrame implements ActionListener, KeyListener {

    private JTextArea txtCadena;

    private JButton btnCrearHilera;
    private JButton btnMetodoTres;
    private JButton btnMetodoCuatro;
    private JButton btnMetodoCinco;
    private JButton btnMetodoSeis;
    private JButton btnMetodoSiete;
    private JButton btnMetodoOcho;

    private JScrollPane scrCadena;

    private PanelLista panelLista;

    private Hilera hilera;

    JTabbedPane Pestanas;
    
    /**
     * Constructor
     */
    public VentanaPrincipal() {

        setTitle("Practica Uno Logica III");
        setSize(400, 185);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        panelLista = new PanelLista();
        panelLista.setLocation(390, 18);
        getContentPane().add(panelLista);

        Pestanas = new JTabbedPane();
        
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
        btnCrearHilera.addActionListener(this);
        
        setVisible(true);

    }

    /**
     * Interfaz de la accion del click
     * @param e Donde se clickeo
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCrearHilera) {
            if (txtCadena.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Ingrese una cadena");
            } else {
                hilera = new Hilera();
                hilera.construirEnLista(txtCadena.getText());
                hilera.pintarLista(panelLista.getTxtCadena());
                hilera.guardarEnArchivo();
                hilera.generarImagen();
                panelLista.pintarLista();
                crearTabs();
                setSize(900,450);
                setLocationRelativeTo(null);
            }
        }
    }
    /**
     * Interfaz de la accion del teclado
     * @param e Donde se tecleo
     */
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (!Character.isDigit(c) && !Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
            e.consume();
        }
    }
/**
     * Interfaz de la accion del teclado
     * @param e Donde se tecleo
     */
    public void keyPressed(KeyEvent e) {
    }
/**
     * Interfaz de la accion del teclado
     * @param e Donde se tecleo
     */
    public void keyReleased(KeyEvent e) {
    }

    /**
     *Metodo que se encarga de generar las tabs de las operaciones
     */
    public void crearTabs(){
        
        Pestanas.removeAll();
	Pestanas.setBounds(20, 145, 360, 200);
	Pestanas.addTab("Agregar Una Hilera",new PanelMetodoUno(hilera,panelLista));
        Pestanas.addTab("Eliminar", new PanelMetodoDos(hilera,panelLista));
        Pestanas.addTab("Reemplazar", new PanelMetodoTres(hilera,panelLista));
        Pestanas.addTab("Invertir", new PanelMetodoCuatro(hilera,panelLista));
        Pestanas.addTab("Ordenar", new PanelMetodoCinco(hilera,panelLista));
        Pestanas.addTab("¿Es SubString?", new PanelMetodoSeis(hilera,panelLista));
        Pestanas.addTab("¿Es Palindrome?", new PanelMetodoSiete(hilera,panelLista));
        Pestanas.addTab("¿Es Anagrama?", new PanelMetodoOcho(hilera,panelLista));
        getContentPane().add(Pestanas);
    }
    
}
