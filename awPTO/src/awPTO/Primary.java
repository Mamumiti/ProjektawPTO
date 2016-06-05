package awPTO;

import java.util.Iterator;
import java.util.Set;

import awPTO.Gates.OR;

public class Primary {

	private Helper helper;
	private OR or;
	private Queue queue;

	public Primary(Helper helper) {
		this.helper = helper;
		queue = new Queue(helper.getLine().length());
		
		for (int i = 0; i < helper.getLine().length(); i++) {
			
			System.out.println(getVariableColumn(helper.getNextSymbol()));
		}
	}

	public void printPrimaryVariablesMatrix() {
		Iterator binaryIterator = helper.getBinaryMatrix().iterator();
		String pomBinary;
		String pomVariable;
		Iterator variableIterator = helper.getVariables().iterator();
		while (variableIterator.hasNext()) {
			System.out.print("|" + variableIterator.next().toString() + "|");
		}
		System.out.println();
		while (binaryIterator.hasNext()) {

			pomBinary = (String) binaryIterator.next();
			for (int i = 0; i < pomBinary.length(); i++) {
				System.out.print("|" + pomBinary.charAt(i) + "|");
			}
			System.out.println();
		}
	}

	private int getVariableColumn(String variable) {
		String pom;
		int i = 0;
		Iterator<String> variableIterator = helper.getVariables().iterator();
		Set<String> s = helper.getVariables();
		while (variableIterator.hasNext()) {
			if (variableIterator.next().indexOf(variable) != -1) {
				return i;
			}
			i++;

		}
		return -1;
	}

}
