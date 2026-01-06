def recursive_insertion_sort(arr, n=None):
    """
    Recursively sorts a list using Insertion Sort.
    :param arr: The list of elements to be sorted.
    :param n: The current number of elements being processed.
    """
    # Initial call setup: use the full length of the array
    if n is None:
        n = len(arr)

    # Base case: A list of 0 or 1 element is already sorted
    if n <= 1:
        return

    # 1. Recursively sort the first n-1 elements
    recursive_insertion_sort(arr, n - 1)

    # 2. Insert the last element (arr[n-1]) into its correct 
    #    position in the sorted portion (arr[0..n-2])
    last_element = arr[n - 1]
    j = n - 2

    # Shift elements of arr[0..n-2] that are greater than 
    # last_element to one position ahead of their current position
    while j >= 0 and arr[j] > last_element:
        arr[j + 1] = arr[j]
        j -= 1
    
    arr[j + 1] = last_element

def main():
    """Driver code to test the algorithm."""
    data = [12, 11, 13, 5, 6]
    
    print(f"Original Array: {data}")
    
    # Sort the array in-place
    recursive_insertion_sort(data)
    
    print(f"Sorted Array:   {data}")

if __name__ == "__main__":
    main()
