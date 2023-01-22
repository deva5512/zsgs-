package LinkedList;

public interface LocalList {
	void add(int num);

	void add(int index, int num);

	void remove();

	void remove(int index);

	void print();

	long size();

	void clear();

	boolean isEmpty();
}
