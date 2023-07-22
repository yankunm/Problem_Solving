class Solution {

    private void swap(char[] s, int l, int r){
        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;
    }

    private void reverseStringHelper(char[] s, int l, int r){
        if(l >= r){
            return;
        }
        swap(s, l, r);
        reverseStringHelper(s, ++l, --r);
    }

    public void reverseString(char[] s) {
        reverseStringHelper(s, 0, s.length-1);
    }
}

/**
Top-Down Recursion

Base Case:

Only one character left or left pointer crossed right pointer

1. Do work at current level

Swap first and last character

2. Recur down to subproblem
 */
