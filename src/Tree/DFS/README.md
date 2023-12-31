# DFS

DFS is recursive, go as far as possible before backtracking.

## DFS Template

1. Base Case

-- Do Something()

-- Recurse for sub-problem (Believe!!)

### Top-Down Recursion

1. Pass down the result as a parameter <br>
2. Usually no return value <br>

### Bottom-Up Recursion (Harder, More Common)

1. Get the **result** from sub-problem <br>
2. Use that **result** to do work at current level to compute a *Solution* <br>
3. return the *Solution* to parent level

When implementing bottom-up, always consider a middle node. (*One that has both children and parent*)

## Bottom-Up DFS

High Level Idea: <br>
1. Base Case <br>
2. Get **result** from sub-problem <br>
3. Use **result** to do work at current level to compute a *Solution* <br>
4. If needed, do additional processing <br>
5. return the *Solution* to parent level

Note: **result** should be defined exactly the same as *Solution*

## Top-Down DFS

High Level Idea: <br>
1. Base Case <br>
2. Use answer from parent problem (parameter) to do work at current level <br>
3. If needed, do additional processing <br>
4. Pass down the *Solution* as a parameter to child-problem





