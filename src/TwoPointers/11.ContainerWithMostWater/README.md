# 11. Container With Most Water

You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

______________________________________________________________________

We want x-axis between the two containers to be as long as possible, we also want the height of the two walls of the container as long as possible.

To keep x-axis as long as possible, we can have two-pointers that come in from both sides, calculate every area there is, and keep track of the maximum.

Intuition 1: Two Pointers in opposite directions 

1. Build intuition through graphics
2. Write Pseudocode
3. Write Actual Code

