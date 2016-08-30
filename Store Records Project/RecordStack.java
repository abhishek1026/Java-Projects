public class RecordStack{
	
	//The private array named data is used to implement the stack for the selling process.
	private Record[] data;
	//This is a counter variable that is used to monitor the top of the stack. It is used by several methods in this class.
	private int top = 0;

	//This public constructor initializes the array to contain 100 elements. However, whenever more items are trying to push onto the stack,
	//the Resize method is used to increase the capacity of the array holding the stack.
	public RecordStack(){

		data = new Record[100];
	}
	//This method pushes record objects to the stack. If the stack is filled to capacity, the array is re-sized to allow for more elements to be added.
	public void push(Record r) {
		if (isAtCapacity()) {
			resizeStack(data.length * 2);
		}

		data[top++] = r;
	}
	//This method checks whether the stack is filled(in other words, about to overflow!).
	private boolean isAtCapacity() {
		return top == data.length;
	}
	//This method resizes the array named data whenever needed.
	private void resizeStack(int newCapacity) {
		Record[] newArray = new Record[newCapacity];
		for (int i = 0; i < top; i++) {
			newArray[i] = data[i];
		}
		data = newArray;
	}
	//This method returns the size of the stack.
	public int size() {
		return top;
	}
	//This method tries to pop a record off the stack. If the stack is already empty, the method does nothing and returns null.
	public Record pop() {
		if(top == 0){
			return null;
		}
		else{
		Record poppedRecord = data[--top];

		return poppedRecord;
		}

	}
	//This method checks whether the stack is empty.
	public boolean isEmpty(){

		return size() == 0;
	}
	//This method returns a string that displays each record belonging to the stack, with a line between each album.
	public String toString(){

		String toBeReturned = "";

		for(int i=0; i<size(); i++){


			if(i<(top-1))
				toBeReturned += data[i].toString() + "\n";

			else
				toBeReturned +=data[i].toString();
		}

		return toBeReturned;

	}
	//This method(getter) returns the member variable called data, which is a single dimensional array(containing Records) that is used to implement the stack.
	public Record[] getData(){
		
		return data;
	
	}


}