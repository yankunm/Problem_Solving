class Solution {
    /**
     * Given: An array x
     * i*, j* = argmax_[i, j](x[j] - x[i]), st:
        i, j in Z_[+], 
        0 <= i < j <= x.length - 1
     *
     */
    public int maxProfit(int[] prices) {
        // Check
        if(prices.length <= 1) return 0;
        
        // Initialize
        int left = 0;
        int right = 1;
        int max = 0;
 
        // Sliding Window Assignment
        while(right < prices.length){
            if(prices[right] < prices[left]) {
                left = right;
            } else if(prices[right] - prices[left] > max){
                max = prices[right] - prices[left];
            }
            right++;
        }

        // Finalize
        return max;
    }
}
/**
Given: An array of prices where prices[i] is the price of a given stock on the ith day
Find: The maximum increase from left to right


Intuition: Sliding Window

Sliding Window definition: left of window is on the least element, right of window is on the max element after the left.


High Level Idea:
1. Check if prices has only 1 element
2. Inititalize left on 0th element and right on 1st element, max to store least integer value
3. For every element right encountered:
    a. if that is less than left then move left there
    b. else if right - left > max then update max
4. Return max



 */
