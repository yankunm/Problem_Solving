class Solution {
    public int subarraySum(int[] nums, int k) {
        // Initialize Hash Table for All Prefix Sums
        HashMap<Integer, Integer> prevSumCount = new HashMap<>();
        prevSumCount.put(0, 1); // chop off a subarray of size 0

        // Initialize Current Sum and Counter for k
        int prefixSum = 0;
        int waysToMakeK = 0;

        // For each element in the array
        for(int i=0; i < nums.length; i++){
            // Extract current prefix sum
            prefixSum += nums[i];

            // Query if We can chop off a previous portion and make k
            int chopOffSum = prefixSum - k;
            if(prevSumCount.containsKey(chopOffSum)){
                // Update counter
                waysToMakeK += prevSumCount.get(chopOffSum);
            }

            // Add current prefixSum to Hash Table with correct count
            int count = prevSumCount.getOrDefault(prefixSum, 0) + 1;
            prevSumCount.put(prefixSum, count);
        }

        // Finalize
        return waysToMakeK;
    }
}

/**
Intuition 2: HashMap and Sequential Scan

Given: An array nums and an integer k
Find: How many times a subarray with sum k occurs

Use HashMap to store how many ways we can make k.
At each step, we can query "in how many ways can I chop off a portion and get k". This depends on how many times a previous sum has occurred previously (since we have negative numbers, sums have duplicates). (Note: We can always chop off a 0 summed array)

sum[until i] - a previous sum = k

    HashMap Definition:
        Key: PrefixSum
        Value: Count


Brute Force Approach: Loop through each subarray starting at each number

High Level Idea:
1. Initialize counter to count number of subarrays
2. For each element nums[i] in array - O(n)
    a. Calculate sum of every subarray starting at i - O(n)
    b. If sum == k then counter++ - O(1)
    c. else move on to next subarray starting at i O(1)
3. Return counter

Time: O(n^2)
Space: O(1)

public int subarraySum(int[] nums, int k) {
        // Initialization
        int res = 0;

        // For each element in nums
        for(int i=0; i<nums.length; i++){
            // Initialize subarray sum
            int sum = nums[i];

            // Process sum
            if(sum == k) res++;

            // Loop through each subarray starting at this number
            for(int j = i+1; j<nums.length; j++){

                // Update subarray sum
                sum += nums[j];

                // Process sum
                if(sum == k) res++;
            }
        }

        // Finalize
        return res;
    }

 */
