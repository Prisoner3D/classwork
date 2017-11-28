package lab3_4;

public class Heap {
	public int[] heap;
	public int max;
	
	public Heap(int[] heap)
	{
		this.heap = heap;
		this.max = heap.length;
		makeHeap();
	}
	
	public int getRight(int index)
	{
		return index * 2 + 2;
	}
	
	public int getLeft(int index)
	{
		return index * 2 + 1;
	}
	
	public int getParent(int index)
	{
		return (index-1)/2;
	}
	
	public void heapSort()
	{
		while (max > 0)
		{
			//main.printArray(heap);
			heapSomething(0);
			swap(heap, 0, max-1);
			max--;
		}
		
	}
	
	public void makeHeap()
	{
		int last = max -1;
		int parent = getParent(last);
		
		for (int i = parent; i > 0; i--)
		{
			heapSomething(i);
		}
	}
	
	public void heapSomething(int index) {
		int left = getLeft(index);
		int right = getRight(index);
		//System.out.println(left + " " + right + " " + index);
		int minVal = index;
		if (left < max && heap[left] > heap[minVal]) {
			minVal = left;
		}
		if (right < max && heap[right] > heap[minVal]) {
			minVal = right;
		}
		boolean swap = heap[minVal] != heap[index];
		if (swap)
		{
			swap(this.heap, minVal, index);
			heapSomething(minVal);
		}
	}
	
	private void swap(int[] a, int i, int j)
	{
	    int temp = a[i];
	    a[i] = a[j];
	    a[j] = temp;
	}

}
