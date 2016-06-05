package awPTO.Gates;

public class NOT {
	private String value;
	private String result;
	private String symbol;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String firstSymbol) {
		this.symbol = firstSymbol;
	}



	public String getValue() {
		return value;
	}

	public void setValue(String firstValue) {
		this.value = firstValue;
	}


	public String calculate() {
		if (value.equals("1")) {
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
		System.out.println(value);
	}


	public void printResult() {
		System.out.println(result);
	}

	public String getOperation() {
		return new StringBuilder().append("~").append(symbol).toString();
	}

	public void printOperation() {
		System.out.print(new StringBuilder().append("~").append(symbol).toString());
	}
}
