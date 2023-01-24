package grafo_ListaVecions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BFSLV 
{
	
	private static ArrayList<Integer> L;
	private static boolean[] marcados;
	
	
	// Verifica si el grafo es conexo
	public static boolean esConexo(GrafoLV g) 
	{
		if (g==null)
			throw new IllegalArgumentException("Se intento consultar con un grafo null!" );
		
		if (g.vertices() == 0)
			return true;
		
		return alcanzables(g, 0).size() == g.vertices();
	}

	
	// Returna los vertices alcanzables desde un vertice origen
	public static Set<Integer> alcanzables(GrafoLV g, int origen)
	{
		Set<Integer> ret = new HashSet<Integer>();
		inicializar(g, origen);
		
		while (L.size() >0)
		{
			int i =	L.get(0);
			marcados[i] = true;
			ret.add(i);

			agregarVecinosPendientes(g, i);
			L.remove(0);			
		}
		
		return ret;
	}
	
	
	// Inicializa las variables
	private static void inicializar(GrafoLV g, int origen) 
	{
		L = new ArrayList<Integer>();	
		L.add(origen);
		marcados = new boolean[g.vertices()];
	}


	// Agrega los vecinos pendientes
	private static void agregarVecinosPendientes(GrafoLV g, int i) 
	{
		for (int vertice : g.vecinos(i))
			if (marcados[vertice] == false && L.contains(vertice) == false)
				L.add(vertice);
	}
	
}
