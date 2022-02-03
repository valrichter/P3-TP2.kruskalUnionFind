package grafo_ListaVecions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
  Representación con Lista de vecinos
*/
public class GrafoLV
{
	
	private ArrayList<Set<Integer>> _vecinos;
	private int _vertice; 
	
	// Constructor
	public GrafoLV( int vertices)
	{
		_vecinos = new ArrayList<Set<Integer>>(vertices);

		for (int i = 0; i < vertices; i++)
			_vecinos.add(new HashSet<Integer>());	

		_vertice = vertices;
	}
	
	
	// Agrega una arista
	public void agregarArista ( int i, int j)
	{
		verificarArista(i, j, "agregar");
		
		_vecinos.get(i).add(j);
		_vecinos.get(j).add(i);
	}
	
	
	// Elimina una arista
	public void eliminarArista(int i, int j)
	{
		verificarArista(i, j, "eliminar");
		
		_vecinos.get(i).remove(j);
		_vecinos.get(j).remove(i);

	}
	
	
	// Verifica que exista la arista (i, j)
	public boolean existeArista (int i, int j)
	{
		verificarArista(i, j, "consultar");
		
		return _vecinos.get(i).contains(j);
	}

	
	// Devuelve los vecinos de un vertice
	public Set<Integer> vecinos(int i)
	{
		verificarVertice(i, " un vertice ");
		
		return _vecinos.get(i);
	}

	
	// Returna el grado de un vertice
	public int grado (int i)
	{ 
		return _vecinos.get(i).size();
	}
	
	
	// Valida la arista
	private void verificarArista(int i, int j, String tipo) 
	{
		if (i == j)
			throw new IllegalArgumentException("Se intento "+tipo+" una arista con i=j : "+i +"/"  + j);
		
		verificarVertice(i, tipo);

		verificarVertice(j, tipo);

	}

	
	// Valida el vertice
	private void verificarVertice(int i, String tipo) 
	{
		if (i < 0 || i >= _vertice)
			throw new IllegalArgumentException("Se intento usar "+tipo+" con valores, fuera de rango: "+ i);
	}

	
	// Returna el tamanio del grafo
	public int vertices()
	{
		return _vertice;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < _vertice; i++)
		{
			builder.append(i);
			builder.append(" ");
			builder.append(this.vecinos(i));
			builder.append("\n");
		}
		builder.append("\n");
		return builder.toString();
	}
	

}
