package awPTO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Helper {

	private String inputLine;
	private Set<String> variables;
	private Set<String> binaryMatrix;
	private InToPost inToPost;
	private String workingLine; 

	public Helper(String filePath) {
		try (InputStream fis = new FileInputStream(filePath);
				InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
				BufferedReader br = new BufferedReader(isr);) {
			inputLine = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		variables = getVariablesTree();
		binaryMatrix = generateBinaryMatrix();
		inToPost = new InToPost(inputLine);
		System.out.println(inputLine);
		this.workingLine = inToPost.doTrans();
	}

	public Set<String> getVariables() {
		return variables;
	}

	public Set<String> getBinaryMatrix() {
		return binaryMatrix;
	}

	public String getLine() {
		return inputLine;
	}

	public int getVariableQuantity() {
		return variables.size();
	}

	public void addVariableToTree(String nextValue) {
		this.variables.add(nextValue);
	}

	private Set<String> getVariablesTree() {
		Set<String> tree = new TreeSet<>();
		for (char c : inputLine.toCharArray()) {
			if (Character.isLetter(c)) {
				tree.add(Character.toString(c));
			}
		}
		return tree;
	}

	public int getBinaryMatrixSize() {
		return binaryMatrix.size();
	}

	public Set<String> generateBinaryMatrix() {
		Set<String> tree = new TreeSet<>();
		for (int i = 0; i < Math.pow(2, getVariableQuantity()); i++) {
			StringBuilder st = new StringBuilder();
			for (int j = 0; j < getVariableQuantity() - Integer.toBinaryString(i).length(); j++) {
				st.append(0);
			}
			st.append(Integer.toBinaryString(i));
			tree.add(st.toString());
		}
		return tree;
	}
	
	public String getNextSymbol() {
		String pom;
		while(!workingLine.isEmpty()) {
			pom = workingLine.charAt(0)+"";
			this.workingLine = this.workingLine.substring(1);
			return pom;
		}
		return "-1";
	}
	

}
