package awPTO;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import awPTO.Gates.*;


public class Primary {

	private Helper helper;
	private OR or;
	private AND and;
	private XOR xor;
	private NOR nor;
	private NAND nand;
	private NOT not;
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
		xor = new XOR();
		nand = new NAND();
		nor = new NOR();
		setToArray();

	}

	public void printPrimaryVariablesMatrix() {
		calculateInput();
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
		Iterator<String> variableIterator = variableList.iterator();
		Set<String> s = helper.getVariables();
		while (variableIterator.hasNext()) {
			if (variableIterator.next().indexOf(variable) != -1) {
				return i;
			}
			i++;
		}
		return -1;
	}

	
	private void calculateInput(){
		String pom = "";
		String queueVPom[] = new String[4];
		String queueBPom[] = new String[4];
		boolean notFlag = false;
		String lastSymbol;
		for (int i = 0; i < helper.getLine().length(); i++) {
			lastSymbol=pom;
			pom = helper.getNextSymbol();
			Iterator<String> binaryIterator;
			int index;
			
			switch (pom) {
			case "|":
				if(notFlag==false) {
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
					or.setFirstValue(orPom.charAt(Integer.parseInt(queueBPom[1])) + "");
					or.setSecondValue(orPom.charAt(Integer.parseInt(queueBPom[0])) + "");
					binaryList.set(index, new StringBuilder(orPom).append(or.calculate()).toString());
					index++;
				}
			
				variableList.add(or.getOperation());
				queueVariables.Push(or.getOperation(), 0);
				String a = or.getOperation();
				queueValues.Push(String.valueOf(getVariableColumn(or.getOperation())), 0);
				}
				else
				{
					nor.setFirstSymbol(queueVariables.Pop().getName());
					nor.setSecondSymbol(queueVariables.Pop().getName());
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
						nor.setFirstValue(orPom.charAt(Integer.parseInt(queueBPom[1])) + "");
						nor.setSecondValue(orPom.charAt(Integer.parseInt(queueBPom[0])) + "");
						binaryList.set(index, new StringBuilder(orPom).append(nor.calculate()).toString());
						index++;
					}
					
					notFlag=false;
					variableList.add(nor.getOperation());
					queueVariables.Push(nor.getOperation(), 0);
					String a = nor.getOperation();
					queueValues.Push(String.valueOf(getVariableColumn(nor.getOperation())), 0);
				}
				break;
			case "&":
				if(notFlag==false) {
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
					and.setFirstValue(orPom.charAt(Integer.parseInt(queueBPom[1])) + "");
					and.setSecondValue(orPom.charAt(Integer.parseInt(queueBPom[0])) + "");
					binaryList.set(index, new StringBuilder(orPom).append(and.calculate()).toString());
					index++;
				}
			
				variableList.add(and.getOperation());
				queueVariables.Push(and.getOperation(), 0);
				queueValues.Push(String.valueOf(getVariableColumn(and.getOperation())), 0);
					break;
				}else {
					nand.setFirstSymbol(queueVariables.Pop().getName());
					nand.setSecondSymbol(queueVariables.Pop().getName());
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
						nand.setFirstValue(orPom.charAt(Integer.parseInt(queueBPom[1])) + "");
						nand.setSecondValue(orPom.charAt(Integer.parseInt(queueBPom[0])) + "");
						binaryList.set(index, new StringBuilder(orPom).append(nand.calculate()).toString());
						index++;
					}
				
					variableList.add(nand.getOperation());
					queueVariables.Push(nand.getOperation(), 0);
					queueValues.Push(String.valueOf(getVariableColumn(nand.getOperation())), 0);
				}
				break;
			case "%":
				xor.setFirstSymbol(queueVariables.Pop().getName());
				xor.setSecondSymbol(queueVariables.Pop().getName());
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
					xor.setFirstValue(orPom.charAt(Integer.parseInt(queueBPom[1])) + "");
					xor.setSecondValue(orPom.charAt(Integer.parseInt(queueBPom[0])) + "");
					binaryList.set(index, new StringBuilder(orPom).append(xor.calculate()).toString());
					index++;
				}
			
				variableList.add(xor.getOperation());
				queueVariables.Push(xor.getOperation(), 0);
				queueValues.Push(String.valueOf(getVariableColumn(xor.getOperation())), 0);
					break;
			
			case "~":
				notFlag=true;
				break;
			default:
//				if(notFlag==true) {
//					not.setSymbol((queueVariables.Pop().getName()));
//					queueBPom[0] = queueValues.Pop().getName();
//					queueBPom[1] = queueValues.Pop().getName();
//					while(!queueValues.isEmpty())
//					{
//						queueValues.Pop();
//					}
//
//					binaryIterator = binaryList.iterator();
//					index = 0;
//					while (binaryIterator.hasNext()) {
//						String orPom = binaryIterator.next();
//						not.setValue(orPom.charAt(Integer.parseInt(queueBPom[1])) + "");
//						binaryList.set(index, new StringBuilder(orPom).append(not.calculate()).toString());
//						index++;
//					}
//				
//					variableList.add(not.getOperation());
//					queueVariables.Push(not.getOperation(), 0);
//					queueValues.Push(String.valueOf(getVariableColumn(not.getOperation())), 0);
//				}
					queueVariables.Push(pom, 0);
					queueValues.Push(String.valueOf(getVariableColumn(pom)), 0);
				
				break;
			}

		}
	}
}
