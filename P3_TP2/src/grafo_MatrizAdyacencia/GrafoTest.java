package grafo_MatrizAdyacencia;

import static org.junit.Assert.*;
import org.junit.Test;

public class GrafoTest
{
	
	@Test(expected = IllegalArgumentException.class)
	public void verticeNegativoTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.vecinos(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void verticeExcedidoTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.vecinos(5);
	}

	@Test
	public void todosAisladosTest()
	{
		Grafo grafo = new Grafo(5);
		assertEquals(0, grafo.vecinos(2).size());
	}
	
	@Test
	public void verticeUniversalTest()
	{
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(1, 0, 0.2);
		grafo.agregarArista(1, 2, 0.7);
		grafo.agregarArista(1, 3, 0.9);
		
		int[] esperado = {0, 2, 3};
		Assert.iguales(esperado, grafo.vecinos(1));
	}
	
	@Test
	public void verticeNormalTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(1, 3, 0.6);
		grafo.agregarArista(2, 3, 0.3);
		grafo.agregarArista(2, 4, 0.2);
		
		int[] esperados = {1, 2};
		Assert.iguales(esperados, grafo.vecinos(3));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void primerVerticeNegativoTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(-1, 3, 0.2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void primerVerticeExcedidoTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(5, 2, 0.1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void segundoVerticeNegativoTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, -1, 0.5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void segundoVerticeExcedidoTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 5, 0.8);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void agregarLoopTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 2, 0.5);
	}

	@Test
	public void aristaExistenteTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 3, 0.2);
		assertTrue( grafo.existeArista(2, 3) );
	}

	@Test
	public void aristaOpuestaTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 3, 0.2);
		assertTrue( grafo.existeArista(3, 2) );
	}

	@Test
	public void aristaInexistenteTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 3, 0.2);
		assertFalse( grafo.existeArista(1, 4) );
	}

	@Test(expected = IllegalArgumentException.class)
	public void agregarAristaDosVecesTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 3, 0.5);
		grafo.agregarArista(2, 3, 0.5);
	}
	
	@Test
	public void eliminarAristaExistenteTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 4, 0.5);
		
		grafo.eliminarArista(2, 4);
		assertFalse( grafo.existeArista(2, 4) );
	}

	@Test(expected = IllegalArgumentException.class)
	public void eliminarAristaInexistenteTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.eliminarArista(2, 4);
	}
	
	@Test
    public void cambiarPesoDeAristaTest()
	{
        Grafo grafo = new Grafo(5);
        grafo.agregarArista(2, 4, 0.5);
        
        grafo.cambiarPesoArista(2, 4, 0.9);
        assertTrue(grafo.getPesoArista(2, 4).equals(0.9));
    }
	
	@Test(expected = IllegalArgumentException.class)
    public void aristaPesoIncorrectoTest()
	{
        Grafo grafo = new Grafo(5);
        grafo.agregarArista(2, 4, 0.5);
        grafo.agregarArista(4, 2, 0.5);
    }
	
	@Test
    public void aristaPesoCorrectoTest()
	{
        Grafo grafo = new Grafo(5);
        grafo.agregarArista(2, 4, 0.5);
        
        assertTrue(grafo.getPesoArista(2, 4).equals(0.5));
    }
	
}
