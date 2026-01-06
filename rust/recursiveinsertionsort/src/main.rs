/// Recursively sorts a slice using the Insertion Sort algorithm.
fn recursive_insertion_sort<T: PartialOrd + Copy>(slice: &mut [T], n: usize) {
    // Base case: A slice of 1 or 0 elements is already sorted
    if n <= 1 {
        return;
    }

    // 1. Recursively sort the first n-1 elements
    recursive_insertion_sort(slice, n - 1);

    // 2. Insert the last element of the current range into its sorted position
    let last = slice[n - 1];
    let mut j = (n - 1) as i32 - 1;

    // Shift elements that are greater than 'last' to the right
    while j >= 0 && slice[j as usize] > last {
        slice[(j + 1) as usize] = slice[j as usize];
        j -= 1;
    }
    
    slice[(j + 1) as usize] = last;
}

fn main() {
    let mut data = vec![12, 11, 13, 5, 6];
    
    println!("Original array: {:?}", data);

    let n = data.len();
    // Start recursion with the length of the vector
    recursive_insertion_sort(&mut data, n);

    println!("Sorted array:   {:?}", data);
}
