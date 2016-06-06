package Testy.NOR;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import awPTO.Gates.NOR;
@RunWith(Parameterized.class)
public class NorSymbolTest {
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays
				.asList(new Object[][] { { "A", "B", "A~|B" }, { "A&C", "B", "A&C~|B" }, { "A", "B&C", "A~|B&C" }, { "A&B", "D&E", "A&B~|D&E" } });
	}

	private String input1;
	private String input2;
	private String expected;

	public NorSymbolTest(String input1, String input2, String excepted) {
		this.input1 = input1;
		this.input2 = input2;
		this.expected = excepted;
	}
	
	@Test
	public void test() {
		NOR nor  = new NOR();
		nor.setFirstValue("0");
		nor.setSecondValue("0");
		
		nor.setFirstSymbol(input1);
		nor.setSecondSymbol(input2);
		nor.calculate();
		System.out.println();
		nor.printOperation();
		assertEquals(expected, nor.getOperation());
	}
}
