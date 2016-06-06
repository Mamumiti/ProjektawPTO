package Testy.XOR;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import awPTO.Gates.XOR;
@RunWith(Parameterized.class)
public class XorSymbolTest {
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays
				.asList(new Object[][] { { "A", "B", "A%B" }, { "A&C", "B", "A&C%B" }, { "A", "B&C", "A%B&C" }, { "A&B", "D&E", "A&B%D&E" } });
	}

	private String input1;
	private String input2;
	private String expected;

	public XorSymbolTest(String input1, String input2, String excepted) {
		this.input1 = input1;
		this.input2 = input2;
		this.expected = excepted;
	}
	
	@Test
	public void test() {
	
		XOR xor  = new XOR();
		xor.setFirstValue("0");
		xor.setSecondValue("0");
		
		xor.setFirstSymbol(input1);
		xor.setSecondSymbol(input2);
		xor.calculate();
		System.out.println();
		xor.printOperation();
		assertEquals(expected, xor.getOperation());
	}
}
