package awPTO;

public class awPTO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Helper helper = new Helper("input.txt");
		
		//String input = "(A|B)&C~&D&~E";
		String input = helper.getLine();
		System.out.println(helper.getVariableQuantity());
	      String output;
	      InToPost theTrans = new InToPost(input);
	      output = theTrans.doTrans(); 
	      System.out.println("input is:"+input+" \nPostfix is " + output + '\n');
	      
	      for (int i = 0; i <= helper.getVariableQuantity(); i++) {
			System.out.println(Integer.toBinaryString(i));
		}
	      //System.out.println(theTrans.getTheStack().pop());
	      
//	      for (int i = 0; i<=1;i++) {
//	    	  for (int j = 0; j <=1; j++) {
//	    		  for (int j2 = 0; j2 <=1; j2++) {
//					System.out.print(i+" "+j+" "+j2+"\n");
//				}
//			}
//	      }
		
	}

}
