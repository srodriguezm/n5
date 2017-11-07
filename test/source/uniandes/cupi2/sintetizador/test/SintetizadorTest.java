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
import uniandes.cupi2.sintetizador.mundo.*;

/**
 * Clase usada para verificar que los m�todos de la clase Sintetizador est�n correctamente implementados.
 */
public class SintetizadorTest
{
    /**
     * Sintetizador en el que se realizar�n las pruebas.
     */
    private Sintetizador sintetizador;

    // -----------------------------------------------------------------
    // Escenarios
    // -----------------------------------------------------------------
    /**
     * Crea una instancia de la clase Sintetizador. Este m�todo se ejecuta antes de cada m�todo de prueba.
     */
    @Before
    public void setupEscenario1( )
    {
        try
        {
            sintetizador = new Sintetizador( );
        }
        catch( Exception e )
        {
            fail( "Error al crear el sintetizador" );
        }
    }

    // -----------------------------------------------------------------
    // M�todos de prueba
    // -----------------------------------------------------------------
    
    /**
     * <b>Prueba 1</b> : verifica el m�todo constructor de la clase Sintetizador.<br>
     * <b>M�todos a probar: </b><br>
     * Sintetizador<br>
     * cargarEfectos<br>
     * darEfectoActual<br>
     * siguienteEfecto<br>
     * anteriorEfecto<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se crea el Sintetizador correctamente.
     */
    @Test
    public void testSintetizador( )
    {
        // Caso de prueba 1
        assertEquals( "No se encuentra en el primer efecto.", sintetizador.darEfectoActual( ).darIndice( ), 0 );
        for(int i = 0; i < sintetizador.darEfectos().length; i++)
        {
            assertNotNull( "El efecto deber�a existir", sintetizador.darEfectoActual( ) );
            try
            {
                sintetizador.darSiguienteEfecto( );
            }
            catch(Exception e)
            {
                fail("No debe generar excepci�n al navegar los efectos hacia adelante.");
            }
        }
        
        try
        {
            sintetizador.darSiguienteEfecto( );
            fail("Debe generar excepci�n en el �ltimo efecto.");
        }
        catch(Exception e)
        {
            //Esta excepci�n debe ocurrir.
        }
        
        
        for(int i = 0; i < sintetizador.darEfectos( ).length; i++)
        {
            assertNotNull( "El efecto deber�a existir", sintetizador.darEfectoActual( ) );
            try
            {
                sintetizador.darAnteriorEfecto( );
            }
            catch(Exception e)
            {
                fail("No debe generar excepci�n al navegar los efectos hacia atr�s.");
            }
        }
        
        try
        {
            sintetizador.darAnteriorEfecto( );
            fail("Debe generar excepci�n en el primer efecto.");
        }
        catch(Exception e)
        {
            //Esta excepci�n debe ocurrir.
        }
    }
    
    /**
     * <b>Prueba 2</b> : verifica el m�todo reproducir.<br>
     * <b>M�todos a probar: </b><br>
     * darNota<br>
     * reproducir<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se reproducen correctamente cada una de las notas.
     */
    @Test
    public void testReproducir( )
    {
        try
        {
            Nota[] notas = sintetizador.darNotas( );
            for(Nota nota : notas)
            {
                sintetizador.reproducir( nota.darNombre( ) );
            }
        }
        catch(Exception e)
        {
            fail("No debe generar excepci�n al reproducir ninguna de las notas.");
        }
    }
    
    /**
     * <b>Prueba 3</b> : verifica el m�todo guardarEfecto.<br>
     * <b>M�todos a probar: </b><br>
     * guardarEfecto<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se guarda el efecto como favorito. <br>
     * 2. Se guardan todas las categor�as menos favorito.
     */
    @Test
    public void testGuardarEfecto()
    {
        //Caso de prueba 1
        sintetizador.guardarEfecto( true, false, false );
        assertTrue("La categor�a favorito deber�a estar seleccionada.", sintetizador.darEfectoActual( ).esFavorito( ));
        assertTrue("La categor�a fantas�a no deber�a estar seleccionada.", !sintetizador.darEfectoActual( ).esFantasia( ));
        assertTrue("La categor�a divertido no deber�a estar seleccionada.", !sintetizador.darEfectoActual( ).esDivertido( ));
        
        //Caso de prueba 2
        sintetizador.guardarEfecto( false, true, true );
        assertTrue("La categor�a favorito no deber�a estar seleccionada.", !sintetizador.darEfectoActual( ).esFavorito( ));
        assertTrue("La categor�a fantas�a deber�a estar seleccionada.", sintetizador.darEfectoActual( ).esFantasia( ));
        assertTrue("La categor�a divertido deber�a estar seleccionada.", sintetizador.darEfectoActual( ).esDivertido( ));
    }
    
    /**
     * <b>Prueba 4</b> : verifica el m�todo buscarPorNombre.<br>
     * <b>M�todos a probar: </b><br>
     * buscarPorNombre<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se encuentran todos los efectos por su nombre. <br>
     * 2. No se encuentra un efecto inexistente en el sintetizador.
     */
    @Test
    public void testBuscarPorNombre()
    {
        //Caso de prueba 1
        for(int i = 0; i < sintetizador.darEfectos( ).length; i++)
        {
            String nombre = sintetizador.darEfectoActual( ).darNombre( );
            try
            {
                sintetizador.buscarPorNombre( nombre );
            }
            catch(Exception e)
            {
                fail("Debe encontrar el efecto.");
            }
            try
            {
                sintetizador.darSiguienteEfecto( );
            }
            catch(Exception e)
            {
                //Se genera al llegar al �ltimo efecto
            }
        }
        
        //Caso de prueba 2
        try
        {
            sintetizador.buscarPorNombre( "Un efecto inexistente" );
            fail("No debe encontrar el efecto.");
        }
        catch(Exception e)
        {
            //Debe generar excepci�n
        }
    }
    
    /**
     * <b>Prueba 5</b> : verifica el m�todo buscarMejorCalificado.<br>
     * <b>M�todos a probar: </b><br>
     * buscarMejorCalificado<br>
     * <b>Casos de prueba:</b><br>
     * 1. Encuentra el mejor calificado correcto. <br>
     */
    @Test
    public void testBuscarMejorCalificado()
    {
        sintetizador.buscarMejorCalificado( );
        double mejorCalificacion = sintetizador.darEfectoActual( ).darCalificacion( );
        for( int i = 0; i < sintetizador.darEfectos( ).length; i++ )
        {
            double calificacion = sintetizador.darEfectoActual( ).darCalificacion( );
            
            if(mejorCalificacion < calificacion)
            {
                fail("El mejor calificado encontrado no posee la mejor calificaci�n.");
            }
            try
            {
                sintetizador.darSiguienteEfecto( );
            }
            catch(Exception e)
            {
                //Se genera al llegar al �ltimo efecto
            }
        }
    }
}
