package algoritmos;

import java.util.Arrays;

public class UnionFind
{
	
	// Los padres de cada vertice
	private static int parents[];
	// Los rangos de cada vertice
	private static int rank[];
	
	public UnionFind(int tamanio) 
	{
		parents = new int[tamanio];

        for (int i = 0; i < parents.length; i++)
        {
            parents[i] = i;
        }
        
        rank = new int[tamanio];	
	}
	
	
	// Union por rank
	public void union(int i, int j)
	{
		int p1 = raiz(i);
		int p2 = raiz(j);
		
		if (p1 == p2)
            return;   
		
		// Si el rango de p1 es menor que el rango de p2
        if (rank[p1] < rank[p2])
        {
        	parents[p1] = p2;
        }
        
        // Si el rango de p1 es mayor que el rango de p2
        else if (rank[p1] > rank[p2])
        {
            parents[p2] = p1;
        }
        
        else
        {
            parents[p1] = p2;
            rank[p2]++;
        }
	}
	
	
	// Find
	public boolean find(int i, int j)
	{
		return raiz(i) == raiz(j);
	}
	
	
	// Path Compression
	private int raiz(int i)
	{
		validar(i);
		while (parents[i] != i)
		{
            parents[i] = parents[parents[i]];
            i = parents[i];
        }

        return parents[i];
	}

	
	// Valida los valores introducidos
	private static void validar(int i)
    {
		if(i < 0)
    	{
    		throw new IllegalArgumentException(i + " Union-Find no admite valores negativos");
    	}
    	else if(i >= parents.length)
    	{
        	throw new IllegalArgumentException(i + " esta fuera de rango");
    	}
    }
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Parents: ");
		builder.append(Arrays.toString(parents));
		builder.append(", Rank: ");
		builder.append(Arrays.toString(rank));
		return builder.toString();
	}
	
}
