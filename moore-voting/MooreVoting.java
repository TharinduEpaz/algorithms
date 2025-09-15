public class MooreVoting {
    
    // Method to find majority element
    public static int findMajorityElement(int[] nums) {
        // Phase 1: Find candidate
        int candidate = 0;
        int count = 0;
        
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        
        return candidate;
    }
    
    // Method with verification step
    public static int findMajorityElementWithVerification(int[] nums) {
        // Phase 1: Find candidate
        int candidate = findMajorityElement(nums);
        
        // Phase 2: Verify if candidate is actually majority
        int actualCount = 0;
        for (int num : nums) {
            if (num == candidate) {
                actualCount++;
            }
        }
        
        // Check if candidate appears more than n/2 times
        if (actualCount > nums.length / 2) {
            return candidate;
        } else {
            return -1; // No majority element exists
        }
    }
    
    public static void main(String[] args) {
        // Test cases
        int[] arr1 = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        int[] arr2 = {3, 3, 4, 2, 4, 4, 2, 4};
        int[] arr3 = {1, 1, 1, 1, 2, 3, 4};
        
        System.out.println("Array 1: " + java.util.Arrays.toString(arr1));
        System.out.println("Majority element: " + findMajorityElement(arr1));
        System.out.println("With verification: " + findMajorityElementWithVerification(arr1));
        System.out.println();
        
        System.out.println("Array 2: " + java.util.Arrays.toString(arr2));
        System.out.println("Majority element: " + findMajorityElement(arr2));
        System.out.println("With verification: " + findMajorityElementWithVerification(arr2));
        System.out.println();
        
        System.out.println("Array 3: " + java.util.Arrays.toString(arr3));
        System.out.println("Majority element: " + findMajorityElement(arr3));
        System.out.println("With verification: " + findMajorityElementWithVerification(arr3));
    }
}