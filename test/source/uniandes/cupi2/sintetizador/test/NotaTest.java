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
import uniandes.cupi2.sintetizador.mundo.Nota;

/**
 * Clase usada para verificar que los m�todos de la clase Nota est�n correctamente implementados.
 */
public class NotaTest
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Nota en la que se realizar�n las pruebas.
     */
    private Nota nota;

    // -----------------------------------------------------------------
    // Escenarios
    // -----------------------------------------------------------------
    /**
     * Crea una instancia de la clase Nota. Este m�todo se ejecuta antes de cada m�todo de prueba.
     */
    @Before
    public void setupEscenario1( )
    {
            nota = new Nota( "do4", 48, "./data/teclas/do4.png" );
    }

    // -----------------------------------------------------------------
    // M�todos de prueba
    // -----------------------------------------------------------------
    /**
     * <b>Prueba 1</b> : verifica el m�todo constructor de la clase Nota.<br>
     * <b>M�todos a probar: </b><br>
     * Nota<br>
     * darNombre<br>
     * darValor<br>
     * darRutaImagen<br>
     * 1. Se crea el efecto correctamente.
     */
    @Test
    public void testEfecto( )
    {
        // Caso de prueba 1
        assertEquals( "El nombre asignado a la nota corresponde.", "do4", nota.darNombre() );
        assertEquals( "La ruta de la imagen asignada a la no corresponde.", "./data/teclas/do4.png", nota.darRutaImagen( ) );
        assertTrue( "El valor asignado a la nota no corresponde.", 48 == nota.darValor( ) );
        
    }     

}
