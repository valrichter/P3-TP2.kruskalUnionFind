package algoritmos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import grafo_MatrizAdyacencia.Grafo;

public class BFS 
{
	private static ArrayList<Integer> ListaPendientes;
	private static boolean[] marcados;
	
	// Se fija si el grafo es conexo
	public static boolean esConexo(Grafo g) 
	{
		if (g == null)
			throw new IllegalArgumentException("Se intento consultar con un grafo null!" );
		
		if (g.getTamanio() == 0)
			return true;
		
		return alcanzables(g, 0).size() == g.getTamanio();
	}

	// Calcula los vertices alcanzables desde otro vertice
	public static Set<Integer> alcanzables(Grafo g, int origen)
	{
		Set<Integer> alcanzablesSet = new HashSet<Integer>();
		inicializar(g, origen);
		
		while (ListaPendientes.size() > 0)
		{
			int i =	ListaPendientes.get(0);
			marcados[i] = true;
			alcanzablesSet.add(i);

			agregarVecinosPendientes(g, i);
			ListaPendientes.remove(0);			
		}
		
		return alcanzablesSet;
	}

	// Inicializa las variables
	private static void inicializar(Grafo g, int origen) 
	{
		ListaPendientes = new ArrayList<Integer>();	
		ListaPendientes.add(origen);
		marcados = new boolean[g.getTamanio()];
	}

	// Agrega los vecinos que existen y que no estan en la lista de pendientes
	private static void agregarVecinosPendientes(Grafo g, int i) 
	{
		for (int vertice : g.vecinos(i))
			if (marcados[vertice] == false && ListaPendientes.contains(vertice) == false)
				ListaPendientes.add(vertice);		
	}
}
