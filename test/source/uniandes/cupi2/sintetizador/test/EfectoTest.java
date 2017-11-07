/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad  de  los Andes   (Bogot� - Colombia)
 * Departamento de  Ingenier�a  de  Sistemas    y   Computaci�n
 * Licenciado   bajo    el  esquema Academic Free License versi�n 2.1
 *      
 * Proyecto Cupi2   (http://cupi2.uniandes.edu.co)
 * Ejercicio: n5_sintetizador
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.sintetizador.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import uniandes.cupi2.sintetizador.mundo.Efecto;

/**
 * Clase usada para verificar que los m�todos de la clase Efecto est�n correctamente implementados.
 */
public class EfectoTest
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Efecto en el que se realizar�n las pruebas.
     */
    private Efecto efecto;

    // -----------------------------------------------------------------
    // Escenarios
    // -----------------------------------------------------------------
    /**
     * Crea una instancia de la clase Efecto. Este m�todo se ejecuta antes de cada m�todo de prueba.
     */
    @Before
    public void setupEscenario1( )
    {
            efecto = new Efecto( "Act�stico", "Sonido tradicional de piano", 5, 0, "" );
    }

    // -----------------------------------------------------------------
    // M�todos de prueba
    // -----------------------------------------------------------------
    /**
     * <b>Prueba 1</b> : verifica el m�todo constructor de la clase Efecto.<br>
     * <b>M�todos a probar: </b><br>
     * Efecto<br>
     * darNombre<br>
     * darDescripcion<br>
     * darCalificacion<br>
     * darIndice<br>
     * esFavorito<br>
     * esFantasia<br>
     * esDivertido<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se crea el efecto correctamente.
     */
    @Test
    public void testEfecto( )
    {
        // Caso de prueba 1
        assertEquals( "El nombre asignado al efecto no corresponde.", "Act�stico", efecto.darNombre() );
        assertEquals( "La descripci�n asignada al efecto no corresponde.", "Sonido tradicional de piano", efecto.darDescripcion( ) );
        assertTrue( "La calificaci�n asignada al efecto no corresponde.", 5 == efecto.darCalificacion( ) );
        assertTrue( "El �ndice asignado al efecto no corresponde.", 0 == efecto.darIndice( ) );
        assertTrue("La categor�a favorito no deber�a estar seleccionada.", !efecto.esFavorito( ));
        assertTrue("La categor�a fantas�a no deber�a estar seleccionada.", !efecto.esFantasia( ));
        assertTrue("La categor�a divertido no deber�a estar seleccionada.", !efecto.esDivertido( ));

    }
    
    /**
     * <b>Prueba 2</b> : verifica el m�todo guardar<br>
     * <b>M�todos a probar: </b><br>
     * guardar<br>
     * esFavorito<br>
     * esFantasia<br>
     * esDivertido<br>
     * 1. Se guarda el efecto como favorito. <br>
     * 2. Se guardan todas las categor�as menos favorito.
     */
    @Test
    public void testGuardar()
    {
        //Caso de prueba 1
        efecto.guardar( true, false, false );
        assertTrue("La categor�a favorito deber�a estar seleccionada.", efecto.esFavorito( ));
        assertTrue("La categor�a fantas�a no deber�a estar seleccionada.", !efecto.esFantasia( ));
        assertTrue("La categor�a divertido no deber�a estar seleccionada.", !efecto.esDivertido( ));
        
        //Caso de prueba 2
        efecto.guardar( false, true, true );
        assertTrue("La categor�a favorito no deber�a estar seleccionada.", !efecto.esFavorito( ));
        assertTrue("La categor�a fantas�a deber�a estar seleccionada.", efecto.esFantasia( ));
        assertTrue("La categor�a divertido deber�a estar seleccionada.", efecto.esDivertido( ));
    }
    

}
