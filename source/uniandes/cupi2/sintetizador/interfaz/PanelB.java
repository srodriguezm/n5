package uniandes.cupi2.sintetizador.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelB extends JPanel implements ActionListener
{
	//Constantes
	public final static String ARRIBA="Arriba";
	public final static String ABAJO="Abajo";
	
	//Atributos
	private JButton butArriba;
	private JButton butAbajo;
	/**
     * Ventana principal del sintetizador.
     */
	private InterfazSintetizador principal;
	
	
	//Constructor
	
	public PanelB(InterfazSintetizador ventana)
	{
		principal=ventana;
		setLayout(new GridLayout(2,1));
		 butArriba= new JButton ("");
		 butAbajo= new JButton ("");
		
		ImageIcon icono1= new ImageIcon( "./data/botones/anterior.png" );
		ImageIcon icono2= new ImageIcon( "./data/botones/siguiente.png");
		
		butArriba.setIcon(icono1);
		butAbajo.setIcon(icono2);
		butAbajo.setActionCommand(ABAJO);
		butArriba.setActionCommand(ARRIBA);
		butArriba.addActionListener(this);
		butAbajo.addActionListener(this);
		
		add(butArriba,BorderLayout.NORTH);
		add(butAbajo, BorderLayout.SOUTH );
		
	}

	/**
     * Respuesta a los eventos en los elementos de la interfaz.
     * @param e Evento generado. e != null.
     */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals(ABAJO))
		{
			principal.darSiguienteEfecto();
		}
		else if(e.getActionCommand().equals(ARRIBA))
		{
			principal.darAnteriorEfecto();
		}
		
	}
	
}
