package Testy.OR;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import awPTO.Gates.OR;
@RunWith(Parameterized.class)
public class OrSymbolTest {
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays
				.asList(new Object[][] { { "A", "B", "A|B" }, { "A&C", "B", "A&C|B" }, { "A", "B&C", "A|B&C" }, { "A&B", "D&E", "A&B|D&E" } });
	}

	private String input1;
	private String input2;
	private String expected;

	public OrSymbolTest(String input1, String input2, String excepted) {
		this.input1 = input1;
		this.input2 = input2;
		this.expected = excepted;
	}
	
	@Test
	public void test() {
		OR or  = new OR();
		or.setFirstValue("0");
		or.setSecondValue("0");
		
		or.setFirstSymbol(input1);
		or.setSecondSymbol(input2);
		or.calculate();
		System.out.println();
		or.printOperation();
		assertEquals(expected, or.getOperation());
	}
}
