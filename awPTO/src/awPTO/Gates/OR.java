package awPTO.Gates;

public class OR {

	private int firstValue;
	private int secondValue;
	private int result;

	public OR() {
		this.result = calculate(this.firstValue, this.secondValue);
	}

	public int getFirstValue() {
		return firstValue;
	}

	public void setFirstValue(int firstValue) {
		this.firstValue = firstValue;
	}

	public int getSecondValue() {
		return secondValue;
	}

	public void setSecondValue(int secondValue) {
		this.secondValue = secondValue;
	}

	public OR(int firstValue, int secondValue) {
		this.firstValue = firstValue;
		this.secondValue = secondValue;
	}

	private int calculate(int firstValue, int secondValue) {
		if ((firstValue == 1) && (secondValue == 1)) {
			return 1;
		}
		return 0;
	}

	public int getResult() {

		return result;
	}

	public void printFirstValue() {
		System.out.println(firstValue);
	}

	public void printSecondValue() {
		System.out.println(secondValue);
	}

	public void printResut() {
		System.out.println(result);
	}

}
