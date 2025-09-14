public class twoPointers {
    
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
        
        // remove duplicates using two pointers 

        int[] nums = {1, 1, 2, 2, 2, 3, 4, 4, 5};
        
        System.out.print("Original array: ");
        printArray(nums, nums.length);
        
        int newLength = removeDuplicates(nums);
        
        System.out.println("New length: " + newLength);
        System.out.print("Array after removing duplicates: ");
        printArray(nums, newLength);
        
    }
}
