class Solution {
    private static final String[] RSYMBOLS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int[] RINTEGERS = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public String intToRoman(int num) {
        String str = "";

        // Loop through each element in romanInt
        for(int i=0; i< RINTEGERS.length; i++){
            // Keep fitting until not possible
            while(RINTEGERS[i] <= num){
                str += RSYMBOLS[i];
                num -= RINTEGERS[i];
            }
        }

        // Finalize
        return str;
    }
}
