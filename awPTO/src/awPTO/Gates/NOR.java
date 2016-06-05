package awPTO.Gates;

public class NOR {

	private String firstValue;
	private String secondValue;
	private String result;
	private String firstSymbol;
	private String secondSymbol;

	public String getFirstSymbol() {
		return firstSymbol;
	}

	public void setFirstSymbol(String firstSymbol) {
		this.firstSymbol = firstSymbol;
	}

	public String getSecondSymbol() {
		return secondSymbol;
	}

	public void setSecondSymbol(String secondSymbol) {
		this.secondSymbol = secondSymbol;
	}

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

	public String calculate() {
		if ((firstValue.equals("1")) || (secondValue.equals("1"))) {
			result = "0";
			return "0";
		}
		result = "1";
		return "1";
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
		return new StringBuilder().append(firstSymbol).append("~|").append(secondSymbol).toString();
	}

	public void printOperation() {
		System.out.print(new StringBuilder().append(firstSymbol).append("~|").append(secondSymbol).toString());
	}

}
