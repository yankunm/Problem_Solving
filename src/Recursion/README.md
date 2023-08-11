# Recursion

**Ex(1) Reverse String**


Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.

Note: O(1) space means we should have independent subproblems without ANY additional space consumtion using recursion.

This means a top-down approach. WE ARE GOING FROM OUTSIDE IN.

1. Do work at current level
2. Go to the subproblem to do work

In the base case, we return with the simplest subproblem.

Note: we may also need to create a helper to advance the pointers.

Top-Down Recursion: <br>
1. Swap leading and trailing characters in place <br>
2. reverseString(str[1..n-2])

Bottom-Up Recursion: <br>
1. Call function recursively to reverse the smaller substring and block until that is complete <br>
2. Swap the leading and trailing characters <br>

*It is better to use Top-Down Recursion, so we can optimize using tail recursion techiniques.*



