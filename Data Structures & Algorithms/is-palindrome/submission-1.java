class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        String lowerStr = s.toLowerCase();
        while(i <= j){
            while(!(Character.isDigit(lowerStr.charAt(i)) ||
                    Character.isLetter(lowerStr.charAt(i))) && i < j) {
                i++;
            }
            while(!(Character.isDigit(lowerStr.charAt(j)) ||
                    Character.isLetter(lowerStr.charAt(j))) && j > i) {
                j--;
            }


            if(lowerStr.charAt(i++) != lowerStr.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
