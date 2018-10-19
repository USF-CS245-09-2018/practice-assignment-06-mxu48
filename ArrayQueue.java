import java.util.*;
public class ArrayQueue implements Queue  {

	private Object [] arr;
	private int head;
	private int tail;
	private int size;

	public ArrayQueue() {
		int max = 10;
		arr = new Object[max];
		head = 0;
		tail = 0;
		size = 0;
	}

	public void enqueue (Object item) {
		/* If full */
		if(size == arr.length) {
			doubleArr(arr, head, tail);
		} 

		tail = size % arr.length;
		arr[tail] = item;
		size++;
	}

	public Object dequeue() {
		if(empty()) {
			System.out.println("Array Queue is empty");
		}
		Object remove = arr[head];
		head = head + 1;
		size--;

		if(size == 0) {
			head = 0;
			tail = 0;
		}
		if(head == arr.length) {
			head = 0;
		} 
		return remove;
	}

	public boolean empty() {
		return head == tail;
	}

	public void doubleArr (Object [] arr, int head, int tail) {
		Object [] newArr = new Object [arr.length*2];
		int start = head; 
		for(int i = 0; i <= size; i++) {
			newArr[i] = arr[start];
			start = (start+1) % size; /* Account for circular */
		}
		head = 0;
		tail = size; 
		arr = newArr;
	}

}


