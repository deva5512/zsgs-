package LinkedList;

public class LList implements LocalList {
	private long len = 0;
	Node head;

	class Node {
		int val;
		Node next;

		Node(int num) {
			val = num;
		}
	}

	@Override
	public void add(int num) {
		Node n = new Node(num);
		if (head == null) {
			head = n;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}

			temp.next = n;
		}
		len++;
	}

	@Override
	public void print() {
		if (head == null) {
			System.out.println("List is empty");
		} else {
			Node temp = head;

			while (temp != null) {
				System.out.print(temp.val + " ");
				temp = temp.next;
			}
		}
		System.out.println();
	}

	@Override
	public void remove() {
		if (head == null) {
			System.out.println("List is empty");
			return;
		} else if (len == 1) {
			head = null;
		} else {
			Node temp = head;
			for (int i = 1; i < len - 1; i++) {
				temp = temp.next;
			}
			temp.next = null;
		}
		len--;
	}

	@Override
	public long size() {
		return len;
	}

	@Override
	public void add(int index, int num) {
		if (index > len) {
			throw new IndexOutOfBoundsException("length : " + len);
		}
		if (index < 0) {
			throw new IndexOutOfBoundsException("Negitive number");
		}
		Node n = new Node(num);
		if (index == 0) {
			n.next = head;
			head = n;
		} else {
			Node temp = head;
			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}
			n.next = temp.next;
			temp.next = n;
		}
		len++;
	}

	@Override
	public void remove(int index) {
		if (index > len) {
			throw new IndexOutOfBoundsException("length : " + len);
		}
		if (index < 0) {
			throw new IndexOutOfBoundsException("Negitive number");
		}
		if (index == 0) {
			head = head.next;
		} else {
			Node temp = head;
			for (int i = 0; i < index - 1; i++) {
				if (i == len - 2) {
					temp.next = null;
					return;
				}
				temp = temp.next;
			}
			temp.next = temp.next.next;
		}
		len--;
	}

	@Override
	public String toString() {
		if (len == 0) {
			System.out.println("[ ]");
			return "";
		}
		System.out.print("[ ");
		Node temp = head;
		System.out.print(temp.val);
		temp = temp.next;
		while (temp != null) {
			System.out.print(", " + temp.val);
			temp = temp.next;
		}
		System.out.print(" ]\n");

		return "";
	}

	@Override
	public void clear() {
		head = null;
		len = 0;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

}
