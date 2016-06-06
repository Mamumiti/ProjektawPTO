package Testy.AND;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import awPTO.Gates.NAND;
@RunWith(Parameterized.class)
public class AndSymbolTest {
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays
				.asList(new Object[][] { { "A", "B", "A~&B" }, { "A|C", "B", "A|C~&B" }, { "A", "B&C", "A~&B&C" }, { "A|B", "D|E", "A|B~&D|E" } });
	}

	private String input1;
	private String input2;
	private String expected;

	public AndSymbolTest(String input1, String input2, String excepted) {
		this.input1 = input1;
		this.input2 = input2;
		this.expected = excepted;
	}
	
	@Test
	public void test() {
		NAND nand  = new NAND();
		nand.setFirstValue("0");
		nand.setSecondValue("0");
		
		nand.setFirstSymbol(input1);
		nand.setSecondSymbol(input2);
		nand.calculate();
		System.out.println();
		nand.printOperation();
		assertEquals(expected, nand.getOperation());
	}
}
