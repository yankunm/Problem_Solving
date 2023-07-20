# Two Pointers

Two Pointers, divide the array into three segments.

## Same Direction

i and j both go from left to right: <br>
[0, i): processed (saved for later) <br>
[i, j): processed (not needed) <br>
[j, array.length): unknown <br>

**Note: The reletive positions of processed data is remained the same as before.**

[1, 2, 0, 3, 0, 8] <br>
Move zeroes to the end. When two pointers go in the same direction, it will become [1, 2, 3, 8, 0, 0]. <br>
1 is before 2. 3 is before 8. --> relative positions maintained. Invariant.

Schema(Same Direction): <br>
1. Initialize two pointers i, j (usually both 0) <br>
2. While j < array.length: <br>
   If *we need array[j]* then *swap(array[i], array[j]), i++ (make i ready at next position)* <br>
   else *skip it (don't move i since its spot is not fulfilled), j++ (keep traversing using j)* <br>

Think of i as the "database traverser" and j as the "processing traverser". We save data using i, and use j to explore. <br>

This reminds me of the partition algorithm in Quicksort. <br>

## Different Directions

i and j go in opposite directions: <br>
[0, i), (j, array.length): processed <br>
[i, j]: unknown <br>

(Keep the interval parentheses consistent) 

Schema(Diff Direction): <br>
1. Initialize two pointers i = 0, j = array.length - 1 <br>
2. While i <= j: <br>
    Decide what you should do based on the value of array[i] and array[j] <br>
    Move (at least one pointer) forward <br>

   

