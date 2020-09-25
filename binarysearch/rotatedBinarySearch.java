package binarysearch;

public class rotatedBinarySearch {
	public static void main (String args[]) {
		int loop = 10000;
		int arr[] = new int [loop];
		for (loop=100; loop < arr.length; ++loop) {
			arr[loop] = loop+1;
			if (loop == 99)
				break;
			if (loop == (10000 - 1))
				loop = 0;
		}
		
		System.out.println(rotatedSearch(arr, 0, arr.length - 1, 987));
		System.out.println(rotatedSearchItr(arr, 987));
	}
	
	public static int rotatedSearchItr(int arr[], int key) {
		for (int start=0, end = arr.length - 1; start<=end;) {
			int mid = start + (end-start)/2;
			if (arr[mid] == key)
				return mid;
			if (arr[start] < arr[mid]) {
				if ((key > arr[start]) && (key < arr[mid]))
					end = mid - 1;
				else
					start = mid + 1;
			} else {
				if ((key > arr[mid]) && (key < arr[end]))
					start = mid + 1;
				else
					end = mid - 1;
			}
		}
		return -1;
	}
	
	public static int rotatedSearch(int arr[], int start, int end, int key) {
		if (start>=end)
			return -1;
		int mid = start + (end-start)/2;
		if (arr[mid] == key)
			return 1;
		else if (arr[start] < arr[mid]) {
			/* it means array is sorted */
			if ((key < arr[end]) && (key > arr[mid]))
				return rotatedSearch(arr, mid+1, end, key);
			return rotatedSearch(arr, start, mid-1, key);
		} 
		if ((key > arr[mid]) && (key < arr[end]))
			return rotatedSearch(arr, mid + 1, end, key);
		else
			return rotatedSearch(arr, start, mid - 1, key);
	}
}
