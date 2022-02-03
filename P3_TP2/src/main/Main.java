package main;

import algoritmos.Kruskal;
import grafo_MatrizAdyacencia.Grafo;
import grafo_MatrizAdyacencia.TiempoPromedio;

public class Main
{

	public static void main(String[] args)
	{
		// Grafo de ejemplo usado para explicar kurskal en la diapo de AGM (pag. 15)
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
		
		System.out.println("Grafo:");
		System.out.println(g);
		
		// 1)
		System.out.println("1) Implementar el Algoritmo de Kruskal sin Union-Find");
		System.out.println(Kruskal.arbolGeneradorMinimoBFS(g));
	
		// 2)
		System.out.println("2) Implementar el Algoritmo de Kruskal con Union-Find");
		System.out.println(Kruskal.arbolGeneradorMinimoUF(g));
		
		// Aca tarda un poquito ya que BFS es lento
		// 3)
		System.out.println("3) Generar grafos aleatoriamente y medir el tiempo de ejecucion de las dos versiones");
		
		System.out.println("Generando grafo...");
		Grafo g1 = TiempoPromedio.aleatorioConexo(400);
		System.out.println("Procesando AGM...");
		
		System.out.print("Tiempo con UF (seg): ");
		System.out.print("Unitario ");
		System.out.print(TiempoPromedio.kruskalUF(g1));
		System.out.print(", Promedio ");
		System.out.println(TiempoPromedio.kruskalUFpromedio(g1));
		
		System.out.print("Tiempo con BFS (seg): ");
		System.out.print("Unitario = ");
		System.out.print(TiempoPromedio.kruskalBFS(g1));
		System.out.print(", Promedio = ");
		System.out.println(TiempoPromedio.kruskalBFSpromedio(g1));
		System.out.println("\n");
		
		// Este punto en particular suele tardar varios minutos, mas que nada BFS
		// 4)
		System.out.println("4) Graficar el tiempo promedio de ejecucion en funcion del tamanio del grafo");
		TiempoPromedio.kruskalUFpromedioConTamanio(100);
		TiempoPromedio.kruskalBFSpromedioConTamanio(100);
	}

}
