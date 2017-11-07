package uniandes.cupi2.sintetizador.interfaz;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.sintetizador.mundo.Sintetizador;

public class PanelE extends JPanel implements ActionListener
{
	//Constantes
	
		public final static String BUSCAR_POR_NOMBRE= "Buscar por nombre";
		public final static String BUSCAR_MEJOR_CALIFICADO= "Buscar mejor calificado";
		public final static String CONTAR_EFECTOS_POR_GRUPOS= "Contar efectos por grupos";
		public final static String OPCION1= "Opción 1";
		public final static String OPCION2= "Opción 2";
	//Atributos
		private JButton butBuscarNom;
		private JButton butBuscarMej;
		private JButton butContar;
		private JButton butOpcion1;
		private JButton butOpcion2;
		/**
	     * Ventana principal del sintetizador.
	     */
		private InterfazSintetizador principal;
		
	
	//Constructor
	public PanelE(InterfazSintetizador ventana)
	{
		principal= ventana; 
		
		//		Asociación	de	un	distribuidor	gráfico	y	de	las	dimensiones
		setLayout(new GridLayout(1, 5));
		
		
		//		Definición	del	borde
		TitledBorder	border	=	BorderFactory.createTitledBorder("Opciones");	
		setBorder(border);
		
		//Botón "Buscar por nombre"
		butBuscarNom= new JButton ("Buscar por nombre");
		butBuscarNom.setActionCommand(BUSCAR_POR_NOMBRE);
		butBuscarNom.addActionListener(this);
		
		//"Botón "Buscar mejor calificado"
		butBuscarMej= new JButton ("Buscar mejor calificado");
		butBuscarMej.setActionCommand(BUSCAR_MEJOR_CALIFICADO);
		butBuscarMej.addActionListener(this);
		
		//Botón "Contar efectos por grupo"
		butContar= new JButton ("Contar efectos por grupo");
		butContar.setActionCommand(CONTAR_EFECTOS_POR_GRUPOS);
		butContar.addActionListener(this);
		
		//Botón "Opción 1"
		butOpcion1= new JButton("Opción 1");
		butOpcion1.setActionCommand(OPCION1);
		butOpcion1.addActionListener(this);
		
		//Botón "Opción 2"
		butOpcion2= new JButton ("Opción 2");
		butOpcion2.setActionCommand(OPCION2);
		butOpcion2.addActionListener(this);
		
		//		Adicionar	todos	los	componentes	gráficos	al	panel	add(	new	JLabel(	""	)	);
		
		add(new JLabel("")); 
		add(butBuscarNom);
		add(butBuscarMej);
		add(butContar);
		add(butOpcion1);
		add(butOpcion2);
	}
	//Método de atención a eventos
	/**
     * Respuesta a los eventos en los elementos de la interfaz.
     * @param e Evento generado. e != null.
     */
	public void actionPerformed(ActionEvent evento)
	{
		String comando= evento.getActionCommand();
		
		if(comando.equals(BUSCAR_POR_NOMBRE))
		{
			principal.buscarPorNombre();
		}
		if(comando.equals(BUSCAR_MEJOR_CALIFICADO))
		{
			principal.buscarMejorCalificado();
		}
		
		if(comando.equals(CONTAR_EFECTOS_POR_GRUPOS))
		{
			principal.contarEfectosPorGrupo();
		}
		
		if(comando.equals(OPCION1))
		{
			principal.metodo1();
		}
		

		if(comando.equals(OPCION2))
		{
			principal.metodo2();
		}
		
	}
	

}
