package Testy.InToPost;

import static org.junit.Assert.*;

import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import awPTO.InToPost;

@RunWith(Parameterized.class)
public class InToPostTransformTest {

	
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays
				.asList(new Object[][] { { "A|B", "AB|" }, { "A~&C", "A~C&"}, { "A~|D", "A~D|"} });
	}
	private String input;
	private String expected;
	
	public InToPostTransformTest(String input, String expected) {
		this.input = input;
		this.expected = expected;
	}
	
	@Test
	public void doTransTest() {
		InToPost inToPost = new InToPost(input);
			assertEquals(expected, inToPost.doTrans());
	}

}
