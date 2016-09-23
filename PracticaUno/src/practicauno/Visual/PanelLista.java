/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicauno.Visual;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import practicauno.Lista.Hilera;
import practicauno.Nodo.Nodo;

/**
 *
 * @author jsebastian.pelaez
 */
public class PanelLista extends JPanel{
    
    public PanelLista(){
        setBorder(BorderFactory.createTitledBorder("Representación de la Hilera"));
        setSize(350,500);
        setLayout(null);
        
              
        setVisible(true);
        
    }
    
    public void pintarLista(Hilera l){
        
    }
    
}
