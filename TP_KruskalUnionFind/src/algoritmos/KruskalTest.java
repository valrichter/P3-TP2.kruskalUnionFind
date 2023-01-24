package algoritmos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import grafo_MatrizAdyacencia.Grafo;

public class KruskalTest
{
	
	@Test (expected=IllegalArgumentException.class)
	public void testNull() 
	{
		Kruskal.arbolGeneradorMinimoBFS(null);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testVacio()
	{
		Grafo g = new Grafo(0);
		Kruskal.arbolGeneradorMinimoBFS(g);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testNoConexo()
	{
		Grafo g = null;
		Grafo h = Kruskal.arbolGeneradorMinimoBFS(g);
		assertEquals(g, h);
	}

	// Grafo usado en la diapo de kruskal (pag 15)
	@Test
	public void testAGMBFS()
	{
		Grafo g = inicializarEjemplo();
		Grafo gAGM = Kruskal.arbolGeneradorMinimoBFS(g);
		
		Grafo resultado = new Grafo(9);
		resultado.agregarArista(0, 1, 4.0);
		resultado.agregarArista(0, 7, 8.0);
		resultado.agregarArista(2, 3, 6.0);
		resultado.agregarArista(2, 5, 4.0);
		resultado.agregarArista(2, 8, 3.0);
		resultado.agregarArista(3, 4, 9.0);
		resultado.agregarArista(5, 6, 3.0);
		resultado.agregarArista(6, 7, 1.0);
		
		assertEquals(gAGM, resultado);
	}
	
	// Grafo usado en la diapo de kruskal (pag 15)
	@Test
	public void testAGMUF()
	{
		Grafo g = inicializarEjemplo();
		Grafo gAGM = Kruskal.arbolGeneradorMinimoUF(g);
		
		Grafo resultado = new Grafo(9);
		resultado.agregarArista(0, 1, 4.0);
		resultado.agregarArista(0, 7, 8.0);
		resultado.agregarArista(2, 3, 6.0);
		resultado.agregarArista(2, 5, 4.0);
		resultado.agregarArista(2, 8, 3.0);
		resultado.agregarArista(3, 4, 9.0);
		resultado.agregarArista(5, 6, 3.0);
		resultado.agregarArista(6, 7, 1.0);
		
		assertEquals(gAGM, resultado);	
	}

	private Grafo inicializarEjemplo() 
	{
		// Grafo de la diapo de AGM
		Grafo g = new Grafo(9);	
		
		g.agregarArista(0, 1, 4.0);
		g.agregarArista(0, 7, 8.0);
		g.agregarArista(1, 2, 8.0);
		g.agregarArista(1, 7, 12.0);
		g.agregarArista(2, 3, 6.0);
		g.agregarArista(2, 8, 3.0);
		g.agregarArista(2, 5, 4.0);
		g.agregarArista(3, 4, 9.0);
		g.agregarArista(3, 5, 13.0);
		g.agregarArista(4, 5, 10.0);
		g.agregarArista(5, 6, 3.0);
		g.agregarArista(6, 8, 5.0);
		g.agregarArista(6, 7, 1.0);
		g.agregarArista(7, 8, 6.0);
		
		return g;
	}
	
}
