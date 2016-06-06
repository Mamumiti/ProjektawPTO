package Testy.Helper;

import static org.junit.Assert.*;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import awPTO.Helper;

public class HelperTest {
	
	Helper help;
	
	@Before
	public void setup() {
		help = new Helper("test.txt");
	}
	@Test
	public void VariableQuantityTest() {
		assertEquals(3, help.getVariableQuantity());
	}
	@Test
	public void getVariablesTreeTest() {
		Set<String> tree = new TreeSet<>();
		tree.add("A");
		tree.add("B");
		tree.add("C");
		assertEquals(tree, help.getVariables());
		System.out.println(help.getVariables());
	}
	
	@Test
	public void matrixSizeTest() {
		assertEquals(8, help.getBinaryMatrixSize());
	}
	
	@Test
	public void binaryMatrixTest() {
		Set<String> tree = new TreeSet<>();
		tree.add("000");
		tree.add("001");
		tree.add("010");
		tree.add("011");
		tree.add("100");
		tree.add("101");
		tree.add("110");
		tree.add("111");

		System.out.println(help.generateBinaryMatrix());
		assertEquals(tree, help.generateBinaryMatrix());
	}
	
	@Test
	public void getNextSymbolTest() {
		assertEquals("A", help.getNextSymbol());
		assertEquals("B", help.getNextSymbol());
		assertEquals("&", help.getNextSymbol());
		
	}
	
	

}
