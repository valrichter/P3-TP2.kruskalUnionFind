package grafo_MatrizAdyacencia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

public class Assert
{
	// Verifica que sean iguales como conjuntos
	public static void iguales(int[] esperado, Set<Integer> alcanzables)
	{
		assertEquals(esperado.length, alcanzables.size());
		for (int elem: esperado)
			assertTrue(alcanzables.contains(elem));
	}
}
