package algoritmos;

import static org.junit.Assert.*;
import org.junit.Test;

public class UnionFindTest
{
	@Test (expected=IllegalArgumentException.class)
	public void testUnionNegativa()
	{
		UnionFind uf= new UnionFind(5);
		uf.union(0, -1);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testFindNegativa()
	{
		UnionFind uf= new UnionFind(5);
		uf.find(0, -1);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testFindNoExiste()
	{
		UnionFind uf= new UnionFind(5);
		uf.find(0, -1);
	}
	
	@Test
	public void testUnionFind()
	{
		UnionFind uf= new UnionFind(5);
		uf.union(0, 2);
		assertTrue(uf.find(0, 2));
	}
}
