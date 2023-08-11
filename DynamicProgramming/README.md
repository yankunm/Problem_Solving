# Dynamic Programming

Dynamic Programing, AKA Search + Memoization, is an optimization technique used on search problems. Search problems are DPs fathers.

Dynamic Programming: Use subproblem *answers* to construct the current *solution*

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

If your search space has REPEATING SUBPROBLEMS, then you can record them down in a table to make sure you don't recalculate them and waste time.

Then, the TIME COMPLEXITY will depend on the NUMBER OF SUBPROBLEMS.

Note: When analyzing your **search space**, always draw a **Tree**. **the tree will not be 2^n (we are kicking off branches)**

**Note: Every DP can be written as Bottom-Up DFS**

**Note: Every DP problem is a Shortest Path on a DAG problem**

**MOST IMPORTANT: Always define your STATE well (the STATE is used to describe your subproblem)**

**TIP: After defining STATE, you can start thinking from a MIDDLE STATE to define your recursion.**

### Bottom Up DFS

1. Return STATE of subproblem
2. Initialize memo (record calculated subproblems)
3. Return dfs(*top_level_answer_state*)

**Note: We use the *top_level_answer_state* as input to our dfs cause that's what we are interested in, and dfs will construct answer for that**

**dfs(top_state) High Level Idea:**
1. Base Case Check
2. If *current answer* was calculated, return it
3. Transition Rule (Ask subproblem answer, use that to construct *current answer*)
4. Store *current answer* for parent problem / user


For Array DP Problems, It's usually one of two categories: <br>
1. **1D Problem**: index i or problem length --> dp[3] represents answer for arr[0,3)
2. **2D Problem**: indexes i, j --> dp[3, 5] represents answer for arr[3, 5)

**TIP: Consider if 1D is possible first, if not then increase dimensions.**

ex. Work Break Problem

**State:** Whether we can break s[0, i) into a word in wordDict



