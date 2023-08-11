class Solution {
    public int[] twoSum(int[] nums, int target){
        // Initialize Hash Table
        HashMap<Integer, Integer> pastNums = new HashMap<>();

        // For each element in array
        for(int i=0; i<nums.length; i++){

            // if complement exists in HashMap
            int complement = target - nums[i];
            if(pastNums.containsKey(complement)) 
                return new int[]{i, pastNums.get(complement)};
            
            // else Update and advance
            pastNums.put(nums[i], i);
        }

        // Finalize
        return new int[]{-1, -1};
    }
}
/**
// Intuition 2: HashMap - Hit-or-Miss

    HashMap Definition:
        Key: nums[i]
        Value: i

    High Level Idea:
    1. For each element in array - O(n)
        a. if its complement (target - this element) exists in hashMap then return - O(1)
        b. else store itself in the hashMap and go to next element (O(1))

    Time: O(n)
    Space: O(n)

// Intuition 1: Squential Scan O(n^2)

    Exhaust all search space.
    Second loop just need to loop everything after i, because all pairs formed
    with previous numbers was already exhausted.


    * Given: An array x and a target y
    * Find:  whether j exists, st:
    *  i, j in Z_[+]
    *  i, j in [0, x.length - 1], i != j, 
    *  x[j] = y - x[i] 
    // hit-or-miss:
    // our goal is to see if complement exist in array
    public int[] twoSum(int[] nums, int target) {
        // put everything into a hash table
        //  while we are doing this, we can check if complement was added
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            // check if complement exists
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{i, map.get(complement)};
            }
            // value has to be key
            map.put(nums[i], i);
        }
        // // loop through every element in nums:
        // //  if complement exist and its index is not the same as current index then return corresponding indices
        // for(int i = 0; i < nums.length; i++){
        //     int complement = target - nums[i];
        //     if(map.containsKey(complement) && map.get(complement) != i){
        //         return new int[]{i,map.get(complement)};
        //     }
        // }
        return null;
    }
 */

    




