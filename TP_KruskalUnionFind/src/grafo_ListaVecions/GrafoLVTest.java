package grafo_ListaVecions;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

public class GrafoLVTest 
{
	@Test (expected=IllegalArgumentException.class)
	public void agregarAristaVerticeIgual()
	{
		GrafoLV g = new GrafoLV(5);
		g.agregarArista(0, 0);
	}

	@Test (expected=IllegalArgumentException.class)
	public void agregarAristaFueraDeRangoSuperior()
	{
		GrafoLV g = new GrafoLV(5);
		g.agregarArista(5, 0);
	}

	@Test (expected=IllegalArgumentException.class)
	public void agregarAristaFueraDeRangoSuperiorJ()
	{
		GrafoLV g = new GrafoLV(5);
		g.agregarArista(0, 5);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void agregarAristaFueraDeRangoInferior()
	{
		GrafoLV g = new GrafoLV(5);
		g.agregarArista(-1, 0);
	}

	@Test (expected=IllegalArgumentException.class)
	public void agregarAristaFueraDeRangoInferiorJ()
	{
		GrafoLV g = new GrafoLV(5);
		g.agregarArista(0, -1);
	}

	@Test
	public void agregarAristaTest() 
	{
		GrafoLV g = new GrafoLV(5); // Setup
		g.agregarArista(0, 1); // Exercise
		assertTrue(g.existeArista(0, 1)); // Verify
	}
	
	@Test
	public void agregarAristaSimetriaTest() 
	{
		GrafoLV g = new GrafoLV(5); // Setup
		g.agregarArista(0, 1); // Exercise
		assertTrue(g.existeArista(1, 0)); // Verify
	}
	
	@Test
	public void eliminarAristaTest() 
	{
		GrafoLV g = new GrafoLV(5);
		g.agregarArista(0, 1);
		g.eliminarArista(0, 1);
		assertFalse(g.existeArista(0, 1));
	}
	
	@Test
	public void gradoTest()
	{
		GrafoLV g = grafoEjemplo();
		assertEquals(2, g.grado(1));
	}

	@Test
	public void gradoCeroTest()
	{
		GrafoLV g = grafoEjemplo();
		assertEquals(0, g.grado(4));
	}
	
	@Test
	public void vecinoTest()
	{
		GrafoLV g = new GrafoLV(4);
		g.agregarArista(0, 1);
		g.agregarArista(0, 2);
		g.agregarArista(0, 3);
		
		HashSet<Integer> vecinos = (HashSet<Integer>)g.vecinos(0);
		
		assertEquals(3, vecinos.size());
		assertTrue(g.vecinos(0).contains(1));
		assertTrue(g.vecinos(0).contains(2));
		assertTrue(g.vecinos(0).contains(3));
	}
	
	private GrafoLV grafoEjemplo()
	{
		GrafoLV g = new GrafoLV(5);
		g.agregarArista(0, 1);
		g.agregarArista(1, 2);
		g.agregarArista(2, 3);
		g.agregarArista(3, 0);
		return g;
	}
	

}
