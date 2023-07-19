class Solution {

    // This is the powerSet of nums
    private List<List<Integer>> powerSet = new ArrayList<>();
    int k;

    private void backtrack(List arr, int start, int[] nums){
        if(arr.size() == k){
            powerSet.add(new ArrayList(arr));
        } else {
            // Loop through all possible state spaces at that k
            for(int i = start; i < nums.length; i++){
                arr.add(nums[i]);
                backtrack(arr, i + 1, nums);
                arr.remove(arr.size() - 1);
            }
        }

    }

    // Return the power set using backtracking
    public List<List<Integer>> subsets(int[] nums) {
        // Initialize
        List<Integer> arr = new ArrayList<>(); // result array

        // Loop
        for(k = 0; k < nums.length+1; k++){
            backtrack(arr, 0, nums);
        }

        // Finalize
        return powerSet;
    }
}
