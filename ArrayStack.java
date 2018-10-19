public class ArrayStack implements Stack {
	
	private Object [] arr;
	private int top;
	private int size;

	public ArrayStack() {
		arr = new Object[10];
		top = -1;
		size = 0;
	}

	public boolean empty() {
		return top == -1;
	}

	public Object pop() {
		if(empty()) {
			System.out.println("Cannot pop.");
		} 
			
		size--;
		return arr[top--];
	}

	public void push (Object item) {
		if(size == arr.length) {
			doubleArr();
		}
		top = top+1;
		arr[top] = item;
		
		size++;
	}

	private void doubleArr() {
		Object [] newArr = new Object [arr.length * 2];
		for(int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];
		}

		arr = newArr;
	}

	public Object peek() {
		if(empty()) {
			System.out.println("Cannot peek.");
		} 
		return arr[top];
	}

}







