package grafo_MatrizAdyacencia;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/*
Representacion con Matriz de Adyacencia
*/
public class Grafo
{
	
	private Double[][] grafo;
	private ArrayList<Arista> aristas = new ArrayList<Arista>();
	
	
	// Constructor
	public Grafo(int vertices)
	{
		grafo = new Double[vertices][vertices];
	}
	
	
	// Agregado de aristas
	public void agregarArista(int i, int j, Double peso)
	{
		if( this.existeArista(i, j) )
			throw new IllegalArgumentException("Ya existe la arista (" + i + ", " + j + ")");	
		
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		Arista arista = new Arista(i, j, peso);
		aristas.add(arista);
		
		grafo[i][j] = peso;
		grafo[j][i] = peso;
	}
	
	
	// Eliminacion de aristas
	public void eliminarArista(int i, int j)
	{
		if( !this.existeArista(i, j) )
			throw new IllegalArgumentException("NO existe la arista (" + i + ", " + j + ")");
		
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		Arista arista = new Arista(i, j, grafo[i][j]);
		aristas.remove(arista);

		grafo[i][j] = null;
		grafo[j][i] = null;
	}

	
	// Cambia el peso de una arista
    public void cambiarPesoArista(int i, int j, Double peso)
    {
        grafo[i][j] = peso;
        grafo[j][i] = peso;
        
        eliminarArista(i, j);
        agregarArista(i, j, peso);
    }
    
    
	// Informa si existe la arista especificada
	public boolean existeArista(int i, int j)
	{
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		return grafo[i][j] != null;
	}

	
	// Cantidad de vertices
	public int getTamanio()
	{
		return grafo.length;
	}
	
	
	// Vecinos de un vertice
	public Set<Integer> vecinos(int i)
	{
		verificarVertice(i);
		
		Set<Integer> vecinos = new HashSet<Integer>();
		for(int j = 0; j < getTamanio(); ++j) if( i != j )
		{
			if( this.existeArista(i,j) )
				vecinos.add(j);
		}
		
		return vecinos;		
	}
	
	
	// Returna el peso de una arista
	public Double getPesoArista(int i, int j)
	{
        return grafo[i][j];
    }
	
	
	// Returna todas las aristas del grafo	
	public ArrayList<Arista> getTodasAristas()
	{
		// Se ordena antes para evitar errores en el equals de grafo
		// Esto se debe porque al paracer dos ArrayList son iguales solo si tienen los
		// mismos elmentos ordenados de la misma manera
		Collections.sort(aristas); // Ordena las aristas de la MENOS pesada a la MAS pesada
        return aristas;
    }
	
	
	// Retorna el grafo completo
	public Double[][] getGrafo()
	{
        return grafo;
    }

	
	// Verifica que sea un vertice valido
	private void verificarVertice(int i)
	{
		if( i < 0 )
			throw new IllegalArgumentException("El vertice " + i + " no puede ser negativo");
		
		if( i >= getTamanio() )
			throw new IllegalArgumentException("Los vertices deben estar entre 0 y " + (this.getTamanio() - 1) + ": " + i);
	}

	
	// Verifica que i y j sean distintos
	private void verificarDistintos(int i, int j)
	{
		if( i == j )
			throw new IllegalArgumentException("No se permiten loops: (" + i + ", " + j + ")");
	}
	
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(grafo);
		result = prime * result + Objects.hash(aristas);
		return result;
	}

	
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grafo other = (Grafo) obj;
		return (getTodasAristas().equals(other.getTodasAristas()) && Arrays.deepEquals(grafo, other.grafo));
	}

	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		DecimalFormat df = new DecimalFormat("#.##");
		int letra = 65;
		
		for(int fila = 0; fila < grafo.length; fila++)
	    {
			builder.append("  |  ");
			builder.append((char)letra);
			letra++;
	    }
		builder.append("  |");
		builder.append("\n");
		letra = 65;
		
		for(int fila = 0; fila < grafo.length; fila++)
	    { 
			builder.append((char)letra);
			builder.append(" ");
			builder.append("|");
			letra++;
			
	    	for(int columna = 0; columna < grafo[fila].length; columna++)
	    	{
	    		
		    	if (grafo[fila][columna] == null)
		    	{
			    	builder.append("  -  ");
			    	builder.append("|");
		    	}
		    	else
		    	{
		    		if(df.format(grafo[fila][columna]).length() == 4)
					{
		    			builder.append(" ");
		    			builder.append(df.format(grafo[fila][columna]));
		    			builder.append("|");
					}

					if(df.format(grafo[fila][columna]).length() == 3)
					{
						builder.append(" ");
		    			builder.append(df.format(grafo[fila][columna]));
		    			builder.append(" ");
		    			builder.append("|");
					}
					
					if(df.format(grafo[fila][columna]).length() == 2)
					{
						builder.append(" ");
						builder.append(" ");
		    			builder.append(df.format(grafo[fila][columna]));
		    			builder.append(" ");
		    			builder.append("|");
					}
					
					if(df.format(grafo[fila][columna]).length() == 1)
					{
						builder.append(" ");
						builder.append(" ");
		    			builder.append(df.format(grafo[fila][columna]));
		    			builder.append(" ");
		    			builder.append(" ");
		    			builder.append("|");
					}
		    	}
			}
	    	builder.append("\n");
	    }
		builder.append("\n");
		return builder.toString();
	}

}
