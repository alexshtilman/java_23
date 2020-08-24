package telran.numbers;

import java.util.*;

public class SetOperations {
	/**
	 * 
	 * @param array
	 * @return array with no repeated numbers additional requirement: one code line
	 */
	public static Integer[] removeRepeated(Integer array[]) {
		// return Arrays.stream(array).distinct().toArray();
		return new HashSet<Integer>(Arrays.asList(array)).toArray(new Integer[0]);
	}

	/**
	 * 
	 * @param ar1
	 * @param ar2
	 * @return array of common integers from two received arrays throws
	 *         IllegalArgumentException if at least one array from the received has
	 *         the repeated numbers ar1 -> {1,2,3,4}, ar2 -> {1,2,8,9} => result ->
	 *         {1,2}
	 */
	public static int[] intersection(int array1[], int array2[]) {
		HashSet<Integer> ar1 = new HashSet<Integer>(Arrays.asList(toInteger(array1)));
		HashSet<Integer> ar2 = new HashSet<Integer>(Arrays.asList(toInteger(array2)));
		boolean intersect = ar1.retainAll(ar2);
		if (!intersect)
			throw new IllegalArgumentException();
		return toInt(ar1);
	}

	/**
	 * 
	 * @param array
	 * @return true if the array has the repeated numbers
	 */
	public static boolean hasRepeated(int array[]) {
		if (array.length == 0)
			return false;
		return removeRepeated(toInteger(array)).length != array.length;
	}

	/**
	 * 
	 * @param ar1
	 * @param ar2
	 * @return union of ar1 and ar2 (all elements of ar1 + elements of ar2 that
	 *         don't exist in ar1) throws IllegalArgumentException if at least one
	 *         array from the received has the repeated numbers ar1 -> {1,2,3,4},
	 *         ar2 -> {1,2,8,9} => result -> {1,2,3,4,8,9}
	 */
	public static int[] union(int array1[], int array2[]) {
		HashSet<Integer> ar1 = new HashSet<Integer>(Arrays.asList(toInteger(array1)));
		HashSet<Integer> ar2 = new HashSet<Integer>(Arrays.asList(toInteger(array2)));
		boolean uni = ar1.addAll(ar2);
		if (!uni || (array1.length == 0 && array2.length == 0))
			throw new IllegalArgumentException();

		return toInt(ar1);
	}

	/**
	 * 
	 * @param ar1
	 * @param ar2
	 * @return array of elements from ar1 that don't exist in ar2 throws
	 *         IllegalArgumentException if at least one array from the received has
	 *         the repeated numbers ar1 -> {1,2,3,4}, ar2 -> {1,2,8,9} => result ->
	 *         {3,4}
	 */
	public static int[] subtraction(int array1[], int array2[]) {
		HashSet<Integer> ar1 = new HashSet<Integer>(Arrays.asList(toInteger(array1)));
		HashSet<Integer> ar2 = new HashSet<Integer>(Arrays.asList(toInteger(array2)));
		boolean sub = ar1.removeAll(ar2);
		if (!sub || (array1.length == 0 && array2.length == 0))
			throw new IllegalArgumentException();

		return toInt(ar1);
	}

	public static int[] toInt(HashSet<Integer> set) {
		int[] a = new int[set.size()];
		int i = 0;
		for (Integer val : set)
			a[i++] = val;
		return a;
	}

	public static Integer[] toInteger(int array[]) {
		Integer[] intArray = new Integer[array.length];
		for (int i = 0; i < array.length; i++) {
			intArray[i] = Integer.valueOf(array[i]);
		}
		return intArray;
	}
}
