package uniandes.cupi2.sintetizador.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelD extends JPanel implements ActionListener
{
	//Constantes
	private final static String GUARDAR="Guardar";
	//Atributos
	/**
     * Ventana principal del sintetizador.
     */
	private InterfazSintetizador principal;
	private JLabel labDescripcion;
	private JLabel labCalificacion;
	private JTextField txtCal;
	private JTextField txtCampo;
	private JCheckBox cbFavorito;
	private JCheckBox cbFantasia;
	private JCheckBox cbDivertido;
	private JButton btnGuardar;
	//	Definición	del	borde
	
	
	//Constructor
	public PanelD(InterfazSintetizador ventana)
	{
		principal=ventana;
		setLayout(new GridLayout(2,1));
		//Paneles temporales
		JPanel arriba=new JPanel();
		JPanel grupos=new JPanel();
		//Definición del borde
		TitledBorder	border	=	BorderFactory.createTitledBorder("Grupos a los que pertenece");	
		grupos.setBorder(border);
		arriba.setLayout(new GridLayout(4,1));
		grupos.setLayout(new GridLayout(4,1));
		
		//Inicialización de atributos
		
		labDescripcion= new JLabel("Descripción: " );
		 labCalificacion= new JLabel("Calificación: ");
		 cbFavorito= new JCheckBox("Favoritos");
		 cbFantasia= new JCheckBox("Fantasía");
		 cbDivertido= new JCheckBox("Divertidos");
		 txtCampo= new JTextField(principal.darDescripcion());
		 btnGuardar=new JButton("Guardar");
		 btnGuardar.setActionCommand(GUARDAR);
		 btnGuardar.addActionListener(this);
		 
		 txtCal= new JTextField(principal.darCalificacion());

		
		 txtCal.setEditable(false);
		 txtCampo.setEditable(false);
		
		 txtCampo.setEditable(false);
		 
		 arriba.add(labDescripcion);
		 arriba.add(txtCampo);
		 arriba.add(labCalificacion);
		 arriba.add(txtCal);
		 grupos.add(cbFavorito);
		 grupos.add(cbFantasia);
		 grupos.add(cbDivertido);
		 grupos.add(btnGuardar);
		 add(arriba);
		 add(grupos);
		
	}
	
	public void actualizarPanelD(String descripcion, String calif,boolean fant, boolean fav, boolean div)
	{
		txtCal.setText(calif);
		txtCampo.setText(descripcion);
		cbFantasia.setSelected(fant);
		cbFavorito.setSelected(fav);
		cbDivertido.setSelected(div);
	}
	
	/**
     * Respuesta a los eventos en los elementos de la interfaz.
     * @param e Evento generado. e != null.
     */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals(GUARDAR))
		{
			principal.guardarEfecto(cbFavorito.isSelected(),cbFantasia.isSelected(),cbDivertido.isSelected());;
		}
	}

}
