package binarysearch;

public class binarySearch {
	public static void main(String args[]) {
		int loop = 10000;
		int arr[] = new int [loop];
		for (loop=0; loop < arr.length; ++loop)
			arr[loop] = loop+1;
		
		System.out.println(search(arr, 0, arr.length - 1, 987));
		System.out.println(searchItr(arr, 987));
	}
	
	private static int searchItr(int arr[], int key) {
		for (int start = 0, end = arr.length - 1; start<=end;) {
			int mid = start + (end-start)/2;
			if (key == arr[mid])
				return mid;
			if (key > arr[mid])
				start = mid + 1;
			else
				end = mid - 1;
		}
		return 0;
	}
	
	private static int search(int []arr, int start, int end, int key) {
		if (start>=end)
			return -1;
		int mid = start + (end-start)/2;
		if (arr[mid] == key)
			return 1;
		else if (key > arr[mid]) {
			return search(arr, mid + 1, end, key);
		} else {
			return search(arr, start, mid-1, key);
		}
	}
}
