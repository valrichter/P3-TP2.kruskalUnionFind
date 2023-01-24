package grafo_ListaVecions;

import java.util.Set;
import static org.junit.Assert.*;

public class Assert 
{
	
	public static void iguales(int[] esperado, Set<Integer> alcanzables)
	{
		assertEquals(esperado.length, alcanzables.size());
		for (int elem: esperado)
			assertTrue(alcanzables.contains(elem));
	}
	
}
