package awPTO;

public class awPTO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Helper helper = new Helper("input.txt");
		
		String input = "1+2*4/(5-7)+3/6";
	      String output;
	      InToPost theTrans = new InToPost(input);
	      output = theTrans.doTrans(); 
	      System.out.println("input is:"+input+" \nPostfix is " + output + '\n');
		
	}

}
