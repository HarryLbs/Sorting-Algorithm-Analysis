public class QuickSort {
	public int comparisons = 0;
    public int movements = 0;

	public void quickSort(int[] list) {
		quickSort(list, 0, list.length-1);
	}
	
	public void quickSort(int[] list, int first, int last) {
		if (last > first) {
			comparisons++;
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex -1);
			quickSort(list, pivotIndex + 1, last);
		}
	}
	
	/** Partition the array list[first..last] */
	public int partition(int[] list, int first, int last) {
		int pivot = list[first]; // Choose the first element as the pivot
		int low = first + 1; // Index for forward search
		int high = last; //Index for backward search
		
		while (high > low) {
			// Search forward from left
			comparisons++;
			while (low <= high && list[low] <= pivot){
				low++;
				comparisons++;
			}
			
			// Search backward from right
			while (low <= high && list[high] > pivot){
				comparisons++;
				high--;
			}
				
			
			//	Swap two elements in the list
			if (high > low) {
				comparisons++;
				movements++;
				int temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}
		
		while (high > first && list[high] >= pivot){
			high--;
			comparisons++;
		}
			
		
		//	Swap pivot with list[high]
		comparisons++;
		movements++;
		if (pivot > list[high]) {
			list[first] = list[high];
			list[high] = pivot; 
			return high;
		}
		else {
			return first;
		}
	}
}
