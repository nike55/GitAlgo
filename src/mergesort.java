
/*MERGESORT - more stable 
 *
 *In comparison to Quicksort the divide part in Mergesort is simple, 
 *while the merging part is complex
 *
 *Quicksort can sort "inline" in an existing collection, 
 *e.g. it does not have to create a copy of the collection while Mergesort requires a copy
 * 
 *Time complexity of Merge Sort: O(nLogn) in all 3 cases (worst, average and best) as merge sort always 
 *divides the array in two halves and take linear time to merge two halves
 *
 *Auxiliary Space: O(n)
 *
 *Algorithmic Paradigm: Divide and Conquer
 *
 *Sorting In Place: No in a typical implementation
 *
 *Stable: Yes
 */


public class mergesort {

	void merge(int arr[], int l, int m, int r){
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];
 
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];
 
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
		
	}
	
	void sort(int[] arr, int l, int r){
		if(l < r){
			int m = (l+r)/2;
			sort(arr, l, m);
			sort(arr, m+1, r);
			
			merge(arr, l, m, r);
		}
	}
	
	public static void main(String args[]){
		int arr[] = {12, 11, 13, 5, 6, 7};
		mergesort ob = new mergesort();
		ob.sort(arr, 0, arr.length-1);
		//System.out.println("sorted");
	}
}
