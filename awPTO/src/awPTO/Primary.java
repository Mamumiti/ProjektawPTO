package awPTO;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import awPTO.Gates.AND;
import awPTO.Gates.OR;

public class Primary {

	private Helper helper;
	private OR or;
	private AND and;
	private Queue queueValues;
	private Queue queueVariables;
	private ArrayList<String> variableList = new ArrayList<String>();;
	private ArrayList<String> binaryList = new ArrayList<String>();;

	public Primary(Helper helper) {
		this.helper = helper;
		queueValues = new Queue(helper.getLine().length());
		queueVariables = new Queue(helper.getLine().length());
		or = new OR();
		and = new AND();
		setToArray();
		System.out.println(variableList.size());
		System.out.println(binaryList.size());

		String pom;
		String queueVPom[] = new String[4];
		String queueBPom[] = new String[4];

		for (int i = 0; i < helper.getLine().length(); i++) {
			pom = helper.getNextSymbol();
			Iterator<String> binaryIterator;
			int index;
			Boolean flag = false;
			switch (pom) {
			case "|":

				or.setFirstSymbol(queueVariables.Pop().getName());
				or.setSecondSymbol(queueVariables.Pop().getName());
				queueBPom[0] = queueValues.Pop().getName();
				queueBPom[1] = queueValues.Pop().getName();
				while(!queueValues.isEmpty())
				{
					queueValues.Pop();
				}
				binaryIterator = binaryList.iterator();
				index = 0;

				while (binaryIterator.hasNext()) {
					String orPom = binaryIterator.next();
					System.out.print(orPom.charAt(Integer.parseInt(queueBPom[1])) + " ");
					System.out.println(orPom.charAt(Integer.parseInt(queueBPom[0])));
					or.setFirstValue(orPom.charAt(Integer.parseInt(queueBPom[1])) + "");
					or.setSecondValue(orPom.charAt(Integer.parseInt(queueBPom[0])) + "");
					binaryList.set(index, new StringBuilder(orPom).append(or.calculate()).toString());
					index++;
				}
				System.out.println("####");
				flag = true;
				variableList.add(or.getOperation());
				queueVariables.Push(or.getOperation(), 0);
				queueValues.Push(or.calculate(), 0);
				break;
			case "&":

				and.setFirstSymbol(queueVariables.Pop().getName());
				and.setSecondSymbol(queueVariables.Pop().getName());
				queueBPom[0] = queueValues.Pop().getName();
				queueBPom[1] = queueValues.Pop().getName();
				while(!queueValues.isEmpty())
				{
					queueValues.Pop();
				}

				binaryIterator = binaryList.iterator();
				index = 0;
				while (binaryIterator.hasNext()) {
					String orPom = binaryIterator.next();
					System.out.print(orPom.charAt(Integer.parseInt(queueBPom[1])) + " ");
					System.out.println(orPom.charAt(Integer.parseInt(queueBPom[0])));

					and.setFirstValue(orPom.charAt(Integer.parseInt(queueBPom[1])) + "");
					and.setSecondValue(orPom.charAt(Integer.parseInt(queueBPom[0])) + "");
					binaryList.set(index, new StringBuilder(orPom).append(and.calculate()).toString());
					index++;
				}
				flag = true;
				System.out.println();
				variableList.add(and.getOperation());
				queueVariables.Push(and.getOperation(), 0);
				queueValues.Push(String.valueOf(getVariableColumn(and.getOperation())), 0);

			default:
				if (flag == false) {
					queueVariables.Push(pom, 0);
					queueValues.Push(String.valueOf(getVariableColumn(pom)), 0);
				}
				break;
			}

		}
	}

	public void printPrimaryVariablesMatrix() {
		Iterator<String> binaryIterator = binaryList.iterator();
		Iterator<String> variableIterator = variableList.iterator();

		while (variableIterator.hasNext()) {
			System.out.print(" # " + variableIterator.next().toString() + " # ");
		}
		System.out.println();
		String pom;
		while (binaryIterator.hasNext()) {
			pom = binaryIterator.next();
			for (int i = 0; i < pom.length(); i++) {
				System.out.print(" # " + pom.charAt(i) + " # ");

			}
			System.out.println();
		}
	}

	private void setToArray() {
		Iterator<String> binaryIterator = helper.getBinaryMatrix().iterator();
		Iterator<String> variableIterator = helper.getVariables().iterator();

		while (variableIterator.hasNext()) {
			variableList.add(variableIterator.next().toString());
		}

		while (binaryIterator.hasNext()) {
			binaryList.add(binaryIterator.next());
		}
	}

	private int getVariableColumn(String variable) {
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
