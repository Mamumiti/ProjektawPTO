package awPTO;

public class Queue {
	private Task[] stack;
	private int head, quantinity;

	public Queue(int quantinity) {
		this.quantinity = quantinity + 1;
		stack = new Task[this.quantinity];
		head = 0;
	}
	public void Push(String name, int priority) {
		Task newElement = new Task(name, priority);

		stack[++head] = newElement;
		int pos = head;
		while (pos != 1 && newElement.getPriority() > stack[pos / 2].getPriority()) {
			stack[pos] = stack[pos / 2];
			pos /= 2;
		}
		stack[pos] = newElement;
	}
	public boolean isEmpty() {
		return head == 0;
	}

	public boolean isFull() {
		return head == quantinity - 1;
	}

	public Task Pop() {
		int parent, child;
		Task element, temp;
		if (isEmpty()) {
			return null;
		}
		element = stack[1];
		temp = stack[head--];

		parent = 1;
		child = 2;
		while (child <= head) {
			if (child < head && stack[child].getPriority() < stack[child + 1].getPriority())
				child++;
			if (temp.getPriority() >= stack[child].getPriority())
				break;
			stack[parent] = stack[child];
			parent = child;
			child *= 2;
		}
		stack[parent] = temp;

		return element;
	}
}
