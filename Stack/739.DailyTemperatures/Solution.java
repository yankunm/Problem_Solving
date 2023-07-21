class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        // Initialize Stack
        Deque<Integer> stack = new ArrayDeque<>();

        // Loop over temperatures backwards to find "next warmer"
        for(int i = temperatures.length - 1; i >= 0; i--){
            // pop all elements until top is warmer or until empty
            while(!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]){
                stack.pop();
            }
            // if there is next element
            if(!stack.isEmpty()){
                answer[i] = stack.peek() - i;
            } else {
                answer[i] = 0;
            }
            stack.push(i);
        }

        return answer;
    }
}

/**

Approach: Monotonic Decreasing Stack

Time: O(n)
Space: O(n)

ArrayDeque:

[73,74,75,71,69,72,76,73]
[ 1, 1, 4, 2, 1, 1, 0, 0]
 0   1  2  3  4  5  6  7

0,73
1,74
2,75
6,76

 1. Initialize Stack: store indices of array elements
 2. For each element arr[i] in array backwards
    -get rid of top element until found next top
    -calulate distance from arr[i] to index to top of stack
    -repeat

Previous Answer:

public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++){
            int j = i;
            while(j < temperatures.length && temperatures[j] <= temperatures[i]){
                j++;
            }
            if(j >= temperatures.length){
                answer[i] = 0;
            } else {
                answer[i] = j - i;
            }
        }
        return answer;
    }
 */
