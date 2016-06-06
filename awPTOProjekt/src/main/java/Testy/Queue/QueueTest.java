package Testy.Queue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import awPTO.Queue;

public class QueueTest {

	Queue queue;
	@Before
	public void setup() {
		queue = new Queue(3);
		queue.Push("a", 1);
		queue.Push("b", 3);
		queue.Push("c", 2);

	}
	@Test
	public void isEmptyTest() {
		assertEquals(false, queue.isEmpty());
	}
	@Test
	public void isFullTest() {
		assertEquals(true, queue.isFull());
	}
	
	@Test
	public void popTest() {
		//System.out.println(queue.Pop().toString());
		assertEquals("N:b, P:3", queue.Pop().toString());
	}
	
}
