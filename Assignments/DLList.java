package LinkedList;

public class DLList implements LocalList {
	private long len = 0;
	Node head;
	Node tail;

	class Node {
		int val;
		Node next;
		Node previous;

		Node(int num) {
			val = num;
		}
	}

	@Override
	public void add(int num) {
		Node n = new Node(num);
		if (head == null) {
			head = n;
			tail = n;
			n.previous = null;
		} else {
			n.previous = tail;
			tail.next = n;
			tail = n;
		}
		len++;
	}

	@Override
	public void print() {
		if (head == null) {
			throw new NullPointerException("List is empty");
		} else {
			Node temp = head;
			System.out.print(temp.val + " ");
			while (temp != tail) {
				temp = temp.next;
				System.out.print(temp.val + " ");
			}
		}
		System.out.println();
	}

	public void printReverse() {
		if (head == null) {
			throw new NullPointerException("List is empty");
		} else {
			Node temp = tail;
			System.out.print(temp.val + " ");
			while (temp != head) {
				temp = temp.previous;
				System.out.print(temp.val + " ");
			}
		}
		System.out.println();
	}

	@Override
	public void remove() {
		if (head == null) {
			throw new NullPointerException("List is empty");
		} else if (len == 1) {
			head = null;
		} else {
			tail = tail.previous;
			tail.next = null;
		}
		len--;
	}

	@Override
	public long size() {
		return len;
	}

	@Override
	public String toString() {
		if (head == null) {
			System.out.println("[ ]");
			return "";
		}
		Node temp = head;
		System.out.print("[ " + temp.val);
		temp = temp.next;
		for (int i = 1; i < len; i++) {
			System.out.print(", " + temp.val);
			temp = temp.next;
		}
		System.out.print(" ]");
		return "";
	}

	@Override
	public void add(int index, int num) {
		if (index >= len) {
			throw new IndexOutOfBoundsException("length : " + len);
		}
		if (index < 0) {
			throw new IndexOutOfBoundsException("Negative index ");
		} else {
			Node n = new Node(num);
			if (index == 0) {
				head.previous = n;
				n.next = head;
				head = n;
			} else if (index == len - 1) {
				n.previous = tail;
				tail = n;
			} else {
				Node temp = head;
				for (int i = 0; i < index - 1; i++) {
					temp = temp.next;
				}
				n.next = temp.next;
				n.previous = temp;
				temp.next.previous = n;
				temp.next = n;
			}
			len++;
		}
	}

	@Override
	public void remove(int index) {
		if (index >= len) {
			throw new IndexOutOfBoundsException("length : " + len);
		}
		if (index < 0) {
			throw new IndexOutOfBoundsException("Negative index ");
		}
		if (index == 0) {
			head = head.next;
			head.previous = null;
		} else if (index == len - 1) {
			tail = tail.previous;
			tail.next = null;
		} else {
			Node temp = head;
			for (int i = 0; i < index - 1; i++) {
				temp = temp.next;
			}
			temp.next = temp.next.next;
			temp.next.previous = temp;
		}
		len--;
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
		len = 0;
	}

	@Override
	public boolean isEmpty() {
		return len == 0;
	}
}
