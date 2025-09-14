## Java Code Implementation

```java
public class RemoveDuplicates {
    
    public static int removeDuplicates(int[] nums) {
        // Handle edge case: empty array
        if (nums.length == 0) {
            return 0;
        }
        
        // Initialize slow pointer
        int slow = 0;
        
        // Fast pointer starts from index 1
        for (int fast = 1; fast < nums.length; fast++) {
            // If current element is different from the last unique element
            if (nums[fast] != nums[slow]) {
                slow++;  // Move slow pointer forward
                nums[slow] = nums[fast];  // Place unique element at slow position
            }
        }
        
        // Return length of array with unique elements
        return slow + 1;
    }
    
    // Helper method to print array
    public static void printArray(int[] arr, int length) {
        System.out.print("[");
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i]);
            if (i < length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 4, 4, 5};
        
        System.out.print("Original array: ");
        printArray(nums, nums.length);
        
        int newLength = removeDuplicates(nums);
        
        System.out.println("New length: " + newLength);
        System.out.print("Array after removing duplicates: ");
        printArray(nums, newLength);
    }
}
```

**Output:**
```
Original array: [1, 1, 2, 2, 2, 3, 4, 4, 5]
New length: 5
Array after removing duplicates: [1, 2, 3, 4, 5]
```

---

## Algorithm Explanation

### Problem Statement
Remove duplicates from a **sorted** array in-place such that each element appears only once. Return the new length of the modified array.

### Two-Pointers Approach

The algorithm uses two pointers that move at different speeds:

**1. Slow Pointer (`slow`)**
- Maintains the boundary of unique elements
- Points to the last position containing a unique element
- Only advances when a new unique element is found

**2. Fast Pointer (`fast`)**
- Scans through the entire array
- Searches for elements that are different from the current unique element
- Always moves forward in each iteration

### Step-by-Step Process

1. **Initialization**: Set `slow = 0` (first element is always unique)
2. **Iteration**: Loop `fast` from index 1 to end of array
3. **Comparison**: If `nums[fast] != nums[slow]`, we found a new unique element
4. **Update**: Increment `slow` and copy `nums[fast]` to `nums[slow]`
5. **Continue**: Keep scanning until `fast` reaches the end

### Visual Walkthrough

```
Array: [1, 1, 2, 2, 2, 3, 4, 4, 5]
Index:  0  1  2  3  4  5  6  7  8

Initial state:
slow = 0, fast = 1
[1, 1, 2, 2, 2, 3, 4, 4, 5]
 ↑  ↑
slow fast

Step 1: nums[1] == nums[0] (1 == 1) → Skip
slow = 0, fast = 2

Step 2: nums[2] != nums[0] (2 != 1) → Found unique
slow = 1, nums[1] = nums[2] = 2
[1, 2, 2, 2, 2, 3, 4, 4, 5]
    ↑     ↑
   slow  fast

Step 3: nums[3] == nums[1] (2 == 2) → Skip
Step 4: nums[4] == nums[1] (2 == 2) → Skip

Step 5: nums[5] != nums[1] (3 != 2) → Found unique
slow = 2, nums[2] = nums[5] = 3
[1, 2, 3, 2, 2, 3, 4, 4, 5]
       ↑           ↑
      slow        fast

Continue this process...

Final result: [1, 2, 3, 4, 5, ...]
New length = slow + 1 = 5
```

### Key Insights

- **Why it works**: The slow pointer always points to the last unique element, so comparing with `nums[slow]` ensures we detect new unique values
- **In-place modification**: We overwrite duplicate positions with unique elements, saving space
- **Maintains order**: Original relative order of unique elements is preserved
- **Handles edge cases**: Works correctly for empty arrays and arrays with all identical elements

### Time & Space Complexity

- **Time Complexity**: O(n) - Single pass through the array
- **Space Complexity**: O(1) - Only uses two pointer variables, modifies array in-place

This algorithm is optimal for the given constraints and is commonly used in coding interviews and real-world applications where memory efficiency is important.