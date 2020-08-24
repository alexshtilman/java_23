package telran.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.numbers.SetOperations;

class SetOperationTests {

	@Test
	void testRemoveRepeated() {
		Integer arrays[][] = { { 1, 1, 1, 1, 1 }, {}, { 32, 0, 32 }, { 1, 2, 3, 4, 5 } };
		Integer expected[][] = { { 1 }, {}, { 32, 0 }, { 1, 2, 3, 4, 5 } };
		for (int i = 0; i < arrays.length; i++) {
			assertArrayEquals(expected[i], SetOperations.removeRepeated(arrays[i]));
		}
	}

	@Test
	void testIntersection() {
		int array1[] = { 1, 2, 3, 4 };
		int array2[] = { 1, 2, 8, 9 };
		int array3[] = { 1, 1, 1, 1 };

		int noIntersection[] = { 99, -3, 7 };
		int empty[] = {};
		int expected[] = { 1, 2 };
		int expected2[] = { 1 };
		assertArrayEquals(expected, SetOperations.intersection(array1, array2));
		assertArrayEquals(expected2, SetOperations.intersection(array1, array3));
		try {
			SetOperations.intersection(array1, noIntersection);
		} catch (IllegalArgumentException e) {
			// expected
		}
		try {
			SetOperations.intersection(array2, empty);
		} catch (IllegalArgumentException e) {
			// expected
		}
		try {
			SetOperations.intersection(empty, array1);
		} catch (IllegalArgumentException e) {
			// expected
		}
		try {
			SetOperations.intersection(empty, empty);
		} catch (IllegalArgumentException e) {
			// expected
		}
		try {
			SetOperations.intersection(array1, array1);
		} catch (IllegalArgumentException e) {
			// expected
		}
	}

	@Test
	void testHasRepeated() {
		int arrays[][] = { { 1, 1, 1, 1, 1 }, {}, { 32, 0, 32 }, { 1, 2, 3, 4, 5 } };
		assertTrue(SetOperations.hasRepeated(arrays[0]));
		assertFalse(SetOperations.hasRepeated(arrays[1]));
		assertTrue(SetOperations.hasRepeated(arrays[2]));
		assertFalse(SetOperations.hasRepeated(arrays[3]));
	}

	@Test
	void testUnion() {
		int array1[] = { 1, 2, 3, 4 };
		int array2[] = { 1, 2, 8, 9 };
		int array3[] = { 1, 1, 1, 1 };
		int noIntersection[] = { 99, -3, 7 };
		int empty[] = {};
		int expected[] = { 1, 2, 3, 4, 8, 9 };
		assertArrayEquals(expected, SetOperations.union(array1, array2));
		try {
			SetOperations.union(array1, noIntersection);
		} catch (IllegalArgumentException e) {
			// unexpected
			fail("unexpected");
		}
		try {
			SetOperations.union(array2, empty);
		} catch (IllegalArgumentException e) {
			// expected
		}
		try {
			SetOperations.union(empty, array1);
		} catch (IllegalArgumentException e) {
			// unexpected
			fail("unexpected");
		}
		try {
			SetOperations.union(empty, empty);
		} catch (IllegalArgumentException e) {
			// expected
		}
		try {
			SetOperations.union(array1, array1);
		} catch (IllegalArgumentException e) {
			// expected
		}
		try {
			SetOperations.union(array1, array3);
		} catch (IllegalArgumentException e) {
			// expected
		}
	}

	@Test
	void testSubstraction() {
		int array1[] = { 1, 2, 3, 4 };
		int array2[] = { 1, 2, 8, 9 };
		int array3[] = { 1, 1, 1, 1 };
		int noIntersection[] = { 99, -3, 7 };
		int empty[] = {};
		int expected[] = { 3, 4 };
		int expected2[] = { 2, 3, 4 };
		assertArrayEquals(expected, SetOperations.subtraction(array1, array2));
		assertArrayEquals(expected2, SetOperations.subtraction(array1, array3));
		try {
			SetOperations.subtraction(array1, noIntersection);
		} catch (IllegalArgumentException e) {
			// expected
		}
		try {
			SetOperations.subtraction(array2, empty);
		} catch (IllegalArgumentException e) {
			// expected
		}
		try {
			SetOperations.subtraction(empty, array1);
		} catch (IllegalArgumentException e) {
			// expected
		}
		try {
			SetOperations.subtraction(empty, empty);
		} catch (IllegalArgumentException e) {
			// expected
		}
		try {
			SetOperations.subtraction(array1, array1);
		} catch (IllegalArgumentException e) {
			// unexpected
			fail("unexpected");
		}
	}
}
