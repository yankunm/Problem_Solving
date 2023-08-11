class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        // Initialize current state
        List<List<Integer>> res = new ArrayList<>();
        int k = 0;
        List<Integer> curr = new ArrayList<>();

        // Call dfs on current state
        dfs(nums, res, curr, k);

        // Finalize
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> curr, int k){
        // Base Case
        if(k >= nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        // Update state: Add next element
        curr.add(nums[k]);
        dfs(nums, res, curr, k+1);

        // Update state: Do not add next element
        curr.remove(curr.size()-1);
        dfs(nums, res, curr, k+1);

        // Restore state (k is current, curr is current)
    }
}

/**

Intuition: Search Space Traversal problem


              {}.                           k = 0
            /     \.        
1.         {}       {1}                     k = 1
          /\     /        \
2.      {} {2} {1}.        {1, 2}.          k = 2
         /\  / \ ... ... ... /.  \
3.    {}{3}{2}{2,3}{1}{1,3} {1,2}{1, 2, 3}  k = 3

STATE: (index k, subset at index k)


Top Down DFS High Level Idea:
1. Base Case (If at leaf level return)
2. For each substate:
    1. Update state
        a. (k+1, add)
        b. (k+1, do not add)
    2. dfs on next state
    3. Restore state: k back to current, subset back to current

Time: O(2^n)
 */
