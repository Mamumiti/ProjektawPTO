package awPTO;

import java.util.Iterator;
import java.util.Set;

import awPTO.Gates.OR;

public class Primary {

	private Helper helper;
	private OR or;
	private Queue queueValues;
	private Queue queueVariables;
	private String[] variableArray;
	private String[] binaryArray;;

	public Primary(Helper helper) {
		this.helper = helper;
		queueValues = new Queue(helper.getLine().length());
		queueVariables = new Queue(helper.getLine().length());
		variableArray = new String[helper.getVariableQuantity()];
		binaryArray = new String[helper.getBinaryMatrixSize()];
		or = new OR();
		setToArray();
		System.out.println(variableArray.length);
		System.out.println(binaryArray.length);

		// for (int i = 0; i < variableArray.length; i++) {
		// System.out.print(variableArray[i]);
		// }
		// System.out.println();
		//
		// for (int i = 0; i < binaryArray.length; i++) {
		// System.out.println(binaryArray[i]);
		// }
		String pom;
		for (int i = 0; i < helper.getLine().length(); i++) {
			pom = helper.getNextSymbol();
		// System.out.println(pom + " "+getVariableColumn(pom));
			switch (pom) {
			case "|":
					for (int j = 0; j < binaryArray.length; j++) {
						//System.out.println((binaryArray[j].charAt(0)+"").equals("1"));
						or.setFirstValue(binaryArray[j].charAt(0)+"");
						or.setSecondValue(binaryArray[j].charAt(1)+"");
						or.setFirstSymbol('A');
						or.setSecondSymbol('B');
						or.calculate();
						or.printOperation();
						or.printResult();
					}
				break;

			default:
				queueVariables.Push(pom, 1);
				queueValues.Push(String.valueOf(getVariableColumn(pom)),1);
				break;
			}
			
			///System.out.println(getVariableColumn(helper.getNextSymbol()));
		}
	}

	public void printPrimaryVariablesMatrix() {
		Iterator binaryIterator = helper.getBinaryMatrix().iterator();
		String pomBinary;
		String pomVariable;
		Iterator variableIterator = helper.getVariables().iterator();
		while (variableIterator.hasNext()) {
			System.out.print(variableIterator.next().toString());
		}
		System.out.println();
		while (binaryIterator.hasNext()) {

			pomBinary = (String) binaryIterator.next();
			for (int i = 0; i < pomBinary.length(); i++) {
				System.out.print(pomBinary.charAt(i));
			}
			System.out.println();
		}
	}

	private void setToArray() {
		Iterator binaryIterator = helper.getBinaryMatrix().iterator();
		String pomBinary;
		String pomVariable;
		Iterator variableIterator = helper.getVariables().iterator();
		int pom = 0;
		while (variableIterator.hasNext()) {
			variableArray[pom] = variableIterator.next().toString();
			pom++;
			// System.out.print(variableIterator.next().toString());
		}
		// System.out.println();
		pom = 0;
		while (binaryIterator.hasNext()) {

			// pomBinary = (String) binaryIterator.next();
			binaryArray[pom] = (String) binaryIterator.next();
			pom++;
			// for (int i = 0; i < pomBinary.length(); i++) {
			// System.out.print( pomBinary.charAt(i));
			// }
			// System.out.println();
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
