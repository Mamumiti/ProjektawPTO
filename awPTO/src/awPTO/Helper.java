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

	private String line;
	private Set<String> variables;
	private Set<String> binaryMatrix;

	public Helper(String filePath) {
		try (InputStream fis = new FileInputStream(filePath);
				InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
				BufferedReader br = new BufferedReader(isr);) {
			line = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		variables = getVariablesTree();
		binaryMatrix = generateBinaryMatrix();
	}

	public String getLine() {
		return line;
	}

	public int getVariableQuantity() {
		return variables.size();
	}

	private Set<String> getVariablesTree() {
		Set<String> tree = new TreeSet<>();
		for (char c : line.toCharArray()) {
			if (Character.isLetter(c)) {
				tree.add(Character.toString(c));
			}
		}
		return tree;
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

}
