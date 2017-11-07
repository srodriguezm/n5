package uniandes.cupi2.sintetizador.interfaz;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.sun.prism.Image;
import uniandes.cupi2.sintetizador.mundo.Sintetizador;

/**
 * Panel con los banners.
 */
public class PanelA extends JPanel
{
	
	//Atributos
	/**
	 * Etiqueta con el banner. <br>
	 */
	private JLabel labImagen1;
	/**
     * Ventana principal del sintetizador.
     */
	private InterfazSintetizador principal;

	
	//Constructor
	/**
     * Construye el panel con la etiqueta.
     * * @param ventana Instancia principal de la aplicación.
     */
	public PanelA(InterfazSintetizador ventana)
	{
		principal=ventana;
		setLayout( new BorderLayout( ) );	
		ImageIcon icono = new ImageIcon( new ImageIcon( "./data/banners/sintetizador-0.png" ).getImage().getScaledInstance(800, 150,0));
		labImagen1= new JLabel("");
		labImagen1.setIcon(icono);
		add(labImagen1, BorderLayout.NORTH);

	}
	/**
	 * 
	 * @param pRuta ruta de la imagen que 
	 */
	public void actualizarPanelA(String pRuta)
	{
		ImageIcon icono1 = new ImageIcon( new ImageIcon( pRuta ).getImage().getScaledInstance(800, 150,0));
		labImagen1.setIcon(icono1);
		
	}
	
	
}


