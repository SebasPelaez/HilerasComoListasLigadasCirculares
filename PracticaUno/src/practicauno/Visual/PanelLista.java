/**
 * @author Juan Sebastian Pelaez, Juan Esteban Marin
 */
package practicauno.Visual;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
        
/**
 * Panel que despliega la imagen con la lista
 */
public class PanelLista extends JPanel implements ActionListener {

    private JTextArea txtCadena;
    private JScrollPane scrCadena;
    private JScrollPane scrImagen;
    private JPanel panelImagen;
    private JPanel panelCadena;
    private JButton btnVisualizar;
    private JLabel lblImagen;
    private Icon icnImagen;

    public PanelLista() {
        setBorder(BorderFactory.createTitledBorder("Representación de la Hilera"));
        setSize(490, 385);
        setLayout(null);

        panelImagen = new JPanel();
        panelImagen.setBounds(10, 20, 470, 170);
        panelImagen.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelImagen.setLayout(null);
        add(panelImagen);

        panelCadena = new JPanel();
        panelCadena.setBounds(10, 230, 470, 140);
        panelCadena.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelCadena.setLayout(null);
        add(panelCadena);

        btnVisualizar = new JButton("Visualizar Lista");
        btnVisualizar.setBounds(150, 195, 180, 30);
        btnVisualizar.addActionListener(this);

        txtCadena = new JTextArea();
        scrCadena = new JScrollPane(txtCadena);
        scrCadena.setBounds(10, 10, 440, 120);
        txtCadena.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        txtCadena.setLineWrap(true);
        txtCadena.setToolTipText("Cadena en forma de Lista");
        txtCadena.setWrapStyleWord(true);
        panelCadena.add(scrCadena);

        scrImagen = new JScrollPane();
        scrImagen.setBounds(10, 10, 450, 150);
        panelImagen.add(scrImagen);
        
        setVisible(true);

    }

    public JTextArea getTxtCadena() {
        return txtCadena;
    }

    public void setTxtCadena(JTextArea txtCadena) {
        this.txtCadena = txtCadena;
    }

    public void pintarLista() {
        repaint();
        add(btnVisualizar);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVisualizar) {
            panelImagen.remove(scrImagen);
            repaint();
            lblImagen = new JLabel();
            icnImagen = new ImageIcon("src//grafico.jpg");
            lblImagen.setIcon(icnImagen);
            panelImagen.add(scrImagen);
            scrImagen.setViewportView(lblImagen);
            repaint();
        }
    }

}
