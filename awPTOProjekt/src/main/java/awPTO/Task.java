package awPTO;

public class Task {
	private String elementName;
	private int priority;

	public Task(String name, int priority) {
		this.elementName = name;
		this.priority = priority;
	}

	public String getName() {
		return elementName;
	}

	public void setName(String name) {
		this.elementName = name;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "N:" + elementName + ", P:" + priority;
	}
}
