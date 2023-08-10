# Dynamic Programming

## Search

When a given problem is composed of multiple subproblems, we can keep on breaking down the problem and ultimately CONSTRUCT the BIGGER problem using all the SUB-PROBLEMS.

When analyzing your **search space**, always draw a **Tree**.

The time complexity of the search problenm depends on: <br>
1. The depth of the search space tree
2. The number of children of each node

**The most important part of all search problem, or any dynamic programming problem, is to define your *state* well. Make sure every subproblem can be described as a *state*.**


## Top Down DFS

1. Define STATE of subproblems<br>
2. Initialize Initial State<br>
3. Call dfs on Initial State<br>

**dfs High Level Idea**: 
1. Base Case <br>
2. For each subproblem x: <br>
   a. Update *state* <br>
   b. Call dfs on next state (branch down) <br>
   c. **Restore *state*** <br>
