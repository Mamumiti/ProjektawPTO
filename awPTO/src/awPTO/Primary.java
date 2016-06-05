package awPTO;

import java.util.Iterator;
import java.util.Set;

public class Primary {

	private InToPost inToPost;
	private Helper helper;
	
	
	
	public Primary(Helper helper) {
		this.helper = helper;
		this.inToPost = new InToPost(helper.getLine());
	}
	
	public void printPrimaryVariablesMatrix() {
			Iterator  binaryIterator = helper.getBinaryMatrix().iterator();
			Iterator variableIterator = helper.getVariables().iterator();
			String pom;
		while(binaryIterator.hasNext()) {
			pom = (String) binaryIterator.next();
	
			for (char c : pom.toCharArray()) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
	
	
	
}
