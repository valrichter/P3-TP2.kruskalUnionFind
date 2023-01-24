package algoritmos;

import java.util.ArrayList;
import java.util.Set;

import grafo_MatrizAdyacencia.Arista;
import grafo_MatrizAdyacencia.Grafo;

import java.util.Collections;

public class Kruskal
{
	
	// Genera un AGM con BFS
	public static Grafo arbolGeneradorMinimoBFS(Grafo grafo)
	{	
		boolean esValido = esValido(grafo);
		
	    Grafo arbolMinimo = new Grafo(grafo.getTamanio());
	    ArrayList<Arista> aristasGrafo = grafo.getTodasAristas();
	    ArrayList<Arista> aristasArbolMinimo = new ArrayList<Arista>();
	    
	    if(esValido)
	    {
	    	int i = 0;
		    while ( i < aristasGrafo.size() )
		    { 
		        Arista aristaActual = aristasGrafo.get(i);
		        Set<Integer> alcanzables = BFS.alcanzables(arbolMinimo, aristaActual.getVerticeI());
		        
		        // Si la aristaActual NO esta contenia dentro de aristasArbolMinimo
		        // Y si su vertice J NO esta contenido en los alcazables de su vertice I, es decir, no forma ciclo
		        if ( !aristasArbolMinimo.contains(aristaActual) && !alcanzables.contains(aristaActual.getVerticeJ()) )
		        {
		        	aristasArbolMinimo.add(aristaActual);
		        	arbolMinimo.agregarArista( aristaActual.getVerticeI(), aristaActual.getVerticeJ(), aristaActual.getPeso() );
		        }
		        i++;
		    }
	    }
	
	    return arbolMinimo;
	}
	
	
	// Genera un AGM con Union Find
	public static Grafo arbolGeneradorMinimoUF(Grafo grafo)
	{	
		boolean esValido = esValido(grafo);
		
	    Grafo arbolMinimo = new Grafo(grafo.getTamanio());
	    ArrayList<Arista> aristasGrafo = grafo.getTodasAristas();
	    UnionFind aristasArbolMinimo = new UnionFind(grafo.getTamanio());
	    
	    Collections.sort(aristasGrafo); // Ordena las aristas de la MENOS pesada a la MAS pesada
	    
	    if(esValido)
	    {
	    	int i = 0;
		    while ( i < aristasGrafo.size() )
		    { 
		        Arista aristaActual = aristasGrafo.get(i);
		        
		        // Si el vertice J NO esta contenido en la componente conexa del vertice I
		        if ( !aristasArbolMinimo.find(aristaActual.getVerticeI(), aristaActual.getVerticeJ()) )
		        {
		        	aristasArbolMinimo.union( aristaActual.getVerticeI(), aristaActual.getVerticeJ() );
		        	arbolMinimo.agregarArista( aristaActual.getVerticeI(), aristaActual.getVerticeJ(), aristaActual.getPeso() );
		        }
		        i++;
		    }    
	    }
	    
	    return arbolMinimo;
	}
	
	
	// Verifica que el grafo sea valido
	private static boolean esValido(Grafo grafo)
	{
		if(!BFS.esConexo(grafo))
		{
			//throw new IllegalArgumentException("El grafo no es conexo, por lo tanto no se puede generar un AGM");
			return false;
		}
		else if(grafo == null)
		{
	    	throw new IllegalArgumentException("El grafo es null, por lo tanto no se puede generar un AGM");
		}
		else if(grafo.getTamanio() == 0)
		{
			throw new IllegalArgumentException("El grafo es vacio, por lo tanto no se puede generar un AGM");
		}
		else 
		{
			return true;
		}
	}

}
