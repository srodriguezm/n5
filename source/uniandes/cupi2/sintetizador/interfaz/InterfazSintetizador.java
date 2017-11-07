package uniandes.cupi2.sintetizador.interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.cupi2.sintetizador.mundo.Efecto;
import uniandes.cupi2.sintetizador.mundo.Sintetizador;

/**
 * Clase principal de la interfaz
 */
public class InterfazSintetizador extends JFrame 
{
	/**
     * Asociación a la clase principal del mundo.
     */
	private Sintetizador mundo;
	

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------
	/** 
	 * Panel que contiene los banners.
	 */
	private PanelA panelA;
	/**
	 * Panel con los botones para pasar al siguiente y anterior efecto, ubicado en la parte oeste de la interfaz.
	 */
	private PanelB panelB;
	/**
	 * Panel de botones con las teclas que permiten reproducir el efecto, ubicado en el centro de la interfaz.
	 */
	private PanelC panelC;
	/**
	 * Panel de botones, campo de texto y etiquetas, contiene la descripción, calificación y grupos a los que pertenece el efecto, ubicado en la parte este de la interfaz.
	 */
	private PanelD panelD;
	/**
	 * Panel de botones con las opciones, ubicado en la parte sur de la interfaz.
	 */
	private PanelE panelE;

	
	 // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye la ventana principal de la aplicación. <br>
     * <b>post:</b> Todos los componentes de la interfaz fueron inicializados.
     */
	
	public InterfazSintetizador()
	{
		
		try
		{
			mundo= new Sintetizador();
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		setTitle("Sintetizador");
		setSize(800,600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		panelA= new PanelA(this);
		add(panelA, BorderLayout.NORTH);
		
		panelB= new PanelB(this);
		add(panelB, BorderLayout.WEST);
		
		panelC= new PanelC(this);
		add(panelC, BorderLayout.CENTER);
		
		panelD= new PanelD(this);
		add(panelD, BorderLayout.EAST);
		
		panelE= new PanelE(this);
		add(panelE, BorderLayout.SOUTH);
		
	
	}
	
	
	// -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------
	/**
     * Ejecuta la aplicación.
     * @param pArgs Parámetros de la ejecución. No son necesarios.
     */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		InterfazSintetizador ventana= new InterfazSintetizador();
		ventana.setVisible(true);
	}

	// -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
	/**
	 * Pasa al siguiente efecto al oprimir el botón de abajo.<br>
	 *  <b>post: </b> Se pasa al siguiente efecto.
	 */
	public void darSiguienteEfecto() 
	{
		// TODO Auto-generated method stub
		String ruta="";
		try 
		{
			mundo.darSiguienteEfecto();	
			Efecto ef=mundo.darEfectoActual();
			ruta=mundo.darEfectoActual().darRutaImagen();
			panelA.actualizarPanelA(ruta);
			panelD.actualizarPanelD(ef.darDescripcion(), String.valueOf(ef.darCalificacion()), ef.esFantasia(), ef.esFavorito(), ef.esDivertido());
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog( this, e.getMessage( ), "Siguiente efecto", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	/**
	 * Pasa al anterior efecto al oprimir el botón de arriba.<br>
	 *  <b>post: </b> Se pasa al anterior efecto.
	 */
	public void darAnteriorEfecto()
	{
		String ruta="";
		try
		{
			mundo.darAnteriorEfecto();
			Efecto ef=mundo.darEfectoActual();
			ruta=mundo.darEfectoActual().darRutaImagen();
			panelA.actualizarPanelA(ruta);
			panelD.actualizarPanelD(ef.darDescripcion(), String.valueOf(ef.darCalificacion()), ef.esFantasia(), ef.esFavorito(), ef.esDivertido());
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog( this, e.getMessage( ), "Anterior efecto", JOptionPane.INFORMATION_MESSAGE );	
		}
	}

	/**
	 * Reproduce la nota al oprimir una tecla. <br>
	 * <b> post: </b> Se reprodujo la nota.
	 * @param nota la nota que se desea reproducir. nota!=null && nota!="".
	 */
	public void reproducir(String nota)
	{
		// TODO Auto-generated method stub
		try
		{
			mundo.reproducir(nota);
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog( this, e.getMessage());
		}
		
	}

	/**
	 * Muestra la descripción del efecto actual. <br>
	 * @return la descripción del efecto actual. 
	 */
	public String darDescripcion() 
	{
		// TODO Auto-generated method stub
		return mundo.darEfectoActual().darDescripcion();
	}

	/**
	 * Muestra la calificación del efecto actual.
	 * @return la calificación del efecto actual.
	 */
	public String darCalificacion()
	{
		// TODO Auto-generated method stub
		String calificacion=" "+mundo.darEfectoActual().darCalificacion();
		return calificacion;
	}

	/**
	 * Busca el efecto por el nombre ingresado por el usuario. <br>
	 * * <b> post: </b> Se busca el efecto por el nombre ingresado y se muestra en la interfaz, con su respectivo banner, descripción, calificación y grupos a los que pertenece.
	 */
	public void buscarPorNombre() 
	{
		String strEstado = JOptionPane.showInputDialog( this, "Introduzca el nombre del efecto" );
		try 
		{
			mundo.buscarPorNombre(strEstado);
			Efecto actual=mundo.darEfectoActual();
			panelA.actualizarPanelA(actual.darRutaImagen());
			panelD.actualizarPanelD(actual.darDescripcion(), String.valueOf(actual.darCalificacion()), actual.esFantasia(), actual.esFavorito(), actual.esDivertido());
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, e.getMessage(), "Buscar por nombre", JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * Busca el efecto mejor calificado al oprimir el botón.
	 * <b> post: </b> busca el efecto mejor calificado y lo muestra en la interfaz con su banner, descripción, calificación y grupos a los que pertenece.
	 */
	public void buscarMejorCalificado() 
	{
		// TODO Auto-generated method stub
		try 
		{
		mundo.buscarMejorCalificado();
		Efecto temporal=mundo.darEfectoActual();
		panelA.actualizarPanelA(temporal.darRutaImagen());
		String cal=String.valueOf(temporal.darCalificacion());
		panelD.actualizarPanelD(temporal.darDescripcion(), cal, temporal.esFantasia(), temporal.esFavorito(), temporal.esDivertido());
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this, e.getMessage(), "Buscar Mejor Calificación", JOptionPane.ERROR_MESSAGE);

		}
		
	}

	public void contarEfectosPorGrupo()
	{
		// TODO Auto-generated method stub
		try
		{
			String strEstado = JOptionPane.showInputDialog( this, "Introduzca el grupo" );
			JOptionPane.showMessageDialog(this,	"La cantidad de efectos encontrados del grupo "+strEstado+" es "+mundo.contarEfectosPorGrupo(strEstado), "Contar efectos por grupo",JOptionPane.INFORMATION_MESSAGE);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, e.getMessage(), "Contar efectos por grupo", JOptionPane.ERROR_MESSAGE);
		}
	
	}

	/**
	 * Método 1
	 */
	public void metodo1()
	{
		// TODO Auto-generated method stub
		
		JOptionPane.showMessageDialog(this, mundo.metodo1(), "Opción 1", JOptionPane.INFORMATION_MESSAGE);

	}

	/**
	 * Método 2
	 */
	public void metodo2() 
	{
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, mundo.metodo2(), "Opción 2", JOptionPane.INFORMATION_MESSAGE);

	}

	/**
	 * Guarda los grupos a los que pertenece el efecto, puede ser favorito, fantasía y divertido. <br>
	 * @param selected grupo al que puede pertencer el efecto.
	 * @param selected2 grupo al que puede pertencer el efecto.
	 * @param selected3 grupo al que puede pertencer el efecto.
	 */
	public void guardarEfecto(boolean selected, boolean selected2, boolean selected3) 
	{
		// TODO Auto-generated method stub
		mundo.guardarEfecto(selected, selected2, selected3);
	}


	



}
