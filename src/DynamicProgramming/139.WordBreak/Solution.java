class Solution {

    private Boolean[] state;

    public boolean wordBreak(String s, List<String> wordDict) {
        // Initialize states
        int n = s.length();
        state = new Boolean[n + 1]; // lazy instantiation

        // Bottom-Up DFS (top level: i = n)
        return dfs(s, n, new HashSet<>(wordDict));
    }

    private boolean dfs(String s, int i, Set<String> wordDict){
        // Initialize

        // Base Case (when i=0)
        if(i == 0) return true;

        // Check if answer already calculated
        if(state[i] != null) return state[i];

        // Calculate state
        state[i] = false;

        // Loop Assignment - Call dfs on subproblems to go down search path
        for(int j = 0; j < i; j++){
            boolean right = wordDict.contains(s.substring(j, i));
            // if the right word is not in wordDict then go to next subproblem
            if(!right) continue;

            // Get answer from subproblem
            boolean left = dfs(s, j, wordDict);
            if(left){
                state[i] = true;
                break;
            }
        }

        // Finalize 
        return state[i];
    }
}

/**

Approach: 1D Dynamic Programming

Define state: s.substring(0, j)

state[0] = if we can break s.substring(0, 0) = true
state[i] = if we can break s.substring(0, i)
state[length] = if we can break s.substring(0, length)

1. State[i] -> if we can break s.substring(0, i)
2. Initialize state table
3. Return dfs()

dfs(state):
1. Base Case
    a. i = 0: return true
2. If state has been calculated, return state[i]
3. For each subproblem j from [0, i):
    a. Ask subproblem [0, j) for answer (block here)
    b. if subproblem is true and [j, n] is in dictionary then return true
4. state[i] = answer from step 3
5. return state[i]




Intuition 1: Sequential LookUp workds in s

public boolean wordBreak(String s, List<String> wordDict) {
        // Put all words in wordDict into Hash Set
        HashSet<String> set = new HashSet<>();
        for(String word: wordDict){
            set.add(word);
        }
        int lastSeen = 0;

        // Loop Through all characters in s
        for(int i = 1; i <= s.length(); i++){
            // If set contains this word
            if(set.contains(s.substring(lastSeen, i))){
                lastSeen = i;
            }
        }

        return lastSeen != s.length() ? false : true;
    }

Know why this algorithm doesn't work?

This is the exact mistake I made in Reconstruct Iterinary.

By satisfying as soon as possible (using a word in the wordDict as soon as I could), I discarded potential answers.

The goal for search problems is to always not discard potential answers, and here I did.

吊了小鱼放了大鱼。应该都吊。

I need to store and consider past answers.

 */
