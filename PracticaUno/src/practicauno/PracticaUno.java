/**
 *
 * @author Juan Sebastian Pelaez, Juan Esteban Marin
 */
package practicauno;

import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.skin.NebulaSkin;
import org.jvnet.substance.skin.SubstanceNebulaLookAndFeel;
import practicauno.Visual.VentanaPrincipal;


public class PracticaUno {

    /**
     * 
     * @param args parametros Java
     * @throws IOException Por si no resulta la configuracion del Look and Feel
     */
    public static void main(String[] args) throws IOException {
        JFrame.setDefaultLookAndFeelDecorated(true);
		SubstanceLookAndFeel.setSkin(new NebulaSkin());
		SubstanceLookAndFeel.setSkin("org.pushingpixels.substance.api.skin.SubstanceNebulaLookAndFeel");
		try {			
			UIManager.setLookAndFeel(new SubstanceNebulaLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
				e.printStackTrace();
		}	
        new VentanaPrincipal();
    }    
}
