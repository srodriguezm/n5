package uniandes.cupi2.sintetizador.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelC extends JPanel implements ActionListener
{
	//Constantes
	
	public final static String SONIDO1="sonido1";
	public final static String SONIDO2="sonido2";
	public final static String SONIDO3="sonido3";
	public final static String SONIDO4="sonido4";
	public final static String SONIDO5="sonido5";
	public final static String SONIDO6="sonido6";
	public final static String SONIDO7="sonido7";
	public final static String SONIDO8="sonido8";
	
	//Atributos
	
	private JButton butDo4;
	private JButton butRe4;
	private JButton butMi4;
	private JButton butFa4;
	private JButton butSol4;
	private JButton butLa4;
	private JButton butSi4;
	private JButton butDo5;
	/**
     * Ventana principal del sintetizador.
     */
	private InterfazSintetizador principal;
	
	
	
	
	//Constructor
	public PanelC(InterfazSintetizador ventana)
	{
		principal=ventana; 
		setLayout(new GridLayout(1, 8));
		
		ImageIcon icono1 = new ImageIcon( "./data/teclas/do4.png" );
		ImageIcon icono2 = new ImageIcon( "./data/teclas/re4.png" );
		ImageIcon icono3 = new ImageIcon( "./data/teclas/mi4.png" );
		ImageIcon icono4 = new ImageIcon( "./data/teclas/fa4.png" );
		ImageIcon icono5 = new ImageIcon( "./data/teclas/sol4.png" );
		ImageIcon icono6 = new ImageIcon( "./data/teclas/la4.png" );
		ImageIcon icono7 = new ImageIcon( "./data/teclas/si4.png" );
		ImageIcon icono8 = new ImageIcon( "./data/teclas/do5.png" );
		
		
		 butDo4= new JButton ("");
		 butRe4= new JButton ("");
		 butMi4= new JButton ("");
		 butFa4= new JButton ("");
		 butSol4= new JButton ("");
		 butLa4= new JButton ("");
		 butSi4= new JButton ("");
		 butDo5= new JButton ("");
		
		butDo4.setIcon(icono1);
		butRe4.setIcon(icono2);
		butMi4.setIcon(icono3);
		butFa4.setIcon(icono4);
		butSol4.setIcon(icono5);
		butLa4.setIcon(icono6);
		butSi4.setIcon(icono7);
		butDo5.setIcon(icono8);
		
		add(butDo4,BorderLayout.CENTER);
		add(butRe4,BorderLayout.CENTER);
		add(butMi4,BorderLayout.CENTER);
		add(butFa4,BorderLayout.CENTER);
		add(butSol4,BorderLayout.CENTER);
		add(butLa4,BorderLayout.CENTER);
		add(butSi4,BorderLayout.CENTER);
		add(butDo5,BorderLayout.CENTER);
		
		butDo4.setActionCommand(SONIDO1);
		butDo4.addActionListener(this);
		
		butRe4.setActionCommand(SONIDO2);
		butRe4.addActionListener(this);
		
		butMi4.setActionCommand(SONIDO3);
		butMi4.addActionListener(this);
		
		butFa4.setActionCommand(SONIDO4);
		butFa4.addActionListener(this);
		
		butSol4.setActionCommand(SONIDO5);
		butSol4.addActionListener(this);

		butLa4.setActionCommand(SONIDO6);
		butLa4.addActionListener(this);
		
		butSi4.setActionCommand(SONIDO7);
		butSi4.addActionListener(this);
		
		butDo5.setActionCommand(SONIDO8);
		butDo5.addActionListener(this);
		
		
	}
	/**
     * Respuesta a los eventos en los elementos de la interfaz.
     * @param e Evento generado. e != null.
     */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		String comando= e.getActionCommand();
		if(comando.equals(SONIDO1))
		{
			principal.reproducir("do4");
		}
		if(comando.equals(SONIDO2))
		{
			principal.reproducir("re4");
		}
		if(comando.equals(SONIDO3))
		{
			principal.reproducir("mi4");
		}
		if(comando.equals(SONIDO4))
		{
			principal.reproducir("fa4");
		}
		if(comando.equals(SONIDO5))
		{
			principal.reproducir("sol4");
		}
		if(comando.equals(SONIDO6))
		{
			principal.reproducir("la4");
		}
		if(comando.equals(SONIDO7))
		{
			principal.reproducir("si4");
		}
		if(comando.equals(SONIDO8))
		{
			principal.reproducir("do5");
		}
	
	}
	




}
