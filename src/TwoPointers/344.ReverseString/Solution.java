class Solution {

    private void swap(char[] s, int i, int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public void reverseString(char[] s) {
        // Initialization
        int i = 0, j = s.length - 1;

        // Swap until they cross
        while(i <= j){
            swap(s, i, j);
            i++;
            j--;
        }
    }
}

/**
Initialize i = 0, j = s.length
while i <= j:
    swap(s[i], s[j])
    i++
    j--
 */
