package awPTO.Gates;

public class OR {

	private String firstValue;
	private String secondValue;
	private String result;
	private char firstSymbol;
	private char secondSymbol;
		
	public String getFirstValue() {
		return firstValue;
	}

	public void setFirstValue(String firstValue) {
		this.firstValue = firstValue;
	}

	public String getSecondValue() {
		return secondValue;
	}

	public void setSecondValue(String secondValue) {
		this.secondValue = secondValue;
	}

	public String calculate(String firstValue, String secondValue) {
		if ((firstValue.equals("1")) && (secondValue.equals("1"))) {
			return "1";
		}
		return "0";
	}

	public String getResult() {

		return result;
	}

	public void printFirstValue() {
		System.out.println(firstValue);
	}

	public void printSecondValue() {
		System.out.println(secondValue);
	}

	public void printResult() {
		System.out.println(result);
	}
	
	public String getOperation() {
		return  new StringBuilder().append(firstSymbol).append("|").append(secondSymbol).toString();
	}
	
	public void printOperation() {
		System.out.print(new StringBuilder().append(firstSymbol).append("|").append(secondSymbol).toString());
	}
	

}
