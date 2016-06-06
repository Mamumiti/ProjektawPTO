package Testy.Primary;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import awPTO.Helper;
import awPTO.Primary;

public class PrrimaryTest {

	Primary p ;
	
	@Before
	public void setup() {
		p = new Primary(new Helper("test.txt"));
	}
	@Test
	public void getVariableColumnTest() {
		assertEquals(0, p.getVariableColumn("A"));
	}

}
