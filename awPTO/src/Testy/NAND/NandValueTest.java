package Testy.NAND;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import awPTO.Gates.NAND;

@RunWith(Parameterized.class)
public class NandValueTest {

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays
				.asList(new Object[][] { { "1", "1", "0" }, { "1", "0", "1" }, { "0", "1", "1" }, { "0", "0", "1" } });
	}

	private String input1;
	private String input2;
	private String expected;

	public NandValueTest(String input1, String input2, String excepted) {
		this.input1 = input1;
		this.input2 = input2;
		this.expected = excepted;
	}
	
	@Test
	public void test() {
		NAND nand  = new NAND();
		nand.setFirstValue(input1);
		nand.setSecondValue(input2);
		assertEquals(expected, nand.calculate());
	}

}
