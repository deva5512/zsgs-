package PreparationQuestions;

public class DeleteLastElementAndMoveKthElement_29_04_2023 {

	public static void main(String[] args) {
		LinkedListPro l = new LinkedListPro();
		// 7 -> 16 -> 100 -> 33 -> 21-> 9 -> 63 -> 11 -> 49 -> 199 -> 59
		l.add(7);
		l.add(16);
		l.add(100);
		l.add(33);
		l.add(21);
		l.add(9);
		l.add(63);
		l.add(11);
		l.add(49);
		l.add(199);
		l.add(59);
		l.toString();
		l.deleteAndAdd(6);
		System.out.println();
		l.toString();
	}

}

class LinkedListPro {

	Node head;

	static class Node {
		int val;
		Node next;

		public Node(int val) {
			this.val = val;
		}
	}

	public void add(int val) {
		Node n = new Node(val);
		if (head == null) {
			head = n;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = n;
		}
	}

	public void deleteAndAdd(int index) {
		Node temp = head;
		int val = 0;

		while (temp.next.next != null) {
			if (index == 1) {
				val = temp.next.val;
				temp.next = temp.next.next;
				index--;
			} else {
				temp = temp.next;
				index--;
			}
		}
		temp.next.val = val;
	}

	public String toString() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		return "";
	}

}
