package Testy.Stack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import awPTO.Stack;

public class StackTest {
	Stack s;
	
	@Before
	public void setup() {
		s = new Stack(5);
	}
	
	@Test
	public void isemptyTest() {
		assertEquals(true, s.isEmpty());
	}

	@Test
	public void pushTest() {
		s.push('0');
		assertEquals(false, s.isEmpty());
	}
	
	@Test
	public void peekTest() {
		s.push('a');
		assertEquals('a', s.peek());
	}
	
	@Test
	public void popTest() {
		s.push('a');
		assertEquals('a', s.pop());
	}
	

}
