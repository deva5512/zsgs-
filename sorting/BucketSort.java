package Sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BucketSort {
	public static void main(String[] args) {
		int[] arr = { 12, 25, 31 };
		bucketSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void bucketSort(int[] nums) {

		// Fins the no of buckets by using the formula square root of max value plus 1
		int max = Arrays.stream(nums).max().getAsInt();
		int noOfBuckets = (int) Math.sqrt(Math.ceil(max)) + 1;

		// Create a array of list for the size of number of buckets
		List<Integer>[] buckets = new List[noOfBuckets];

		// Add Separate linked lists in each indexes
		int i = 0;
		for (; i < buckets.length; i++)
			buckets[i] = new LinkedList<>();

		// Store the values in the array indexes based on its hash value
		for (i = 0; i < nums.length; i++) {
			int index = hash(nums[i], noOfBuckets);
			buckets[index].add(nums[i]);
		}

		// Sort each and every indexes separately and add it in the original array
		i = 0;
		for (List<Integer> index : buckets) {
			Collections.sort(index);
			for (int j = 0; j < index.size(); j++)
				nums[i++] = (int) index.get(j);
		}
	}

	// Hashing is calculated by the value divided by number of buckets
	public static int hash(int val, int noOfBuckets) {
		return val / noOfBuckets;
	}
}
