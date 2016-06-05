package awPTO;

public class awPTO {

	public static void main(String[] args) {

//		Helper helper = new Helper("input.txt");
//		
//
//		String input = helper.getLine();
//		System.out.println(helper.getVariableQuantity());
//	      String output;
//	      InToPost theTrans = new InToPost(input);
//	      output = theTrans.doTrans(); 
//	      System.out.println("input is:"+input+" \nPostfix is " + output + '\n');
//	 
//	      helper.generateBinaryMatrix();
	      
	      Primary  p = new Primary(new Helper("input.txt"));
	      p.printPrimaryVariablesMatrix();
	      
	}
	
	

}
