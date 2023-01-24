// 
// Decompiled by Procyon v0.5.36
// 

package grafo_MatrizAdyacencia;

import java.util.Objects;

public class Arista implements Comparable<Arista>
{
	
    private int i;
    private int j;
    private double peso;
    
    // Constructor
    public Arista(int i, int j, double peso)
    {
        this.i = i;
        this.j = j;
        this.peso = peso;
    }

    
    // Returna el vertice i
	public int getVerticeI()
	{
        return this.i;
    }
    
	
	// Returna el vertice j
    public int getVerticeJ() {
        return this.j;
    }
    
    
    // Returna el peso
    public double getPeso()
    {
        return this.peso;
    }
    
    
    @Override
	public int hashCode()
    {
		return Objects.hash(i, j, peso);
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
		Arista other = (Arista) obj;
		
		if( (i == other.i && j == other.j && peso == other.peso) ||
			(j == other.i && i == other.j && peso == other.peso) )
			return true;
		
		return false;
	}
    
	
    @Override
    public int compareTo(Arista o)
    {
        if (this.peso < o.peso) {
            return -1;
        }
        if (this.peso > o.peso) {
            return 1;
        }
        return 0;
    }
    
    
    @Override
	public String toString()
    {
		StringBuilder builder = new StringBuilder();
		builder.append("Arista i=");
		builder.append(i);
		builder.append(" j=");
		builder.append(j);
		builder.append(" peso=");
		builder.append(peso);
		builder.append("\n");
		return builder.toString();
	}
    
}
