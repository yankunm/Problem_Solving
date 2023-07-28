class Solution {

    // Tests if given two words differ by one character only
    // Time: O(word.length())
    // Space: O(1)
    private boolean differByOne(String word1, String word2){ 
        // checks
        if(word1.length() != word2.length()) return false;
        if(word1.equals(word2)) return false;
        
        // switch to false if difference encountered
        boolean allowedDifference = true;

        // loop through every character in both words
        for(int i=0; i<word1.length(); i++){
            if((word1.charAt(i) != word2.charAt(i)) && !allowedDifference){
                return false;
            } else if(word1.charAt(i) != word2.charAt(i)){
                allowedDifference = false;
            }
        }

        // If no differences at all
        if(allowedDifference){
            return false;
        } else {
            return true;
        }
    }

    // Time: O(n^2 * word_length)
    // Space: O(n)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // Initialize Queue with all entry points
        Deque<String> frontier = new ArrayDeque<>();
        boolean endWordExists = false;

        // visited record
        HashSet<String> visited = new HashSet<>();

        // if beginWord is in list, mark it as visited already
        for(int i = 0; i < wordList.size(); i++){
            // Add reference to visited if it was visited
            if(wordList.get(i).equals(beginWord) == true) visited.add(wordList.get(i));
            if(wordList.get(i).equals(endWord) == true) endWordExists = true;
            // Add reference to frontier if adjacent wor
            if(differByOne(wordList.get(i), beginWord)){
                frontier.offer(wordList.get(i));
                visited.add(wordList.get(i));
            }
        }
        if(!endWordExists) return 0;

        // BFS
        int levels = 1;
        while(!frontier.isEmpty()){
            int size = frontier.size();
            levels++;
            for(int i=0; i<size; i++){
                // Poll out element
                String curr = frontier.poll();
                // Process element
                if(curr.equals(endWord) == true) return levels;
                // Expand element
                for(String str: wordList){
                    if(!visited.contains(str) && differByOne(str, curr)){
                        frontier.offer(str);
                        visited.add(str);
                    }
                }
            }
        }

        // Finalize
        return 0;
    }
}

/**
Intuition: BFS

transformationGraph -> tgraph

nodes = words
edges = a pair of words are adjacent in transformation sequence

1. Initialize Queue and store all entry points (words that differ by 1 character in wordList), Use HashSet to record visited nodes
    -any entry point is an adjacent word of beginWord
    -do special endWord exist at all
2. Initialize levels counter = 1
3. while Queue is not empty:
    a. extract size of current level
    b. increment level counter
    c. for each entry point in this level
        -poll out element
        -process element (if endWord then return)
        -Expand word (store all adjacent words (valid, unvisited) in the queue)
4. return levels


Testing if two words differ by one character only:

"hot" "hot"

differByOne(String word1, String word2){
    if(word1.length() != word2.length()) return false;
    if(word1.equals(word2)) return false;
    boolean allowedDifference = true;
    for(int i=0; i<word1.length(); i++){
        if((word1.charAt(i) != word2.charAt(i)) && !allowedDifference){
            return false;
        } else if(word1.charAt(i) != word2.charAt(i)){
            allowedDifference = false;
        }
    }
    if(allowedDifference){
        return false;
    } else {
        return true;
    }
}

 */
