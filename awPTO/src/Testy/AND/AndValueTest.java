package Testy.AND;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import awPTO.Gates.AND;


@RunWith(Parameterized.class)
public class AndValueTest {

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays
				.asList(new Object[][] { { "1", "1", "1" }, { "1", "0", "0" }, { "0", "1", "0" }, { "0", "0", "0" } });
	}

	private String input1;
	private String input2;
	private String expected;

	public AndValueTest(String input1, String input2, String excepted) {
		this.input1 = input1;
		this.input2 = input2;
		this.expected = excepted;
	}
	
	@Test
	public void test() {
		AND and  = new AND();
		and.setFirstValue(input1);
		and.setSecondValue(input2);
		assertEquals(expected, and.calculate());
	}

}
