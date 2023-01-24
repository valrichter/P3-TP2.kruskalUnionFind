package grafo_MatrizAdyacencia;

import java.util.Random;
import algoritmos.Kruskal;
import grafo_ListaVecions.BFSLV;
import grafo_ListaVecions.GrafoLV;

public class TiempoPromedio
{
    
    // Returna el tiempo (seg) que tarda kruskal con BFS
    public static double kruskalBFS(Grafo grafo)
    { 
    	double tiempo = 0;
    	long inicio = System.currentTimeMillis(); 
    	Kruskal.arbolGeneradorMinimoBFS(grafo);
    	long fin = System.currentTimeMillis();
    	tiempo = fin - inicio;
          
        return tiempo / 1000.0;
    }
    
    
	// Returna el tiempo (seg) promedio de krukal con BFS
    public static double kruskalBFSpromedio(Grafo grafo)
    { 
    	double tiempo = 0;
        for(int i=0; i<100; ++i)
        {
        	tiempo += kruskalBFS(grafo);
        }
        
        return tiempo / 100;
    }
    
    
    // Returna el tiempo (seg) promedio de krukal con BFS en funcion del tamanio del grafo
    public static void kruskalBFSpromedioConTamanio(int crecimiento)
    { 
    	for(int n=100; n<=1000; n=n+crecimiento)
		{
			System.out.println("Generando grafo...");
			Grafo g = TiempoPromedio.aleatorioConexo(n);
			
			System.out.println("Procesando AGM con BFS...");
			double tiempo = TiempoPromedio.kruskalBFSpromedio(g);
			
			System.out.print("Tamanio: " + n + ", seg: " + tiempo);
			System.out.println("\n");
		}
		System.out.println("\n");
    }
    
    
    // Returna el tiempo (seg) que tarda kruskal con Union Find
    public static double kruskalUF(Grafo grafo)
    { 
    	double tiempo = 0;
    	long inicio = System.currentTimeMillis(); 
    	Kruskal.arbolGeneradorMinimoUF(grafo);
    	long fin = System.currentTimeMillis();
    	tiempo = fin - inicio;
          
        return tiempo / 1000.0;
    }
    
    
    // Returna el tiempo (seg) promedio de krukal con Union Find
    public static double kruskalUFpromedio(Grafo grafo)
    {
    	double tiempo = 0;
        for(int i=0; i<100; ++i)
        {
        	tiempo += kruskalUF(grafo);
        }
        
        return tiempo / 100;
    }
    
    
    // Returna el tiempo (seg) promedio de krukal con UF en funcion del tamanio del grafo
    public static void kruskalUFpromedioConTamanio(int crecimiento)
    { 
    	for(int n=100; n<=1000; n=n+crecimiento)
		{
			System.out.println("Generando grafo...");
			Grafo g = TiempoPromedio.aleatorioConexo(n);
			
			System.out.println("Procesando AGM con UF...");
			double tiempo = TiempoPromedio.kruskalUFpromedio(g);
			
			System.out.print("Tamanio: " + n + ", seg: " + tiempo);
			System.out.println("\n");
		}
		System.out.println("\n");
    }
    
    // Genera grafos random conexos, su complejidad es mala ya que usa BFS pero es lo mas secillo que pude hacer
    public static Grafo aleatorioConexo(int n)
    {
    	Random random = new Random();
    	GrafoLV gLV = new GrafoLV(n);
        Grafo g = new Grafo(n);  
        
        while(!BFSLV.esConexo(gLV))
        {	
        	int v1 = random.nextInt(n);
        	int v2 = random.nextInt(n);
        	
        	// No bluces y no aristas repetidas
        	if(v1 != v2 && !g.existeArista(v1, v2))
        	{
        		g.agregarArista(v1, v2, random.nextDouble());  
        		gLV.agregarArista(v1, v2);
        	}
        }
        
		return g;	
    }
    
}
