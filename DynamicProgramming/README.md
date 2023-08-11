# Dynamic Programming

## Search

When a given problem is composed of multiple subproblems, we can keep on breaking down the problem and ultimately CONSTRUCT the BIGGER problem using all the SUB-PROBLEMS.

When analyzing your **search space**, always draw a **Tree**.

The time complexity of the search problenm depends on: <br>
1. The depth of the search space tree
2. The number of children of each node

**The most important part of all search problem, or any dynamic programming problem, is to define your *state* well. Make sure every subproblem can be described as a *state*.**


### Top Down DFS

1. Define STATE of subproblems<br>
2. Initialize Initial State<br>
3. Call dfs on Initial State<br>

**dfs High Level Idea**: 
1. Base Case <br>
2. For each subproblem x: <br>
   a. Update *state* <br>
   b. Call dfs on next state (branch down) <br>
   c. **Restore *state*** <br>

**ex. Subsets**

After drawing out search space, I would like my base case to be once I am at a leaf node, add that subset to my answer.

For this, I would need a **traverser/index/level** to keep track of at *which level of the search space tree* am I in. **Lets call that k**

**Note: You have to know index k is that INDEX OF WHAT (of input array? of a collection of data?)**

Therefore, for each subproblem I have a current state consisting of **the current subset appearance** and the **index for that state**.

This is the magic of search problems. We defined a state ourselves using our brain, formed a tree, and traversed that tree.

## Search + Memoization

