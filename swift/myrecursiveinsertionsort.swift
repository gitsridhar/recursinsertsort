import Foundation

/**
 Sorts an array using a recursive Insertion Sort approach.
 - Parameters:
   - array: The array to be sorted (passed by reference).
   - n: The number of elements currently being processed.
 */
func recursiveInsertionSort<T: Comparable>(_ array: inout [T], _ n: Int) {
    // Base case: An array of 1 or 0 elements is already sorted
    if n <= 1 {
        return
    }

    // 1. Recursively sort the first n-1 elements
    recursiveInsertionSort(&array, n - 1)

    // 2. Insert the last element (at index n-1) into its 
    //    correct position in the sorted portion (0..<n-1)
    let last = array[n - 1]
    var j = n - 2

    // Move elements of array[0..<n-1] that are greater than 'last'
    // to one position ahead of their current position
    while j >= 0 && array[j] > last {
        array[j + 1] = array[j]
        j -= 1
    }
    
    array[j + 1] = last
}

// MARK: - Main Execution
func main() {
    var data = [12, 11, 13, 5, 6]
    
    print("Original Array: \(data)")
    
    // Start recursion with the total count of the array
    recursiveInsertionSort(&data, data.count)
    
    print("Sorted Array:   \(data)")
}

// Invoke the driver code
main()
