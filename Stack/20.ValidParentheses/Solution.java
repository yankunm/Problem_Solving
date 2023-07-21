class Solution {
    public boolean isValid(String s) {
        // Initialize
        Deque<Character> pastP = new ArrayDeque<>();
        char[] converted = s.toCharArray();

        // Loop
        for(char c: converted){
            if(c == ')' && !pastP.isEmpty() && pastP.peek() == '('){
                pastP.pop();
            } else if(c == ']' && !pastP.isEmpty() && pastP.peek() == '['){
                pastP.pop();
            } else if(c == '}' && !pastP.isEmpty() && pastP.peek() == '{'){
                pastP.pop();
            } else if(c == '(' || c == '{' || c == '['){
                pastP.push(c);
            } else {
                return false;
            }
        }

        return !pastP.isEmpty() ? false : true;
    }
}
