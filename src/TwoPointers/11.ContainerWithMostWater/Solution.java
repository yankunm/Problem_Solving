class Solution {

    private int calculateArea(int[] height, int i, int j){
        return Math.min(height[i], height[j]) * (j - i);
    }

    public int maxArea(int[] height) {
        // Initialize
        int max = 0;
        int i = 0;
        int j = height.length - 1;

        // Loop Assignment
        while(i < j){
            max = Math.max(max, calculateArea(height, i, j));
            if(height[i] < height[j])
                i++;
            else
                j--;
        }

        // Finalize
        return max;
    }
}

/**
[1,8,6,2,5,4,8,3,7]

1st line: (1, 0) --> (1, 1)
...
3rd line: (3, 0) --> (3, 6)

2nd line: height[2-1] = 8
9th line: height[9-1] = 7
x-axis length = 9 - 2 = 7

7(7) = 49 = most area of water between two lines

Optimize the amount of area between two lines.

[1,2,6,8,5,4,19,3,7]
 
             ji  

Repeat while i < j (when they don't meet)

 Propose: Move whichever height is smaller inside
        If they are equal then move anyone inside

 calculateArea(height, 0, height.length) --> first step
    --> the smaller of the two numbers, min(height[i], height[j]),
        multiplied by j - i

        e.g.
            i = 1 --> height[i] = 8
            j = 8 --> height[j] = 7
            min(height[i], height[j]) = 7
                * (8 - 1) = 49 = max

Pseudocode:

maxArea(height):
    sum := 0
    i = 0
    j = height.length - 1

    while i < j do:
        sum = max(sum, calculateArea(height, i, j))
        if(height[i] < height[j])
            i++
        else 
            j--

 */
