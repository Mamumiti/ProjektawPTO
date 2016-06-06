package Testy.NOT;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import awPTO.Gates.NOR;
import awPTO.Gates.NOT;
@RunWith(Parameterized.class)
public class NotSymbolTest {
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays
				.asList(new Object[][] { { "A", "~A" }, { "B", "~B" } });
	}

	private String input1;
	private String expected;

	public NotSymbolTest(String input1, String excepted) {
		this.input1 = input1;
		this.expected = excepted;
	}
	
	@Test
	public void test() {
		NOT not  = new NOT();
		not.setValue("0");
		not.setSymbol(input1);
		not.calculate();
		not.printOperation();
		assertEquals(expected, not.getOperation());
	}
}
