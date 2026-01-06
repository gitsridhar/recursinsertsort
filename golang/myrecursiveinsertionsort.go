package main

import "fmt"

// RecursiveInsertionSort sorts a slice of integers using recursion.
func recursiveInsertionSort(arr []int, n int) {
	// Base case: A slice of 1 or 0 elements is already sorted
	if n <= 1 {
		return
	}

	// 1. Recursively sort the first n-1 elements
	recursiveInsertionSort(arr, n-1)

	// 2. Insert the last element into its correct sorted position
	last := arr[n-1]
	j := n - 2

	/* Move elements of arr[0..n-2] that are greater than 'last'
	   to one position ahead of their current position */
	for j >= 0 && arr[j] > last {
		arr[j+1] = arr[j]
		j--
	}
	arr[j+1] = last
}

func main() {
	data := []int{12, 11, 13, 5, 6}
	fmt.Printf("Original slice: %v\n", data)

	// Start the recursion with the full length of the slice
	recursiveInsertionSort(data, len(data))

	fmt.Printf("Sorted slice:   %v\n", data)
}
