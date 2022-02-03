package grafo_ListaVecions;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

public class BFSTest 
{
	
	@Test (expected=IllegalArgumentException.class)
	public void testNull() 
	{
		BFSLV.esConexo(null);
	}
	
	@Test
	public void testVacio()
	{
		GrafoLV g = new GrafoLV(0);
		assertTrue(BFSLV.esConexo(g));
	}
	
	@Test
	public void testNoConexo()
	{
		GrafoLV g = inicializarEjemplo();
		assertFalse(BFSLV.esConexo(g));
	}

	@Test
	public void testConexo()
	{
		GrafoLV g = inicializarEjemplo();
		g.agregarArista(3, 4);
		assertTrue(BFSLV.esConexo(g));
	}
	
	@Test
	public void alcanzablesTest()
	{
		GrafoLV g = inicializarEjemplo();
		Set<Integer> alcanzables = BFSLV.alcanzables(g, 0);
		
		int[] esperado = {0, 1, 2, 3};
		Assert.iguales(esperado, alcanzables);
	}
	
	@Test
	public void alcanzablesTodosTest()
	{
		GrafoLV g = inicializarEjemplo();
		g.agregarArista(3, 4);
		
		Set<Integer> alcanzables = BFSLV.alcanzables(g, 0);
		
		int[] esperado = {0, 1, 2, 3, 4};
		Assert.iguales(esperado, alcanzables);
	}
	
	private GrafoLV inicializarEjemplo() 
	{
		GrafoLV g = new GrafoLV(5);
		g.agregarArista(0, 1);
		g.agregarArista(0, 2);
		g.agregarArista(2, 3);
		return g;
	}
	
}
