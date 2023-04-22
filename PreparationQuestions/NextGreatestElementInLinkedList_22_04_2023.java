package PreparationQuestions;

import java.util.Scanner;

/*		3. You are given the head of a linked list with n nodes.
		For each node in the list, find the value of the next greater node. That is, for each node, find the value of the first node that is next to it and has a strictly larger value than it.
		Return an integer array answer where answer[i] is the value of the next greater node of the ith node (1-indexed). If the ith node does not have a next greater node, set answer[i] = 0.
		
				Example: Input: head = [2,7,4,3,5]
					Output: [7,0,5,5,0]
 */

public class NextGreatestElementInLinkedList_22_04_2023 {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		LinkedListEx list = new LinkedListEx();
		System.out.println("Enter the length of the linked list : ");
		int size = scanner.nextInt();

		for (int i = 0; i < size; i++) {
			System.out.print("Enter the Element " + i + " : ");
			list.add(scanner.nextInt());
		}

		System.out.print("\nThe list is : ");
		System.out.println(list);

		if (list.size == 0) {
			System.out.println("Invalid");
			return;
		}

		for (int i = 0; i < list.size; i++) {
			int val = list.get(i);
			boolean changed = true;
			for (int j = i + 1; j < list.size; j++) {
				if (list.get(j) > val) {
					changed = false;
					list.Changevalue(i, list.get(j));
					break;
				}
			}
			if (changed) {
				list.Changevalue(i, 0);
			}
		}
		System.out.println(list);
	}

}

class LinkedListEx {

	Node head;
	int size;

	public LinkedListEx() {
		this.head = null;
	}

	static class Node {
		int val;
		Node next;

		Node(int val) {
			this.val = val;
		}
	}

	public void add(int num) {
		Node n = new Node(num);
		if (head == null) {
			head = n;
		} else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;
			temp.next = n;
		}
		size++;
	}

	public String toString() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		return "";
	}

	public void Changevalue(int index, int val) {
		if (index >= size || index < 0) {
			return;
		}
		Node temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		temp.val = val;
	}

	public int get(int index) {
		if (index >= size || index < 0) {
			return -1;
		}
		Node temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp.val;
	}

}
