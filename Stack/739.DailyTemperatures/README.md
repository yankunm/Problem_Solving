# 739. Daily Temperatures

Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.


_______________________________________________________________

Intuition 1: Two Pointers in Same Direction

/**
[30,40,50,60]
 0  1  2  3

for every element in temperatures:
    int j = i
    while temperatures at j is not warmer and jis less than temp.length
        advance j to look for warmer temperature
    if j ran out and haven't found one then make answer[i] = 0
    Make answer[i] = j - i if found
    

ex.1 
[73,74,75,71,69,72,76,73]
 0  1  2  3  4  5  6  7

1-st day = 73 degrees F
2-nd day = 74 degrees F

answer = [1, 1, 4, 2, 1, 1, 0, 0]
          0  1  2  3  4  5  6  7

answer[1] = number of days you have to wait after the 1st day to get a warmer temperature = 1 - 0
answer[2] = how many days do you have to wait to get warmer = 3 - 2
answer[?] = future warmer index - current index
 */

 Time Limit Exceeded

 __________________________________________________________________

Approach 2: Stack


Find: the distance to the next greater element

Stack Definition: Stores all the indices of the elements to the right of arr[i], that are greater than arr[i]

This stack is monotonically Increasing. This follows from out definition of the stack.

The top of the stack: the NEXT greater element than current.


_________________________________________________________________


We want to use a stack to simply, store the *next warmer* element everytime we pop.
So since the stack will store all warmer temperatures to the right of arr[i], and it is
monotononically decreasing, we have to traverse backwards.

General Schema:

1. Initialize stack

2. For each element arr[i] backwards
  
  -pop until stack is empty OR the top element is bigger than current (we only want values to increase going down the stack)

3. Calculate distance from arr[i] to top of stack

4. Repeat



