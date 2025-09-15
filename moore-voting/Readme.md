# Moore Voting Algorithm

The **Moore Voting Algorithm** is an efficient algorithm used to find the majority element in an array - an element that appears more than n/2 times where n is the array length. It works in **O(n) time complexity** and **O(1) space complexity**.

## How It Works

The algorithm uses two variables:
- **`candidate`**: stores the potential majority element
- **`count`**: tracks the "votes" for the current candidate

The key insight is that if we cancel out each occurrence of an element with an occurrence of a different element, the majority element will still remain.

## Algorithm Steps

1. Initialize `candidate` and `count`
2. For each element in the array:
   - If `count` is 0, set current element as `candidate`
   - If current element equals `candidate`, increment `count`
   - Otherwise, decrement `count`
3. The `candidate` at the end is the potential majority element
4. Verify by counting actual occurrences (optional verification step)